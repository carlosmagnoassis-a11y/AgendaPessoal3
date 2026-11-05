
package com.example.agendapessoal.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.util.Patterns
import androidx.compose.material3.MaterialTheme

@Composable
fun CadastroScreen(
    onSalvar: (String, String, String) -> Unit,
    onVoltar: () -> Unit
) {
    var nome by rememberSaveable { mutableStateOf("") }
    var telefone by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var mensagemErro by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Cadastrar novo contato")

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = telefone,
            onValueChange = { telefone = it },
            label = { Text("Telefone") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        if (mensagemErro.isNotEmpty()) {
            Text(
                text = mensagemErro,
                color = MaterialTheme.colorScheme.error
            )
        }


        Button(
            onClick = {
                when {
                    nome.isBlank() ||
                            telefone.isBlank() ||
                            email.isBlank() -> {
                        mensagemErro = "Preencha todos os campos."
                    }

                    !Patterns.EMAIL_ADDRESS.matcher(
                        email.trim()
                    ).matches() -> {
                        mensagemErro = "Digite um e-mail válido."
                    }

                    else -> {
                        mensagemErro = ""

                        onSalvar(
                            nome.trim(),
                            telefone.trim(),
                            email.trim()
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salvar contato")
        }


        TextButton(onClick = onVoltar) {
            Text("Voltar")
        }
    }
}


