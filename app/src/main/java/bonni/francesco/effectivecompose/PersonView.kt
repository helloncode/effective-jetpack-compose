package bonni.francesco.effectivecompose

import PersonDetail
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import bonni.francesco.data.Person

@Composable
fun PersonView(viewModel: MainViewModel, item: Person) {
    Row(
        modifier = Modifier.clickable {
            viewModel.selected(item)
        }
    ) {
        Image(
            modifier = Modifier
                .size(48.dp)
                .background(Color.Green),
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Image"
        )
        Spacer(modifier = Modifier.width(16.dp))
        PersonDetail(modifier = Modifier.padding(16.dp), item = item)
    }
}