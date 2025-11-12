package cl.duoc.restapp.data.remote

import cl.duoc.restapp.data.model.Usuario
import retrofit2.http.GET

interface ApiService {
    @GET("api.php?endpoint=obtenerUsuarios")
    suspend fun getUsuarios(): List<Usuario>
}