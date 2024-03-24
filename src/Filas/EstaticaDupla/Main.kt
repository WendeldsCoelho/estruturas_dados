package Filas.EstaticaDupla

import Filas.Circular.Enfileiravel
import Filas.Circular.FilaEstaticaCircular

fun main(args: Array<String>){
    var fila: DuplamenteEnfileiravel = FilaEstaticaDupla()
    fila.enfileirarFim("10")
    fila.enfileirarInicio("12")
    println(fila.espiarFim())
    println(fila.espiarInicio())
    fila.atualizarFim("2")
    fila.atualizarInicio("5")
    println(fila.espiarFim())
    println(fila.espiarInicio())
    fila.enfileirarFim("10")
    fila.enfileirarFim("10")
    print(fila.imprimir())
}