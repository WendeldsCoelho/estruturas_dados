package Estudos.ListaExemplo

import Listas.EstaticaCircular.ListaEstaticaCircular

fun main() {
    val lista = ListaAlunos()

    // Criando alguns alunos
    val alunoA = Aluno("João", "2021001")
    val alunoB = Aluno("Maria", "2021002")
    val alunoC = Aluno("Pedro", "2021003")
    val alunoE = Aluno("Ana", "2021004")
    val alunoF = Aluno("Carlos", "2021005")

    // Adicionando alunos à lista
    lista.anexar(alunoA)
    lista.anexar(alunoB)
    lista.anexar(alunoC)
    println("Lista de alunos após adicionar alunos A, B, e C: ${lista.imprimir()}")

    // Selecionando um aluno na posição 1 (índice 0)
    val alunoSelecionado = lista.selecionarUm(1)
    println("Aluno selecionado na posição 1: $alunoSelecionado")

    // Atualizando o aluno na posição 1
    lista.atualizar(1, alunoE)
    println("Lista de alunos após atualizar aluno na posição 1 com o aluno E: ${lista.imprimir()}")

    // Removendo o aluno na posição 1
    val alunoRemovido = lista.apagar(1)
    println("Aluno removido na posição 1: $alunoRemovido")
    println("Lista de alunos após remover aluno na posição 1: ${lista.imprimir()}")

    // Inserindo um novo aluno na posição 1
    lista.inserir(1, alunoF)
    println("Lista de alunos após inserir aluno F na posição 1: ${lista.imprimir()}")
}