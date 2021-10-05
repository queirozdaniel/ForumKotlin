package com.danielqueiroz.forum.domain.service

import com.danielqueiroz.forum.domain.model.Curso
import com.danielqueiroz.forum.domain.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(private val repository: CursoRepository){

    fun buscarPorId(id: Long): Curso {
        return repository.getById(id)
    }

}
