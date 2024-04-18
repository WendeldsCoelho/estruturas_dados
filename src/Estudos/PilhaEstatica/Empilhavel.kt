package Estudos.PilhaEstatica

interface Empilhavel {
    fun empilhar(dado: Any?)
    fun desempilhar(): Any?
    fun topo(): Any?

    fun empilhar2(dado: Any?)
    fun desempilhar2(): Any?
    fun topo2(): Any?
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun estaCheia2(): Boolean
    fun estaVazia2(): Boolean
    fun imprimir(): String
    fun imprimir2(): String
}