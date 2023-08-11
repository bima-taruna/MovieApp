@file:OptIn(ExperimentalComposeUiApi::class)

package com.bima.movieapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.unit.dp

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    text:String,
    onChange:(String)->Unit,
    keyboard: SoftwareKeyboardController?,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            value = text,
            onValueChange = onChange,
            label = { Text("Search Movie") },
            shape = RoundedCornerShape(100),
            colors = TextFieldDefaults.colors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = modifier
                .weight(1f)
                .padding(end = 8.dp)
        )
        Button(
            onClick = {
                keyboard?.hide()
                onClick()
            },
            modifier = Modifier.height(56.dp)
        ) {
            Icon(Icons.Filled.Search, contentDescription = null)
        }
    }
}