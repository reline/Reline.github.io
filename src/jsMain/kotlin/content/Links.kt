package content

import androidx.compose.runtime.Composable
import components.Row
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Text

@Composable
fun Links() {
    Row {
        Link("GitHub", url = "https://github.com/reline")
        Link("LinkedIn", url = "https://www.linkedin.com/in/nathanreline")
        Link("StackOverflow", url = "https://stackoverflow.com/users/4780750/nathan-reline")
    }
}

@Composable
fun Link(text: String, url: String) {
    A(href = url, attrs = {
        target(ATarget.Blank)
    }) {
        Text(text)
    }
}
