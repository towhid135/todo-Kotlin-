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

public val Todoz.Homefill: ImageVector
    get() {
        if (_homefill != null) {
            return _homefill!!
        }
        _homefill = Builder(name = "Homefill", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(12.026f, 4.289f)
                curveTo(13.809f, 2.908f, 16.654f, 2.794f, 18.57f, 4.008f)
                lineTo(18.753f, 4.13f)
                lineTo(26.434f, 9.503f)
                curveTo(27.086f, 9.959f, 27.694f, 10.701f, 28.14f, 11.554f)
                curveTo(28.585f, 12.408f, 28.847f, 13.333f, 28.847f, 14.134f)
                verticalLineTo(23.174f)
                curveTo(28.847f, 26.297f, 26.31f, 28.834f, 23.187f, 28.834f)
                horizontalLineTo(8.813f)
                curveTo(5.691f, 28.834f, 3.153f, 26.285f, 3.153f, 23.16f)
                verticalLineTo(13.96f)
                curveTo(3.153f, 13.215f, 3.389f, 12.338f, 3.795f, 11.514f)
                curveTo(4.15f, 10.794f, 4.618f, 10.147f, 5.127f, 9.686f)
                lineTo(5.348f, 9.501f)
                lineTo(12.026f, 4.289f)
                close()
                moveTo(16.0f, 18.5f)
                curveTo(15.177f, 18.5f, 14.5f, 19.177f, 14.5f, 20.0f)
                verticalLineTo(24.0f)
                curveTo(14.5f, 24.823f, 15.177f, 25.5f, 16.0f, 25.5f)
                curveTo(16.823f, 25.5f, 17.5f, 24.823f, 17.5f, 24.0f)
                verticalLineTo(20.0f)
                curveTo(17.5f, 19.177f, 16.823f, 18.5f, 16.0f, 18.5f)
                close()
            }
        }
        .build()
        return _homefill!!
    }

private var _homefill: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Homefill, contentDescription = "")
    }
}
