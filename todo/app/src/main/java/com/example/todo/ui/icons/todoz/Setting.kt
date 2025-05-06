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

public val Todoz.Setting: ImageVector
    get() {
        if (_setting != null) {
            return _setting!!
        }
        _setting = Builder(name = "Setting", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(16.0f, 11.5f)
                curveTo(18.484f, 11.5f, 20.5f, 13.516f, 20.5f, 16.0f)
                curveTo(20.5f, 18.484f, 18.484f, 20.5f, 16.0f, 20.5f)
                curveTo(13.516f, 20.5f, 11.5f, 18.484f, 11.5f, 16.0f)
                curveTo(11.5f, 13.516f, 13.516f, 11.5f, 16.0f, 11.5f)
                close()
                moveTo(16.0f, 12.5f)
                curveTo(14.071f, 12.5f, 12.5f, 14.071f, 12.5f, 16.0f)
                curveTo(12.5f, 17.93f, 14.071f, 19.5f, 16.0f, 19.5f)
                curveTo(17.93f, 19.5f, 19.5f, 17.93f, 19.5f, 16.0f)
                curveTo(19.5f, 14.071f, 17.93f, 12.5f, 16.0f, 12.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(10.389f, 3.283f)
                curveTo(11.573f, 2.581f, 13.125f, 2.918f, 13.948f, 4.034f)
                lineTo(14.104f, 4.268f)
                lineTo(14.104f, 4.271f)
                lineTo(14.265f, 4.537f)
                curveTo(14.693f, 5.276f, 15.292f, 5.8f, 16.021f, 5.8f)
                curveTo(16.751f, 5.8f, 17.351f, 5.272f, 17.78f, 4.531f)
                lineTo(17.779f, 4.53f)
                lineTo(17.927f, 4.278f)
                lineTo(17.926f, 4.277f)
                curveTo(18.647f, 3.049f, 20.168f, 2.592f, 21.407f, 3.167f)
                lineTo(21.65f, 3.296f)
                lineTo(21.657f, 3.3f)
                lineTo(23.951f, 4.62f)
                curveTo(24.646f, 5.019f, 25.149f, 5.668f, 25.369f, 6.459f)
                horizontalLineTo(25.37f)
                curveTo(25.552f, 7.156f, 25.494f, 7.865f, 25.209f, 8.498f)
                lineTo(25.073f, 8.765f)
                lineTo(25.072f, 8.766f)
                curveTo(24.859f, 9.141f, 24.709f, 9.522f, 24.65f, 9.883f)
                curveTo(24.592f, 10.243f, 24.618f, 10.621f, 24.809f, 10.946f)
                curveTo(25.175f, 11.572f, 25.992f, 11.807f, 26.827f, 11.807f)
                curveTo(28.498f, 11.807f, 29.86f, 13.17f, 29.86f, 14.84f)
                verticalLineTo(17.187f)
                curveTo(29.86f, 18.857f, 28.498f, 20.22f, 26.827f, 20.22f)
                curveTo(25.992f, 20.22f, 25.175f, 20.455f, 24.809f, 21.08f)
                curveTo(24.439f, 21.711f, 24.652f, 22.542f, 25.073f, 23.261f)
                verticalLineTo(23.262f)
                curveTo(25.451f, 23.92f, 25.573f, 24.684f, 25.409f, 25.413f)
                lineTo(25.372f, 25.559f)
                lineTo(25.37f, 25.567f)
                curveTo(25.19f, 26.257f, 24.785f, 26.84f, 24.211f, 27.243f)
                lineTo(23.954f, 27.404f)
                lineTo(23.952f, 27.406f)
                lineTo(21.651f, 28.722f)
                curveTo(21.215f, 28.963f, 20.751f, 29.086f, 20.28f, 29.086f)
                curveTo(20.051f, 29.086f, 19.815f, 29.053f, 19.568f, 28.995f)
                curveTo(18.954f, 28.826f, 18.429f, 28.469f, 18.059f, 27.967f)
                lineTo(17.909f, 27.742f)
                lineTo(17.749f, 27.476f)
                curveTo(17.32f, 26.738f, 16.723f, 26.213f, 15.994f, 26.213f)
                curveTo(15.355f, 26.213f, 14.816f, 26.617f, 14.403f, 27.215f)
                lineTo(14.234f, 27.483f)
                lineTo(14.09f, 27.733f)
                curveTo(13.762f, 28.29f, 13.272f, 28.702f, 12.69f, 28.916f)
                lineTo(12.436f, 28.995f)
                lineTo(12.43f, 28.997f)
                curveTo(11.808f, 29.165f, 11.174f, 29.108f, 10.613f, 28.844f)
                lineTo(10.378f, 28.718f)
                lineTo(10.37f, 28.713f)
                lineTo(8.076f, 27.393f)
                lineTo(7.823f, 27.232f)
                curveTo(7.258f, 26.829f, 6.848f, 26.245f, 6.656f, 25.551f)
                curveTo(6.475f, 24.855f, 6.534f, 24.147f, 6.818f, 23.515f)
                lineTo(6.954f, 23.249f)
                lineTo(6.955f, 23.247f)
                curveTo(7.169f, 22.872f, 7.318f, 22.492f, 7.377f, 22.13f)
                curveTo(7.428f, 21.816f, 7.414f, 21.487f, 7.282f, 21.192f)
                lineTo(7.219f, 21.067f)
                curveTo(6.852f, 20.441f, 6.035f, 20.206f, 5.2f, 20.206f)
                curveTo(3.53f, 20.206f, 2.167f, 18.844f, 2.167f, 17.173f)
                verticalLineTo(14.826f)
                curveTo(2.167f, 13.156f, 3.53f, 11.793f, 5.2f, 11.793f)
                curveTo(6.035f, 11.793f, 6.852f, 11.558f, 7.219f, 10.933f)
                curveTo(7.543f, 10.38f, 7.419f, 9.671f, 7.1f, 9.021f)
                lineTo(6.951f, 8.746f)
                curveTo(6.603f, 8.137f, 6.481f, 7.432f, 6.594f, 6.742f)
                lineTo(6.657f, 6.448f)
                verticalLineTo(6.447f)
                curveTo(6.837f, 5.757f, 7.243f, 5.173f, 7.816f, 4.77f)
                lineTo(8.073f, 4.609f)
                lineTo(8.075f, 4.608f)
                lineTo(10.382f, 3.287f)
                lineTo(10.389f, 3.283f)
                close()
                moveTo(21.114f, 4.139f)
                curveTo(20.348f, 3.683f, 19.369f, 3.911f, 18.854f, 4.612f)
                lineTo(18.757f, 4.759f)
                lineTo(18.754f, 4.763f)
                lineTo(18.607f, 5.016f)
                verticalLineTo(5.017f)
                curveTo(17.908f, 6.232f, 16.944f, 6.833f, 15.987f, 6.833f)
                curveTo(15.09f, 6.833f, 14.187f, 6.305f, 13.501f, 5.238f)
                lineTo(13.367f, 5.017f)
                lineTo(13.226f, 4.759f)
                lineTo(13.221f, 4.751f)
                lineTo(13.217f, 4.744f)
                lineTo(13.121f, 4.602f)
                curveTo(12.647f, 3.964f, 11.771f, 3.73f, 11.037f, 4.062f)
                lineTo(10.883f, 4.141f)
                lineTo(8.577f, 5.474f)
                curveTo(8.12f, 5.737f, 7.766f, 6.178f, 7.624f, 6.711f)
                curveTo(7.502f, 7.17f, 7.539f, 7.648f, 7.729f, 8.072f)
                lineTo(7.82f, 8.25f)
                lineTo(7.821f, 8.251f)
                curveTo(8.519f, 9.451f, 8.56f, 10.603f, 8.086f, 11.432f)
                curveTo(7.615f, 12.256f, 6.601f, 12.793f, 5.2f, 12.793f)
                curveTo(4.071f, 12.793f, 3.167f, 13.697f, 3.167f, 14.826f)
                verticalLineTo(17.173f)
                curveTo(3.167f, 18.286f, 4.068f, 19.206f, 5.2f, 19.206f)
                curveTo(6.601f, 19.206f, 7.615f, 19.743f, 8.086f, 20.568f)
                curveTo(8.53f, 21.345f, 8.522f, 22.406f, 7.944f, 23.525f)
                lineTo(7.821f, 23.748f)
                lineTo(7.82f, 23.75f)
                curveTo(7.553f, 24.214f, 7.484f, 24.764f, 7.624f, 25.288f)
                curveTo(7.766f, 25.821f, 8.105f, 26.244f, 8.552f, 26.519f)
                lineTo(8.559f, 26.524f)
                lineTo(8.565f, 26.528f)
                lineTo(10.872f, 27.847f)
                verticalLineTo(27.846f)
                curveTo(11.273f, 28.088f, 11.742f, 28.142f, 12.167f, 28.031f)
                lineTo(12.166f, 28.029f)
                curveTo(12.626f, 27.913f, 12.993f, 27.611f, 13.226f, 27.237f)
                lineTo(13.229f, 27.23f)
                lineTo(13.233f, 27.224f)
                lineTo(13.38f, 26.971f)
                lineTo(13.379f, 26.97f)
                curveTo(14.08f, 25.765f, 15.045f, 25.154f, 16.0f, 25.154f)
                curveTo(16.897f, 25.154f, 17.801f, 25.682f, 18.486f, 26.749f)
                lineTo(18.62f, 26.969f)
                lineTo(18.621f, 26.971f)
                lineTo(18.768f, 27.224f)
                verticalLineTo(27.223f)
                curveTo(18.997f, 27.623f, 19.378f, 27.907f, 19.826f, 28.019f)
                curveTo(20.262f, 28.128f, 20.72f, 28.077f, 21.111f, 27.842f)
                lineTo(21.11f, 27.841f)
                lineTo(23.41f, 26.513f)
                curveTo(23.867f, 26.249f, 24.221f, 25.809f, 24.363f, 25.276f)
                curveTo(24.486f, 24.817f, 24.449f, 24.338f, 24.258f, 23.914f)
                lineTo(24.167f, 23.737f)
                lineTo(24.166f, 23.736f)
                lineTo(24.043f, 23.511f)
                curveTo(23.465f, 22.393f, 23.457f, 21.332f, 23.901f, 20.555f)
                curveTo(24.372f, 19.73f, 25.386f, 19.194f, 26.787f, 19.194f)
                curveTo(27.916f, 19.194f, 28.82f, 18.29f, 28.82f, 17.16f)
                verticalLineTo(14.814f)
                curveTo(28.82f, 13.7f, 27.919f, 12.78f, 26.787f, 12.78f)
                curveTo(25.386f, 12.78f, 24.372f, 12.243f, 23.901f, 11.418f)
                curveTo(23.457f, 10.641f, 23.465f, 9.581f, 24.043f, 8.462f)
                lineTo(24.166f, 8.238f)
                lineTo(24.167f, 8.237f)
                curveTo(24.435f, 7.772f, 24.503f, 7.222f, 24.363f, 6.698f)
                curveTo(24.221f, 6.165f, 23.882f, 5.742f, 23.435f, 5.467f)
                lineTo(23.422f, 5.459f)
                lineTo(21.115f, 4.139f)
                horizontalLineTo(21.114f)
                close()
            }
        }
        .build()
        return _setting!!
    }

private var _setting: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Setting, contentDescription = "")
    }
}
