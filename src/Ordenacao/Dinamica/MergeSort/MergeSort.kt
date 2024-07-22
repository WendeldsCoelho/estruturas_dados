package Ordenacao.Dinamica.MergeSort

class MergeSort(private var lista: ListaDinamica) : Ordenavel {

    private fun trocar(no1 : NoDuplo, no2: NoDuplo){
        val temp = no1.dado
        no1.dado = no2.dado
        no2.dado = temp
    }


    override fun imprimir(){
        println(lista.imprimir())
    }

    // recebe uma lista e retorna um par de listas
    fun dividirLista(lista: ListaDinamica) : Pair<ListaDinamica, ListaDinamica>{
        // se inicio for nulo, retornar um par de listas vazias
        val inicio = lista.ponteiroInicio ?: return Pair(ListaDinamica(),ListaDinamica())
    }

    override fun ordenar(){
        mergesort(list)
    }

    fun mergesort (lista: ListaDinamica){

    }
}