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

public val Todoz.Arrowdown: ImageVector
    get() {
        if (_arrowdown != null) {
            return _arrowdown!!
        }
        _arrowdown = Builder(name = "Arrowdown", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(26.207f, 11.58f)
                curveTo(26.398f, 11.389f, 26.722f, 11.389f, 26.913f, 11.58f)
                curveTo(27.081f, 11.748f, 27.101f, 12.017f, 26.976f, 12.209f)
                lineTo(26.913f, 12.286f)
                lineTo(18.22f, 20.98f)
                curveTo(17.61f, 21.589f, 16.805f, 21.9f, 16.0f, 21.9f)
                curveTo(15.245f, 21.9f, 14.49f, 21.628f, 13.896f, 21.091f)
                lineTo(13.78f, 20.98f)
                lineTo(5.087f, 12.286f)
                curveTo(4.896f, 12.095f, 4.896f, 11.772f, 5.087f, 11.58f)
                curveTo(5.254f, 11.413f, 5.523f, 11.392f, 5.716f, 11.518f)
                lineTo(5.793f, 11.58f)
                lineTo(14.486f, 20.274f)
                curveTo(15.269f, 21.057f, 16.511f, 21.106f, 17.352f, 20.42f)
                lineTo(17.514f, 20.274f)
                lineTo(26.207f, 11.58f)
                close()
            }
        }
        .build()
        return _arrowdown!!
    }

private var _arrowdown: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Arrowdown, contentDescription = "")
    }
}
