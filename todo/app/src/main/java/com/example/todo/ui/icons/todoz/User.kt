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

public val Todoz.User: ImageVector
    get() {
        if (_user != null) {
            return _user!!
        }
        _user = Builder(name = "User", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(16.0f, 17.0f)
                curveTo(11.773f, 17.0f, 8.333f, 13.56f, 8.333f, 9.333f)
                curveTo(8.333f, 5.107f, 11.773f, 1.667f, 16.0f, 1.667f)
                curveTo(20.226f, 1.667f, 23.666f, 5.107f, 23.666f, 9.333f)
                curveTo(23.666f, 13.56f, 20.226f, 17.0f, 16.0f, 17.0f)
                close()
                moveTo(16.0f, 3.667f)
                curveTo(12.88f, 3.667f, 10.333f, 6.213f, 10.333f, 9.333f)
                curveTo(10.333f, 12.453f, 12.88f, 15.0f, 16.0f, 15.0f)
                curveTo(19.12f, 15.0f, 21.666f, 12.453f, 21.666f, 9.333f)
                curveTo(21.666f, 6.213f, 19.12f, 3.667f, 16.0f, 3.667f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(27.454f, 30.333f)
                curveTo(26.907f, 30.333f, 26.454f, 29.88f, 26.454f, 29.333f)
                curveTo(26.454f, 24.733f, 21.76f, 21.0f, 16.0f, 21.0f)
                curveTo(10.24f, 21.0f, 5.547f, 24.733f, 5.547f, 29.333f)
                curveTo(5.547f, 29.88f, 5.094f, 30.333f, 4.547f, 30.333f)
                curveTo(4.0f, 30.333f, 3.547f, 29.88f, 3.547f, 29.333f)
                curveTo(3.547f, 23.64f, 9.134f, 19.0f, 16.0f, 19.0f)
                curveTo(22.867f, 19.0f, 28.454f, 23.64f, 28.454f, 29.333f)
                curveTo(28.454f, 29.88f, 28.0f, 30.333f, 27.454f, 30.333f)
                close()
            }
        }
        .build()
        return _user!!
    }

private var _user: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.User, contentDescription = "")
    }
}
