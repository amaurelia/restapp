package cl.duoc.restapp.repository

import cl.duoc.restapp.data.model.Usuario
import cl.duoc.restapp.data.remote.RetrofitInstance

class UsuarioRepository {
    suspend fun getUsuarios(): List<Usuario> {
        return RetrofitInstance.api.getUsuarios()
    }
}
