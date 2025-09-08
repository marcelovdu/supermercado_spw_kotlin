package testes

import system.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque

    println("--- SEPARAÇÃO DE ITENS POR VALIDADE ---")
    println("\n--- ESTADO INICIAL ---")
    println("Quantidade total de itens no estoque: ${estoque.qtdItens()}")

    // Divide os itens válidos e inválidos.
    val (itensValidos, itensInvalidos) = estoque.getItens().partition { it.valido() }

    // Adiciona todos os itens válidos no carrinho A e itens inválidos no carrinho B
    println("\nAdicionando ${itensValidos.size} itens válidos ao Carrinho A...")
    for (item in itensValidos) {
        spw.carrinhoA.adicionaItem(item, estoque)
    }

    println("Adicionando ${itensInvalidos.size} itens inválidos ao Carrinho B...")
    for (item in itensInvalidos) {
        spw.carrinhoB.adicionaItem(item, estoque)
    }

    // Mostra o estoque e os dois carrinhos
    println("\n--- ESTADO FINAL ---")

    println("Estoque: ${estoque.qtdItens()} itens")
    println("-----------------------------------")

    println("Carrinho A (Itens Válidos): ${spw.carrinhoA.getItens().size} itens")
    spw.carrinhoA.getItens().forEach {
        println("  - ${it.produto.nome} (${it.produto.genero.nome}, válido)")
    }
    println("-----------------------------------")

    println("Carrinho B (Itens Inválidos): ${spw.carrinhoB.getItens().size} itens")
    spw.carrinhoB.getItens().forEach {
        println("  - ${it.produto.nome} (${it.produto.genero.nome}, inválido)")
    }
    println("-----------------------------------")
}