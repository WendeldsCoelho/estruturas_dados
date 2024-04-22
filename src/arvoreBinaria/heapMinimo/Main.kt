package arvoreBinaria.heapMinimo

fun main() {
    val heap: Amontoavel = ArvoreBinariaHeapMinimo(10)
    heap.inserir(5)
    heap.inserir(2)
    heap.inserir(3)
    heap.atualizar(4)
    heap.inserir(1)
    println(heap.imprimir())
    println(heap.extrair())
    println(heap.obter())
    println(heap.obter())
    println(heap.imprimir())
}