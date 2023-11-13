import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Header() {
    FlowRow(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically),
        horizontalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterHorizontally),
    ) {
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.align(Alignment.CenterVertically)) {
            Text("Nathan Reline", fontSize = 24.sp)
            Text("Android Engineer in Phoenix", modifier = Modifier.alpha(ContentAlpha.medium), fontSize = 20.sp)
        }
        ProfileImage(modifier = Modifier.width(450.dp))
    }
}
