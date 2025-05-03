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

public val Todoz.Movie: ImageVector
    get() {
        if (_movie != null) {
            return _movie!!
        }
        _movie = Builder(name = "Movie", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFF0069A3)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(6.667f, 8.5f)
                horizontalLineTo(18.667f)
                curveTo(19.573f, 8.499f, 20.444f, 8.851f, 21.097f, 9.479f)
                curveTo(21.75f, 10.108f, 22.133f, 10.966f, 22.167f, 11.872f)
                lineTo(22.195f, 12.644f)
                lineTo(22.887f, 12.302f)
                lineTo(27.594f, 9.981f)
                lineTo(27.609f, 9.975f)
                lineTo(27.624f, 9.967f)
                curveTo(27.719f, 9.912f, 27.823f, 9.877f, 27.931f, 9.862f)
                lineTo(28.04f, 9.854f)
                curveTo(28.184f, 9.854f, 28.327f, 9.893f, 28.453f, 9.965f)
                curveTo(28.568f, 10.039f, 28.663f, 10.141f, 28.729f, 10.261f)
                curveTo(28.781f, 10.354f, 28.813f, 10.456f, 28.827f, 10.561f)
                lineTo(28.833f, 10.666f)
                verticalLineTo(21.334f)
                curveTo(28.834f, 21.476f, 28.798f, 21.615f, 28.729f, 21.739f)
                curveTo(28.661f, 21.863f, 28.562f, 21.967f, 28.443f, 22.042f)
                curveTo(28.311f, 22.124f, 28.159f, 22.166f, 28.004f, 22.166f)
                curveTo(27.91f, 22.164f, 27.817f, 22.146f, 27.729f, 22.113f)
                lineTo(27.641f, 22.075f)
                lineTo(27.637f, 22.073f)
                lineTo(22.89f, 19.699f)
                lineTo(22.196f, 19.353f)
                lineTo(22.167f, 20.128f)
                curveTo(22.133f, 21.034f, 21.75f, 21.892f, 21.097f, 22.521f)
                curveTo(20.444f, 23.149f, 19.573f, 23.501f, 18.667f, 23.5f)
                horizontalLineTo(6.667f)
                lineTo(6.493f, 23.496f)
                curveTo(5.628f, 23.453f, 4.807f, 23.09f, 4.192f, 22.475f)
                curveTo(3.536f, 21.818f, 3.167f, 20.928f, 3.167f, 20.0f)
                verticalLineTo(12.0f)
                lineTo(3.17f, 11.826f)
                curveTo(3.213f, 10.961f, 3.577f, 10.141f, 4.192f, 9.525f)
                curveTo(4.848f, 8.869f, 5.738f, 8.5f, 6.667f, 8.5f)
                close()
                moveTo(6.485f, 10.176f)
                curveTo(6.065f, 10.217f, 5.671f, 10.403f, 5.371f, 10.704f)
                curveTo(5.027f, 11.048f, 4.833f, 11.514f, 4.833f, 12.0f)
                verticalLineTo(20.0f)
                curveTo(4.833f, 20.486f, 5.027f, 20.952f, 5.371f, 21.296f)
                curveTo(5.714f, 21.64f, 6.18f, 21.833f, 6.667f, 21.833f)
                horizontalLineTo(18.667f)
                curveTo(19.153f, 21.833f, 19.619f, 21.64f, 19.962f, 21.296f)
                curveTo(20.306f, 20.952f, 20.5f, 20.486f, 20.5f, 20.0f)
                verticalLineTo(12.0f)
                curveTo(20.5f, 11.514f, 20.306f, 11.048f, 19.962f, 10.704f)
                curveTo(19.619f, 10.36f, 19.153f, 10.167f, 18.667f, 10.167f)
                horizontalLineTo(6.667f)
                lineTo(6.485f, 10.176f)
                close()
                moveTo(26.443f, 12.38f)
                lineTo(22.443f, 14.38f)
                lineTo(22.167f, 14.518f)
                verticalLineTo(17.482f)
                lineTo(22.443f, 17.62f)
                lineTo(26.443f, 19.62f)
                lineTo(27.167f, 19.982f)
                verticalLineTo(12.018f)
                lineTo(26.443f, 12.38f)
                close()
            }
        }
        .build()
        return _movie!!
    }

private var _movie: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Movie, contentDescription = "")
    }
}
