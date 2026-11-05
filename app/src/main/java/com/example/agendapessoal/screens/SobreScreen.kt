
package com.example.agendapessoal.screens

import android.content.ActivityNotFoundException
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SobreScreen(
    onVoltar: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Sobre a Agenda Pessoal",
            style = MaterialTheme.typography.headlineMedium
        )

        Text("Agenda Pessoal - Versão 1.0")

        HorizontalDivider()

        Text(
            "Aplicativo para cadastrar, listar e " +
                    "consultar informações de contatos pessoais."
        )

        Text(
            text = "Tecnologias utilizadas:",
            style = MaterialTheme.typography.titleMedium
        )

        Text("• Kotlin")
        Text("• Jetpack Compose")
        Text("• Material Design 3")
        Text("• Navigation Compose")

        HorizontalDivider()

        Text(
            text = "Como utilizar:",
            style = MaterialTheme.typography.titleMedium
        )

        Text("1. Acesse a tela inicial.")
        Text("2. Visualize os contatos cadastrados.")
        Text("3. Clique em Cadastrar novo contato.")
        Text("4. Preencha nome, telefone e e-mail.")
        Text("5. Clique em Salvar contato.")
        Text("6. Toque em um contato para ver detalhes.")

        HorizontalDivider()

        Text(
            text = "Desenvolvido por: Carlos Magno de Assis e Nicolas Cruz",
            style = MaterialTheme.typography.bodyMedium
        )

        Button(
            onClick = {
                val textoCompartilhamento =
                    "Conheça a Agenda Pessoal! " +
                            "Um aplicativo Android desenvolvido " +
                            "com Kotlin e Jetpack Compose para " +
                            "cadastrar, listar e consultar contatos."

                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(
                        Intent.EXTRA_TEXT,
                        textoCompartilhamento
                    )
                }

                try {
                    val chooser = Intent.createChooser(
                        intent,
                        "Compartilhar aplicativo"
                    )

                    context.startActivity(chooser)

                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(
                        context,
                        "Nenhum aplicativo disponível para compartilhar.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Compartilhar aplicativo")
        }

        Button(
            onClick = onVoltar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}
