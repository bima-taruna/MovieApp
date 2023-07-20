package com.bima.movieapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bima.movieapp.R
import com.bima.movieapp.common.Constant
import com.bima.movieapp.domain.model.Cast
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CastCard(
    cast: Cast?,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(vertical = 16.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (cast?.profilePath != null) {
            GlideImage(
                imageModel = { Constant.IMG_URL + cast.profilePath },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop
                ),
                modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp)
            )
        } else {
            Image(painter = painterResource(id = R.drawable.user), contentDescription = "default icon",  modifier = Modifier
                .clip(CircleShape)
                .size(120.dp))
        }
        Spacer(modifier = modifier.padding(8.dp))
        Text(text = cast?.name.toString(), fontWeight = FontWeight.SemiBold , style = MaterialTheme.typography.labelLarge)
        Text(text = cast?.character.toString(), fontStyle = FontStyle.Italic, textAlign = TextAlign.Center, style = MaterialTheme.typography.labelMedium)
    }

}