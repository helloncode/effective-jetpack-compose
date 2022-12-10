package bonni.francesco.effectivecompose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bonni.francesco.data.Person

@Composable
fun PersonRow(item: Person) {
    Text(
        text = "Name: ${item.firstName}",
    )
    Spacer(modifier = Modifier.width(8.dp))
    Text(
        text = "Surname: ${item.lastName}",
        maxLines = 1
    )
}