package Hash


class ListaDinamica(var tamanho : Int? = 10) : Listavel {
    var quantidade : Int = 0
    var ponteiroInicio : NoDuplo? = null
    var ponteiroFim : NoDuplo? = null
    override fun anexar(dado: Any?){
        if (!estaCheia()) {
            val noTemp = NoDuplo(dado)
            noTemp.anterior = ponteiroFim
            if (!estaVazia())
                ponteiroFim?.proximo = noTemp
            else
                ponteiroInicio = noTemp

            ponteiroFim = noTemp
            quantidade++
        } else {
            println("List is Full")
        }
    }
    override fun inserir(posicao: Int, dado: Any?){
        if (!estaCheia()) {
            if (posicao >= 0 && posicao <= quantidade) {
                val noTemp = NoDuplo(dado)
                var ponteiroAnterior: NoDuplo? = null
                var ponteiroProximo = ponteiroInicio

                for (i in 0 until posicao) {
                    ponteiroAnterior = ponteiroProximo
                    ponteiroProximo = ponteiroProximo?.proximo
                }


                if (ponteiroAnterior != null)
                    ponteiroAnterior.proximo = noTemp
                else
                    ponteiroInicio = noTemp

                if (ponteiroProximo != null)
                    ponteiroProximo.anterior = noTemp
                else
                    ponteiroFim = noTemp

                noTemp.proximo = ponteiroProximo
                noTemp.anterior = ponteiroAnterior

                quantidade = quantidade.inc()
            } else {
                println("Invalid Index")
            }
        } else {
            println("List is full")
        }
    }

    override fun selecionar(posicao: Int): Any?{
        var dadoAux : Any? = null
        if(!estaVazia()){
            var ponteiroAux = ponteiroInicio
            for(i in 0 until posicao){
                if(i == posicao - 1)
                    ponteiroAux = ponteiroAux?.proximo
            }
        }
        else
            println("List is empty")

        return dadoAux
    }
    override fun selecionarTodos(): Array<Any?>{
        var dadosAux : Array<Any?> = arrayOfNulls(quantidade)
        if (!estaVazia()){
            var ponteiroAux = ponteiroInicio
            for(i in 0 until quantidade){
                dadosAux[i] = ponteiroAux?.dado
                ponteiroAux = ponteiroAux?.proximo
            }
        }
        else
            println("List is empty")

        return dadosAux
    }
    override fun atualizar(posicao: Int, dado: Any?){
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var ponteiroAuxiliar = ponteiroInicio
                for (i in 0 until posicao)
                    ponteiroAuxiliar = ponteiroAuxiliar?.proximo
                ponteiroAuxiliar?.dado = dado
            } else {
                println("Invalid Index")
            }
        } else {
            println("List is Empty")
        }
    }
    override fun apagar(posicao: Int): Any?{
        var dadoAux : Any? = null
        if(!estaVazia()){
            if(posicao >= 0 && posicao < quantidade){
                var ponteiroAux = ponteiroInicio
                for(i in 0 until posicao)
                    ponteiroAux = ponteiroAux?.proximo

                dadoAux = ponteiroAux?.dado

                val ponteiroAnterior = ponteiroAux?.anterior
                val ponteiroProximo = ponteiroAux?.proximo

                if(ponteiroAnterior != null)
                    ponteiroAnterior.proximo = ponteiroProximo
                else
                    ponteiroInicio = ponteiroInicio?.proximo

                if (ponteiroProximo != null)
                    ponteiroProximo.anterior = ponteiroAnterior
                else
                    ponteiroFim = ponteiroFim?.anterior

                quantidade--
            }
            else
                println("Invalid Index")
        }
        else
            println("List is empty")

        return dadoAux
    }
    override fun apagarTodos(): Array<Any?>{
        var dadosAux : Array<Any?> = selecionarTodos()
        limpar()
        return dadosAux
    }

    override fun limpar(){
        ponteiroInicio = null
        ponteiroFim = null
        quantidade = 0
    }
    override fun tamanho(): Int{
        return quantidade
    }
    override fun estaCheia(): Boolean{
        return quantidade == tamanho
    }
    override fun estaVazia(): Boolean{
        return quantidade == 0
    }
    override fun imprimir(): String{
        var ponteiroAux = ponteiroInicio
        var resultado = "["
        for (i in 0 until quantidade) {
            if (i <  quantidade-1)
                resultado += "${ponteiroAux?.dado},"
            else
                resultado += "${ponteiroAux?.dado}"

            ponteiroAux = ponteiroAux?.proximo
        }
        return "$resultado]"
    }
}