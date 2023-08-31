package teka.android.denitracker.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import teka.android.denitracker.ui.theme.TxtFieldShapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    modifier: Modifier? = Modifier,
    value: String,
    error: String? = null,
    label: String,
    onValueChanged: (String) -> Unit,
    shape: Shape = TxtFieldShapes.medium,
) {
    Column(
        modifier = modifier ?: Modifier.fillMaxWidth().background(Color.Green)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChanged,
            label = { Text(label) },
            modifier = modifier ?: Modifier.fillMaxWidth().background(Color.Green),
            shape = shape,
        )
        if (error != null) {
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomPasswordTextField(
    modifier: Modifier? = Modifier,
    value: String,
    label: String,
    onValueChanged: (String) -> Unit,
    error: String? = null,
    shape: Shape = TxtFieldShapes.medium,
) {
    Column(
        modifier = modifier ?: Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChanged,
            label = { Text(label) },
            modifier = modifier ?: Modifier.fillMaxWidth(),
            shape = shape,
            visualTransformation = PasswordVisualTransformation()
        )
        if (error != null) {
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error
            )
        }
    }

}

