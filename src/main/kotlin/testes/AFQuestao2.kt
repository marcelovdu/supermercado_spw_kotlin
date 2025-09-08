package testes

import system.SupermercadoWeb
import model.Data

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque

    println("--- BUSCA POR ITENS COM VALIDADE VENCIDA ---")

    try {
        print("Digite o dia: ")
        val dia = readln().toInt()
        print("Digite o mês: ")
        val mes = readln().toInt()
        print("Digite o ano: ")
        val ano = readln().toInt()

        val dataPesquisa = Data(dia, mes, ano)
        val x = estoque.getItens().filter { it.validade.antes(dataPesquisa) }

        println("\n--- RESULTADO DA BUSCA ---")
        if (x.isEmpty()) {
            println("Nenhum item com validade anterior a ${dataPesquisa} foi encontrado.")
        } else {
            println("${x.size} itens encontrados com validade anterior a ${dataPesquisa}:")
            println("---------------------------------------------------------------------------------")

            x.forEach { item ->
                val precoFormatado = "R$ %.2f".format(item.produto.preco)

                println("  - ${item.produto.nome} (${item.produto.marca.nome})")
                println("    Código: ${item.codigo}")
                println("    Preço: $precoFormatado")
                println("    Validade: ${item.validade}")
                println("    Válido?: ${if (item.valido()) "sim" else "não"}")
                println("    ------------------------------------------")
            }
        }
    } catch (e: NumberFormatException) {
        println("\nErro: Por favor, digite valores numéricos válidos para dia, mês e ano.")
    }
}