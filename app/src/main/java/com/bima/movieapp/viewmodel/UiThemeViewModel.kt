package com.bima.movieapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bima.movieapp.domain.use_case.ui_mode.GetUiMode
import com.bima.movieapp.domain.use_case.ui_mode.SetUiMode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UiThemeViewModel @Inject constructor(
    private val getUiMode: GetUiMode,
    private val setUiMode: SetUiMode
) :ViewModel() {
    private val _uiMode = mutableStateOf<Boolean?>(false)
    val uiMode: State<Boolean?> = _uiMode

    init {
        getUiSettings()
    }

    fun saveUiSettings(value:Boolean) {
        viewModelScope.launch {
            setUiMode.invoke(value)
        }
    }

     private fun getUiSettings() {
        viewModelScope.launch {
            getUiMode("isDarkMode").collect {
                _uiMode.value = it
            }
        }
    }
}