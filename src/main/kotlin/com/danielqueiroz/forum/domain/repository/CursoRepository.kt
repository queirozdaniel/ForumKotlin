package com.danielqueiroz.forum.domain.repository

import com.danielqueiroz.forum.domain.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso, Long> {
}