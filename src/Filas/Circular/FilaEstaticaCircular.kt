package Filas.Circular

class FilaEstaticaCircular(private val tamanho: Int = 10) : Enfileiravel {
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho)
    private var quantidade = 0
    override fun enfileirar(dado: Any?){
        if(!estaCheia()){
            if(ponteiroFim == dados.size){
                ponteiroFim = 0
            }
            quantidade ++
            ponteiroFim++
            dados[ponteiroFim] = dado
        }
        else
            println("Queue is full.")
    }
    override fun desenfileirar(): Any?{
        var elementoInicio: Any? = null
        if(!estaVazia()){
            elementoInicio = dados[ponteiroInicio]
            ponteiroInicio++

            if(ponteiroInicio == dados.size){
                ponteiroInicio = 0
            }
            quantidade--
        }
        else
            println("Queue is empty.")
        return elementoInicio
    }
    override fun atualizar(dado: Any?){
        if(!estaVazia()){
            dados[ponteiroInicio] = dado
        }
        else
            println("Queue is empty")
    }
    override fun espiar(): Any?{
        var elementoInicio: Any? = null
        if(!estaVazia()){
            elementoInicio = dados[ponteiroInicio]
        }
        else
            println("Queue is empty")
        return elementoInicio
    }

    override fun estaCheia() : Boolean{
        return(quantidade == dados.size)
    }
    override fun estaVazia(): Boolean{
        return(quantidade == 0)
    }
    override fun imprimir(): String{
        var resultado = "["
        var ponteiroAux = ponteiroInicio
        for(i in 0..quantidade - 1) {
            if (i == quantidade - 1)
                resultado += "${dados[ponteiroAux % dados.size]}"
            else
                resultado += "${dados[ponteiroAux % dados.size]},"
        }
        return "${resultado}]"
    }
}