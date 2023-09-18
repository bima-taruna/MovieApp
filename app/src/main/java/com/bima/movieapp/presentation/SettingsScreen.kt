package com.bima.movieapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bima.movieapp.viewmodel.UiThemeViewModel

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: UiThemeViewModel = hiltViewModel()
) {
    Column(
        modifier.fillMaxSize()
    ) {
        val check = viewModel.uiMode.value
        Row(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Dark Mode")
            Switch(checked = check!!, onCheckedChange = {
                viewModel.saveUiSettings(it)
            })
        }
    }
}