package cl.duoc.restapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.duoc.restapp.viewmodel.PostViewModel

@Composable
fun PostScreen(viewModel: PostViewModel = PostViewModel()) {
    val posts by viewModel.posts.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Lista de Posts", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        posts.forEach { post ->
            Text("• ${post.title}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}
