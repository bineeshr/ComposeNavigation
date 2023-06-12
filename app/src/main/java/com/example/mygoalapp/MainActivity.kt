package com.example.mygoalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mygoalapp.ui.main.MainScreen
import com.example.mygoalapp.ui.theme.MyGoalAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGoalAppTheme {
                MainScreen(onFinish = {
                    finishAndRemoveTask()
                })
            }
        }
    }
}