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

public val Todoz.Tag: ImageVector
    get() {
        if (_tag != null) {
            return _tag!!
        }
        _tag = Builder(name = "Tag", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp, viewportWidth
                = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(15.551f, 3.171f)
                curveTo(17.362f, 3.101f, 19.135f, 3.723f, 20.473f, 4.925f)
                lineTo(20.734f, 5.173f)
                lineTo(26.774f, 11.213f)
                curveTo(29.362f, 13.801f, 29.443f, 17.977f, 27.017f, 20.664f)
                lineTo(26.774f, 20.919f)
                lineTo(20.923f, 26.77f)
                curveTo(19.58f, 28.101f, 17.827f, 28.772f, 16.062f, 28.772f)
                curveTo(14.417f, 28.772f, 12.764f, 28.182f, 11.469f, 27.013f)
                lineTo(11.215f, 26.772f)
                lineTo(5.175f, 20.732f)
                curveTo(3.809f, 19.367f, 3.087f, 17.478f, 3.174f, 15.55f)
                lineTo(3.494f, 8.884f)
                verticalLineTo(8.883f)
                curveTo(3.629f, 5.955f, 5.941f, 3.639f, 8.886f, 3.492f)
                lineTo(8.885f, 3.491f)
                lineTo(15.552f, 3.172f)
                lineTo(15.551f, 3.171f)
                close()
                moveTo(15.598f, 4.173f)
                lineTo(8.931f, 4.493f)
                curveTo(6.576f, 4.595f, 4.72f, 6.381f, 4.498f, 8.689f)
                lineTo(4.481f, 8.915f)
                lineTo(4.162f, 15.582f)
                verticalLineTo(15.584f)
                curveTo(4.094f, 17.127f, 4.64f, 18.644f, 5.669f, 19.789f)
                lineTo(5.881f, 20.013f)
                lineTo(11.921f, 26.052f)
                curveTo(13.027f, 27.159f, 14.501f, 27.772f, 16.062f, 27.772f)
                curveTo(17.524f, 27.772f, 18.91f, 27.233f, 19.989f, 26.255f)
                lineTo(20.201f, 26.052f)
                lineTo(26.055f, 20.199f)
                curveTo(27.161f, 19.093f, 27.774f, 17.619f, 27.774f, 16.059f)
                curveTo(27.774f, 14.597f, 27.236f, 13.21f, 26.257f, 12.131f)
                lineTo(26.055f, 11.919f)
                lineTo(20.015f, 5.879f)
                curveTo(18.922f, 4.786f, 17.432f, 4.166f, 15.901f, 4.165f)
                lineTo(15.598f, 4.173f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(12.666f, 8.833f)
                curveTo(14.776f, 8.833f, 16.5f, 10.556f, 16.5f, 12.666f)
                curveTo(16.5f, 14.777f, 14.776f, 16.5f, 12.666f, 16.5f)
                curveTo(10.556f, 16.5f, 8.833f, 14.777f, 8.833f, 12.666f)
                curveTo(8.833f, 10.556f, 10.556f, 8.833f, 12.666f, 8.833f)
                close()
                moveTo(12.666f, 9.833f)
                curveTo(11.11f, 9.833f, 9.833f, 11.11f, 9.833f, 12.666f)
                curveTo(9.833f, 14.222f, 11.11f, 15.5f, 12.666f, 15.5f)
                curveTo(14.222f, 15.5f, 15.5f, 14.222f, 15.5f, 12.666f)
                curveTo(15.5f, 11.11f, 14.222f, 9.833f, 12.666f, 9.833f)
                close()
            }
        }
        .build()
        return _tag!!
    }

private var _tag: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Tag, contentDescription = "")
    }
}
