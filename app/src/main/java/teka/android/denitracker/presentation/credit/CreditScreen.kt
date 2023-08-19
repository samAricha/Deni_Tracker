package teka.android.denitracker.presentation.credit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CreditListPage(
    creditList: List<CreditItem>,
    onCreditClicked: (CreditItem) -> Unit
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
            items(creditList) { debt ->
                CreditListItem(credit = debt, onCreditClicked = onCreditClicked)
                Divider(color = Color.Gray, thickness = 1.dp)
            }
        }
    }
}

@Composable
fun CreditListItem(
    credit: CreditItem,
    onCreditClicked: (CreditItem) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCreditClicked(credit) }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = credit.debtorName, style = MaterialTheme.typography.subtitle1)
            Text(text = "${credit.amount} ${if (credit.isOwed) "Owed" else "Lent"}")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = credit.date)
    }
}

data class CreditItem(
    val debtorName: String,
    val amount: Double,
    val isOwed: Boolean,
    val date: String
)