package io.github.jja08111.progressbutton

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private var job: Job? = null

    fun callSomeApi() {
        job?.cancel()
        job = viewModelScope.launch {
            _isLoading.update { true }
            delay(2_000)
            _isLoading.update { false }
        }
    }
}