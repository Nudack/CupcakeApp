package com.example.cupcakeapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cupcakeapp.R

@Composable
fun SelectOptionScreen(
    modifier: Modifier,
    radioButtonList: List<String>,
    currentPrice: String,
    onSelectedChange: (String) -> Unit,
    onNavigateNext: () -> Unit,
    onCancelButtonClicked: () -> Unit
){
    var selectOption by remember { mutableStateOf("") }
    val selectedOption by remember { mutableStateOf("")}
    var showError by remember { mutableStateOf(true) }
    Column(
        modifier = modifier,
    ){
        radioButtonList.forEach { eachOption: String ->
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = (selectOption == eachOption),
                    onClick = {
                        selectOption = eachOption
                        onSelectedChange(selectOption)
                        showError = false
                    }
                )
                TextButton(modifier = Modifier.padding(8.dp), onClick = {
                    selectOption = eachOption
                    onSelectedChange(selectOption)
                    showError = false
                } ){
                    Text(text = eachOption, fontSize = 20.sp)
                }
            }

        }
        if (showError) {
            Text(
                text = "Selecciona una opción primero",
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)).
                align(alignment = Alignment.CenterHorizontally),
                color = MaterialTheme.colorScheme.error,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        } else {
            Text(
                text = "Has seleccionado: $selectOption",
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                fontSize = 20.sp
            )
            Text(
                text = "Precio: $currentPrice",
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                fontSize = 20.sp
            )
            Button(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium))
                    .fillMaxWidth(),
                onClick = {  ; onNavigateNext() }) {
                Text(text = "Siguiente")
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                verticalAlignment = Alignment.Bottom
            ){
                OutlinedButton(
                    modifier = Modifier.weight(1f),
                    onClick = onCancelButtonClicked
                ) {
                    Text(text = "Cancelar")
                }
            }
        }
    }
}

