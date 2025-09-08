package testes

import system.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque

    println("--- ANÁLISE DE LUCRO E PREJUÍZO ---")

    // Calcula o lucro potencial
    val itensIniciais = estoque.getItens()
    var lucroTotalPotencial = 0.0
    itensIniciais.forEach { item ->
        lucroTotalPotencial += item.produto.preco
    }

    val lucroTotalFormatado = "R$ %.2f".format(lucroTotalPotencial)
    println("\nAnálise Inicial:")
    println("Quantidade total de itens no estoque: ${itensIniciais.size}")
    println("Lucro total potencial com a venda de todos os itens: $lucroTotalFormatado")

    // Calcula o prejuízo
    val itensVencidos = itensIniciais.filter { !it.valido() }
    var prejuizo = 0.0
    itensVencidos.forEach { item ->
        prejuizo += item.produto.preco
        // Remove o item vencido do estoque de forma segura
        estoque.saiItem(item)
    }

    val prejuizoFormatado = "R$ %.2f".format(prejuizo)
    val itensRemovidosCount = itensVencidos.size

    // Mostra o estoque sem os itens vencidos
    println("\n--- GESTÃO DE ESTOQUE ---")
    println("$itensRemovidosCount itens vencidos foram retirados do estoque e jogados no lixo.")
    println("Prejuízo total com a retirada dos itens: $prejuizoFormatado")

    val itensRestantes = estoque.getItens()
    println("\nEstoque após a limpeza:")
    if (itensRestantes.isEmpty()) {
        println("O estoque está vazio.")
    } else {
        itensRestantes.forEach { item ->
            println("  - ${item.produto.nome} (${item.produto.marca.nome})")
            println("    Validade: ${item.validade}")
            println("    -----------------------------------")
        }
    }
    println("Quantidade total de itens restantes no estoque: ${estoque.qtdItens()}")

    // Mostra o lucro real
    val lucroReal = lucroTotalPotencial - prejuizo
    val lucroRealFormatado = "R$ %.2f".format(lucroReal)

    println("\n--- RESULTADO FINAL ---")
    println("Lucro real (considerando o prejuízo): $lucroRealFormatado")
}