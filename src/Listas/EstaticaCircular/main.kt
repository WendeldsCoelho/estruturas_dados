package Listas.EstaticaCircular

fun main() {
    var lista = ListaEstaticaCircular()
    lista.anexar("A")
    lista.anexar("B")
    println(lista.imprimir())
    lista.anexar("C")
    println(lista.imprimir())
    println(lista.selecionarUm(1))
    lista.atualizar(1,"E")
    println(lista.selecionarUm(1))
    lista.apagar(1)
    println(lista.imprimir())
    lista.inserir(1,"F")
    println(lista.imprimir())

}