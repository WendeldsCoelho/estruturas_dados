package Listas.EstaticaCircular

class ListaEstaticaCircular (private val tamanho: Int  = 10): Listavel{
    private var ponteiroInicio = 0
    private var ponteiroFim = -1;
    private var dados: Array<Any?> = arrayOfNulls(tamanho)
    private var quantidade = 0

    override fun anexar(dado: Any?){
        if(!estaCheia()){
            if(ponteiroFim == dados.size - 1) {
                ponteiroFim = -1
            }
            quantidade ++
            ponteiroFim++
            dados[ponteiroFim] = dado
        }
        else
            print("List is full!")
    }
    override fun inserir (posicao: Int, dado: Any?){
        if(!estaCheia()){
            if(posicao >= 0 && posicao<=quantidade){
                var pontoManipulacao = (ponteiroInicio+posicao)% dados.size

                var ponteiroAux = ponteiroFim+1
                for (i in posicao until quantidade) {
                    var anterior = ponteiroAux-1

                    if(ponteiroAux == dados.size) {
                        ponteiroAux = 0
                    }
                    var atual = ponteiroAux

                    dados[atual] = dados[anterior]
                    ponteiroAux--
                }
                dados[pontoManipulacao] = dado
                ponteiroFim++
                if (ponteiroFim == dados.size) {
                    ponteiroFim = 0
                }
                quantidade++
            }
            else
                print("Posição informada inválida")
        }
        else
            print("List is full!")
    }
    override fun selecionarUm(posicao: Int): Any? {
        var elemento: Any? = null
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                val pontoManipulacao = (ponteiroInicio + posicao) % dados.size
                elemento = dados[pontoManipulacao]
            } else {
                println("Invalid position")
            }
        } else {
            println("List is empty")
        }
        return elemento
    }

    override fun atualizar(posicao: Int, dado: Any?){
        if(!estaVazia()){
            if(posicao>=0 && posicao < quantidade) {
                var pontoManipulacao = (ponteiroInicio + posicao) % dados.size
                dados[pontoManipulacao] = dado
            }
            else
                print("Posição informada inválida")
        }
        else
            print("List is empty")

    }
    override fun apagar(posicao: Int): Any?{
        var elementoTemp: Any? = null
        if(!estaVazia()){
            if(posicao >= 0 && posicao < quantidade) {
                var pontoManipulacao = (ponteiroInicio + posicao) % dados.size
                elementoTemp = dados[pontoManipulacao]
                var ponteiroAux = pontoManipulacao
                for(i in posicao until(quantidade-1)){
                    var atual = ponteiroAux
                    var proximo = (ponteiroAux + 1) % dados.size
                    dados[atual] = dados[proximo]
                    ponteiroAux++
                }
                ponteiroFim--
                if(ponteiroFim == -1){
                    ponteiroFim = dados.size - 1
                }
                quantidade--
            }
            else
                print("Posição informada inválida")
        }
        else
            print("List is empty")
        return elementoTemp
    }

    override fun estaCheia(): Boolean{
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
