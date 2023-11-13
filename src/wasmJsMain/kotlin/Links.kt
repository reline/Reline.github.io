import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Links() {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally),
    ) {
        Link("GitHub", url = "https://github.com/reline")
        Link("LinkedIn", url = "https://www.linkedin.com/in/nathanreline")
        Link("StackOverflow", url = "https://stackoverflow.com/users/4780750/nathan-reline")
    }
}

@Composable
fun Link(text: String, url: String) {
    ClickableText(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Companion.Blue, textDecoration = TextDecoration.Underline)) {
                pushStringAnnotation(tag = url, annotation = url)
                append(text)
            }
        },
        modifier = Modifier
            .pointerHoverIcon(PointerIcon.Hand),
        onClick = {
            openUrl(url)
        }
    )
}