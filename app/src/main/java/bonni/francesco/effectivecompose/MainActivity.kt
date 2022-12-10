package bonni.francesco.effectivecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bonni.francesco.effectivecompose.R
import bonni.francesco.effectivecompose.ui.theme.EffectiveComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EffectiveComposeTheme {
                val state = viewModel.state.collectAsState()
                val coroutineScope = rememberCoroutineScope()
                var shuffleCount by remember { mutableStateOf(0) }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {

                    Box {
                        val listState = rememberLazyListState()
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            contentPadding = PaddingValues(16.dp),
                            state = listState
                        ) {
                            items(items = state.value.fakeData.shuffled()) { item ->
                                PersonView(viewModel = viewModel, item = item)
                            }
                        }

                        val showButton = listState.firstVisibleItemIndex > 0

                        AnimatedVisibility(
                            modifier = Modifier
                                .align(Alignment.BottomEnd),
                            visible = showButton) {
                            Button(
                                modifier = Modifier
                                    .height(48.dp)
                                    .width(120.dp),
                                onClick = {
                                    coroutineScope.launch {
                                        listState.scrollToItem(0)
                                    }
                                }) {
                                Text("Scroll To Top")
                            }
                        }

                        Button(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .height(48.dp)
                                .width(120.dp),
                            onClick = {
                                viewModel.shuffle()
                            }) {
                            Text("Shuffle")
                        }

                        shuffleCount++
                    }
                }
            }
        }
    }
}