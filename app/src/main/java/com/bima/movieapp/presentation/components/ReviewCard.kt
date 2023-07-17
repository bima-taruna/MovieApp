package com.bima.movieapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bima.movieapp.domain.model.Reviews

@Composable
fun ReviewCard(
    reviews: Reviews,
) {
   Card(
       elevation = CardDefaults.cardElevation(),
       shape = CardDefaults.shape
   ) {
       Column {
           Text(text = reviews.author.toString())
           Text(text = reviews.contents.toString())
       }
   } 
}