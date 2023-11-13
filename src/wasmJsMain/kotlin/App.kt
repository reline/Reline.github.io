import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun App() {
    MaterialTheme {
        FlowColumn(
            modifier = Modifier.wrapContentSize().padding(96.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            Header()
            Links()
            Blurb()
        }
    }
}
