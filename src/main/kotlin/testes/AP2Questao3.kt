package testes

import system.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque

    println("--- ESTOQUE DE VÁLIDOS POR MARCA E GÊNERO ---")

    val generos = spw.generos
    val marcas = spw.marcas
    var totalItensValidos = 0

    for (genero in generos) {
        println("\n### GÊNERO: ${genero.nome.uppercase()} ###")

        for (marca in marcas) {
            val itensPorGeneroEMarca = estoque.getItens(genero)
                .filter { it.produto.marca == marca && it.valido() }

            if (itensPorGeneroEMarca.isNotEmpty()) {
                println("\n  --- MARCA: ${marca.nome.uppercase()} ---")

                for (item in itensPorGeneroEMarca) {
                    val precoFormatado = "R$ %.2f".format(item.produto.preco)

                    println("    - ${item.produto.nome}")
                    println("      Código: ${item.codigo}")
                    println("      Preço: $precoFormatado")
                    println("      Validade: ${item.validade}")
                    println("      Válido?: sim")
                    println("      -----------------------------------")
                    totalItensValidos++
                }
            }
        }
    }

    println("\nTotal de itens válidos mostrados: $totalItensValidos")
}