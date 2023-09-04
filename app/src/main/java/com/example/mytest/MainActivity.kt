@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mytest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.mytest.ui.theme.MyTestTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTestTheme {
                HomeScreen()
                //A surface container using the 'background' color from the theme
                //Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                //}
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Box {
        Background()
        Column {
            Title("Android")
            Spacer(modifier = Modifier.height(24.dp))
            SimpleOutlinedTextFieldSample()
            PasswordTextField()
            Row {
                SimpleButton(onClick = { /*TODO*/ })
                InscriptionLink()

            }

        }
    }

}

@Composable
fun InscriptionPage() {

}

@Composable
fun Background() {
    Image(
        painter = painterResource(id = R.drawable.wallpaper_application),
        contentDescription = stringResource(id = R.string.dog_content_description),
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer(scaleX = 2.2f, scaleY = 2.2f),

        )
}


@Composable
fun Title(name: String, modifier: Modifier = Modifier, fontSize: TextUnit = 80.sp) {
    Text(
        text = "Cryptlist",
        modifier = modifier,
        fontWeight = FontWeight.Bold,
        fontSize = fontSize,
        color = Color.White
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleOutlinedTextFieldSample() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Email") }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }
    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun SimpleButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Se connecter")
    }

}

@Composable
fun InscriptionLink() {
    val destinationUrl = ""
    var isHovered by remember { mutableStateOf(false) }
    Text(
        text = "Créer un compte",
        color = if (isHovered) Color.Blue else Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .pointerInput(Unit) {
                detectTransformGestures { _, _, _, _ ->
                    isHovered = true
                }
            }
            .clickable {
            }
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTestTheme {
        HomeScreen()

    }
}