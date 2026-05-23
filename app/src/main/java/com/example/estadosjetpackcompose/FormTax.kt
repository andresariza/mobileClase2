package com.example.estadosjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToLong

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormTax(viewModel : FormTaskViewModel) {



    Scaffold() { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),

            ) {

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.inputValue,
                onValueChange = { myValue ->
                    viewModel.updateCantidad(myValue)
                },
                label = {
                    Text("Cantidad")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AttachMoney,
                        contentDescription = ""
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )
            Spacer(modifier = Modifier.height(16.dp))



            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.inputPercentage,
                onValueChange = {
                    viewModel.updatePercentage(it)
                },
                label = {
                    Text("Porcentaje")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Calculate,
                        contentDescription = ""
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Redondear ")
                Switch(
                    checked = viewModel.switchRound,
                    onCheckedChange = {
                        viewModel.updateSwitchRoud(it)
                    }
                )
            }


            Text(
                text = "Resultado: ${viewModel.result}",
                fontSize = 50.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}
