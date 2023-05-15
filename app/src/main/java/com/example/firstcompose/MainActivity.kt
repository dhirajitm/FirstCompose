package com.example.firstcompose

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcompose.ui.theme.FirstComposeTheme

class MainActivity : ComponentActivity() {
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        setContent {
            NotificationScreen()

//            PreviewItem()
/*
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextUi()
                ButtonUi()
                TextFieldUi()
                CircleImageUi()
            }
*/

//            ListViewItem()
        }
    }
}

@Composable
private fun ListViewItem() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_home_24),
            contentDescription = "",
            modifier = Modifier.padding(8.dp)
        )
        Column {
            Text(
                text = "Dhiraj Gupta",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Text(
                text = "Lead Android Developer",
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Composable
private fun TextUi() {
    Text(
        text = "Hello Dhiraj",
        color = Color.Blue,
        fontSize = 28.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun ButtonUi() {
    Button(
        onClick = {
            Log.d("Click", "Button Clicked")
//            Toast.makeText(this, "Hello I'm clicked", Toast.LENGTH_SHORT).show()
        }, Modifier.padding(8.dp), colors = ButtonDefaults.buttonColors(
            contentColor = Color.Yellow,
            backgroundColor = Color.Blue
        )
    ) {
        Text(
            text = "Click Me",
            fontSize = 24.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(12.dp, 2.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.baseline_home_24),
            contentDescription = "Button click me",
            colorFilter = ColorFilter.tint(color = Color.Yellow)
        )
    }
}

@Composable
private fun TextFieldUi() {
    val state = remember {
        mutableStateOf("")
    }
    TextField(value = state.value,
        onValueChange = {
            state.value = it
        }, label = {
            Text(text = "Input Text")
        }, placeholder = {
            Text(text = "Hello")
        }, modifier = Modifier.padding(8.dp)
    )
}

@Composable
private fun CircleImageUi() {
    Image(
        painter = painterResource(id = R.drawable.baseline_home_24),
        contentDescription = "",
        modifier = Modifier
            .background(Color.LightGray, CircleShape)
            .size(60.dp)
            .border(0.6.dp, Color.Magenta, CircleShape)
            .clip(CircleShape)
            .clickable {

            }
    )
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun showPreview() {
    Greeting("Android")
}