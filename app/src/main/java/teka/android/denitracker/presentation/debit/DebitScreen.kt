package teka.android.denitracker.presentation.debit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun DebitListPage(
    debtList: List<DebtItem>,
    onDebtClicked: (DebtItem) -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Debt List",
            style = MaterialTheme.typography.h5,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(debtList) { debt ->
                DebtListItem(debt = debt, onDebtClicked = onDebtClicked)
                Divider(color = Color.Gray, thickness = 1.dp)
            }
        }
    }
}

@Composable
fun DebtListItem(
    debt: DebtItem,
    onDebtClicked: (DebtItem) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onDebtClicked(debt) }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = debt.debtorName, style = MaterialTheme.typography.subtitle1)
            Text(text = "${debt.amount} ${if (debt.isOwed) "Owed" else "Lent"}")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = debt.date)
    }
}

data class DebtItem(
    val debtorName: String,
    val amount: Double,
    val isOwed: Boolean,
    val date: String
)
