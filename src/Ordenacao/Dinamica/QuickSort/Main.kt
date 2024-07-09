package Ordenacao.Dinamica.QuickSort

fun main()  {
    var lista: Listavel = ListaDinamica(20)
    lista.anexar(5)
    lista.anexar(8)
    lista.anexar(2)
    lista.anexar(9)
    lista.anexar(1)

    var b: Ordenavel = QuickSort(lista)
    b.imprimir()
    b.ordenar()
    b.imprimir()
}