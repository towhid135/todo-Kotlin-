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

public val Todoz.Add: ImageVector
    get() {
        if (_add != null) {
            return _add!!
        }
        _add = Builder(name = "Add", defaultWidth = 31.0.dp, defaultHeight = 31.0.dp, viewportWidth
                = 31.0f, viewportHeight = 31.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(15.5f, 0.5f)
                curveTo(16.292f, 0.5f, 16.938f, 1.145f, 16.938f, 1.938f)
                verticalLineTo(14.063f)
                horizontalLineTo(29.063f)
                curveTo(29.855f, 14.063f, 30.5f, 14.708f, 30.5f, 15.5f)
                curveTo(30.5f, 16.292f, 29.855f, 16.938f, 29.063f, 16.938f)
                horizontalLineTo(16.938f)
                verticalLineTo(29.063f)
                curveTo(16.938f, 29.855f, 16.292f, 30.5f, 15.5f, 30.5f)
                curveTo(14.708f, 30.5f, 14.063f, 29.855f, 14.063f, 29.063f)
                verticalLineTo(16.938f)
                horizontalLineTo(1.938f)
                curveTo(1.145f, 16.938f, 0.5f, 16.292f, 0.5f, 15.5f)
                curveTo(0.5f, 14.708f, 1.145f, 14.063f, 1.938f, 14.063f)
                horizontalLineTo(14.063f)
                verticalLineTo(1.938f)
                curveTo(14.063f, 1.145f, 14.708f, 0.5f, 15.5f, 0.5f)
                close()
            }
        }
        .build()
        return _add!!
    }

private var _add: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Add, contentDescription = "")
    }
}
