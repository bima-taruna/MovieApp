package com.bima.movieapp.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BigButton(
    modifier: Modifier = Modifier,
    buttonText:String,
    icon: ImageVector?,
    onClick : () -> Unit,
) {
    Button(
        modifier = modifier
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        onClick = onClick
    ) {
        Row {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier.padding(end = 8.dp).size(ButtonDefaults.IconSize)
                )
            }
            Text(text = buttonText,  fontWeight = FontWeight.Bold)
        }
    }
}