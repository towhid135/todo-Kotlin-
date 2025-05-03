package com.example.todo.ui.icons.todoz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.ui.icons.Todoz
import kotlin.Unit

public val Todoz.Home: ImageVector
    get() {
        if (_home != null) {
            return _home!!
        }
        _home = Builder(name = "Home", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(16.0f, 4.835f)
                curveTo(15.555f, 4.835f, 15.125f, 4.997f, 14.791f, 5.29f)
                lineTo(6.791f, 12.29f)
                lineTo(6.79f, 12.291f)
                curveTo(6.595f, 12.463f, 6.438f, 12.674f, 6.33f, 12.911f)
                curveTo(6.249f, 13.089f, 6.199f, 13.278f, 6.178f, 13.472f)
                lineTo(6.167f, 13.666f)
                verticalLineTo(25.333f)
                curveTo(6.167f, 25.819f, 6.36f, 26.286f, 6.704f, 26.63f)
                curveTo(7.048f, 26.973f, 7.514f, 27.167f, 8.0f, 27.167f)
                horizontalLineTo(11.167f)
                verticalLineTo(20.0f)
                curveTo(11.167f, 19.072f, 11.536f, 18.182f, 12.192f, 17.525f)
                curveTo(12.849f, 16.869f, 13.739f, 16.5f, 14.667f, 16.5f)
                horizontalLineTo(17.333f)
                curveTo(18.261f, 16.5f, 19.152f, 16.869f, 19.809f, 17.525f)
                curveTo(20.465f, 18.182f, 20.833f, 19.072f, 20.833f, 20.0f)
                verticalLineTo(27.167f)
                horizontalLineTo(24.0f)
                curveTo(24.486f, 27.167f, 24.953f, 26.974f, 25.297f, 26.63f)
                curveTo(25.641f, 26.286f, 25.833f, 25.819f, 25.833f, 25.333f)
                verticalLineTo(13.666f)
                curveTo(25.833f, 13.406f, 25.777f, 13.148f, 25.67f, 12.911f)
                curveTo(25.589f, 12.733f, 25.481f, 12.57f, 25.35f, 12.427f)
                lineTo(25.21f, 12.291f)
                lineTo(25.209f, 12.29f)
                lineTo(17.209f, 5.29f)
                curveTo(16.875f, 4.997f, 16.445f, 4.835f, 16.0f, 4.835f)
                close()
                moveTo(14.667f, 18.167f)
                curveTo(14.181f, 18.167f, 13.714f, 18.36f, 13.37f, 18.704f)
                curveTo(13.026f, 19.048f, 12.833f, 19.514f, 12.833f, 20.0f)
                verticalLineTo(27.167f)
                horizontalLineTo(19.167f)
                verticalLineTo(20.0f)
                curveTo(19.167f, 19.514f, 18.973f, 19.048f, 18.63f, 18.704f)
                curveTo(18.286f, 18.36f, 17.819f, 18.167f, 17.333f, 18.167f)
                horizontalLineTo(14.667f)
                close()
                moveTo(4.5f, 13.676f)
                curveTo(4.496f, 13.179f, 4.599f, 12.687f, 4.8f, 12.232f)
                curveTo(5.0f, 11.779f, 5.294f, 11.374f, 5.663f, 11.043f)
                lineTo(13.663f, 4.029f)
                lineTo(13.667f, 4.026f)
                curveTo(14.309f, 3.452f, 15.139f, 3.135f, 16.0f, 3.135f)
                curveTo(16.753f, 3.135f, 17.483f, 3.378f, 18.084f, 3.823f)
                lineTo(18.333f, 4.026f)
                lineTo(18.337f, 4.029f)
                lineTo(26.337f, 11.043f)
                curveTo(26.704f, 11.372f, 26.998f, 11.776f, 27.198f, 12.227f)
                curveTo(27.374f, 12.622f, 27.475f, 13.047f, 27.496f, 13.479f)
                lineTo(27.5f, 13.664f)
                verticalLineTo(25.333f)
                curveTo(27.5f, 26.261f, 27.131f, 27.152f, 26.475f, 27.809f)
                curveTo(25.818f, 28.465f, 24.928f, 28.833f, 24.0f, 28.833f)
                horizontalLineTo(8.0f)
                lineTo(7.826f, 28.829f)
                curveTo(6.961f, 28.786f, 6.141f, 28.424f, 5.525f, 27.809f)
                curveTo(4.869f, 27.152f, 4.5f, 26.261f, 4.5f, 25.333f)
                verticalLineTo(13.676f)
                close()
            }
        }
        .build()
        return _home!!
    }

private var _home: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Home, contentDescription = "")
    }
}
