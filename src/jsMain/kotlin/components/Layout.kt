package components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Main
import style.AppCSSVariables

@Composable
fun Layout(content: @Composable () -> Unit) {
    Div({
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            alignItems(AlignItems.Center)
        }
    }) {
        content()
    }
}

@Composable
fun MainContentLayout(content: @Composable () -> Unit) {
    Main({
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            width(50.percent)
            margin(4.em)
            gap(AppCSSVariables.gap.value())
        }
    }) {
        content()
    }
}

@Composable
fun Row(content: @Composable () -> Unit) {
    Div({
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            justifyContent(JustifyContent.Center)
            gap(AppCSSVariables.gap.value())
        }
    }) {
        content()
    }
}

@Composable
fun Column(content: @Composable () -> Unit) {
    Div({
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            justifyContent(JustifyContent.Center)
            gap(AppCSSVariables.gap.value())
        }
    }) {
        content()
    }
}
