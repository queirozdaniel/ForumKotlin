package com.danielqueiroz.forum.domain.repository

import com.danielqueiroz.forum.domain.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {

}