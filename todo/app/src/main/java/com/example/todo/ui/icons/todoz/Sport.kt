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

public val Todoz.Sport: ImageVector
    get() {
        if (_sport != null) {
            return _sport!!
        }
        _sport = Builder(name = "Sport", defaultWidth = 32.0.dp, defaultHeight = 17.0.dp,
                viewportWidth = 32.0f, viewportHeight = 17.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(6.667f, 1.169f)
                horizontalLineTo(9.333f)
                curveTo(10.528f, 1.169f, 11.5f, 2.142f, 11.5f, 3.336f)
                verticalLineTo(7.836f)
                horizontalLineTo(20.5f)
                verticalLineTo(3.336f)
                curveTo(20.5f, 2.142f, 21.472f, 1.169f, 22.667f, 1.169f)
                horizontalLineTo(25.333f)
                curveTo(26.528f, 1.169f, 27.5f, 2.142f, 27.5f, 3.336f)
                verticalLineTo(14.002f)
                curveTo(27.5f, 15.197f, 26.528f, 16.169f, 25.333f, 16.169f)
                horizontalLineTo(22.667f)
                curveTo(21.472f, 16.169f, 20.5f, 15.197f, 20.5f, 14.002f)
                verticalLineTo(9.502f)
                horizontalLineTo(11.5f)
                verticalLineTo(14.002f)
                curveTo(11.5f, 15.197f, 10.528f, 16.169f, 9.333f, 16.169f)
                horizontalLineTo(6.667f)
                curveTo(5.472f, 16.169f, 4.5f, 15.197f, 4.5f, 14.002f)
                verticalLineTo(3.336f)
                curveTo(4.5f, 2.142f, 5.472f, 1.169f, 6.667f, 1.169f)
                close()
                moveTo(6.167f, 14.502f)
                horizontalLineTo(9.835f)
                verticalLineTo(14.002f)
                lineTo(9.833f, 3.336f)
                verticalLineTo(2.836f)
                horizontalLineTo(6.167f)
                verticalLineTo(14.502f)
                close()
                moveTo(22.167f, 14.502f)
                horizontalLineTo(25.835f)
                verticalLineTo(14.002f)
                lineTo(25.833f, 3.336f)
                verticalLineTo(2.836f)
                horizontalLineTo(22.167f)
                verticalLineTo(14.502f)
                close()
                moveTo(31.5f, 6.502f)
                verticalLineTo(10.836f)
                horizontalLineTo(29.833f)
                verticalLineTo(6.502f)
                horizontalLineTo(31.5f)
                close()
                moveTo(2.167f, 6.502f)
                verticalLineTo(10.836f)
                horizontalLineTo(0.5f)
                verticalLineTo(6.502f)
                horizontalLineTo(2.167f)
                close()
            }
        }
        .build()
        return _sport!!
    }

private var _sport: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Sport, contentDescription = "")
    }
}
