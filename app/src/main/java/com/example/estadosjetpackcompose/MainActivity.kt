package com.example.estadosjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel : FormTaskViewModel = viewModel();
            //MyApp();
            //MyDados();
            FormTax(viewModel);
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //var contador = 0;
        var contador by remember { mutableStateOf(0) }

        Text(
            text = "Sumador de Números: $contador",
            fontSize = 50.sp,
            textAlign = TextAlign.Center
        )

        Button(
            onClick = {
                Log.i("mi-error", "Estoy haciendo click")
                contador++;
            }
        ) {
            Text(text = "Sumar +")
        }


        Button(
            onClick = {
                Log.i("mi-error2", "Estoy haciendo click")
                contador--;
            }
        ) {
            Text(text = "Restar -")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun MyDados() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var numberImage by remember { mutableStateOf(0) }
        val list = listOf(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6,
        )
        var image= list.get(numberImage);

        Image(
            painter = painterResource(image),
            contentDescription = "Bodoque",
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)

        )

        Button(
            onClick = {
                Log.i("mi-error", "Estoy haciendo click")
                numberImage = (0..5).random()
            }
        ) {
            Text(text = "Lanza el dado :)")
        }

    }
}