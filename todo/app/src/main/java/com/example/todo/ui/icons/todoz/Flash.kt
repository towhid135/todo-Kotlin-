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

public val Todoz.Flash: ImageVector
    get() {
        if (_flash != null) {
            return _flash!!
        }
        _flash = Builder(name = "Flash", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(18.25f, 2.22f)
                curveTo(18.645f, 2.111f, 18.947f, 2.172f, 19.132f, 2.242f)
                curveTo(19.316f, 2.311f, 19.583f, 2.464f, 19.81f, 2.808f)
                curveTo(20.037f, 3.155f, 20.247f, 3.733f, 20.247f, 4.693f)
                verticalLineTo(13.793f)
                horizontalLineTo(23.867f)
                curveTo(24.679f, 13.793f, 25.186f, 13.983f, 25.503f, 14.192f)
                curveTo(25.741f, 14.349f, 25.892f, 14.531f, 25.987f, 14.688f)
                lineTo(26.066f, 14.835f)
                curveTo(26.149f, 15.022f, 26.229f, 15.309f, 26.177f, 15.682f)
                curveTo(26.124f, 16.058f, 25.932f, 16.563f, 25.398f, 17.176f)
                lineTo(15.305f, 28.643f)
                verticalLineTo(28.644f)
                curveTo(14.428f, 29.645f, 13.729f, 29.833f, 13.32f, 29.833f)
                curveTo(13.122f, 29.833f, 12.974f, 29.794f, 12.873f, 29.751f)
                lineTo(12.864f, 29.749f)
                lineTo(12.856f, 29.746f)
                lineTo(12.704f, 29.676f)
                curveTo(12.541f, 29.588f, 12.348f, 29.437f, 12.179f, 29.179f)
                curveTo(11.951f, 28.832f, 11.74f, 28.254f, 11.74f, 27.294f)
                verticalLineTo(18.193f)
                horizontalLineTo(8.12f)
                curveTo(7.308f, 18.193f, 6.801f, 18.003f, 6.484f, 17.794f)
                curveTo(6.246f, 17.637f, 6.095f, 17.455f, 6.0f, 17.298f)
                lineTo(5.922f, 17.151f)
                curveTo(5.839f, 16.964f, 5.758f, 16.678f, 5.811f, 16.304f)
                curveTo(5.863f, 15.928f, 6.056f, 15.422f, 6.591f, 14.808f)
                lineTo(6.59f, 14.807f)
                lineTo(16.683f, 3.343f)
                curveTo(17.315f, 2.625f, 17.852f, 2.33f, 18.25f, 2.22f)
                close()
                moveTo(13.75f, 28.715f)
                curveTo(13.75f, 28.715f, 13.75f, 28.714f, 13.751f, 28.713f)
                curveTo(13.752f, 28.713f, 13.753f, 28.712f, 13.755f, 28.71f)
                lineTo(13.75f, 28.715f)
                close()
                moveTo(18.236f, 3.287f)
                curveTo(18.235f, 3.288f, 18.233f, 3.29f, 18.23f, 3.292f)
                curveTo(18.232f, 3.29f, 18.233f, 3.288f, 18.234f, 3.288f)
                curveTo(18.236f, 3.286f, 18.238f, 3.285f, 18.238f, 3.285f)
                curveTo(18.238f, 3.285f, 18.238f, 3.286f, 18.236f, 3.287f)
                close()
                moveTo(25.193f, 15.131f)
                lineTo(24.917f, 14.993f)
                curveTo(24.911f, 14.99f, 24.898f, 14.984f, 24.891f, 14.98f)
                curveTo(24.872f, 14.971f, 24.85f, 14.96f, 24.822f, 14.949f)
                curveTo(24.767f, 14.926f, 24.696f, 14.902f, 24.607f, 14.878f)
                curveTo(24.43f, 14.832f, 24.187f, 14.793f, 23.867f, 14.793f)
                horizontalLineTo(19.747f)
                curveTo(19.477f, 14.793f, 19.247f, 14.564f, 19.247f, 14.293f)
                verticalLineTo(4.693f)
                curveTo(19.26f, 3.958f, 19.112f, 3.588f, 19.008f, 3.405f)
                lineTo(18.63f, 2.745f)
                lineTo(18.208f, 3.306f)
                verticalLineTo(3.307f)
                curveTo(18.17f, 3.335f, 18.108f, 3.379f, 18.032f, 3.439f)
                curveTo(17.918f, 3.53f, 17.775f, 3.654f, 17.609f, 3.828f)
                lineTo(17.438f, 4.016f)
                lineTo(7.345f, 15.483f)
                lineTo(7.344f, 15.484f)
                curveTo(7.131f, 15.727f, 6.997f, 15.939f, 6.915f, 16.113f)
                curveTo(6.839f, 16.273f, 6.794f, 16.43f, 6.794f, 16.56f)
                verticalLineTo(16.869f)
                lineTo(7.07f, 17.007f)
                curveTo(7.076f, 17.01f, 7.089f, 17.017f, 7.097f, 17.021f)
                curveTo(7.115f, 17.03f, 7.138f, 17.04f, 7.165f, 17.051f)
                curveTo(7.22f, 17.074f, 7.291f, 17.098f, 7.38f, 17.122f)
                curveTo(7.557f, 17.168f, 7.8f, 17.206f, 8.12f, 17.206f)
                horizontalLineTo(12.24f)
                curveTo(12.511f, 17.206f, 12.74f, 17.436f, 12.74f, 17.706f)
                verticalLineTo(27.307f)
                curveTo(12.74f, 28.011f, 12.864f, 28.422f, 12.998f, 28.624f)
                lineTo(13.39f, 29.212f)
                lineTo(13.778f, 28.693f)
                curveTo(13.816f, 28.665f, 13.88f, 28.621f, 13.955f, 28.561f)
                curveTo(14.108f, 28.44f, 14.311f, 28.258f, 14.552f, 27.981f)
                lineTo(14.551f, 27.98f)
                lineTo(24.643f, 16.517f)
                lineTo(24.644f, 16.516f)
                curveTo(24.856f, 16.273f, 24.99f, 16.061f, 25.072f, 15.887f)
                curveTo(25.148f, 15.727f, 25.193f, 15.57f, 25.193f, 15.44f)
                verticalLineTo(15.131f)
                close()
            }
        }
        .build()
        return _flash!!
    }

private var _flash: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Flash, contentDescription = "")
    }
}
