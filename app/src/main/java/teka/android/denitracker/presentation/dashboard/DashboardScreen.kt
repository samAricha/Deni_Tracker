package teka.android.denitracker.presentation.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen(totalOwed: Double, totalLent: Double) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Dashboard",
            style = MaterialTheme.typography.h5,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Overview",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total Owed:",
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "$$totalOwed",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total Lent:",
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "$$totalLent",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // Placeholder for graphs or charts
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Graphs and Charts Placeholder",
            style = MaterialTheme.typography.subtitle1,
            color = Color.Gray
        )
    }
}
