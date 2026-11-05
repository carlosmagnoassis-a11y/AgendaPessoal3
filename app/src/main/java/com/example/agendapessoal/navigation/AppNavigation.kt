
package com.example.agendapessoal.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.agendapessoal.data.ContatoStore
import com.example.agendapessoal.screens.HomeScreen
import com.example.agendapessoal.screens.CadastroScreen
import com.example.agendapessoal.screens.DetalhesScreen
import com.example.agendapessoal.screens.SobreScreen

object Routes {
    const val HOME = "home"
    const val CADASTRO = "cadastro"
    const val DETALHES = "detalhes"
    const val SOBRE = "sobre"
}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    // Lista compartilhada entre todas as telas
    val contatoStore = remember { ContatoStore() }

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {

        // 1. Tela inicial e listagem
        composable(Routes.HOME) {
            HomeScreen(
                contatos = contatoStore.contatos,

                onCadastrar = {
                    navController.navigate(Routes.CADASTRO)
                },

                onVerDetalhes = { contatoId ->
                    navController.navigate(
                        "${Routes.DETALHES}/$contatoId"
                    )
                },

                onSobre = {
                    navController.navigate(Routes.SOBRE)
                }
            )
        }

        // 2. Cadastro de contatos
        composable(Routes.CADASTRO) {
            CadastroScreen(
                onSalvar = { nome, telefone, email ->

                    contatoStore.adicionarContato(
                        nome = nome,
                        telefone = telefone,
                        email = email
                    )

                    navController.popBackStack()
                },

                onVoltar = {
                    navController.popBackStack()
                }
            )
        }

        // 3. Detalhes do contato
        composable("${Routes.DETALHES}/{id}") { backStackEntry ->

            val contatoId = backStackEntry.arguments
                ?.getString("id")
                ?.toIntOrNull()

            val contato = contatoId?.let { id ->
                contatoStore.buscarContato(id)
            }

            DetalhesScreen(
                contato = contato,
                onVoltar = {
                    navController.popBackStack()
                }
            )
        }

        // 4. Sobre / Ajuda
        composable(Routes.SOBRE) {
            SobreScreen(
                onVoltar = {
                    navController.popBackStack()
                }
            )
        }
    }
}
