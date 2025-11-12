package cl.duoc.restapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.duoc.restapp.data.model.Usuario
import cl.duoc.restapp.repository.UsuarioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsuarioViewModel : ViewModel() {
    private val repository = UsuarioRepository()
    private val _usuarios = MutableStateFlow<List<Usuario>>(emptyList())
    val usuarios: StateFlow<List<Usuario>> = _usuarios

    init {
        fetchUsuarios()
    }

    private fun fetchUsuarios() {
        viewModelScope.launch {
            _usuarios.value = repository.getUsuarios()
        }
    }
}
