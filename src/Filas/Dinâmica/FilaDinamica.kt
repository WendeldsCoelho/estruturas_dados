package Filas.Dinâmica

class FilaDinamica(var tamanho: Int = 10) : Enfileiravel {
    private var ponteiroInicio : NoDuplo? = null
    private var ponteiroFim : NoDuplo? = null
    private var quantidade : Int = 0


    override fun enfileirar(dado: Any?){
        if(!estaCheia()){
            var noTemp = NoDuplo(dado)
            noTemp.anterior = ponteiroFim
            if(!estaVazia()){
                ponteiroFim?.proximo = noTemp
            }
            else
                ponteiroInicio = noTemp

            ponteiroFim = noTemp
            quantidade++
        }
        else
            print("Queue is full")
    }
    override fun desenfileirar(): Any?{
        var elementoTemp : Any? = null
        if(!estaVazia()) {
            elementoTemp = ponteiroInicio?.dado
            ponteiroInicio = ponteiroInicio?.proximo
            quantidade--

            if (!estaVazia())
                ponteiroInicio?.anterior = null
            else
                ponteiroFim = null
        }
        else
            println("Queue is empty")

        return elementoTemp
    }
    override fun atualizar(dado: Any?){
        if (!estaVazia())
            ponteiroInicio?.dado = dado
        else
            println("Queue is empty")
    }
    override fun frente(): Any?{
        var elementoTemp : Any? = null
        if(!estaVazia()){
            elementoTemp  = ponteiroInicio?.dado
        }
        else
            println("Queue is empty")

        return elementoTemp
    }
    override fun estaCheia(): Boolean{
        return quantidade == tamanho
    }
    override fun estaVazia(): Boolean{
        return quantidade == 0
    }
    override fun imprimir(): String {
        var ponteiroAux = ponteiroInicio
        var resultado = "["
        for(i in 0 until quantidade){
            if(i < quantidade-1){
                resultado+= "${ponteiroAux?.dado},"
            }
            else
                resultado+= "${ponteiroAux?.dado}"

        }
        return "${resultado}]"
    }

}