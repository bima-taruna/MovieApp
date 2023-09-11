package com.bima.movieapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bima.movieapp.domain.use_case.ui_mode.GetUiMode
import com.bima.movieapp.domain.use_case.ui_mode.SetUiMode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class UiThemeViewModel @Inject constructor(
    private val getUiMode: GetUiMode,
    private val setUiMode: SetUiMode
) :ViewModel() {

    fun saveUiSettings(value:Boolean) {
        viewModelScope.launch {
            setUiMode.invoke(value)
        }
    }

    fun getUiSettings() = runBlocking {
        getUiMode.invoke("isDarkMode")
    }
}