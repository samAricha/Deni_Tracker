package teka.android.denitracker.presentation.credit

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun AddCreditScreen(
    onDebtSaved: (String, Double, Boolean, String, String) -> Unit,
    onCancel: () -> Unit
) {
    var debtorName by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var isOwed by remember { mutableStateOf(true) }
    var date by remember { mutableStateOf("") }
    var additionalNotes by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Add Debt",
            style = MaterialTheme.typography.h5,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = debtorName,
            onValueChange = { debtorName = it },
            label = { Text("Debtor's Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        // Add more input fields for other information (e.g., date, additional notes)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Owe")
            Switch(
                checked = isOwed,
                onCheckedChange = { isOwed = it }
            )
            Text("Owed")
        }

        Button(
            onClick = {
                onDebtSaved(
                    debtorName,
                    amount.toDouble(),
                    isOwed,
                    date,
                    additionalNotes
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Save")
        }

        Button(
            onClick = onCancel,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Cancel")
        }
    }
}
