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

public val Todoz.Arrowleft: ImageVector
    get() {
        if (_arrowleft != null) {
            return _arrowleft!!
        }
        _arrowleft = Builder(name = "Arrowleft", defaultWidth = 42.0.dp, defaultHeight = 42.0.dp,
                viewportWidth = 42.0f, viewportHeight = 42.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(25.473f, 31.913f)
                curveTo(25.305f, 32.081f, 25.037f, 32.101f, 24.844f, 31.976f)
                lineTo(24.767f, 31.913f)
                lineTo(16.073f, 23.22f)
                curveTo(15.486f, 22.633f, 15.153f, 21.84f, 15.153f, 21.0f)
                curveTo(15.153f, 20.209f, 15.437f, 19.465f, 15.962f, 18.896f)
                lineTo(16.069f, 18.783f)
                lineTo(16.073f, 18.78f)
                lineTo(24.759f, 10.096f)
                curveTo(24.875f, 9.989f, 25.007f, 9.941f, 25.119f, 9.94f)
                curveTo(25.247f, 9.94f, 25.371f, 9.986f, 25.473f, 10.087f)
                curveTo(25.64f, 10.255f, 25.661f, 10.523f, 25.535f, 10.716f)
                lineTo(25.473f, 10.793f)
                lineTo(16.779f, 19.486f)
                curveTo(15.996f, 20.269f, 15.948f, 21.51f, 16.633f, 22.351f)
                lineTo(16.779f, 22.514f)
                lineTo(25.473f, 31.207f)
                curveTo(25.664f, 31.398f, 25.664f, 31.722f, 25.473f, 31.913f)
                close()
            }
        }
        .build()
        return _arrowleft!!
    }

private var _arrowleft: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Arrowleft, contentDescription = "")
    }
}
