package testes

import system.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque

    println("--- ANÁLISE DO ESTOQUE ---")

    // Itens não vencidos no estoque
    val itensValidos = estoque.getItens().count { it.valido() }

    // Itens vencidos no estoque
    val itensVencidos = estoque.getItens().count { !it.valido() }

    // Soma dos itens
    val somaItens = itensValidos + itensVencidos

    val totalItensNoEstoque = estoque.qtdItens()

    println("Itens não vencidos: $itensValidos")
    println("Itens vencidos: $itensVencidos")
    println("Soma dos itens não vencidos e vencidos: $somaItens")
    println("Total de itens no estoque: $totalItensNoEstoque")

    // Verifica se a soma é igual ao total
    val resultadoVerificacao = somaItens == totalItensNoEstoque

    println("\nA soma dos itens é igual ao total do estoque? $resultadoVerificacao")

    if (resultadoVerificacao) {
        println("A soma bate com o total. A contagem está correta.")
    } else {
        println("Há um problema na contagem. A soma não bate com o total.")
    }
}