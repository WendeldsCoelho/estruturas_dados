package Ordenacao.Dinamica.MergeSort

interface Listavel {
    fun anexar(dado: Int)
    //fun inserir(posicao: Int, dado: Any?)
    //fun selecionar(posicao: Int): Any?
    //fun selecionarTodos(): Array<Any?>
    //fun atualizar(posicao: Int, dado: Any?)
    //fun apagar(posicao: Int): Any?
    //fun apagarTodos(): Array<Any?>
    //fun limpar()

    //fun tamanho(): Int
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}