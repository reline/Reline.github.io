import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun Blurb() {
    Text(
        "Hey, my name's Nathan! I'm an Android Developer in the Phoenix metro area. I love spending time with my four cats, wrenching on cars, and finding myself in new places eating new food.",
        fontSize = 16.sp,
        textAlign = TextAlign.Start,
    )
}
