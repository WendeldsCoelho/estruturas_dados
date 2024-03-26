package Estudos.ListaExemplo

class ListaAlunos(private val tamanho: Int = 10): Listavel {
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var alunos: Array<Aluno?> = arrayOfNulls(tamanho)
    private var quantidade = 0

    override fun anexar(aluno: Aluno?) {
        if (!estaCheia()) {
            if (ponteiroFim == alunos.size - 1) {
                ponteiroFim = -1
            }
            quantidade++
            ponteiroFim++
            alunos[ponteiroFim] = aluno
        } else {
            println("List is full!")
        }
    }

    override fun inserir(posicao: Int, aluno: Aluno?) {
        if (!estaCheia()) {
            if (posicao >= 0 && posicao <= quantidade) {
                val pontoManipulacao = (ponteiroInicio + posicao) % alunos.size
                var ponteiroAux = ponteiroFim + 1
                for (i in posicao until quantidade) {
                    val anterior = ponteiroAux - 1
                    if (ponteiroAux == alunos.size) {
                        ponteiroAux = 0
                    }
                    val atual = ponteiroAux
                    alunos[atual] = alunos[anterior]
                    ponteiroAux--
                }
                alunos[pontoManipulacao] = aluno
                ponteiroFim++
                if (ponteiroFim == alunos.size) {
                    ponteiroFim = 0
                }
                quantidade++
            } else {
                println("Invalid position")
            }
        } else {
            println("List is full!")
        }
    }

    override fun selecionarUm(posicao: Int): Aluno? {
        var aluno: Aluno? = null
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                val pontoManipulacao = (ponteiroInicio + posicao) % alunos.size
                aluno = alunos[pontoManipulacao]
            } else {
                println("Invalid position")
            }
        } else {
            println("List is empty")
        }
        return aluno
    }

    override fun atualizar(posicao: Int, aluno: Aluno?) {
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                val pontoManipulacao = (ponteiroInicio + posicao) % alunos.size
                alunos[pontoManipulacao] = aluno
            } else {
                println("Invalid position")
            }
        } else {
            println("List is empty")
        }
    }

    override fun apagar(posicao: Int): Aluno? {
        var alunoTemp: Aluno? = null
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                val pontoManipulacao = (ponteiroInicio + posicao) % alunos.size
                alunoTemp = alunos[pontoManipulacao]
                var ponteiroAux = pontoManipulacao
                for (i in posicao until (quantidade - 1)) {
                    val atual = ponteiroAux
                    val proximo = (ponteiroAux + 1) % alunos.size
                    alunos[atual] = alunos[proximo]
                    ponteiroAux++
                }
                ponteiroFim--
                if (ponteiroFim == -1) {
                    ponteiroFim = alunos.size - 1
                }
                quantidade--
            } else {
                println("Invalid position")
            }
        } else {
            println("List is empty")
        }
        return alunoTemp
    }

    override fun estaCheia(): Boolean {
        return quantidade == alunos.size
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {
        var resultado = "["
        var ponteiroAux = ponteiroInicio
        for (i in 0 until quantidade) {
            resultado += "${alunos[ponteiroAux]}"
            ponteiroAux = (ponteiroAux + 1) % alunos.size
            if (i < quantidade - 1) {
                resultado += ","
            }
        }
        resultado += "]"
        return resultado
    }
}

data class Aluno(val nome: String, val matricula: String)