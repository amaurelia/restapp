package cl.duoc.restapp.repository

import cl.duoc.restapp.data.model.Post
import cl.duoc.restapp.data.remote.RetrofitInstance

class PostRepository {
    suspend fun getPosts(): List<Post> {
        return RetrofitInstance.api.getPosts()
    }
}
