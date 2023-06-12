package com.example.mygoalapp.ui.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mygoalapp.R
import com.example.mygoalapp.ui.theme.MyGoalAppTheme
import com.example.mygoalapp.ui.theme.buttonTextColor
import com.example.mygoalapp.ui.theme.textColor

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    Surface(modifier, color = MaterialTheme.colors.surface) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.hey_welcome),
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.textColor
            )
            Text(
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                text = stringResource(id = R.string.welcome_details),
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.textColor,
                textAlign = TextAlign.Center
            )
            Button(
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 32.dp)
                    .fillMaxWidth(),
                onClick = { },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    modifier = Modifier.padding(16.dp, 8.dp),
                    text = stringResource(id = R.string.get_started),
                    color = MaterialTheme.colors.buttonTextColor
                )
            }
        }

    }
}

@Preview
@Composable
fun PreviewWelcomeScreen() {
    MyGoalAppTheme {
        WelcomeScreen()
    }
}