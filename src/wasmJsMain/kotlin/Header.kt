import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.LoadState
import org.jetbrains.compose.resources.rememberImageBitmap
import org.jetbrains.compose.resources.resource

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Header() {
    FlowRow(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterHorizontally),
    ) {
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.align(Alignment.CenterVertically)) {
            Text("Nathan Reline", fontSize = 24.sp)
            Text("Android Engineer in Phoenix", modifier = Modifier.alpha(ContentAlpha.medium), fontSize = 20.sp)
        }
        ProfileImage(modifier = Modifier.fillMaxWidth(.5f))
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProfileImage(modifier: Modifier = Modifier) {
    when (val bitmap = resource("profile.jpg").rememberImageBitmap()) {
        is LoadState.Success -> {
            Image(
                bitmap = bitmap.value,
                contentDescription = "Me",
                modifier = modifier
                    .clip(CircleShape)
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop,
            )
        }
        else -> {/* show nothing */}
    }
}
