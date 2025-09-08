package testes

import system.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val itensEstoque = estoque.getItens()

    println("--- ESTOQUE ---")
    println("Item\t\t\t\tPreço\t\tValidade\tVálido?")
    println("------------------------------------------------------------------")

    for (item in itensEstoque) {
        val precoFormatado = "R$ %.2f".format(item.produto.preco)
        val validoString = if (item.valido()) "sim" else "não"

        println("${item.produto.nome} (${item.produto.genero.nome}, ${item.produto.marca.nome})")
        println("\t\t\t\t$precoFormatado\t\t${item.validade}\t\t$validoString")
        println("------------------------------------------------------------------")
    }

    println("...")
    println("TOTAL: ${estoque.qtdItens()} itens.")
}