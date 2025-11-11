package cl.duoc.restapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PruebaUiTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun muestra_lista_de_usuarios() {
        val usuarios = listOf("Camila", "Luis", "Valentina")

        composeTestRule.setContent {
            ListaDeUsuarios(usuarios)
        }

        // Verificar que un nombre aparece en pantalla
        composeTestRule.onNodeWithText("Camila").assertExists()
        composeTestRule.onNodeWithText("Valentina").assertExists()
    }
}

@Composable
private fun ListaDeUsuarios(usuarios: List<String>) {
    Column {
        usuarios.forEach { nombre ->
            Text(text = nombre, modifier = androidx.compose.ui.Modifier.testTag("usuario_$nombre"))
        }
    }
}