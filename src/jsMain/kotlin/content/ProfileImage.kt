package content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Img
import style.AppStyleSheet

@Composable
fun ProfileImage() {
    Img(src = "profile.jpg", attrs = {
        classes(AppStyleSheet.profilePicture)
    })
}
