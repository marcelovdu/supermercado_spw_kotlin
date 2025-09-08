package testes

import system.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque

    println("--- ESTOQUE POR GÊNERO ---")

    val generos = spw.generos

    for (genero in generos) {
        val itensPorGenero = estoque.getItens(genero)

        println("\n--- GÊNERO: ${genero.nome.uppercase()} ---")

        for (item in itensPorGenero) {
            val precoFormatado = "R$ %.2f".format(item.produto.preco)
            val validoString = if (item.valido()) "sim" else "não"

            println("  - ${item.produto.nome} (${item.produto.marca.nome})")
            println("    Código: ${item.codigo}")
            println("    Preço: $precoFormatado")
            println("    Validade: ${item.validade}")
            println("    Válido?: $validoString")
            println("    ------------------------------------------")
        }

        println("  Total de itens do gênero: ${itensPorGenero.size}")
    }

    println("\nTotal geral de itens no estoque: ${estoque.qtdItens()}")
}