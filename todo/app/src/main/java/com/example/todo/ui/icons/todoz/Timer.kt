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

public val Todoz.Timer: ImageVector
    get() {
        if (_timer != null) {
            return _timer!!
        }
        _timer = Builder(name = "Timer", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(16.0f, 5.5f)
                curveTo(22.71f, 5.5f, 28.166f, 10.957f, 28.166f, 17.667f)
                curveTo(28.166f, 24.377f, 22.71f, 29.833f, 16.0f, 29.833f)
                curveTo(9.29f, 29.833f, 3.833f, 24.377f, 3.833f, 17.667f)
                curveTo(3.833f, 10.957f, 9.289f, 5.5f, 16.0f, 5.5f)
                close()
                moveTo(16.0f, 6.5f)
                curveTo(9.844f, 6.5f, 4.833f, 11.511f, 4.833f, 17.667f)
                curveTo(4.833f, 23.823f, 9.844f, 28.833f, 16.0f, 28.833f)
                curveTo(22.156f, 28.833f, 27.166f, 23.823f, 27.166f, 17.667f)
                curveTo(27.166f, 11.511f, 22.156f, 6.5f, 16.0f, 6.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(16.0f, 10.167f)
                curveTo(16.271f, 10.167f, 16.5f, 10.396f, 16.5f, 10.667f)
                verticalLineTo(17.334f)
                curveTo(16.5f, 17.604f, 16.27f, 17.834f, 16.0f, 17.834f)
                curveTo(15.73f, 17.834f, 15.5f, 17.604f, 15.5f, 17.334f)
                verticalLineTo(10.667f)
                curveTo(15.5f, 10.396f, 15.729f, 10.167f, 16.0f, 10.167f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(12.0f, 2.167f)
                horizontalLineTo(20.0f)
                curveTo(20.271f, 2.167f, 20.5f, 2.396f, 20.5f, 2.667f)
                curveTo(20.5f, 2.937f, 20.271f, 3.167f, 20.0f, 3.167f)
                horizontalLineTo(12.0f)
                curveTo(11.729f, 3.167f, 11.5f, 2.937f, 11.5f, 2.667f)
                curveTo(11.5f, 2.396f, 11.729f, 2.167f, 12.0f, 2.167f)
                close()
            }
        }
        .build()
        return _timer!!
    }

private var _timer: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Timer, contentDescription = "")
    }
}
