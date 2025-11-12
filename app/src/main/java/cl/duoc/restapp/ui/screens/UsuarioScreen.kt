package cl.duoc.restapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cl.duoc.restapp.viewmodel.UsuarioViewModel

@Composable
fun UsuarioScreen(viewModel: UsuarioViewModel = UsuarioViewModel()) {
    val usuarios by viewModel.usuarios.collectAsState()
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Lista de Usuarios", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        usuarios.forEach { usuario ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Avatar a la izquierda
                    val drawableId = context.resources.getIdentifier(
                        usuario.username,
                        "drawable",
                        context.packageName
                    )
                    if (drawableId != 0) {
                        Image(
                            painter = painterResource(id = drawableId),
                            contentDescription = "Avatar de ${usuario.nombre}",
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                        )
                    }
                    
                    Spacer(modifier = Modifier.width(16.dp))
                    
                    // Información del usuario
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = usuario.nombre,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "\"${usuario.frase}\"",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Correo: ${usuario.correo}",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Teléfono: ${usuario.telefono}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}
