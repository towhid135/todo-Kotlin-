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

public val Todoz.Clock: ImageVector
    get() {
        if (_clock != null) {
            return _clock!!
        }
        _clock = Builder(name = "Clock", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(16.0f, 30.333f)
                curveTo(8.094f, 30.333f, 1.667f, 23.907f, 1.667f, 16.0f)
                curveTo(1.667f, 8.093f, 8.094f, 1.667f, 16.0f, 1.667f)
                curveTo(23.907f, 1.667f, 30.334f, 8.093f, 30.334f, 16.0f)
                curveTo(30.334f, 23.907f, 23.907f, 30.333f, 16.0f, 30.333f)
                close()
                moveTo(16.0f, 3.667f)
                curveTo(9.2f, 3.667f, 3.667f, 9.2f, 3.667f, 16.0f)
                curveTo(3.667f, 22.8f, 9.2f, 28.333f, 16.0f, 28.333f)
                curveTo(22.8f, 28.333f, 28.334f, 22.8f, 28.334f, 16.0f)
                curveTo(28.334f, 9.2f, 22.8f, 3.667f, 16.0f, 3.667f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(20.946f, 21.24f)
                curveTo(20.773f, 21.24f, 20.6f, 21.2f, 20.44f, 21.093f)
                lineTo(16.306f, 18.627f)
                curveTo(15.28f, 18.013f, 14.519f, 16.667f, 14.519f, 15.48f)
                verticalLineTo(10.013f)
                curveTo(14.519f, 9.467f, 14.973f, 9.013f, 15.519f, 9.013f)
                curveTo(16.066f, 9.013f, 16.52f, 9.467f, 16.52f, 10.013f)
                verticalLineTo(15.48f)
                curveTo(16.52f, 15.96f, 16.92f, 16.667f, 17.333f, 16.907f)
                lineTo(21.466f, 19.373f)
                curveTo(21.946f, 19.653f, 22.093f, 20.267f, 21.813f, 20.747f)
                curveTo(21.613f, 21.067f, 21.279f, 21.24f, 20.946f, 21.24f)
                close()
            }
        }
        .build()
        return _clock!!
    }

private var _clock: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Clock, contentDescription = "")
    }
}
