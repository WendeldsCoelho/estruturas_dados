package ArvoreGenealogica

class ArvoreGenealogica<T>: ArvoreGenealogicaDAO<T> {

    private var raiz: NoFamiliar<T>? = null

    override fun obterRaiz(): NoFamiliar<T>? {
        return raiz
    }

    override fun criarFilho(nomeNo: String, genitor: String, dataNasc: Int, dataFal: Int?) {
        val noGenitor = buscarNo(genitor) ?: return
        val dadosNo = Dados(nomeNo, dataNasc, dataFal)
        val novoNo = NoFamiliar<T>(dadosNo)
        if (noGenitor.filhos == null) {
            noGenitor.filhos = ListaFilhos()
        }
        noGenitor.filhos?.anexar(novoNo)
    }

    override fun criarRaiz(nomeNo: String?, dataNasc: Int, dataFal: Int?) {
        val dadosNo = Dados(nomeNo, dataNasc, dataFal)
        raiz = NoFamiliar(dadosNo)
    }

    override fun criarConjuge(nomeNo: String, companheiro: String, dataNasc: Int, dataFal: Int?) {
        val noCompanheiro = buscarNo(companheiro) ?: return
        val dadosNo = Dados(nomeNo, dataNasc, dataFal)
        val novoConjuge = NoFamiliar<T>(dadosNo)
        noCompanheiro.conjuge = novoConjuge
    }

    override fun limpar() {
        raiz = null
    }

    override fun imprimir() {
        imprimirArvore(raiz)
    }

    private fun imprimirArvore(no: NoFamiliar<T>?, prefixo: String = "", isUltimo: Boolean = true, nivel: Int = 0) {
        if (no == null) return

        val relacao = when (nivel) {
            0 -> "Raiz"
            1 -> "Filho(a)"
            2 -> "Neto(a)"
            3 -> "Bisneto(a)"
            else -> "Nível $nivel"
        }

        val cônjuge = no.conjuge?.dado?.nome?.let { "Cônjuge: $it" } ?: ""


        println("${prefixo}${if (isUltimo) "└── " else "├── "}${no.dado.nome} ($relacao) $cônjuge")

        val filhos = no.filhos?.selecionarTodos()?.filterIsInstance<NoFamiliar<T>>() ?: emptyList()
        val novosPrefixos = prefixo + if (isUltimo) "    " else "│   "

        for (i in filhos.indices) {
            imprimirArvore(filhos[i], novosPrefixos, i == filhos.lastIndex, nivel + 1)
        }
    }

    override fun buscarNo(nome: String): NoFamiliar<T>? {
        if (raiz == null) return null
        val fila = ListaFilhos()
        fila.anexar(raiz)
        while (!fila.estaVazia()) {
            val noAtual = fila.apagar(0) as? NoFamiliar<T>
            if (noAtual?.dado?.nome == nome) return noAtual

            noAtual?.filhos?.selecionarTodos()?.forEach {
                fila.anexar(it)
            }
            noAtual?.conjuge?.let {
                fila.anexar(it)
            }
        }
        return null
    }

    override fun remover(nomeNo: String): Boolean {
        TODO("Not yet implemented")
    }
}