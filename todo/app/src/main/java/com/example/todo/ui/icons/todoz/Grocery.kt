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
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(22.989f, 8.0f)
                curveTo(24.688f, 10.3f, 21.188f, 10.3f, 22.989f, 13.0f)
                moveTo(15.988f, 23.4f)
                curveTo(29.489f, 23.4f, 29.188f, 27.2f, 28.889f, 23.4f)
                curveTo(28.588f, 19.2f, 23.989f, 16.0f, 15.988f, 16.0f)
                curveTo(7.988f, 16.0f, 3.388f, 19.2f, 3.088f, 23.4f)
                curveTo(2.788f, 27.2f, 2.488f, 23.4f, 15.988f, 23.4f)
                close()
                moveTo(15.988f, 21.0f)
                curveTo(15.988f, 19.5f, 16.088f, 17.8f, 16.989f, 16.0f)
                lineTo(15.988f, 21.0f)
                close()
                moveTo(9.988f, 21.0f)
                curveTo(9.988f, 19.5f, 10.089f, 18.4f, 10.988f, 16.7f)
                lineTo(9.988f, 21.0f)
                close()
                moveTo(21.989f, 21.0f)
                curveTo(21.989f, 19.7f, 22.088f, 18.6f, 22.788f, 17.1f)
                lineTo(21.989f, 21.0f)
                close()
                moveTo(15.988f, 7.0f)
                curveTo(17.688f, 9.3f, 14.189f, 9.3f, 15.988f, 12.0f)
                verticalLineTo(7.0f)
                close()
                moveTo(8.988f, 8.0f)
                curveTo(10.689f, 10.3f, 7.188f, 10.3f, 8.988f, 13.0f)
                verticalLineTo(8.0f)
                close()
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
