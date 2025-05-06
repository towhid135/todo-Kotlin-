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

public val Todoz.Arrowright: ImageVector
    get() {
        if (_arrowright != null) {
            return _arrowright!!
        }
        _arrowright = Builder(name = "Arrowright", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(11.527f, 5.087f)
                curveTo(11.694f, 4.919f, 11.963f, 4.899f, 12.156f, 5.024f)
                lineTo(12.233f, 5.087f)
                lineTo(20.926f, 13.78f)
                curveTo(21.513f, 14.367f, 21.846f, 15.16f, 21.846f, 16.0f)
                curveTo(21.846f, 16.791f, 21.563f, 17.535f, 21.038f, 18.104f)
                lineTo(20.93f, 18.217f)
                lineTo(20.926f, 18.22f)
                lineTo(12.241f, 26.904f)
                curveTo(12.124f, 27.011f, 11.992f, 27.059f, 11.88f, 27.06f)
                curveTo(11.752f, 27.06f, 11.628f, 27.014f, 11.527f, 26.913f)
                curveTo(11.359f, 26.746f, 11.339f, 26.477f, 11.464f, 26.284f)
                lineTo(11.527f, 26.207f)
                lineTo(20.22f, 17.514f)
                curveTo(21.003f, 16.731f, 21.052f, 15.49f, 20.367f, 14.649f)
                lineTo(20.22f, 14.486f)
                lineTo(11.527f, 5.793f)
                curveTo(11.335f, 5.602f, 11.335f, 5.278f, 11.527f, 5.087f)
                close()
            }
        }
        .build()
        return _arrowright!!
    }

private var _arrowright: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Arrowright, contentDescription = "")
    }
}
