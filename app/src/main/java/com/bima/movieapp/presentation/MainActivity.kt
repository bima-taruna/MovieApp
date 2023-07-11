package com.bima.movieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bima.movieapp.R
import com.bima.movieapp.presentation.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                 val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.NowPlayingScreen.route
                ) {
                    composable(
                        route = Screen.NowPlayingScreen.route
                    ) {
                        NowPlayingScreen(navController = navController)
                    }
                    composable(
                        route = Screen.MovieDetailScreen.route + "/{movieId}"
                    ) {
                        MovieDetailScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(modifier = modifier, Arrangement.Center, Alignment.CenterHorizontally) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
            Spacer(modifier = modifier.padding(top = 8.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.to_detail))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieAppTheme {
        Greeting("Android")
    }
}