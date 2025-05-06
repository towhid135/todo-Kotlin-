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

public val Todoz.Trash: ImageVector
    get() {
        if (_trash != null) {
            return _trash!!
        }
        _trash = Builder(name = "Trash", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(6.664f, 7.204f)
                curveTo(13.271f, 6.533f, 19.969f, 6.735f, 26.698f, 7.344f)
                lineTo(28.044f, 7.471f)
                horizontalLineTo(28.045f)
                curveTo(28.279f, 7.494f, 28.464f, 7.685f, 28.488f, 7.917f)
                lineTo(28.489f, 8.018f)
                lineTo(28.488f, 8.028f)
                curveTo(28.469f, 8.278f, 28.255f, 8.473f, 28.0f, 8.473f)
                horizontalLineTo(27.913f)
                curveTo(21.293f, 7.811f, 14.669f, 7.535f, 8.093f, 8.088f)
                lineTo(6.777f, 8.209f)
                lineTo(4.058f, 8.475f)
                curveTo(3.768f, 8.502f, 3.525f, 8.299f, 3.498f, 8.019f)
                curveTo(3.474f, 7.768f, 3.624f, 7.557f, 3.844f, 7.49f)
                lineTo(3.941f, 7.471f)
                horizontalLineTo(3.942f)
                lineTo(6.662f, 7.204f)
                horizontalLineTo(6.664f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(14.253f, 2.167f)
                horizontalLineTo(17.746f)
                curveTo(19.202f, 2.167f, 19.89f, 2.591f, 20.257f, 3.052f)
                curveTo(20.553f, 3.423f, 20.69f, 3.873f, 20.783f, 4.342f)
                lineTo(20.866f, 4.814f)
                verticalLineTo(4.817f)
                lineTo(21.16f, 6.551f)
                curveTo(21.202f, 6.794f, 21.059f, 7.018f, 20.855f, 7.095f)
                lineTo(20.766f, 7.119f)
                lineTo(20.756f, 7.121f)
                curveTo(20.513f, 7.162f, 20.288f, 7.019f, 20.211f, 6.816f)
                lineTo(20.188f, 6.726f)
                lineTo(20.185f, 6.717f)
                lineTo(19.893f, 4.983f)
                curveTo(19.848f, 4.705f, 19.806f, 4.442f, 19.744f, 4.224f)
                curveTo(19.681f, 4.0f, 19.582f, 3.766f, 19.386f, 3.578f)
                curveTo(19.187f, 3.387f, 18.94f, 3.293f, 18.68f, 3.243f)
                curveTo(18.426f, 3.194f, 18.119f, 3.18f, 17.76f, 3.18f)
                horizontalLineTo(14.267f)
                curveTo(13.91f, 3.18f, 13.606f, 3.191f, 13.356f, 3.235f)
                curveTo(13.099f, 3.28f, 12.851f, 3.368f, 12.649f, 3.556f)
                curveTo(12.45f, 3.743f, 12.351f, 3.978f, 12.287f, 4.201f)
                curveTo(12.256f, 4.31f, 12.23f, 4.431f, 12.205f, 4.56f)
                lineTo(12.134f, 4.967f)
                lineTo(11.827f, 6.7f)
                lineTo(11.826f, 6.707f)
                curveTo(11.786f, 6.952f, 11.573f, 7.127f, 11.333f, 7.127f)
                lineTo(11.258f, 7.123f)
                lineTo(11.246f, 7.121f)
                lineTo(11.149f, 7.094f)
                curveTo(10.967f, 7.02f, 10.841f, 6.84f, 10.833f, 6.649f)
                lineTo(10.839f, 6.552f)
                lineTo(10.84f, 6.55f)
                lineTo(11.133f, 4.802f)
                curveTo(11.243f, 4.142f, 11.357f, 3.513f, 11.75f, 3.028f)
                curveTo(12.115f, 2.577f, 12.798f, 2.167f, 14.253f, 2.167f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(25.171f, 11.686f)
                curveTo(25.415f, 11.708f, 25.602f, 11.89f, 25.632f, 12.117f)
                lineTo(25.635f, 12.218f)
                verticalLineTo(12.222f)
                lineTo(24.768f, 25.647f)
                curveTo(24.692f, 26.716f, 24.607f, 27.728f, 24.057f, 28.496f)
                curveTo(23.539f, 29.219f, 22.518f, 29.833f, 20.28f, 29.833f)
                horizontalLineTo(11.72f)
                curveTo(9.482f, 29.833f, 8.461f, 29.219f, 7.943f, 28.496f)
                curveTo(7.531f, 27.92f, 7.379f, 27.205f, 7.298f, 26.434f)
                lineTo(7.232f, 25.645f)
                lineTo(6.366f, 12.222f)
                lineTo(6.365f, 12.217f)
                lineTo(6.369f, 12.119f)
                curveTo(6.4f, 11.898f, 6.588f, 11.708f, 6.829f, 11.686f)
                curveTo(7.083f, 11.677f, 7.29f, 11.836f, 7.352f, 12.058f)
                lineTo(7.368f, 12.156f)
                lineTo(8.234f, 25.579f)
                verticalLineTo(25.583f)
                curveTo(8.27f, 26.08f, 8.303f, 26.541f, 8.379f, 26.933f)
                curveTo(8.456f, 27.33f, 8.588f, 27.711f, 8.857f, 28.025f)
                curveTo(9.401f, 28.659f, 10.337f, 28.833f, 11.72f, 28.833f)
                horizontalLineTo(20.28f)
                curveTo(21.669f, 28.833f, 22.61f, 28.66f, 23.153f, 28.025f)
                curveTo(23.424f, 27.71f, 23.553f, 27.328f, 23.629f, 26.931f)
                curveTo(23.666f, 26.734f, 23.692f, 26.521f, 23.713f, 26.294f)
                lineTo(23.766f, 25.579f)
                lineTo(24.633f, 12.152f)
                lineTo(24.632f, 12.151f)
                curveTo(24.654f, 11.887f, 24.892f, 11.675f, 25.171f, 11.686f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(13.773f, 21.5f)
                horizontalLineTo(18.214f)
                curveTo(18.484f, 21.5f, 18.714f, 21.73f, 18.714f, 22.0f)
                curveTo(18.714f, 22.27f, 18.484f, 22.5f, 18.214f, 22.5f)
                horizontalLineTo(13.773f)
                curveTo(13.503f, 22.5f, 13.273f, 22.271f, 13.273f, 22.0f)
                curveTo(13.273f, 21.729f, 13.503f, 21.5f, 13.773f, 21.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(12.667f, 16.167f)
                horizontalLineTo(19.334f)
                curveTo(19.604f, 16.167f, 19.834f, 16.396f, 19.834f, 16.667f)
                curveTo(19.834f, 16.937f, 19.604f, 17.167f, 19.334f, 17.167f)
                horizontalLineTo(12.667f)
                curveTo(12.396f, 17.167f, 12.167f, 16.937f, 12.167f, 16.667f)
                curveTo(12.167f, 16.43f, 12.342f, 16.225f, 12.567f, 16.177f)
                lineTo(12.667f, 16.167f)
                close()
            }
        }
        .build()
        return _trash!!
    }

private var _trash: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Trash, contentDescription = "")
    }
}
