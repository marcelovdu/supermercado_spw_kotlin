package testes

import system.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()

    println("--- PRODUTOS MAIS BARATOS POR GÊNERO ---")

    // Agrupa e itera os produtos
    val produtosPorGenero = spw.produtos.groupBy { it.genero }
    produtosPorGenero.forEach { (genero, produtosDoGenero) ->

        // Encontra o produto mais barato
        val produtoMaisBarato = produtosDoGenero.minByOrNull { it.preco }

        if (produtoMaisBarato != null) {
            val precoFormatado = "R$ %.2f".format(produtoMaisBarato.preco)
            println("\n--- GÊNERO: ${genero.nome.uppercase()} ---")
            println("  Produto mais barato: ${produtoMaisBarato.nome}")
            println("  Preço: $precoFormatado")
            println("  Marca: ${produtoMaisBarato.marca.nome}")
        }
    }
}