package com.example.todo.ui.icons.todoz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.ui.icons.Todoz
import kotlin.Unit

public val Todoz.Grocery: ImageVector
    get() {
        if (_grocery != null) {
            return _grocery!!
        }
        _grocery = Builder(name = "Grocery", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            group {
                path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                        strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                        StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType =
                        NonZero) {
                    moveTo(22.989f, 0.4f)
                    curveTo(24.688f, 2.7f, 21.188f, 2.7f, 22.989f, 5.4f)
                    moveTo(15.988f, 15.8f)
                    curveTo(29.489f, 15.8f, 29.188f, 19.6f, 28.889f, 15.8f)
                    curveTo(28.588f, 11.6f, 23.989f, 8.4f, 15.988f, 8.4f)
                    curveTo(7.988f, 8.4f, 3.388f, 11.6f, 3.088f, 15.8f)
                    curveTo(2.788f, 19.6f, 2.488f, 15.8f, 15.988f, 15.8f)
                    close()
                    moveTo(15.988f, 13.4f)
                    curveTo(15.988f, 11.9f, 16.088f, 10.2f, 16.989f, 8.4f)
                    lineTo(15.988f, 13.4f)
                    close()
                    moveTo(9.988f, 13.4f)
                    curveTo(9.988f, 11.9f, 10.089f, 10.8f, 10.988f, 9.1f)
                    lineTo(9.988f, 13.4f)
                    close()
                    moveTo(21.989f, 13.4f)
                    curveTo(21.989f, 12.1f, 22.088f, 11.0f, 22.788f, 9.5f)
                    lineTo(21.989f, 13.4f)
                    close()
                    moveTo(15.988f, -0.6f)
                    curveTo(17.688f, 1.7f, 14.189f, 1.7f, 15.988f, 4.4f)
                    verticalLineTo(-0.6f)
                    close()
                    moveTo(8.988f, 0.4f)
                    curveTo(10.689f, 2.7f, 7.188f, 2.7f, 8.988f, 5.4f)
                    verticalLineTo(0.4f)
                    close()
                }
            }
        }
        .build()
        return _grocery!!
    }

private var _grocery: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Grocery, contentDescription = "")
    }
}
