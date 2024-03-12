package Pilhas.Dupla

fun main(args: Array<String>){
    var pilha : Empilhavel = PilhaEstaticaDupla(16)
    pilha.empilhar1("Bahia")
    pilha.empilhar1("Da")
    pilha.empilhar1("Tecnologia")
    pilha.empilhar1("Ciência")
    pilha.empilhar1("Educação")
    pilha.empilhar1("de")
    pilha.empilhar1("Federal")
    pilha.empilhar1("Instituto")

    pilha.empilhar2("Bahia")
    pilha.empilhar2("Da")
    pilha.empilhar2("Tecnologia")
    pilha.empilhar2("Ciência")
    pilha.empilhar2("Educação")
    pilha.empilhar2("de")
    pilha.empilhar2("Federal")
    pilha.empilhar2("Instituto")
    pilha.desempilhar2()
    pilha.desempilhar1()
    pilha.atualizar1("Estadual")
    pilha.atualizar2("Municipal")
    println("Pilha1=${pilha.imprimir1()}")
    println("Pilha2=${pilha.imprimir2()}")
}