package cl.duoc.restapp.data.model

data class Usuario(
    val id: Int,
    val nombre: String,
    val correo: String,
    val telefono: String,
    val password: String,
    val frase: String? = null,
    val username: String? = null
)