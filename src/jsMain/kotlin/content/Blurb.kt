package content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun Blurb() {
    P {
        Text(
            """Hey, my name's Nathan! I'm an Android Developer in the Phoenix metro area. I love spending time 
                |with my four cats, wrenching on cars, and finding myself in new places eating new food.""".trimMargin(),
        )
    }
}
