package com.bima.movieapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BigButton(
    modifier: Modifier = Modifier,
    buttonText:String,
    onClick : () -> Unit
) {
    Button(
        modifier = modifier
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        onClick = onClick
    ) {
        Text(text = buttonText, color = MaterialTheme.colorScheme.onBackground, fontWeight = FontWeight.Bold)
    }
}