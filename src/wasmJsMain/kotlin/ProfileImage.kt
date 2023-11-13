import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.LoadState
import org.jetbrains.compose.resources.rememberImageBitmap
import org.jetbrains.compose.resources.resource

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
