package Filas.Dinâmica

class Main {
    fun main() {
        var fila: Enfileiravel = FilaDinamica(7)
        fila.enfileirar("Instituto")
        fila.enfileirar("Federal")
        println("Topo: ${fila.frente()}")
        fila.enfileirar("de")
        fila.enfileirar("Educação")
        fila.enfileirar("Ciência")
        fila.enfileirar("e")
        println("Topo: ${fila.frente()}")
        fila.desenfileirar()
        println("fila=${fila.imprimir()}")
    }
}