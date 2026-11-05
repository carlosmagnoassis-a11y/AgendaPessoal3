
package com.example.agendapessoal.data

import androidx.compose.runtime.mutableStateListOf
import com.example.agendapessoal.model.Contato

class ContatoStore {

    val contatos = mutableStateListOf(
        Contato(
            id = 1,
            nome = "Ana",
            telefone = "(27) 99999-1111",
            email = "ana@email.com"
        ),
        Contato(
            id = 2,
            nome = "Bruno",
            telefone = "(27) 99999-2222",
            email = "bruno@email.com"
        ),
        Contato(
            id = 3,
            nome = "Carlos",
            telefone = "(27) 99999-3333",
            email = "carlos@email.com"
        )
    )

    private var proximoId = 4

    fun adicionarContato(
        nome: String,
        telefone: String,
        email: String
    ) {
        val novoContato = Contato(
            id = proximoId,
            nome = nome,
            telefone = telefone,
            email = email
        )

        contatos.add(novoContato)
        proximoId++
    }

    fun buscarContato(id: Int): Contato? {
        return contatos.find { it.id == id }
    }
}


