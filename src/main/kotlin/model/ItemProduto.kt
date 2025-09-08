package model

class ItemProduto(
    val codigo: Long,
    val validade: Data,
    val produto: Produto
) {

    fun valido(): Boolean {
        val dataDeHoje = Data.dataHoje()
        return this.validade.depois(dataDeHoje)
    }
}