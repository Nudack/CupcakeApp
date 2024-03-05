package com.example.cupcakeapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.cupcakeapp.R
import com.example.cupcakeapp.sampledata.OrderUiState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SummaryScreen(orderUiState: OrderUiState, onSendButton: (String, String) -> Unit){
    Column (modifier = Modifier
        .padding(dimensionResource(id = R.dimen.padding_big))) {
        Text(text = "Quantity:", fontSize = 20.sp)
        Text(text = "${orderUiState.quantity}", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
        Text(text = "Flavor:", fontSize = 20.sp)
        Text(text = orderUiState.flavor, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
        Text(text = "Pick up date:", fontSize = 20.sp)
        Text(text = orderUiState.date, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
        Text(text = orderUiState.price, fontSize = 20.sp)
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                modifier = Modifier.padding(vertical = 4.dp),
                onClick = {
                    val summary = "Q: ${orderUiState.quantity}: F: ${orderUiState.flavor}: D: ${orderUiState.date}"
                    onSendButton("Order #198273D", summary) }) {
                Text(text = "Send to another App")
            }
        }

    }
}