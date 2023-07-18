package com.bima.movieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.dp
import com.bima.movieapp.presentation.navigation.Navigation
import com.bima.movieapp.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           AppTheme {
               Surface(tonalElevation = 5.dp) {
                   Navigation()
               }
            }
        }
    }
}

