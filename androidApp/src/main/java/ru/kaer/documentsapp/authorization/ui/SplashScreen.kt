package ru.kaer.documentsapp.authorization.ui

import android.window.SplashScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SplashScreen() {
    Scaffold {
        Box(modifier = Modifier.fillMaxSize().padding(it)){
            Text("SplashScreen")
        }
    }
}