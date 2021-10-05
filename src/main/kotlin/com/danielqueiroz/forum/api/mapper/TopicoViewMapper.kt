package com.danielqueiroz.forum.api.mapper

import com.danielqueiroz.forum.api.dto.TopicoView
import com.danielqueiroz.forum.domain.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico, TopicoView> {

    override fun map(t: Topico): TopicoView {
        return TopicoView(t.id, t.titulo, t.mensagem, t.status, t.dataCriacao)
    }
}