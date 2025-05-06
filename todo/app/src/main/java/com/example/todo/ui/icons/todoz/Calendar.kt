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

public val Todoz.Calendar: ImageVector
    get() {
        if (_calendar != null) {
            return _calendar!!
        }
        _calendar = Builder(name = "Calendar", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(10.667f, 2.167f)
                curveTo(10.938f, 2.167f, 11.167f, 2.396f, 11.167f, 2.667f)
                verticalLineTo(6.667f)
                curveTo(11.167f, 6.937f, 10.938f, 7.167f, 10.667f, 7.167f)
                curveTo(10.396f, 7.167f, 10.167f, 6.937f, 10.167f, 6.667f)
                verticalLineTo(2.667f)
                curveTo(10.167f, 2.396f, 10.396f, 2.167f, 10.667f, 2.167f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(21.333f, 2.167f)
                curveTo(21.604f, 2.167f, 21.833f, 2.396f, 21.833f, 2.667f)
                verticalLineTo(6.667f)
                curveTo(21.833f, 6.937f, 21.604f, 7.167f, 21.333f, 7.167f)
                curveTo(21.063f, 7.167f, 20.833f, 6.937f, 20.833f, 6.667f)
                verticalLineTo(2.667f)
                curveTo(20.833f, 2.396f, 21.063f, 2.167f, 21.333f, 2.167f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(11.019f, 17.235f)
                curveTo(11.315f, 17.111f, 11.692f, 17.181f, 11.918f, 17.4f)
                curveTo(12.075f, 17.566f, 12.167f, 17.791f, 12.167f, 18.0f)
                curveTo(12.167f, 18.036f, 12.16f, 18.089f, 12.146f, 18.185f)
                curveTo(12.142f, 18.211f, 12.132f, 18.244f, 12.112f, 18.283f)
                lineTo(12.097f, 18.315f)
                lineTo(12.086f, 18.349f)
                curveTo(12.075f, 18.381f, 12.056f, 18.421f, 12.024f, 18.469f)
                lineTo(12.018f, 18.479f)
                lineTo(12.012f, 18.49f)
                curveTo(12.014f, 18.486f, 12.009f, 18.493f, 11.984f, 18.523f)
                curveTo(11.972f, 18.538f, 11.961f, 18.55f, 11.943f, 18.571f)
                curveTo(11.937f, 18.578f, 11.929f, 18.586f, 11.922f, 18.595f)
                curveTo(11.757f, 18.745f, 11.538f, 18.833f, 11.333f, 18.833f)
                curveTo(11.236f, 18.833f, 11.127f, 18.81f, 11.019f, 18.765f)
                horizontalLineTo(11.019f)
                lineTo(11.006f, 18.76f)
                lineTo(10.934f, 18.728f)
                curveTo(10.868f, 18.694f, 10.808f, 18.65f, 10.737f, 18.588f)
                curveTo(10.586f, 18.422f, 10.5f, 18.215f, 10.5f, 18.0f)
                curveTo(10.5f, 17.903f, 10.523f, 17.795f, 10.568f, 17.686f)
                curveTo(10.609f, 17.588f, 10.666f, 17.496f, 10.74f, 17.409f)
                curveTo(10.809f, 17.349f, 10.869f, 17.305f, 10.934f, 17.272f)
                lineTo(11.006f, 17.24f)
                lineTo(11.019f, 17.235f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(15.696f, 17.231f)
                curveTo(15.977f, 17.106f, 16.352f, 17.174f, 16.585f, 17.4f)
                curveTo(16.742f, 17.566f, 16.834f, 17.791f, 16.834f, 18.0f)
                curveTo(16.834f, 18.036f, 16.827f, 18.089f, 16.813f, 18.185f)
                curveTo(16.809f, 18.211f, 16.799f, 18.244f, 16.779f, 18.283f)
                lineTo(16.764f, 18.315f)
                lineTo(16.753f, 18.349f)
                curveTo(16.742f, 18.381f, 16.723f, 18.421f, 16.691f, 18.469f)
                lineTo(16.685f, 18.48f)
                lineTo(16.679f, 18.49f)
                curveTo(16.681f, 18.486f, 16.676f, 18.494f, 16.651f, 18.523f)
                curveTo(16.639f, 18.538f, 16.628f, 18.55f, 16.61f, 18.571f)
                curveTo(16.603f, 18.579f, 16.594f, 18.588f, 16.586f, 18.598f)
                curveTo(16.421f, 18.747f, 16.204f, 18.833f, 16.0f, 18.833f)
                curveTo(15.903f, 18.833f, 15.794f, 18.81f, 15.686f, 18.765f)
                horizontalLineTo(15.686f)
                lineTo(15.673f, 18.76f)
                lineTo(15.601f, 18.728f)
                curveTo(15.535f, 18.694f, 15.475f, 18.65f, 15.404f, 18.588f)
                curveTo(15.253f, 18.422f, 15.167f, 18.215f, 15.167f, 18.0f)
                curveTo(15.167f, 17.903f, 15.19f, 17.795f, 15.235f, 17.686f)
                curveTo(15.276f, 17.588f, 15.333f, 17.496f, 15.407f, 17.409f)
                curveTo(15.501f, 17.327f, 15.579f, 17.277f, 15.673f, 17.24f)
                lineTo(15.686f, 17.236f)
                lineTo(15.696f, 17.231f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(20.358f, 17.233f)
                curveTo(20.656f, 17.104f, 21.019f, 17.174f, 21.251f, 17.399f)
                curveTo(21.408f, 17.565f, 21.5f, 17.791f, 21.5f, 18.0f)
                curveTo(21.5f, 18.036f, 21.493f, 18.089f, 21.479f, 18.185f)
                curveTo(21.477f, 18.198f, 21.474f, 18.212f, 21.469f, 18.229f)
                lineTo(21.445f, 18.283f)
                lineTo(21.43f, 18.315f)
                lineTo(21.419f, 18.349f)
                curveTo(21.408f, 18.381f, 21.389f, 18.421f, 21.357f, 18.469f)
                lineTo(21.351f, 18.48f)
                lineTo(21.345f, 18.49f)
                curveTo(21.347f, 18.486f, 21.342f, 18.494f, 21.317f, 18.523f)
                curveTo(21.305f, 18.538f, 21.294f, 18.55f, 21.276f, 18.571f)
                curveTo(21.269f, 18.579f, 21.26f, 18.588f, 21.252f, 18.598f)
                curveTo(21.087f, 18.747f, 20.869f, 18.833f, 20.666f, 18.833f)
                curveTo(20.569f, 18.833f, 20.46f, 18.81f, 20.352f, 18.765f)
                horizontalLineTo(20.353f)
                lineTo(20.339f, 18.76f)
                lineTo(20.267f, 18.728f)
                curveTo(20.204f, 18.696f, 20.146f, 18.653f, 20.079f, 18.595f)
                curveTo(20.063f, 18.575f, 20.046f, 18.555f, 20.03f, 18.534f)
                curveTo(20.01f, 18.509f, 19.989f, 18.484f, 19.969f, 18.458f)
                curveTo(19.956f, 18.438f, 19.945f, 18.42f, 19.937f, 18.404f)
                lineTo(19.914f, 18.349f)
                lineTo(19.902f, 18.315f)
                lineTo(19.887f, 18.283f)
                lineTo(19.864f, 18.229f)
                curveTo(19.859f, 18.214f, 19.856f, 18.201f, 19.854f, 18.189f)
                curveTo(19.84f, 18.09f, 19.833f, 18.037f, 19.833f, 18.0f)
                curveTo(19.833f, 17.796f, 19.92f, 17.577f, 20.07f, 17.411f)
                curveTo(20.166f, 17.328f, 20.244f, 17.277f, 20.339f, 17.24f)
                lineTo(20.358f, 17.233f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(11.333f, 21.85f)
                curveTo(11.569f, 21.85f, 11.781f, 21.933f, 11.92f, 22.068f)
                curveTo(12.076f, 22.234f, 12.167f, 22.458f, 12.167f, 22.667f)
                curveTo(12.167f, 22.873f, 12.078f, 23.094f, 11.926f, 23.259f)
                curveTo(11.76f, 23.412f, 11.539f, 23.5f, 11.333f, 23.5f)
                curveTo(11.236f, 23.5f, 11.127f, 23.477f, 11.019f, 23.432f)
                curveTo(10.918f, 23.39f, 10.825f, 23.331f, 10.736f, 23.254f)
                curveTo(10.587f, 23.089f, 10.5f, 22.871f, 10.5f, 22.667f)
                curveTo(10.5f, 22.594f, 10.513f, 22.515f, 10.538f, 22.434f)
                lineTo(10.568f, 22.352f)
                lineTo(10.573f, 22.339f)
                curveTo(10.617f, 22.225f, 10.674f, 22.14f, 10.74f, 22.074f)
                curveTo(10.879f, 21.935f, 11.094f, 21.85f, 11.333f, 21.85f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(16.0f, 21.85f)
                curveTo(16.239f, 21.85f, 16.455f, 21.935f, 16.594f, 22.074f)
                curveTo(16.66f, 22.139f, 16.716f, 22.225f, 16.76f, 22.338f)
                verticalLineTo(22.339f)
                lineTo(16.766f, 22.352f)
                curveTo(16.811f, 22.461f, 16.834f, 22.569f, 16.834f, 22.667f)
                curveTo(16.834f, 22.873f, 16.745f, 23.094f, 16.593f, 23.259f)
                curveTo(16.427f, 23.412f, 16.206f, 23.5f, 16.0f, 23.5f)
                curveTo(15.794f, 23.5f, 15.573f, 23.411f, 15.407f, 23.258f)
                curveTo(15.255f, 23.093f, 15.167f, 22.872f, 15.167f, 22.667f)
                curveTo(15.167f, 22.594f, 15.18f, 22.515f, 15.205f, 22.434f)
                lineTo(15.235f, 22.352f)
                lineTo(15.24f, 22.339f)
                curveTo(15.284f, 22.225f, 15.341f, 22.14f, 15.407f, 22.074f)
                curveTo(15.546f, 21.935f, 15.761f, 21.85f, 16.0f, 21.85f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(20.717f, 21.834f)
                lineTo(20.813f, 21.849f)
                lineTo(20.831f, 21.853f)
                lineTo(20.849f, 21.855f)
                curveTo(20.867f, 21.857f, 20.883f, 21.861f, 20.899f, 21.867f)
                lineTo(20.949f, 21.887f)
                lineTo(20.981f, 21.904f)
                lineTo(21.015f, 21.914f)
                curveTo(21.047f, 21.925f, 21.088f, 21.944f, 21.136f, 21.976f)
                lineTo(21.146f, 21.983f)
                lineTo(21.155f, 21.989f)
                curveTo(21.153f, 21.987f, 21.161f, 21.992f, 21.19f, 22.016f)
                curveTo(21.205f, 22.029f, 21.216f, 22.039f, 21.236f, 22.057f)
                curveTo(21.244f, 22.064f, 21.253f, 22.071f, 21.263f, 22.079f)
                curveTo(21.412f, 22.245f, 21.5f, 22.463f, 21.5f, 22.667f)
                curveTo(21.5f, 22.873f, 21.41f, 23.093f, 21.258f, 23.259f)
                curveTo(21.092f, 23.411f, 20.872f, 23.5f, 20.666f, 23.5f)
                curveTo(20.457f, 23.5f, 20.234f, 23.41f, 20.067f, 23.254f)
                curveTo(20.02f, 23.206f, 19.978f, 23.147f, 19.941f, 23.074f)
                lineTo(19.906f, 22.994f)
                lineTo(19.901f, 22.981f)
                lineTo(19.871f, 22.9f)
                curveTo(19.846f, 22.819f, 19.833f, 22.74f, 19.833f, 22.667f)
                curveTo(19.833f, 22.594f, 19.846f, 22.515f, 19.871f, 22.434f)
                lineTo(19.901f, 22.353f)
                lineTo(19.906f, 22.34f)
                curveTo(19.939f, 22.254f, 19.979f, 22.184f, 20.025f, 22.127f)
                lineTo(20.073f, 22.073f)
                curveTo(20.241f, 21.906f, 20.488f, 21.817f, 20.717f, 21.834f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(4.667f, 11.62f)
                horizontalLineTo(27.334f)
                curveTo(27.604f, 11.62f, 27.834f, 11.849f, 27.834f, 12.12f)
                curveTo(27.834f, 12.39f, 27.604f, 12.62f, 27.334f, 12.62f)
                horizontalLineTo(4.667f)
                curveTo(4.396f, 12.62f, 4.167f, 12.39f, 4.167f, 12.12f)
                curveTo(4.167f, 11.849f, 4.396f, 11.62f, 4.667f, 11.62f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(10.667f, 4.167f)
                horizontalLineTo(21.333f)
                curveTo(23.671f, 4.167f, 25.447f, 4.838f, 26.638f, 6.029f)
                curveTo(27.829f, 7.22f, 28.5f, 8.995f, 28.5f, 11.334f)
                verticalLineTo(22.667f)
                curveTo(28.5f, 25.005f, 27.829f, 26.781f, 26.638f, 27.971f)
                curveTo(25.447f, 29.162f, 23.671f, 29.834f, 21.333f, 29.834f)
                horizontalLineTo(10.667f)
                curveTo(8.329f, 29.834f, 6.553f, 29.162f, 5.362f, 27.971f)
                curveTo(4.171f, 26.781f, 3.5f, 25.005f, 3.5f, 22.667f)
                verticalLineTo(11.334f)
                curveTo(3.5f, 8.995f, 4.171f, 7.22f, 5.362f, 6.029f)
                curveTo(6.553f, 4.838f, 8.329f, 4.167f, 10.667f, 4.167f)
                close()
                moveTo(10.667f, 5.167f)
                curveTo(8.687f, 5.167f, 7.118f, 5.648f, 6.05f, 6.717f)
                curveTo(4.981f, 7.785f, 4.5f, 9.354f, 4.5f, 11.334f)
                verticalLineTo(22.667f)
                curveTo(4.5f, 24.647f, 4.981f, 26.215f, 6.05f, 27.284f)
                curveTo(7.118f, 28.352f, 8.687f, 28.834f, 10.667f, 28.834f)
                horizontalLineTo(21.333f)
                curveTo(23.313f, 28.834f, 24.882f, 28.352f, 25.95f, 27.284f)
                curveTo(27.019f, 26.215f, 27.5f, 24.647f, 27.5f, 22.667f)
                verticalLineTo(11.334f)
                curveTo(27.5f, 9.354f, 27.019f, 7.785f, 25.95f, 6.717f)
                curveTo(24.882f, 5.648f, 23.313f, 5.167f, 21.333f, 5.167f)
                horizontalLineTo(10.667f)
                close()
            }
        }
        .build()
        return _calendar!!
    }

private var _calendar: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Calendar, contentDescription = "")
    }
}
