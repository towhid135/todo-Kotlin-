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

public val Todoz.Work: ImageVector
    get() {
        if (_work != null) {
            return _work!!
        }
        _work = Builder(name = "Work", defaultWidth = 30.0.dp, defaultHeight = 26.0.dp,
                viewportWidth = 30.0f, viewportHeight = 26.0f).apply {
            path(fill = SolidColor(Color(0xFFA31D00)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(25.779f, 12.403f)
                lineTo(16.123f, 17.235f)
                curveTo(15.462f, 17.566f, 14.684f, 17.587f, 14.009f, 17.298f)
                lineTo(13.875f, 17.235f)
                curveTo(10.657f, 15.625f, 7.44f, 14.013f, 4.222f, 12.403f)
                lineTo(3.498f, 12.042f)
                verticalLineTo(22.997f)
                curveTo(3.498f, 23.844f, 4.155f, 24.501f, 5.002f, 24.501f)
                horizontalLineTo(24.997f)
                curveTo(25.843f, 24.501f, 26.503f, 23.846f, 26.503f, 22.997f)
                verticalLineTo(12.042f)
                lineTo(25.779f, 12.403f)
                close()
                moveTo(3.002f, 5.498f)
                curveTo(2.163f, 5.498f, 1.496f, 6.16f, 1.496f, 7.002f)
                verticalLineTo(9.002f)
                curveTo(1.496f, 9.505f, 1.752f, 9.961f, 2.154f, 10.236f)
                lineTo(2.335f, 10.343f)
                lineTo(14.328f, 16.343f)
                curveTo(14.7f, 16.529f, 15.123f, 16.552f, 15.508f, 16.412f)
                lineTo(15.67f, 16.343f)
                lineTo(27.666f, 10.343f)
                curveTo(28.172f, 10.09f, 28.503f, 9.575f, 28.503f, 9.002f)
                verticalLineTo(7.002f)
                curveTo(28.503f, 6.161f, 27.84f, 5.498f, 26.999f, 5.498f)
                horizontalLineTo(3.002f)
                close()
                moveTo(14.999f, 12.499f)
                curveTo(15.275f, 12.499f, 15.499f, 12.723f, 15.499f, 12.999f)
                lineTo(15.489f, 13.1f)
                curveTo(15.443f, 13.328f, 15.241f, 13.499f, 14.999f, 13.499f)
                curveTo(14.723f, 13.499f, 14.499f, 13.275f, 14.499f, 12.999f)
                lineTo(14.51f, 12.898f)
                curveTo(14.556f, 12.671f, 14.758f, 12.499f, 14.999f, 12.499f)
                close()
                moveTo(11.003f, 1.496f)
                curveTo(10.156f, 1.496f, 9.497f, 2.155f, 9.497f, 3.002f)
                verticalLineTo(4.498f)
                horizontalLineTo(20.501f)
                verticalLineTo(3.002f)
                curveTo(20.501f, 2.156f, 19.846f, 1.496f, 18.997f, 1.496f)
                horizontalLineTo(11.003f)
                close()
                moveTo(2.496f, 11.542f)
                lineTo(2.22f, 11.403f)
                curveTo(2.164f, 11.376f, 2.108f, 11.348f, 2.052f, 11.319f)
                lineTo(1.882f, 11.233f)
                curveTo(1.04f, 10.812f, 0.504f, 9.948f, 0.504f, 9.002f)
                verticalLineTo(7.002f)
                lineTo(0.517f, 6.748f)
                curveTo(0.646f, 5.494f, 1.72f, 4.498f, 3.002f, 4.498f)
                horizontalLineTo(8.498f)
                verticalLineTo(3.002f)
                curveTo(8.498f, 1.634f, 9.635f, 0.496f, 11.003f, 0.496f)
                horizontalLineTo(18.997f)
                curveTo(20.365f, 0.496f, 21.501f, 1.633f, 21.501f, 3.002f)
                verticalLineTo(4.498f)
                horizontalLineTo(26.999f)
                curveTo(28.366f, 4.498f, 29.494f, 5.631f, 29.494f, 7.002f)
                verticalLineTo(9.002f)
                curveTo(29.494f, 9.89f, 29.025f, 10.704f, 28.272f, 11.149f)
                lineTo(28.118f, 11.233f)
                curveTo(28.001f, 11.292f, 27.896f, 11.345f, 27.778f, 11.403f)
                lineTo(27.503f, 11.542f)
                verticalLineTo(22.997f)
                curveTo(27.503f, 24.365f, 26.365f, 25.503f, 24.997f, 25.503f)
                horizontalLineTo(5.002f)
                curveTo(3.634f, 25.503f, 2.496f, 24.365f, 2.496f, 22.997f)
                verticalLineTo(11.542f)
                close()
            }
        }
        .build()
        return _work!!
    }

private var _work: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Work, contentDescription = "")
    }
}
