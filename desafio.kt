enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val tecnologia: String)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

val inscritos = mutableListOf<Usuario>()

fun matricular(vararg usuarios: Usuario) {
    for (usuario in usuarios) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Matrícula realizada com sucesso para o usuário ${usuario.nome}")
        } else {
            println("Usuário ${usuario.nome} já está matriculado nessa formação")
        }
    }
}
}

fun main() {
val usuario1 = Usuario("João")
val usuario2 = Usuario("Maria")
val usuario3 = Usuario("Pedro")

val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 30, "Mobile")
val conteudo2 = ConteudoEducacional("Desenvolvimento Android com Kotlin", 60, "Mobile")
val conteudo3 = ConteudoEducacional("Kotlin para backend", 45, "Backend")

val formacaoKotlin = Formacao("Formação Kotlin", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2, conteudo3))

formacaoKotlin.matricular(usuario1, usuario2)
formacaoKotlin.matricular(usuario3)
formacaoKotlin.matricular(usuario2)
}