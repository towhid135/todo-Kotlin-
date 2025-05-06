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

public val Todoz.Like: ImageVector
    get() {
        if (_like != null) {
            return _like!!
        }
        _like = Builder(name = "Like", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(15.028f, 4.319f)
                curveTo(15.739f, 3.258f, 17.334f, 2.737f, 18.556f, 3.2f)
                lineTo(18.577f, 3.208f)
                curveTo(20.004f, 3.676f, 20.922f, 5.268f, 20.604f, 6.72f)
                lineTo(20.599f, 6.749f)
                lineTo(19.945f, 10.95f)
                verticalLineTo(10.956f)
                curveTo(19.925f, 11.097f, 19.905f, 11.416f, 20.144f, 11.689f)
                lineTo(20.154f, 11.701f)
                lineTo(20.166f, 11.713f)
                curveTo(20.329f, 11.876f, 20.551f, 11.967f, 20.786f, 11.967f)
                horizontalLineTo(26.12f)
                curveTo(27.214f, 11.967f, 28.135f, 12.393f, 28.708f, 13.102f)
                lineTo(28.817f, 13.247f)
                lineTo(28.818f, 13.249f)
                curveTo(29.366f, 14.02f, 29.493f, 15.058f, 29.116f, 16.096f)
                lineTo(29.114f, 16.103f)
                lineTo(29.111f, 16.111f)
                lineTo(25.925f, 25.818f)
                lineTo(25.92f, 25.833f)
                lineTo(25.915f, 25.85f)
                curveTo(25.482f, 27.547f, 23.639f, 28.967f, 21.706f, 28.967f)
                horizontalLineTo(16.64f)
                curveTo(16.307f, 28.967f, 15.758f, 28.914f, 15.195f, 28.762f)
                curveTo(14.626f, 28.608f, 14.098f, 28.365f, 13.753f, 28.02f)
                lineTo(13.731f, 27.997f)
                lineTo(13.705f, 27.978f)
                lineTo(10.061f, 25.163f)
                lineTo(10.676f, 24.367f)
                lineTo(14.414f, 27.262f)
                curveTo(14.663f, 27.483f, 15.022f, 27.648f, 15.377f, 27.758f)
                curveTo(15.765f, 27.878f, 16.211f, 27.953f, 16.64f, 27.953f)
                horizontalLineTo(21.706f)
                curveTo(22.433f, 27.953f, 23.159f, 27.666f, 23.734f, 27.24f)
                curveTo(24.297f, 26.824f, 24.765f, 26.236f, 24.941f, 25.57f)
                lineTo(28.168f, 15.77f)
                lineTo(28.167f, 15.769f)
                curveTo(28.397f, 15.125f, 28.395f, 14.459f, 28.063f, 13.92f)
                lineTo(27.991f, 13.814f)
                curveTo(27.58f, 13.237f, 26.873f, 12.953f, 26.106f, 12.953f)
                horizontalLineTo(20.773f)
                curveTo(20.292f, 12.953f, 19.848f, 12.776f, 19.514f, 12.466f)
                lineTo(19.377f, 12.325f)
                verticalLineTo(12.325f)
                lineTo(19.253f, 12.166f)
                curveTo(18.987f, 11.783f, 18.873f, 11.304f, 18.947f, 10.797f)
                lineTo(19.614f, 6.517f)
                lineTo(19.612f, 6.516f)
                curveTo(19.809f, 5.521f, 19.158f, 4.463f, 18.225f, 4.144f)
                horizontalLineTo(18.226f)
                curveTo(18.222f, 4.142f, 18.218f, 4.141f, 18.215f, 4.14f)
                curveTo(18.214f, 4.14f, 18.212f, 4.139f, 18.211f, 4.139f)
                horizontalLineTo(18.21f)
                curveTo(17.753f, 3.976f, 17.265f, 4.022f, 16.866f, 4.156f)
                curveTo(16.518f, 4.272f, 16.177f, 4.475f, 15.946f, 4.744f)
                lineTo(15.854f, 4.864f)
                lineTo(15.852f, 4.867f)
                lineTo(10.663f, 12.586f)
                lineTo(9.841f, 12.036f)
                lineTo(15.028f, 4.319f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(5.84f, 8.367f)
                horizontalLineTo(7.173f)
                curveTo(8.337f, 8.367f, 9.105f, 8.641f, 9.584f, 9.103f)
                curveTo(10.06f, 9.562f, 10.34f, 10.292f, 10.34f, 11.4f)
                verticalLineTo(24.466f)
                curveTo(10.34f, 25.574f, 10.06f, 26.304f, 9.584f, 26.763f)
                curveTo(9.105f, 27.226f, 8.337f, 27.5f, 7.173f, 27.5f)
                horizontalLineTo(5.84f)
                curveTo(4.677f, 27.5f, 3.909f, 27.226f, 3.429f, 26.763f)
                curveTo(2.953f, 26.304f, 2.673f, 25.574f, 2.673f, 24.466f)
                verticalLineTo(11.4f)
                curveTo(2.673f, 10.292f, 2.953f, 9.562f, 3.429f, 9.103f)
                curveTo(3.909f, 8.641f, 4.677f, 8.367f, 5.84f, 8.367f)
                close()
                moveTo(5.84f, 9.367f)
                curveTo(5.463f, 9.367f, 5.134f, 9.388f, 4.856f, 9.452f)
                curveTo(4.574f, 9.516f, 4.313f, 9.63f, 4.108f, 9.834f)
                curveTo(3.902f, 10.041f, 3.796f, 10.295f, 3.741f, 10.555f)
                curveTo(3.687f, 10.808f, 3.673f, 11.096f, 3.673f, 11.4f)
                verticalLineTo(24.466f)
                curveTo(3.673f, 24.771f, 3.687f, 25.059f, 3.741f, 25.312f)
                curveTo(3.796f, 25.572f, 3.902f, 25.826f, 4.108f, 26.032f)
                curveTo(4.313f, 26.237f, 4.573f, 26.35f, 4.856f, 26.415f)
                curveTo(5.134f, 26.478f, 5.463f, 26.5f, 5.84f, 26.5f)
                horizontalLineTo(7.173f)
                curveTo(7.551f, 26.5f, 7.88f, 26.478f, 8.158f, 26.415f)
                curveTo(8.44f, 26.35f, 8.7f, 26.237f, 8.905f, 26.032f)
                curveTo(9.111f, 25.826f, 9.217f, 25.572f, 9.273f, 25.312f)
                curveTo(9.327f, 25.059f, 9.34f, 24.771f, 9.34f, 24.466f)
                verticalLineTo(11.4f)
                curveTo(9.34f, 11.096f, 9.327f, 10.808f, 9.273f, 10.555f)
                curveTo(9.217f, 10.295f, 9.111f, 10.041f, 8.905f, 9.834f)
                curveTo(8.7f, 9.63f, 8.44f, 9.516f, 8.158f, 9.452f)
                curveTo(7.88f, 9.388f, 7.551f, 9.367f, 7.173f, 9.367f)
                horizontalLineTo(5.84f)
                close()
            }
        }
        .build()
        return _like!!
    }

private var _like: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Like, contentDescription = "")
    }
}
