package Pilhas.Dinâmica
class PilhaDinamica(var tamanho: Int = 10 ): Empilhavel{
    private var ponteiroTopo : NoDuplo? = null
    private var quantidade : Int = 0
    override fun empilhar(dado : Any?){
        if(!estaCheia()){
            val noTemp = NoDuplo(dado)
            noTemp.anterior = ponteiroTopo
            if(!estaVazia()){
                ponteiroTopo?.proximo = noTemp
            }
            ponteiroTopo = noTemp
            quantidade++
        }
        else{
            println("Stack  is full!")
        }
    }

    override fun desempilhar(): Any?{
        var elementoTopo: Any? = null
        if(!estaVazia()){
            elementoTopo = ponteiroTopo?.dado
            ponteiroTopo = ponteiroTopo?.anterior
            quantidade--
        }
        else{
            println("Stack is empty!")
        }
        return elementoTopo
    }

    override fun topo(): Any?{
        var elementoTopo: Any? = null
        if(!estaVazia()){
            elementoTopo = ponteiroTopo?.dado
        } else{
            println("Stack is empty!")
        }
        return elementoTopo
    }
    override fun estaCheia(): Boolean{
        return quantidade ==  tamanho
    }
    override fun estaVazia(): Boolean{
        return quantidade == 0
    }
    override fun imprimir(): String{
        var ponteiroAuxiliar = ponteiroTopo
        var resultado = "["
        for(i in 0 until quantidade) {
            if(i != quantidade - 1) {
                resultado+="${ponteiroAuxiliar?.dado}, "
            } else
                resultado+="${ponteiroAuxiliar?.dado}"

            ponteiroAuxiliar = ponteiroAuxiliar?.anterior
        }
        return "$resultado]"
    }
}
