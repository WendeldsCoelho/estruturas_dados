package Filas.EstaticaDupla

interface DuplamenteEnfileiravel {
    fun enfileirarFim(dado: Any?)
    fun enfileirarInicio(dado: Any?)
    fun desenfileirarInicio(): Any?
    fun desenfileirarFim(): Any?
    fun atualizarInicio(dado: Any?)
    fun atualizarFim(dado: Any?)
    fun espiarInicio(): Any?
    fun espiarFim(): Any?

    fun estaCheia() : Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}