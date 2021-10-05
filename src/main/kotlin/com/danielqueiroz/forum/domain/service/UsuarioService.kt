package com.danielqueiroz.forum.domain.service

import com.danielqueiroz.forum.domain.model.Usuario
import com.danielqueiroz.forum.domain.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService (private val repository: UsuarioRepository){

    fun buscarPorId(id: Long): Usuario {
        return repository.getById(id)
    }

}
