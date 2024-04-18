package arvoreBinaria.heapMinimo

class ArvoreBinariaHeapMinimo(private val tamanho: Int = 10): Amontoavel {
    private var dados = LongArray(tamanho){0}
    private var ponteiroFim = -1
    override fun inserir(dado: Long){
        if(!estaCheia()){
            ponteiroFim = ponteiroFim.inc()
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        } else
            println("Heap está cheia!")
        }
    override fun extrair(): Long?{
        var dadoRaiz: Long? = null
        if(!estaVazia()){
            dadoRaiz = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim = ponteiroFim.dec()
            ajustarAbaixo(0)
        } else
            println("Heap está vazia!")
        return dadoRaiz
    }
    override fun obter(): Long?{
        var dadoRaiz : Long? = null
        if(!estaVazia()){
            dadoRaiz = dados[0]
        }else
            println("Heap está vazia!")
        return dadoRaiz
    }
    override fun atualizar(dado: Long){
        if(!estaVazia()){
            dados[0] = dado
            ajustarAbaixo(0)
        } else
            println("Heap está vazia!")
    }

    private fun ajustarAcima(indice: Int){
        var indiceAtual = indice
        while(indiceAtual != 0){
            val indicePai = indicePai(indiceAtual)
            if(dados[indicePai] > dados[indiceAtual]){
                trocar(indiceAtual, indicePai)
                indiceAtual = indicePai
            }else
                break

        }
    }

    private fun ajustarAbaixo(pai:Int){
        val filhoEsquerdo = indiceFilhoEsquerda(pai)
        val filhoDireito = indiceFilhoDireita(pai)
        var menor = pai

        if(filhoEsquerdo <= ponteiroFim){
            if(dados[menor] > dados[filhoEsquerdo]){
                menor = filhoEsquerdo
            }
        }

        if(filhoDireito <= ponteiroFim) {
            if(dados[menor] > dados[filhoDireito]){
                menor = filhoDireito
            }
        }

        if(menor!=pai){
            trocar(pai, menor)
            ajustarAbaixo(menor)
        }
    }

    private fun indicePai(indiceFilho: Int):Int{
        return(indiceFilho-1)/2
    }

    private fun  indiceFilhoEsquerda(indicePai: Int): Int{
        return  2 * indicePai + 1
    }

    private fun indiceFilhoDireita(indicePai: Int):Int{
        return  2 * indicePai + 2
    }

    private fun trocar(i: Int, j: Int){
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }
    override fun estaCheia(): Boolean{
        return ponteiroFim == dados.size - 1
    }
    override fun estaVazia(): Boolean{
        return ponteiroFim == -1
    }
    override fun imprimir(): String{
        var resultado = "["
        for(i in 0..ponteiroFim){
            resultado+="${dados[i]}"
            if(i != ponteiroFim)
                resultado+=","
        }
        return "${resultado}]"
    }
}