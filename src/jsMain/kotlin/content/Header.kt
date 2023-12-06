package content

import androidx.compose.runtime.Composable
import components.Column
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.alignSelf
import org.jetbrains.compose.web.css.opacity
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text

@Composable
fun Header() {
    Column {
        Div({
            style {
                alignSelf(AlignSelf.Center)
            }
        }) {
            H1 {
                Text("Nathan Reline")
            }
            H2({
                style {
                    opacity(.6)
                }
            }) {
                Text("Android Engineer in Phoenix")
            }
        }
        ProfileImage()
    }
}
