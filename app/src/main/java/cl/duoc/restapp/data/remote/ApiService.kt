package cl.duoc.restapp.data.remote

import cl.duoc.restapp.data.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}