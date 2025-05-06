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

public val Todoz.Filter: ImageVector
    get() {
        if (_filter != null) {
            return _filter!!
        }
        _filter = Builder(name = "Filter", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(4.0f, 8.833f)
                horizontalLineTo(28.0f)
                curveTo(28.271f, 8.833f, 28.5f, 9.063f, 28.5f, 9.333f)
                curveTo(28.5f, 9.604f, 28.271f, 9.833f, 28.0f, 9.833f)
                horizontalLineTo(4.0f)
                curveTo(3.729f, 9.833f, 3.5f, 9.604f, 3.5f, 9.333f)
                curveTo(3.5f, 9.063f, 3.729f, 8.833f, 4.0f, 8.833f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(8.0f, 15.5f)
                horizontalLineTo(24.0f)
                curveTo(24.271f, 15.5f, 24.5f, 15.729f, 24.5f, 16.0f)
                curveTo(24.5f, 16.271f, 24.271f, 16.5f, 24.0f, 16.5f)
                horizontalLineTo(8.0f)
                curveTo(7.729f, 16.5f, 7.5f, 16.271f, 7.5f, 16.0f)
                curveTo(7.5f, 15.729f, 7.729f, 15.5f, 8.0f, 15.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(13.333f, 22.167f)
                horizontalLineTo(18.666f)
                curveTo(18.937f, 22.167f, 19.166f, 22.396f, 19.166f, 22.667f)
                curveTo(19.166f, 22.937f, 18.937f, 23.167f, 18.666f, 23.167f)
                horizontalLineTo(13.333f)
                curveTo(13.063f, 23.167f, 12.833f, 22.937f, 12.833f, 22.667f)
                curveTo(12.833f, 22.396f, 13.063f, 22.167f, 13.333f, 22.167f)
                close()
            }
        }
        .build()
        return _filter!!
    }

private var _filter: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Filter, contentDescription = "")
    }
}
