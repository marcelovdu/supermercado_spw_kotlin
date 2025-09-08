package system

import model.*
import kotlin.random.Random
import java.util.Calendar

class SupermercadoWeb {

    val estoque: Estoque = Estoque()
    val carrinho: Carrinho = Carrinho()
    val carrinhoA: Carrinho = Carrinho()
    val carrinhoB: Carrinho = Carrinho()

    val marcas: MutableList<Marca> = mutableListOf()
    val generos: MutableList<Genero> = mutableListOf()
    val produtos: MutableList<Produto> = mutableListOf()
    val itens: MutableList<ItemProduto> = mutableListOf()

    init {
        iniciaSupermercado()
    }

    private fun iniciaSupermercado() {
        // Inicialização de Marcas
        val nestle = Marca("Nestlé")
        val itambe = Marca("Itambé")
        val duleite = Marca("Duleite")
        val abf = Marca("ABF")
        val pepsico = Marca("Pepsico do Brasil")
        val bretzke = Marca("Bretzke")
        val sadia = Marca("Sadia")
        val perdigao = Marca("Perdigão")
        marcas.addAll(listOf(nestle, itambe, duleite, abf, pepsico, bretzke, sadia, perdigao))

        // Inicialização de Gêneros
        val leite = Leite()
        val presunto = Presunto()
        val achocolatado = Achocolatado()
        generos.addAll(listOf(leite, presunto, achocolatado))

        // Inicialização de Produtos
        val prodNinho = Produto(1, "Ninho", 8.50f, nestle, leite)
        val prodMolico = Produto(2, "Molico", 7.90f, nestle, leite)
        val prodCaixa = Produto(3, "Leite em Caixa", 5.00f, duleite, leite)
        val prodPo = Produto(4, "Leite em Pó", 10.00f, itambe, leite)
        val prodNescau = Produto(5, "Nescau", 9.20f, nestle, achocolatado)
        val prodOvo = Produto(6, "Ovomaltine", 12.00f, abf, achocolatado)
        val prodToddy = Produto(7, "Toddy", 11.50f, pepsico, achocolatado)
        val prodPresDelicia = Produto(8, "Presunto Delícia", 25.00f, bretzke, presunto)
        val prodPresSadia = Produto(9, "Presunto Sadia", 28.00f, sadia, presunto)
        val prodPresPerdigao = Produto(10, "Presunto Perdigão", 26.50f, perdigao, presunto)
        produtos.addAll(listOf(prodNinho, prodMolico, prodCaixa, prodPo, prodNescau, prodOvo, prodToddy, prodPresDelicia, prodPresSadia, prodPresPerdigao))

        //println("Inicializando estoque com 30 itens...")
        val random = Random(Calendar.getInstance().timeInMillis)

        // 10 itens de Leite de 3 marcas distintas
        repeat(10) {
            val produtoLeite = when (random.nextInt(3)) {
                0 -> prodNinho
                1 -> prodMolico
                else -> prodCaixa
            }
            val validade = Data(random.nextInt(1, 29), random.nextInt(Calendar.getInstance().get(Calendar.MONTH) + 1, 13), 2025)
            val item = ItemProduto(random.nextLong(), validade, produtoLeite)
            itens.add(item)
            estoque.entraItem(item)
        }

        // 10 itens de Achocolatado de 3 marcas distintas
        repeat(10) {
            val produtoAchocolatado = when (random.nextInt(3)) {
                0 -> prodNescau
                1 -> prodOvo
                else -> prodToddy
            }
            val validade = Data(random.nextInt(1, 29), random.nextInt(Calendar.getInstance().get(Calendar.MONTH) + 1, 13), 2025)
            val item = ItemProduto(random.nextLong(), validade, produtoAchocolatado)
            itens.add(item)
            estoque.entraItem(item)
        }

        // 10 itens de Presunto de 3 marcas distintas
        repeat(10) {
            val produtoPresunto = when (random.nextInt(3)) {
                0 -> prodPresDelicia
                1 -> prodPresSadia
                else -> prodPresPerdigao
            }
            val validade = Data(random.nextInt(1, 29), random.nextInt(Calendar.getInstance().get(Calendar.MONTH) + 1, 13), 2025)
            val item = ItemProduto(random.nextLong(), validade, produtoPresunto)
            itens.add(item)
            estoque.entraItem(item)
        }
        //println("Estoque inicializado com ${estoque.qtdItens()} itens.")
    }
}