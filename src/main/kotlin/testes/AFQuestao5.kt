package testes

import system.SupermercadoWeb
import kotlin.random.Random

fun main() {
    val spw = SupermercadoWeb()

    // Mostra o estoque e o carrinho
    println("--- SIMULAÇÃO DE COMPRAS E DEVOLUÇÃO ---")
    println("\n--- ESTADO INICIAL ---")
    println("Estoque: ${spw.estoque.qtdItens()} itens")
    println("Carrinho: ${spw.carrinho.getItens().size} itens")

    // Preenche o carrinho com 10 itens
    val itensDoEstoque = spw.estoque.getItens().shuffled()
    val itensParaComprar = itensDoEstoque.take(10)

    println("\n--- COMPRANDO 10 ITENS ---")
    println("Itens sendo adicionados ao carrinho:")
    itensParaComprar.forEach {
        spw.carrinho.adicionaItem(it, spw.estoque)
    }

    // Mostra o estoque e o carrinho após a compra
    println("\n--- ESTADO APÓS A COMPRA ---")
    println("Estoque: ${spw.estoque.qtdItens()} itens")
    println("Carrinho: ${spw.carrinho.getItens().size} itens")

    // Devolve todos os itens do carrinho para o estoque
    val itensParaDevolver = spw.carrinho.getItens().toList()

    println("\n--- DEVOLVENDO ITENS ---")
    println("Itens sendo devolvidos ao estoque:")
    itensParaDevolver.forEach {
        spw.carrinho.removeItem(it, spw.estoque)
    }

    // Mostra o estoque e o carrinho após a devolução
    println("\n--- ESTADO FINAL ---")
    println("Estoque: ${spw.estoque.qtdItens()} itens")
    println("Carrinho: ${spw.carrinho.getItens().size} itens")
}