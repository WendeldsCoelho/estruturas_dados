package Listas.Dinamica

fun main() {
    var lista: Listavel = ListaDinamica()
    lista.anexar("1")
    lista.anexar("2")
    lista.inserir(2,"3")
    println("${lista.imprimir()}")
    lista.anexar("5")
    lista.apagar(0)
    lista.inserir(0,"6")
    lista.inserir(2,"7");
    println("${lista.selecionar(1)}")
    lista.atualizar(1,"8")
    println("${lista.imprimir()}")
}