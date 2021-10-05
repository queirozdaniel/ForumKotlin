package com.danielqueiroz.forum.api.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovoTopicoForm(
    @field:NotBlank @Size(min = 5, max = 50) val titulo: String,
    @field:NotBlank val mensagem: String,
    @field:NotNull val idCurso: Long,
    @field:NotNull val idAutor: Long
)