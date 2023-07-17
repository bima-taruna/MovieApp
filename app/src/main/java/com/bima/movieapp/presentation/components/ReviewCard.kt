package com.bima.movieapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
       colors = CardDefaults.cardColors(),
       shape = CardDefaults.shape,
       modifier = Modifier.padding(16.dp)
   ) {
       Column(modifier = Modifier.padding(16.dp)) {
           Text(text = reviews.author.toString())
           Spacer(modifier = Modifier.padding(8.dp))
           Text(text = reviews.contents.toString())
       }
   } 
}