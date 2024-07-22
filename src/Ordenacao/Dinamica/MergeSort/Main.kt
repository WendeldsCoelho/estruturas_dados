package Ordenacao.Dinamica.MergeSort

fun main()  {
    var lista = ListaDinamica(20)
    lista.anexar(5)
    lista.anexar(8)
    lista.anexar(2)
    lista.anexar(9)
    lista.anexar(1)


    var c = MergeSort(lista)
    c.imprimir()
    c.ordenar()
    c.imprimir()
}