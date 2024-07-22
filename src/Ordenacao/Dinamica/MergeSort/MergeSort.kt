package Ordenacao.Dinamica.MergeSort

class MergeSort(private var lista: ListaDinamica) : Ordenavel {

    private fun trocar(no1: NoDuplo, no2: NoDuplo) {
        val temp = no1.dado
        no1.dado = no2.dado
        no2.dado = temp
    }

    override fun imprimir() {
        println(lista.imprimir())
    }

    fun dividirLista(lista: ListaDinamica): Pair<ListaDinamica, ListaDinamica> {
        val inicio = lista.ponteiroInicio ?: return Pair(ListaDinamica(), ListaDinamica())

        var lento: NoDuplo? = inicio
        var rapido: NoDuplo? = inicio.proximo

        while (rapido != null) {
            rapido = rapido.proximo
            if (rapido != null) {
                lento = lento?.proximo
                rapido = rapido.proximo
            }
        }

        val direita = ListaDinamica()
        direita.ponteiroInicio = lento?.proximo
        lento?.proximo?.anterior = null
        lento?.proximo = null

        val esquerda = ListaDinamica()
        esquerda.ponteiroInicio = inicio

        return Pair(esquerda, direita)
    }

    override fun ordenar() {
        mergesort(lista)
    }

    fun mergesort(lista: ListaDinamica) {
        val inicio = lista.ponteiroInicio
        if (inicio == null || inicio.proximo == null) {
            return
        }

        val (esquerda, direita) = dividirLista(lista)

        // Recursivamente ordenar as partes
        mergesort(esquerda)
        mergesort(direita)

        lista.ponteiroInicio = mesclar(esquerda.ponteiroInicio, direita.ponteiroInicio)
    }

    private fun mesclar(esq: NoDuplo?, dir: NoDuplo?): NoDuplo? {
        if (esq == null) return dir
        if (dir == null) return esq

        var resultado: NoDuplo? = null
        if (esq.dado <= dir.dado) {
            resultado = esq
            resultado.proximo = mesclar(esq.proximo, dir)
            resultado.proximo?.anterior = resultado
        } else {
            resultado = dir
            resultado.proximo = mesclar(esq, dir.proximo)
            resultado.proximo?.anterior = resultado
        }
        return resultado
    }
}