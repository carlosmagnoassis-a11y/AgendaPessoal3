# Agenda Pessoal — Aplicativo Android

## 1. Descrição do projeto

A Agenda Pessoal é um aplicativo Android desenvolvido como atividade da disciplina de Desenvolvimento Mobile do Instituto Federal do Espírito Santo (IFES).

O aplicativo permite cadastrar, listar e consultar informações de contatos pessoais, utilizando Kotlin, Jetpack Compose e Navigation Compose.

## 2. Desenvolvedor

**Carlos Magno de Assis**

## 3. Tecnologias utilizadas

- Kotlin
- Jetpack Compose
- Material Design 3
- Navigation Compose
- Android Studio

## 4. Funcionalidades implementadas

- Tela inicial com três contatos previamente cadastrados.
- Cadastro de novos contatos com nome, telefone e e-mail.
- Validação dos campos obrigatórios e do formato do e-mail.
- Geração automática de identificadores únicos.
- Atualização automática da lista após o cadastro.
- Visualização dos detalhes de cada contato.
- Tratamento de contatos não encontrados.
- Navegação entre quatro telas com Navigation Compose.
- Retorno entre telas utilizando `popBackStack()`.
- Tela Sobre/Ajuda com informações sobre o aplicativo.
- Compartilhamento de uma descrição do projeto utilizando `Intent.ACTION_SEND`.

## 5. Organização do projeto

- `MainActivity.kt` — inicialização do aplicativo.
- `AppNavigation.kt` — configuração das rotas e navegação.
- `Contato.kt` — modelo dos dados.
- `ContatoStore.kt` — gerenciamento da lista compartilhada.
- `HomeScreen.kt` — tela inicial e listagem.
- `CadastroScreen.kt` — cadastro e validação.
- `DetalhesScreen.kt` — consulta aos detalhes.
- `SobreScreen.kt` — informações e compartilhamento.

## 6. Como executar

1. Instalar o Android Studio.
2. Clonar ou baixar o repositório do GitHub.
3. Abrir a pasta do projeto no Android Studio.
4. Aguardar a sincronização do Gradle.
5. Selecionar um emulador Android ou dispositivo físico compatível.
6. Executar o aplicativo pelo botão Run.

## 7. Testes realizados

- Compilação do projeto com sucesso.
- Execução no emulador Android.
- Visualização dos três contatos iniciais.
- Cadastro de novos contatos.
- Rejeição de e-mails inválidos.
- Atualização da lista após o cadastro.
- Consulta aos detalhes dos contatos.
- Funcionamento dos botões de retorno.
- Acesso à tela Sobre/Ajuda.
- Abertura do compartilhamento do Android.

## 8. Uso de inteligência artificial

Foi utilizada a ferramenta ChatGPT, da OpenAI, como apoio no planejamento, desenvolvimento e revisão do código Kotlin, na organização das telas com Jetpack Compose, na configuração da navegação e na identificação de problemas.

O código foi acompanhado e testado no Android Studio. Durante o desenvolvimento, foram realizados ajustes na validação do e-mail, na navegação entre telas, nos botões de retorno e na organização final do aplicativo.

## 9. Limitações conhecidas

Os contatos são armazenados em memória durante a execução do aplicativo. Os dados cadastrados podem ser perdidos após o encerramento completo do processo.

A persistência permanente não foi implementada por não ser obrigatória nesta atividade.
