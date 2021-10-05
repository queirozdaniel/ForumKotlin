package com.danielqueiroz.forum.api.mapper

import com.danielqueiroz.forum.api.dto.NovoTopicoForm
import com.danielqueiroz.forum.domain.model.Topico
import com.danielqueiroz.forum.domain.service.CursoService
import com.danielqueiroz.forum.domain.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
           // id = topicos.size.toLong() + 1,
            titulo = t.titulo,
            mensagem = t.mensagem,
            autor = usuarioService.buscarPorId(t.idAutor),
            curso = cursoService.buscarPorId(t.idCurso)
        )
    }

}
