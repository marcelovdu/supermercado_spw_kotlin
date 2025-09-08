package main

import system.SupermercadoWeb
import model.Leite
import model.Marca

fun main() {
    println("--- Bem-vindo ao Supermercado SPW! ---")

    // 1. Instancia o SupermercadoWeb. O construtor já inicializa o estoque.
    val spw = SupermercadoWeb()

    println("\n--- Resumo Inicial do Sistema ---")
    println("Quantidade de itens no estoque: ${spw.estoque.qtdItens()}")
    println("Itens no carrinho: ${spw.carrinho.getItens().size}")

    // --- Simulação e Testes ---

    // 2. Encontrando um item para adicionar ao carrinho
    println("\n--- Teste 1: Adicionando itens ao carrinho ---")
    val itemNinho = spw.estoque.getItens().firstOrNull { it.produto.nome == "Ninho" }
    val itemToddy = spw.estoque.getItens().firstOrNull { it.produto.nome == "Toddy" }

    if (itemNinho != null) {
        spw.carrinho.adicionaItem(itemNinho, spw.estoque)
    }
    if (itemToddy != null) {
        spw.carrinho.adicionaItem(itemToddy, spw.estoque)
    }

    println("\nQuantidade de itens no estoque após adicionar ao carrinho: ${spw.estoque.qtdItens()}")
    println("Itens no carrinho: ${spw.carrinho.getItens().size}")
    println("Total a pagar: R$ ${"%.2f".format(spw.carrinho.totalAPagar())}")

    // 3. Teste de remoção
    println("\n--- Teste 2: Removendo um item do carrinho ---")
    if (itemToddy != null) {
        spw.carrinho.removeItem(itemToddy, spw.estoque)
    }

    println("\nQuantidade de itens no estoque após remover do carrinho: ${spw.estoque.qtdItens()}")
    println("Itens no carrinho: ${spw.carrinho.getItens().size}")
    println("Total a pagar: R$ ${"%.2f".format(spw.carrinho.totalAPagar())}")

    // 4. Teste dos métodos getItens() sobrecarregados do Estoque
    println("\n--- Teste 3: Buscando itens no estoque ---")
    val leiteGenero = Leite()
    val itensLeite = spw.estoque.getItens(leiteGenero)
    println("Itens do gênero ${leiteGenero.nome}: ${itensLeite.size}")

    val marcaNestle = Marca("Nestlé")
    val itensNestle = spw.estoque.getItens(marcaNestle)
    println("Itens da marca ${marcaNestle.nome}: ${itensNestle.size}")

    val produtoNescau = spw.produtos.first { it.nome == "Nescau" }
    val itensNescau = spw.estoque.getItens(produtoNescau)
    println("Itens do produto ${produtoNescau.nome}: ${itensNescau.size}")
}