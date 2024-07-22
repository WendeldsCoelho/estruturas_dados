package Ordenacao.Dinamica.QuickSort

import QuickSort

fun main()  {
    var lista = ListaDinamica(20)
    lista.anexar(5)
    lista.anexar(8)
    lista.anexar(2)
    lista.anexar(9)
    lista.anexar(1)


    var b = QuickSort(lista)
    b.imprimir()
    b.ordenar()
    b.imprimir()
}