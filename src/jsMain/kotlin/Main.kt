import components.Layout
import components.MainContentLayout
import content.Blurb
import content.Header
import content.Links
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable
import style.AppStyleSheet

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)

        Layout {
            MainContentLayout {
                Header()
                Links()
                Blurb()
            }
        }
    }
}
