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

public val Todoz.Infooutline: ImageVector
    get() {
        if (_infooutline != null) {
            return _infooutline!!
        }
        _infooutline = Builder(name = "Infooutline", defaultWidth = 32.0.dp, defaultHeight =
                32.0.dp, viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(16.0f, 2.167f)
                curveTo(23.63f, 2.167f, 29.834f, 8.369f, 29.834f, 16.0f)
                curveTo(29.834f, 23.63f, 23.631f, 29.834f, 16.0f, 29.834f)
                curveTo(8.37f, 29.834f, 2.167f, 23.63f, 2.167f, 16.0f)
                curveTo(2.167f, 8.369f, 8.37f, 2.167f, 16.0f, 2.167f)
                close()
                moveTo(16.0f, 3.167f)
                curveTo(8.924f, 3.167f, 3.167f, 8.924f, 3.167f, 16.0f)
                curveTo(3.167f, 23.076f, 8.924f, 28.834f, 16.0f, 28.834f)
                curveTo(23.076f, 28.834f, 28.834f, 23.076f, 28.834f, 16.0f)
                curveTo(28.834f, 8.924f, 23.076f, 3.167f, 16.0f, 3.167f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(16.0f, 10.167f)
                curveTo(16.271f, 10.167f, 16.5f, 10.396f, 16.5f, 10.667f)
                verticalLineTo(17.334f)
                curveTo(16.5f, 17.604f, 16.27f, 17.834f, 16.0f, 17.834f)
                curveTo(15.73f, 17.834f, 15.5f, 17.604f, 15.5f, 17.334f)
                verticalLineTo(10.667f)
                lineTo(15.511f, 10.567f)
                curveTo(15.559f, 10.342f, 15.764f, 10.167f, 16.0f, 10.167f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(15.686f, 20.568f)
                curveTo(15.882f, 20.486f, 16.118f, 20.486f, 16.315f, 20.568f)
                curveTo(16.413f, 20.609f, 16.505f, 20.666f, 16.592f, 20.741f)
                curveTo(16.667f, 20.828f, 16.725f, 20.921f, 16.766f, 21.019f)
                curveTo(16.811f, 21.128f, 16.834f, 21.236f, 16.834f, 21.334f)
                curveTo(16.834f, 21.407f, 16.82f, 21.486f, 16.795f, 21.566f)
                lineTo(16.766f, 21.647f)
                lineTo(16.761f, 21.661f)
                curveTo(16.724f, 21.755f, 16.672f, 21.832f, 16.589f, 21.927f)
                curveTo(16.503f, 22.0f, 16.412f, 22.058f, 16.315f, 22.098f)
                curveTo(16.206f, 22.144f, 16.097f, 22.167f, 16.0f, 22.167f)
                curveTo(15.903f, 22.167f, 15.794f, 22.144f, 15.686f, 22.098f)
                curveTo(15.588f, 22.058f, 15.498f, 22.001f, 15.412f, 21.927f)
                curveTo(15.329f, 21.833f, 15.277f, 21.756f, 15.24f, 21.661f)
                lineTo(14.773f, 21.84f)
                lineTo(15.24f, 21.66f)
                lineTo(15.235f, 21.647f)
                lineTo(15.205f, 21.566f)
                curveTo(15.18f, 21.486f, 15.167f, 21.407f, 15.167f, 21.334f)
                curveTo(15.167f, 21.236f, 15.19f, 21.128f, 15.235f, 21.019f)
                curveTo(15.277f, 20.92f, 15.334f, 20.827f, 15.409f, 20.74f)
                curveTo(15.496f, 20.666f, 15.587f, 20.609f, 15.686f, 20.568f)
                close()
            }
        }
        .build()
        return _infooutline!!
    }

private var _infooutline: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Infooutline, contentDescription = "")
    }
}
