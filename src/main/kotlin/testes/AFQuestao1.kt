package testes

import system.SupermercadoWeb
import model.*

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque

    println("--- BUSCA DE ITENS POR GÊNERO ---")
    print("Digite o nome do gênero para buscar: ")
    val generoPesquisa = readln().trim()

    // Converte a entrada em um objeto
    val generoObj = when (generoPesquisa.lowercase()) {
        "leite" -> Leite()
        "achocolatado" -> Achocolatado()
        "presunto" -> Presunto()
        else -> null
    }

    if (generoObj != null) {
        // Usa o método do objeto de gênero
        val itensEncontrados = estoque.getItens(generoObj)

        println("\n--- RESULTADO DA BUSCA POR GÊNERO: ${generoObj.nome.uppercase()} ---")

        if (itensEncontrados.isEmpty()) {
            println("Nenhum item do gênero '${generoPesquisa}' foi encontrado no estoque.")
        } else {
            println("${itensEncontrados.size} itens encontrados do gênero '${generoPesquisa}':")
            println("---------------------------------------------------------------------------------")

            itensEncontrados.forEach { item ->
                val precoFormatado = "R$ %.2f".format(item.produto.preco)

                println("  - ${item.produto.nome}")
                println("    Marca: ${item.produto.marca.nome}")
                println("    Código: ${item.codigo}")
                println("    Preço: $precoFormatado")
                println("    Validade: ${item.validade}")
                println("    ------------------------------------------")
            }
        }
    } else {
        println("Gênero não encontrado. Por favor, digite um gênero válido.")
    }
}