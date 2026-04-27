package com.turbo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    var fps by remember { mutableStateOf(60) }

    LaunchedEffect(Unit) {
        while (true) {
            fps = (45..60).random()
            delay(1000)
        }
    }

    MaterialTheme {
        Surface {
            Text("AI TURBO APK")
            Text("FPS: $fps")
        }
    }
}
