import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import bonni.francesco.data.Person
import bonni.francesco.effectivecompose.PersonRow

@Composable
fun PersonDetail(
    modifier: Modifier,
    item: Person
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            PersonRow(item = item)
        }

        Text(
            text = "Email: ${item.email}",
            maxLines = 1
        )
        Text(text = "Gender: ${item.gender}")
    }
}