package com.example.mygoalapp.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.mygoalapp.R
import com.example.mygoalapp.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashScreenFinished: () -> Unit) {
    val splashImage = painterResource(id = R.drawable.splash_image)
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = splashImage,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
    LaunchedEffect(key1 = true) {
        delay(2000)
        onSplashScreenFinished()
    }
}