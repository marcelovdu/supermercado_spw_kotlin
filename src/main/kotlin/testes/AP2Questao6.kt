package testes

import system.SupermercadoWeb
import kotlin.random.Random

fun main() {
    val spw = SupermercadoWeb()

    println("--- SIMULAÇÃO DE COMPRA ALEATÓRIA ---")

    // Seleciona aleatoriamente alguns itens
    val todosItensValidos = spw.estoque.getItens().filter { it.valido() }
    val numItensParaComprar = Random.nextInt(1, 10)
    val itensParaCarrinho = todosItensValidos.shuffled().take(numItensParaComprar)

    println("Adicionando ${itensParaCarrinho.size} itens aleatórios ao carrinho.")

    // Adiciona os itens no carrinho e remove do estoque
    for (item in itensParaCarrinho) {
        spw.carrinho.adicionaItem(item, spw.estoque)
    }

    println("\n--- ITENS NO CARRINHO ---")
    // Mostra os itens do carrinho
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