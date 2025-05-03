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

public val Todoz.Music: ImageVector
    get() {
        if (_music != null) {
            return _music!!
        }
        _music = Builder(name = "Music", defaultWidth = 25.0.dp, defaultHeight = 25.0.dp,
                viewportWidth = 25.0f, viewportHeight = 25.0f).apply {
            path(fill = SolidColor(Color(0xFFA000A3)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(21.382f, 0.574f)
                curveTo(21.723f, 0.553f, 22.066f, 0.602f, 22.388f, 0.717f)
                curveTo(22.63f, 0.803f, 22.856f, 0.926f, 23.06f, 1.081f)
                lineTo(23.257f, 1.245f)
                curveTo(23.759f, 1.715f, 24.048f, 2.382f, 24.048f, 3.07f)
                lineTo(24.038f, 17.439f)
                curveTo(24.037f, 17.592f, 24.032f, 17.735f, 24.015f, 17.877f)
                lineTo(23.993f, 18.019f)
                verticalLineTo(18.02f)
                curveTo(23.657f, 19.93f, 21.879f, 21.432f, 19.972f, 21.432f)
                horizontalLineTo(18.972f)
                curveTo(18.016f, 21.432f, 17.193f, 21.055f, 16.635f, 20.39f)
                horizontalLineTo(16.636f)
                curveTo(16.114f, 19.768f, 15.87f, 18.917f, 15.981f, 18.024f)
                lineTo(16.009f, 17.846f)
                verticalLineTo(17.844f)
                curveTo(16.346f, 15.934f, 18.123f, 14.432f, 20.03f, 14.432f)
                horizontalLineTo(23.048f)
                verticalLineTo(9.07f)
                curveTo(23.048f, 8.653f, 22.88f, 8.26f, 22.572f, 7.973f)
                horizontalLineTo(22.571f)
                curveTo(22.422f, 7.833f, 22.246f, 7.725f, 22.053f, 7.656f)
                curveTo(21.907f, 7.604f, 21.754f, 7.575f, 21.6f, 7.57f)
                lineTo(21.445f, 7.573f)
                lineTo(10.449f, 8.306f)
                horizontalLineTo(10.447f)
                curveTo(10.068f, 8.333f, 9.714f, 8.502f, 9.454f, 8.779f)
                curveTo(9.227f, 9.022f, 9.088f, 9.332f, 9.056f, 9.66f)
                lineTo(9.048f, 9.802f)
                verticalLineTo(20.432f)
                curveTo(9.048f, 20.476f, 9.043f, 20.52f, 9.031f, 20.565f)
                lineTo(9.017f, 20.619f)
                lineTo(9.016f, 20.675f)
                curveTo(9.011f, 20.823f, 9.007f, 20.903f, 9.003f, 20.949f)
                curveTo(9.0f, 20.986f, 8.997f, 21.0f, 8.993f, 21.024f)
                curveTo(8.653f, 22.932f, 6.876f, 24.432f, 4.972f, 24.432f)
                horizontalLineTo(3.972f)
                curveTo(3.016f, 24.432f, 2.193f, 24.055f, 1.635f, 23.39f)
                horizontalLineTo(1.636f)
                curveTo(1.113f, 22.768f, 0.87f, 21.917f, 0.981f, 21.024f)
                lineTo(1.009f, 20.846f)
                verticalLineTo(20.844f)
                curveTo(1.346f, 18.934f, 3.123f, 17.432f, 5.03f, 17.432f)
                horizontalLineTo(8.048f)
                verticalLineTo(3.804f)
                curveTo(8.05f, 3.17f, 8.292f, 2.561f, 8.726f, 2.097f)
                curveTo(9.159f, 1.634f, 9.751f, 1.352f, 10.384f, 1.308f)
                lineTo(10.383f, 1.307f)
                lineTo(21.383f, 0.575f)
                lineTo(21.382f, 0.574f)
                close()
                moveTo(5.029f, 18.432f)
                curveTo(4.304f, 18.432f, 3.608f, 18.738f, 3.07f, 19.197f)
                curveTo(2.6f, 19.599f, 2.224f, 20.141f, 2.053f, 20.753f)
                lineTo(1.992f, 21.019f)
                verticalLineTo(21.02f)
                curveTo(1.896f, 21.572f, 1.978f, 22.119f, 2.265f, 22.563f)
                lineTo(2.4f, 22.748f)
                lineTo(2.401f, 22.749f)
                curveTo(2.785f, 23.205f, 3.358f, 23.432f, 3.972f, 23.432f)
                horizontalLineTo(4.972f)
                curveTo(5.697f, 23.432f, 6.392f, 23.127f, 6.93f, 22.668f)
                curveTo(7.468f, 22.208f, 7.882f, 21.565f, 8.009f, 20.844f)
                lineTo(8.065f, 20.523f)
                lineTo(8.02f, 20.493f)
                curveTo(8.02f, 20.472f, 8.021f, 20.451f, 8.021f, 20.427f)
                curveTo(8.026f, 20.161f, 8.032f, 19.703f, 8.036f, 18.935f)
                lineTo(8.039f, 18.432f)
                horizontalLineTo(5.029f)
                close()
                moveTo(20.029f, 15.432f)
                curveTo(19.304f, 15.432f, 18.608f, 15.738f, 18.07f, 16.197f)
                curveTo(17.6f, 16.599f, 17.224f, 17.141f, 17.053f, 17.753f)
                lineTo(16.992f, 18.019f)
                verticalLineTo(18.02f)
                curveTo(16.896f, 18.572f, 16.978f, 19.119f, 17.265f, 19.563f)
                lineTo(17.4f, 19.748f)
                lineTo(17.401f, 19.749f)
                curveTo(17.785f, 20.205f, 18.358f, 20.432f, 18.972f, 20.432f)
                horizontalLineTo(19.972f)
                curveTo(20.697f, 20.432f, 21.392f, 20.127f, 21.93f, 19.668f)
                curveTo(22.468f, 19.208f, 22.882f, 18.566f, 23.009f, 17.846f)
                curveTo(23.037f, 17.685f, 23.037f, 17.536f, 23.037f, 17.43f)
                lineTo(23.044f, 15.934f)
                lineTo(23.047f, 15.432f)
                horizontalLineTo(20.029f)
                close()
                moveTo(21.444f, 1.572f)
                lineTo(10.447f, 2.306f)
                lineTo(10.472f, 2.68f)
                lineTo(10.445f, 2.306f)
                curveTo(10.066f, 2.333f, 9.712f, 2.502f, 9.452f, 2.779f)
                curveTo(9.225f, 3.022f, 9.086f, 3.332f, 9.054f, 3.66f)
                lineTo(9.046f, 3.802f)
                verticalLineTo(7.683f)
                lineTo(9.714f, 7.446f)
                curveTo(9.872f, 7.39f, 10.037f, 7.349f, 10.208f, 7.326f)
                lineTo(10.381f, 7.308f)
                lineTo(21.381f, 6.575f)
                lineTo(21.38f, 6.574f)
                curveTo(21.724f, 6.555f, 22.065f, 6.602f, 22.38f, 6.714f)
                lineTo(23.046f, 6.949f)
                verticalLineTo(3.069f)
                curveTo(23.046f, 2.704f, 22.917f, 2.358f, 22.679f, 2.085f)
                lineTo(22.57f, 1.972f)
                curveTo(22.421f, 1.832f, 22.244f, 1.724f, 22.051f, 1.655f)
                curveTo(21.905f, 1.603f, 21.753f, 1.574f, 21.599f, 1.569f)
                lineTo(21.444f, 1.572f)
                close()
            }
        }
        .build()
        return _music!!
    }

private var _music: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Music, contentDescription = "")
    }
}
