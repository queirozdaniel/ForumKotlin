package com.danielqueiroz.forum.api.controller

import com.danielqueiroz.forum.api.dto.AtualizarTopicoForm
import com.danielqueiroz.forum.api.dto.NovoTopicoForm
import com.danielqueiroz.forum.api.dto.TopicoView
import com.danielqueiroz.forum.domain.dto.TopicoPorCategoriaDTO
import com.danielqueiroz.forum.domain.model.Topico
import com.danielqueiroz.forum.domain.service.TopicoService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController( private val topicoService: TopicoService) {

    @GetMapping
    @Cacheable("listaTopicos")
    fun listar(
        @RequestParam(required = false) nomeCurso: String?,
        @PageableDefault(size = 10, sort = ["dataCriacao"], direction = Sort.Direction.DESC) paginacao: Pageable
    ): Page<TopicoView>{
        return topicoService.listar(nomeCurso, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView? {
        return topicoService.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["listaTopicos"], allEntries = true)
    fun cadastrar(@RequestBody @Valid topico: NovoTopicoForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoView>{
        val topicoView = topicoService.cadastrar(topico)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()

        return ResponseEntity.created(uri).body(topicoView);
    }

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = ["listaTopicos"], allEntries = true)
    fun atualizar(@RequestBody @Valid topico: AtualizarTopicoForm, @PathVariable id: Long): ResponseEntity<TopicoView> {
        val topicoView = topicoService.atualizar(topico, id)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = ["listaTopicos"], allEntries = true)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long){
        topicoService.deletar(id)
    }

    @GetMapping("/relatorio")
    fun relatorio(): List<TopicoPorCategoriaDTO>{
        return topicoService.relatorio()
    }

}