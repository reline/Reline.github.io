package style

import org.jetbrains.compose.web.css.*

object AppCSSVariables {
    val gap by variable<CSSUnitValue>()
}

object AppStyleSheet : StyleSheet() {
    val profilePicture by style {
        borderRadius(50.percent)
        property(
            "aspect-ratio",
            1
        )
        property(
            "object-fit",
            "cover"
        )
    }

    init {
        universal style {
            AppCSSVariables.gap(2.em)

            fontWeight("normal")
            property(
                "font-family",
                "Droid Sans Mono,system-ui,-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Cantarell,Droid Sans,Helvetica Neue,Arial,sans-serif"
            )
        }

        "h1, h2" style {
            margin(0.px)
        }
    }
}
