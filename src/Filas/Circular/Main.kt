package Filas.Circular

fun main(args: Array<String>){
    var fila: Enfileiravel = FilaEstaticaCircular()
    fila.enfileirar("7")
    fila.enfileirar("10")
    fila.enfileirar("11")
    println(fila.espiar())
    fila.desenfileirar()
    println( fila.espiar())
    fila.desenfileirar()
    fila.desenfileirar()
    fila.enfileirar("1")
    println( fila.espiar())
    fila.atualizar("2")
    println( fila.espiar())
}