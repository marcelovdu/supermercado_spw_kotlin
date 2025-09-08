package system

import model.ItemProduto

class Carrinho {

    private val itens: MutableList<ItemProduto> = mutableListOf()

    fun adicionaItem(item: ItemProduto, estoque: Estoque) {
        if (estoque.saiItem(item) != null) {
            itens.add(item)
            println("Item ${item.produto.nome} adicionado ao carrinho.")
        } else {
            println("Item ${item.produto.nome} não pôde ser adicionado. Fora de estoque?")
        }
    }

    fun removeItem(item: ItemProduto, estoque: Estoque) {
        if (itens.remove(item)) {
            estoque.entraItem(item)
            println("Item ${item.produto.nome} removido do carrinho e devolvido ao estoque.")
        } else {
            println("Item ${item.produto.nome} não encontrado no carrinho.")
        }
    }

    fun getItens(): List<ItemProduto> {
        return itens.toList()
    }

    fun totalAPagar(): Double {
        var total = 0.0
        for (item in itens) {
            total += item.produto.preco
        }
        return total
    }
}