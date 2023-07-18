package com.bima.movieapp.presentation.components

import android.graphics.drawable.VectorDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.bima.movieapp.R
import com.bima.movieapp.domain.model.Reviews
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ReviewCard(
    reviews: Reviews,
) {
   ElevatedCard(
       elevation = CardDefaults.cardElevation(),
       colors = CardDefaults.cardColors(
           containerColor = MaterialTheme.colorScheme.tertiaryContainer
       ),
       shape = CardDefaults.shape,
       modifier = Modifier.padding(16.dp)
   ) {
       Column(modifier = Modifier.padding(16.dp)) {
           Row() {
               if(reviews.avatar_path.isNullOrEmpty()) {
                   Icon(
                       imageVector = ImageVector.vectorResource(
                           id = R.drawable.baseline_account_circle_24),
                       contentDescription = "reviewer profile pic",
                       modifier = Modifier.size(60.dp)
                   )
               } else {
                   GlideImage(
                       imageModel = { reviews.avatar_path?.drop(1) },
                       imageOptions = ImageOptions(
                           contentScale = ContentScale.Crop
                       ),
                       modifier = Modifier
                           .clip(CircleShape)
                           .size(60.dp)
                   )
               }
               Text(text = reviews.author.toString(), modifier = Modifier
                   .align(Alignment.CenterVertically)
                   .padding(start = 16.dp),
                   color = MaterialTheme.colorScheme.onSurfaceVariant,
                   style = MaterialTheme.typography.labelLarge
               )
           }
           Spacer(modifier = Modifier.padding(8.dp))
           Text(text = reviews.contents.toString(),
               color = MaterialTheme.colorScheme.onSurfaceVariant,
               style = MaterialTheme.typography.bodyMedium
           )
       }
   } 
}