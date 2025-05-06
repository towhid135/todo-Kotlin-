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

public val Todoz.Search: ImageVector
    get() {
        if (_search != null) {
            return _search!!
        }
        _search = Builder(name = "Search", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFF1D1D1D)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(15.334f, 29.0f)
                curveTo(7.8f, 29.0f, 1.667f, 22.867f, 1.667f, 15.333f)
                curveTo(1.667f, 7.8f, 7.8f, 1.667f, 15.334f, 1.667f)
                curveTo(22.867f, 1.667f, 29.0f, 7.8f, 29.0f, 15.333f)
                curveTo(29.0f, 22.867f, 22.867f, 29.0f, 15.334f, 29.0f)
                close()
                moveTo(15.334f, 3.667f)
                curveTo(8.894f, 3.667f, 3.667f, 8.907f, 3.667f, 15.333f)
                curveTo(3.667f, 21.76f, 8.894f, 27.0f, 15.334f, 27.0f)
                curveTo(21.774f, 27.0f, 27.0f, 21.76f, 27.0f, 15.333f)
                curveTo(27.0f, 8.907f, 21.774f, 3.667f, 15.334f, 3.667f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1D1D1D)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(29.333f, 30.333f)
                curveTo(29.08f, 30.333f, 28.827f, 30.24f, 28.627f, 30.04f)
                lineTo(25.96f, 27.373f)
                curveTo(25.573f, 26.987f, 25.573f, 26.347f, 25.96f, 25.96f)
                curveTo(26.347f, 25.573f, 26.987f, 25.573f, 27.373f, 25.96f)
                lineTo(30.04f, 28.627f)
                curveTo(30.427f, 29.013f, 30.427f, 29.653f, 30.04f, 30.04f)
                curveTo(29.84f, 30.24f, 29.587f, 30.333f, 29.333f, 30.333f)
                close()
            }
        }
        .build()
        return _search!!
    }

private var _search: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Search, contentDescription = "")
    }
}
