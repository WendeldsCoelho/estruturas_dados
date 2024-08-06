package arvoreABP

interface Arborizavel {
    fun getRaiz(): NoTriplo?
    fun inserir(dado: Any?)
    fun apagar(dado: Any?): Boolean
    fun buscar(dado: Any?): NoTriplo?
    fun existe(dado: Any?): Boolean
    fun limpar()

    fun imprimirPreOrdem(): String
    fun imprimirEmOrdem(): String
    fun imprimirPosOrdem(): String
}