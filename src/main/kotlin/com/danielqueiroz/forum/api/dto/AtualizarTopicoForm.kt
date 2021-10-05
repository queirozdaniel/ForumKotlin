package com.danielqueiroz.forum.api.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AtualizarTopicoForm(
    @field:NotEmpty @Size(min = 5, max = 50) val titulo: String,
    @field:NotEmpty val mensagem: String
)
