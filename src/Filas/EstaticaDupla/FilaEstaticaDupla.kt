package Filas.EstaticaDupla

class FilaEstaticaDupla(private val tamanho: Int = 10): DuplamenteEnfileiravel {
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho)
    private var quantidade = 0
    override fun enfileirarFim(dado: Any?){
        if(!estaCheia()){
            ponteiroFim++
            if(ponteiroFim == dados.size) {
                ponteiroFim = 0
            }
            quantidade++
            dados[ponteiroFim] = dado
        }
        else
            print("Queue is full!")
    }
    override fun enfileirarInicio(dado: Any?){
        if(!estaCheia()){
            ponteiroInicio--
            if(ponteiroInicio == -1){
                ponteiroInicio = dados.size - 1
            }
            quantidade++
            dados[ponteiroInicio] = dado
        }
        else
            print("Queue is full!")
    }
    override fun desenfileirarInicio(): Any?{
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
            print("Queue is empty!")
        return elementoInicio
    }
    override fun desenfileirarFim(): Any?{
        var elementoFim : Any? = null
        if(!estaVazia()){
            elementoFim = dados[ponteiroFim]
            ponteiroFim--
            if(ponteiroFim == -1){
                ponteiroFim = dados.size - 1
            }
            quantidade--
        }
        else
            print("Queue is empty")
        return elementoFim
    }

    override fun atualizarInicio(dado: Any?){
        if(!estaVazia()){
            dados[ponteiroInicio] = dado
        }
        else
            print("Queue is empty!")
    }
    override fun atualizarFim(dado: Any?){
        if(!estaVazia()){
            dados[ponteiroFim] = dado
        }
        else
            print("Queue is empty!")
    }
    override fun espiarInicio(): Any?{
        var elementoInicio: Any? = null
        if(!estaVazia()){
            elementoInicio = dados[ponteiroInicio]
        }
        return elementoInicio
    }
    override fun espiarFim(): Any?{
        var elementoFim: Any? = null
        if(!estaVazia()){
            elementoFim = dados[ponteiroFim]
        }
        return elementoFim
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
        for(i in 0 .. quantidade - 1){
            if(i == quantidade - 1)
                resultado += "${dados[ponteiroAux]}"
            else
                resultado += "${dados[ponteiroAux]},"

            ponteiroAux++

            if(ponteiroAux == dados.size)
                ponteiroAux = 0
        }
            return "${resultado}]"
    }

}