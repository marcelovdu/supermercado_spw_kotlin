# Sistema de Supermercado Online SPW S/A

Este projeto é uma aplicação de console em Kotlin que simula as funcionalidades de um supermercado online. O programa foi desenvolvido com base em um diagrama de classes e um conjunto de requisitos detalhados, implementando conceitos fundamentais de Programação Orientada a Objetos (POO).

## Funcionalidades Implementadas

O sistema abrange as seguintes funcionalidades principais:

- **Modelagem de Dados**: Classes como `Produto`, `Marca`, `Genero` e `Data` foram criadas para representar as entidades do sistema.
- **Gestão de Estoque**: Adição e remoção de itens, busca por gênero, marca e produto, além de contagem de itens válidos e vencidos.
- **Carrinho de Compras**: Funcionalidades de adicionar e remover itens, com sincronização automática com o estoque.
- **Análise de Dados**: O sistema é capaz de calcular lucros, prejuízos, identificar produtos mais baratos e realizar buscas dinâmicas com base na entrada do usuário.

## Estrutura do Código

O projeto está organizado em pacotes para garantir a separação de responsabilidades:

- `model/`: Contém as classes que representam o **modelo de dados** do supermercado.
- `system/`: Contém as classes que gerenciam a **lógica de negócios**, como o estoque e o carrinho.
- `testes/`: Contém as classes `AP2QuestaoX` e `AFQuestaoX`, que servem como ponto de entrada para **executar e testar** as funcionalidades de cada questão.

## Como Executar

Para rodar o projeto e testar as funcionalidades de cada questão, siga os passos abaixo:

1.  **Clone o repositório:**
    Abra um terminal e use o comando:
    ```bash
    git clone [https://github.com/marcelovdu/supermercado_spw_kotlin.git](https://github.com/marcelovdu/supermercado_spw_kotlin.git)
    ```

2.  **Abra o projeto no IntelliJ IDEA:**
    No IntelliJ, selecione **File > Open** e escolha a pasta clonada do projeto.

3.  **Execute o arquivo desejado:**
    Navegue até a pasta `src/main/kotlin/testes`. Cada arquivo (`AP2Questao1.kt`, `AFQuestao2.kt`, etc.) corresponde a uma questão específica. Abra o arquivo que deseja executar e clique no botão de "play" verde ao lado da função `main()`.