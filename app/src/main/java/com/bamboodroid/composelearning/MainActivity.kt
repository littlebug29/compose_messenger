package com.bamboodroid.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bamboodroid.composelearning.ui.home.Home
import com.bamboodroid.composelearning.ui.theme.ComposeLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearningTheme {
                Home()
            }
        }
    }
}

@Preview
@Composable
fun PreviewScreen() {
    ComposeLearningTheme {
        Home()
    }
}
