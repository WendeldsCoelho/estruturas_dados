package Listas.EstaticaCircular

interface Listavel {

    fun anexar(dado: Any?)
    fun inserir (posicao: Int, dado: Any?)
    fun selecionarUm(posicao: Int): Any?
    fun atualizar(posicao: Int, dado: Any?)
    fun apagar(posicao: Int): Any?

    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}