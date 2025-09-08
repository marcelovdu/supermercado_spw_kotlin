package testes

import system.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()

    // Lista de itens do carrinho
    val itensParaCarrinho = spw.estoque.getItens().filter { it.codigo % 2 != 0L }

    println("--- SIMULAÇÃO DE COMPRA ---")

    // Seleciona os itens ímpares do estoque
    for (item in itensParaCarrinho) {
        spw.carrinho.adicionaItem(item, spw.estoque)
    }

    println("\n--- ITENS NO CARRINHO ---")
    // Mostra os itens do carrinho e o total
    val itensNoCarrinho = spw.carrinho.getItens()
    if (itensNoCarrinho.isEmpty()) {
        println("O carrinho está vazio.")
    } else {
        itensNoCarrinho.forEach { item ->
            val precoFormatado = "R$ %.2f".format(item.produto.preco)
            println("  - ${item.produto.nome} (${item.produto.marca.nome})")
            println("    Preço: $precoFormatado")
            println("    -----------------------------------")
        }
        println("Quantidade de itens no carrinho: ${itensNoCarrinho.size}")
        val totalPagarFormatado = "R$ %.2f".format(spw.carrinho.totalAPagar())
        println("Total a pagar: $totalPagarFormatado")
    }

    println("\n--- ITENS RESTANTES NO ESTOQUE ---")
    // Mostra os itens restantes no estoque
    val itensRestantes = spw.estoque.getItens()
    if (itensRestantes.isEmpty()) {
        println("O estoque está vazio.")
    } else {
        itensRestantes.forEach { item ->
            val precoFormatado = "R$ %.2f".format(item.produto.preco)
            println("  - ${item.produto.nome} (${item.produto.marca.nome})")
            println("    Preço: $precoFormatado")
            println("    Validade: ${item.validade}")
            println("    -----------------------------------")
        }
    }
    println("Quantidade total de itens restantes no estoque: ${spw.estoque.qtdItens()}")
}