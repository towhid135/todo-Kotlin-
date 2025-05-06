package com.example.todo.ui.icons.todoz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.ui.icons.Todoz
import kotlin.Unit

public val Todoz.Logout: ImageVector
    get() {
        if (_logout != null) {
            return _logout!!
        }
        _logout = Builder(name = "Logout", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFFFF4949)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(20.147f, 2.807f)
                horizontalLineTo(20.32f)
                curveTo(23.536f, 2.807f, 25.712f, 3.497f, 27.094f, 4.879f)
                curveTo(28.476f, 6.261f, 29.167f, 8.438f, 29.167f, 11.653f)
                verticalLineTo(20.347f)
                curveTo(29.167f, 23.563f, 28.476f, 25.739f, 27.094f, 27.121f)
                curveTo(25.712f, 28.503f, 23.536f, 29.193f, 20.32f, 29.193f)
                horizontalLineTo(20.147f)
                curveTo(17.242f, 29.193f, 15.182f, 28.619f, 13.794f, 27.486f)
                curveTo(12.504f, 26.433f, 11.719f, 24.834f, 11.429f, 22.552f)
                lineTo(11.377f, 22.086f)
                verticalLineTo(21.984f)
                curveTo(11.398f, 21.787f, 11.536f, 21.617f, 11.732f, 21.558f)
                lineTo(11.833f, 21.538f)
                lineTo(11.836f, 21.537f)
                curveTo(12.06f, 21.515f, 12.29f, 21.672f, 12.362f, 21.896f)
                lineTo(12.382f, 21.995f)
                curveTo(12.582f, 24.151f, 13.2f, 25.748f, 14.51f, 26.782f)
                curveTo(15.802f, 27.802f, 17.667f, 28.193f, 20.16f, 28.193f)
                horizontalLineTo(20.333f)
                curveTo(23.081f, 28.193f, 25.091f, 27.712f, 26.395f, 26.408f)
                curveTo(27.699f, 25.104f, 28.18f, 23.094f, 28.18f, 20.347f)
                verticalLineTo(11.653f)
                curveTo(28.18f, 8.905f, 27.699f, 6.896f, 26.395f, 5.592f)
                curveTo(25.091f, 4.288f, 23.081f, 3.807f, 20.333f, 3.807f)
                horizontalLineTo(20.16f)
                curveTo(17.653f, 3.807f, 15.78f, 4.204f, 14.487f, 5.243f)
                curveTo(13.18f, 6.294f, 12.57f, 7.914f, 12.383f, 10.1f)
                curveTo(12.347f, 10.401f, 12.101f, 10.595f, 11.833f, 10.569f)
                lineTo(11.788f, 11.054f)
                lineTo(11.833f, 10.568f)
                horizontalLineTo(11.822f)
                curveTo(11.554f, 10.549f, 11.347f, 10.312f, 11.365f, 10.029f)
                curveTo(11.585f, 7.456f, 12.38f, 5.684f, 13.76f, 4.542f)
                curveTo(15.151f, 3.391f, 17.222f, 2.807f, 20.147f, 2.807f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF4949)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(4.827f, 15.5f)
                horizontalLineTo(20.0f)
                curveTo(20.27f, 15.5f, 20.5f, 15.729f, 20.5f, 16.0f)
                curveTo(20.5f, 16.271f, 20.27f, 16.5f, 20.0f, 16.5f)
                horizontalLineTo(4.827f)
                curveTo(4.556f, 16.5f, 4.327f, 16.271f, 4.327f, 16.0f)
                curveTo(4.327f, 15.729f, 4.556f, 15.5f, 4.827f, 15.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF4949)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(7.447f, 11.18f)
                curveTo(7.638f, 10.989f, 7.961f, 10.989f, 8.153f, 11.18f)
                curveTo(8.32f, 11.348f, 8.341f, 11.616f, 8.215f, 11.809f)
                lineTo(8.153f, 11.886f)
                lineTo(4.04f, 16.0f)
                lineTo(4.393f, 16.353f)
                lineTo(8.153f, 20.114f)
                curveTo(8.344f, 20.305f, 8.344f, 20.628f, 8.153f, 20.82f)
                lineTo(8.147f, 20.826f)
                lineTo(8.141f, 20.833f)
                curveTo(8.064f, 20.915f, 7.938f, 20.966f, 7.799f, 20.966f)
                curveTo(7.704f, 20.966f, 7.61f, 20.941f, 7.527f, 20.885f)
                lineTo(7.447f, 20.82f)
                lineTo(2.98f, 16.353f)
                curveTo(2.812f, 16.185f, 2.792f, 15.917f, 2.917f, 15.724f)
                lineTo(2.98f, 15.647f)
                lineTo(7.447f, 11.18f)
                close()
            }
        }
        .build()
        return _logout!!
    }

private var _logout: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Logout, contentDescription = "")
    }
}
