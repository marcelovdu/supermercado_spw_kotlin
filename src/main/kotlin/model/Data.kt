package model

import java.util.Calendar

class Data(var dia: Int, var mes: Int, var ano: Int) {

    override fun toString(): String {
        return "%02d/%02d/%04d".format(dia, mes, ano)
    }

    fun setData(novoDia: Int, novoMes: Int, novoAno: Int) {
        this.dia = novoDia
        this.mes = novoMes
        this.ano = novoAno
    }

    fun antes(outraData: Data): Boolean {
        if (this.ano != outraData.ano) {
            return this.ano < outraData.ano
        }
        if (this.mes != outraData.mes) {
            return this.mes < outraData.mes
        }
        return this.dia < outraData.dia
    }

    fun depois(outraData: Data): Boolean {
        if (this.ano != outraData.ano) {
            return this.ano > outraData.ano
        }
        if (this.mes != outraData.mes) {
            return this.mes > outraData.mes
        }
        return this.dia > outraData.dia
    }

    fun igual(outraData: Data): Boolean {
        return this.dia == outraData.dia && this.mes == outraData.mes && this.ano == outraData.ano
    }

    companion object {
        fun dataHoje(): Data {
            val calendario = Calendar.getInstance()
            return Data(
                calendario.get(Calendar.DAY_OF_MONTH),
                calendario.get(Calendar.MONTH) + 1,
                calendario.get(Calendar.YEAR)
            )
        }
    }
}