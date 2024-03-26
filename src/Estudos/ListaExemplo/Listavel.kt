package Estudos.ListaExemplo

interface Listavel {
    fun anexar(dado: Aluno?)
    fun inserir(posicao: Int, dado: Aluno?)
    fun selecionarUm(posicao: Int): Aluno?
    fun atualizar(posicao: Int, dado: Aluno?)
    fun apagar(posicao: Int): Aluno?
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}