package arvoreBinaria.heapMinimo

interface Amontoavel {
    fun inserir(dado: Long)
    fun extrair(): Long?
    fun obter(): Long?
    fun atualizar(dado: Long)

    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}