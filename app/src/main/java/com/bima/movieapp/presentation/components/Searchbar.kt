package com.bima.movieapp.presentation.components

import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bima.movieapp.viewmodel.SearchedMovieViewModel


@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    viewModel: SearchedMovieViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }
    Log.d("searchbar", text)
    Log.d("page", viewModel.page.toString())
//    Log.d("query", viewModel.query)

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
                viewModel.query = it
                            },
            label = { Text("Search Movie") },
//            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
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
                viewModel.getSearchMovie()
//                viewModel.query = text
                      },
            modifier = Modifier.height(56.dp)
        ) {
            Icon(Icons.Filled.Search, contentDescription = null)
        }
    }

}