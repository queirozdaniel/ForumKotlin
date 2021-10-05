package com.danielqueiroz.forum.domain.service

import com.danielqueiroz.forum.api.dto.AtualizarTopicoForm
import com.danielqueiroz.forum.api.dto.NovoTopicoForm
import com.danielqueiroz.forum.api.dto.TopicoView
import com.danielqueiroz.forum.api.mapper.TopicoFormMapper
import com.danielqueiroz.forum.api.mapper.TopicoViewMapper
import com.danielqueiroz.forum.domain.dto.TopicoPorCategoriaDTO
import com.danielqueiroz.forum.domain.exception.NotFoundException
import com.danielqueiroz.forum.domain.model.Topico
import com.danielqueiroz.forum.domain.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
) {
    private val notFoundMessage: String = "Topico não encontrado"


    fun listar(
        nomeCurso: String?,
        paginacao: Pageable
    ): Page<TopicoView> {
        val topicos = if(nomeCurso == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByCursoNome(nomeCurso, paginacao)
        }
        return topicos.map { t -> topicoViewMapper.map(t) }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id).orElseThrow{ NotFoundException(notFoundMessage)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(dto: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(dto)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizarTopicoForm, id: Long): TopicoView {
        val topico = repository.findById(id).orElseThrow{ NotFoundException(notFoundMessage)}
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun relatorio(): List<TopicoPorCategoriaDTO> {
        return repository.relatorio()
    }

}