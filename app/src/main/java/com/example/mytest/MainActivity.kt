@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mytest

import android.os.Bundle
import android.renderscript.RenderScript
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem

import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.Border
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.example.mytest.ui.theme.MyTestTheme
import java.time.format.TextStyle


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTestTheme {
                Navigation()
                //A surface container using the 'background' color from the theme
                //Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                //}
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Box()
    {
        Background()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Title("Android", boolean = true)
            Spacer(modifier = Modifier.height(24.dp))
            SimpleOutlinedTextFieldSample()
            PasswordTextField()
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SimpleButtonConnect(onClick = { navController.navigate("ToDoPage") })
                InscriptionLink(onClick = { navController.navigate("InscriptionPage") })
            }
        }
    }
}

@Composable
fun InscriptionPage(navController: NavHostController) {
    Box()
    {
        Background()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Title("Android", boolean = false)
            Spacer(modifier = Modifier.height(24.dp))
            SimpleOutlinedTextFieldSample()
            PasswordTextField()
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SimpleButtonInscription(onClick = { navController.navigate("HomeScreen") })
            }
        }
    }
}

@Composable
fun ToDoPage(navController: NavHostController) {
    Box()
    {
        Background()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleList("Android")
            ToDoListApp()
        }
    }
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
fun Title(name: String, modifier: Modifier = Modifier, fontSize: TextUnit = 80.sp, boolean: Boolean) {
    Text(
        text = "Cryptlist",
        modifier = modifier,
        fontWeight = FontWeight.Bold,
        fontSize = fontSize,
        color = Color.White,
    )
    if (boolean) {
        Text(
            text = "connection",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    } else {
        Text(
            text = "inscription",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun TitleList(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Ma ToDoCryptList",
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleOutlinedTextFieldSample() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Email") },
        modifier = Modifier.padding(10.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
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
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.padding(10.dp)
    )
}

@Composable
fun SimpleButtonConnect(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Se connecter")
    }

}

@Composable
fun SimpleButtonInscription(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("S'inscrire")
    }

}

@Composable
fun InscriptionLink(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Créer un compte")
    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalTvMaterial3Api::class)
@Composable
fun ToDoListApp() {
    var newTask by remember { mutableStateOf("") }
    val tasks = remember {
        mutableStateListOf(
            ""
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Champ de texte pour ajouter une tâche
        TextField(
            value = newTask,
            onValueChange = { newValue ->
                newTask = newValue
            },
            label = {Text("Content")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            singleLine = true,
            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 18.sp)
        )

        // Bouton pour ajouter une tâche
        Button(
            onClick = {
                if (newTask.isNotBlank()) {
                    tasks.add(newTask)
                    newTask = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Ajouter une tâche")
        }

        // Liste des tâches
        LazyColumn {
            items(items = tasks) { task ->
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color.Green.copy(alpha = 0.5f),
                        Color.Green.copy(alpha = 0.5f)
                    ),
                    startX = 0f,
                    endX = Float.POSITIVE_INFINITY
                )
                    ).border(2.dp, Color.White)
                )
                {
                    Text(text = task, fontSize = 30.sp, color = Color.White)
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTestTheme {
        Navigation()

    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable("HomeScreen") {
            HomeScreen(navController)
        }
        composable("InscriptionPage") {
            InscriptionPage(navController)
        }
        composable("ToDoPage") {
            ToDoPage(navController)
        }
    }
}