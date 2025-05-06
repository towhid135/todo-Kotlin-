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

public val Todoz.Cross: ImageVector
    get() {
        if (_cross != null) {
            return _cross!!
        }
        _cross = Builder(name = "Cross", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(9.989f, 21.303f)
                lineTo(21.303f, 9.989f)
                curveTo(21.494f, 9.798f, 21.819f, 9.798f, 22.01f, 9.989f)
                curveTo(22.201f, 10.181f, 22.201f, 10.505f, 22.01f, 10.697f)
                lineTo(10.696f, 22.01f)
                curveTo(10.505f, 22.202f, 10.181f, 22.202f, 9.989f, 22.01f)
                curveTo(9.798f, 21.819f, 9.798f, 21.494f, 9.989f, 21.303f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(9.989f, 9.99f)
                curveTo(10.181f, 9.798f, 10.505f, 9.798f, 10.696f, 9.99f)
                lineTo(22.01f, 21.303f)
                curveTo(22.201f, 21.495f, 22.201f, 21.819f, 22.01f, 22.01f)
                curveTo(21.819f, 22.202f, 21.494f, 22.202f, 21.303f, 22.01f)
                lineTo(9.989f, 10.697f)
                curveTo(9.798f, 10.505f, 9.798f, 10.181f, 9.989f, 9.99f)
                close()
            }
        }
        .build()
        return _cross!!
    }

private var _cross: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Cross, contentDescription = "")
    }
}
