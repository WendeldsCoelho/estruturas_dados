package Estudos.PilhaEstatica

class PilhaEstatica(private val tamanho:Int = 10): Empilhavel {
    private var ponteiroTopo = -1
    private var ponteiroTopo2 = tamanho
    private var dados: Array<Any?> = arrayOfNulls(tamanho)
    private var quantidade = 0

    override fun empilhar(dado: Any?){
        if(!estaVazia()) {
            ponteiroTopo++
            dados[ponteiroTopo] = dado
        }
        else
            print("Stack is empty!")
    }

    override fun empilhar2(dado: Any?){
        if(!estaVazia()) {
            ponteiroTopo2--
            dados[ponteiroTopo2] = dado
        }
        else
            print("Stack is empty!")
    }
    override fun desempilhar(): Any?{
        var elemento: Any? = null
        if(!estaVazia()){
            elemento = dados[ponteiroTopo]
            ponteiroTopo--
            quantidade--
        }
        else
            print("Stack is empty")
        return elemento
    }

    override fun desempilhar2(): Any?{
        var elemento: Any? = null
        if(!estaVazia()){
            elemento = dados[ponteiroTopo2]
            ponteiroTopo++
        }
        else
            print("Stack is empty")
        return elemento
    }
    override fun topo(): Any?{
        var elemento: Any? = null
        if(!estaVazia()){
            elemento = dados[ponteiroTopo]
        }
        else
            print("Stack is empty")
        return elemento
    }

    override fun topo2(): Any?{
        var elemento: Any? = null
        if(!estaVazia()){
            elemento = dados[ponteiroTopo2]
        }
        else
            print("Stack is empty")
        return elemento
    }

    override fun estaCheia(): Boolean{
        return(ponteiroTopo == (ponteiroTopo-1))
    }
    override fun estaVazia(): Boolean{
        return(ponteiroTopo == -1)
    }

    override fun estaCheia2(): Boolean{
        return(ponteiroTopo == (ponteiroTopo-1))
    }
    override fun estaVazia2(): Boolean{
        return(ponteiroTopo2 == dados.size)
    }
    override fun imprimir(): String{
        var resultado = "["
        for(i in quantidade downTo 0){
            if(i == 0)
                resultado += "${dados[i]}"
            else
                resultado += "${dados[i]}"
        }
        return "${resultado}]"
    }

    override fun imprimir2(): String{
        var resultado = "["
        for(i in ponteiroTopo2 .. dados.size-1){
            if(i == 0)
                resultado += "${dados[i]}"
            else
                resultado += "${dados[i]}"
        }
        return "${resultado}]"
    }
}