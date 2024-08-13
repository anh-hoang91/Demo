package com.anhhoang.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anhhoang.myapplication.network.NetworkModule
import com.anhhoang.myapplication.network.model.Instrument
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InstrumentsViewModel : ViewModel() {
    private val _instruments = MutableStateFlow<List<Instrument>>(emptyList())
    val instruments = _instruments.asStateFlow()

    private val _hasError = MutableStateFlow(false)
    val hasError = _hasError.asStateFlow()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    _instruments.value = NetworkModule.api.getInstruments()
                } catch (e: Exception) {
                    _hasError.value = true
                }
            }
        }
    }
}