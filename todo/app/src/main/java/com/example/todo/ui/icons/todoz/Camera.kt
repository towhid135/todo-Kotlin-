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

public val Todoz.Camera: ImageVector
    get() {
        if (_camera != null) {
            return _camera!!
        }
        _camera = Builder(name = "Camera", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(14.479f, 2.167f)
                horizontalLineTo(17.533f)
                curveTo(18.282f, 2.167f, 19.112f, 2.434f, 19.854f, 2.892f)
                curveTo(20.593f, 3.349f, 21.207f, 3.973f, 21.552f, 4.647f)
                verticalLineTo(4.648f)
                lineTo(22.512f, 6.594f)
                lineTo(22.516f, 6.602f)
                lineTo(22.52f, 6.609f)
                curveTo(22.803f, 7.139f, 23.369f, 7.5f, 24.0f, 7.5f)
                curveTo(25.42f, 7.5f, 26.799f, 8.059f, 27.821f, 9.045f)
                lineTo(28.021f, 9.248f)
                curveTo(29.009f, 10.304f, 29.531f, 11.647f, 29.512f, 13.069f)
                lineTo(29.501f, 13.355f)
                lineTo(28.808f, 24.368f)
                curveTo(28.694f, 26.159f, 28.095f, 27.511f, 27.13f, 28.417f)
                curveTo(26.165f, 29.322f, 24.777f, 29.834f, 22.986f, 29.834f)
                horizontalLineTo(9.014f)
                curveTo(7.247f, 29.834f, 5.852f, 29.308f, 4.876f, 28.39f)
                curveTo(3.961f, 27.53f, 3.37f, 26.285f, 3.217f, 24.683f)
                lineTo(3.192f, 24.358f)
                verticalLineTo(24.355f)
                lineTo(2.499f, 13.355f)
                lineTo(2.488f, 13.069f)
                curveTo(2.47f, 11.739f, 2.925f, 10.473f, 3.786f, 9.463f)
                lineTo(3.977f, 9.25f)
                lineTo(3.979f, 9.248f)
                curveTo(5.017f, 8.136f, 6.485f, 7.5f, 8.0f, 7.5f)
                curveTo(8.619f, 7.5f, 9.203f, 7.137f, 9.486f, 6.572f)
                lineTo(10.446f, 4.665f)
                curveTo(10.79f, 3.983f, 11.408f, 3.353f, 12.152f, 2.893f)
                curveTo(12.897f, 2.433f, 13.731f, 2.167f, 14.479f, 2.167f)
                close()
                moveTo(14.479f, 3.167f)
                curveTo(13.867f, 3.167f, 13.217f, 3.402f, 12.67f, 3.74f)
                curveTo(12.191f, 4.036f, 11.747f, 4.439f, 11.456f, 4.904f)
                lineTo(11.341f, 5.107f)
                lineTo(11.34f, 5.11f)
                lineTo(10.383f, 7.023f)
                curveTo(9.906f, 7.942f, 8.994f, 8.5f, 8.0f, 8.5f)
                curveTo(6.819f, 8.5f, 5.717f, 8.95f, 4.87f, 9.757f)
                lineTo(4.701f, 9.926f)
                curveTo(3.902f, 10.781f, 3.467f, 11.891f, 3.49f, 13.055f)
                lineTo(3.501f, 13.29f)
                lineTo(4.194f, 24.299f)
                curveTo(4.279f, 25.725f, 4.713f, 26.879f, 5.556f, 27.674f)
                curveTo(6.399f, 28.468f, 7.579f, 28.834f, 9.014f, 28.834f)
                horizontalLineTo(22.986f)
                curveTo(24.415f, 28.834f, 25.592f, 28.468f, 26.435f, 27.674f)
                curveTo(27.224f, 26.929f, 27.657f, 25.869f, 27.784f, 24.563f)
                lineTo(27.806f, 24.299f)
                lineTo(28.499f, 13.285f)
                verticalLineTo(13.284f)
                curveTo(28.569f, 12.121f, 28.205f, 10.991f, 27.454f, 10.1f)
                lineTo(27.299f, 9.926f)
                lineTo(27.13f, 9.757f)
                curveTo(26.283f, 8.95f, 25.181f, 8.5f, 24.0f, 8.5f)
                curveTo(23.006f, 8.5f, 22.094f, 7.943f, 21.617f, 7.052f)
                lineTo(20.647f, 5.11f)
                curveTo(20.374f, 4.563f, 19.872f, 4.087f, 19.327f, 3.751f)
                curveTo(18.782f, 3.415f, 18.131f, 3.18f, 17.52f, 3.18f)
                horizontalLineTo(14.979f)
                verticalLineTo(3.167f)
                horizontalLineTo(14.479f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(14.0f, 10.167f)
                horizontalLineTo(18.0f)
                curveTo(18.271f, 10.167f, 18.5f, 10.396f, 18.5f, 10.667f)
                curveTo(18.5f, 10.937f, 18.271f, 11.167f, 18.0f, 11.167f)
                horizontalLineTo(14.0f)
                curveTo(13.729f, 11.167f, 13.5f, 10.937f, 13.5f, 10.667f)
                curveTo(13.5f, 10.396f, 13.729f, 10.167f, 14.0f, 10.167f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(16.0f, 14.833f)
                curveTo(18.67f, 14.833f, 20.834f, 16.996f, 20.834f, 19.666f)
                curveTo(20.834f, 22.337f, 18.67f, 24.5f, 16.0f, 24.5f)
                curveTo(13.33f, 24.5f, 11.167f, 22.337f, 11.167f, 19.666f)
                curveTo(11.167f, 16.996f, 13.33f, 14.833f, 16.0f, 14.833f)
                close()
                moveTo(16.0f, 15.833f)
                curveTo(13.884f, 15.833f, 12.167f, 17.55f, 12.167f, 19.666f)
                curveTo(12.167f, 21.782f, 13.884f, 23.5f, 16.0f, 23.5f)
                curveTo(18.116f, 23.5f, 19.834f, 21.782f, 19.834f, 19.666f)
                curveTo(19.834f, 17.55f, 18.116f, 15.833f, 16.0f, 15.833f)
                close()
            }
        }
        .build()
        return _camera!!
    }

private var _camera: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Camera, contentDescription = "")
    }
}
