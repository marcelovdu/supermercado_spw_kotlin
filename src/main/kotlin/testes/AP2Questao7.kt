package testes

import system.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque

    println("--- BUSCA DE ITENS POR MARCA ---")
    print("Digite o nome da marca para busca: ")
    val marcaPesquisa = readln()

    println("\nBuscando por itens da marca '${marcaPesquisa}'...")

    // Filtra os itens do estoque que são válidos
    val itensEncontrados = estoque.getItens()
        .filter {
            it.valido() && it.produto.marca.nome.equals(marcaPesquisa, ignoreCase = true)
        }

    println("\n--- RESULTADO DA BUSCA ---")
    if (itensEncontrados.isEmpty()) {
        println("Nenhum item válido da marca '${marcaPesquisa}' foi encontrado no estoque.")
    } else {
        println("${itensEncontrados.size} itens válidos encontrados da marca '${marcaPesquisa}':")
        println("---------------------------------------------------------------------------------")

        itensEncontrados.forEach { item ->
            val precoFormatado = "R$ %.2f".format(item.produto.preco)

            println("  - ${item.produto.nome}")
            println("    Gênero: ${item.produto.genero.nome}")
            println("    Código: ${item.codigo}")
            println("    Preço: $precoFormatado")
            println("    Validade: ${item.validade}")
            println("    ------------------------------------------")
        }
    }
}