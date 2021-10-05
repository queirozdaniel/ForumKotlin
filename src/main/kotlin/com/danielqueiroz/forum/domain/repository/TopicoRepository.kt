package com.danielqueiroz.forum.domain.repository

import com.danielqueiroz.forum.domain.dto.TopicoPorCategoriaDTO
import com.danielqueiroz.forum.domain.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository : JpaRepository<Topico, Long>{

    fun findByCursoNome(nomeCurso: String, paginacao: Pageable): Page<Topico>

    @Query("SELECT new com.danielqueiroz.forum.domain.model.dto.TopicoPorCategoriaDTO(curso.categoria, count(t)) FROM Topico t join t.curso curso GROUP BY curso.categoria")
    fun relatorio(): List<TopicoPorCategoriaDTO>

}