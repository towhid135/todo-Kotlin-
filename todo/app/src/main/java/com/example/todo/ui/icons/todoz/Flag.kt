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

public val Todoz.Flag: ImageVector
    get() {
        if (_flag != null) {
            return _flag!!
        }
        _flag = Builder(name = "Flag", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(6.866f, 2.167f)
                curveTo(7.137f, 2.167f, 7.366f, 2.396f, 7.366f, 2.667f)
                verticalLineTo(29.334f)
                curveTo(7.366f, 29.604f, 7.137f, 29.834f, 6.866f, 29.834f)
                curveTo(6.596f, 29.834f, 6.366f, 29.604f, 6.366f, 29.334f)
                verticalLineTo(2.667f)
                curveTo(6.366f, 2.396f, 6.596f, 2.167f, 6.866f, 2.167f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(6.866f, 4.833f)
                horizontalLineTo(21.8f)
                curveTo(23.191f, 4.833f, 24.057f, 5.122f, 24.597f, 5.455f)
                curveTo(25.127f, 5.783f, 25.375f, 6.174f, 25.496f, 6.454f)
                verticalLineTo(6.455f)
                curveTo(25.61f, 6.734f, 25.715f, 7.187f, 25.569f, 7.801f)
                curveTo(25.423f, 8.42f, 25.011f, 9.241f, 24.02f, 10.233f)
                lineTo(22.419f, 11.833f)
                curveTo(22.043f, 12.209f, 21.812f, 12.715f, 21.771f, 13.241f)
                lineTo(21.767f, 13.468f)
                verticalLineTo(13.47f)
                curveTo(21.784f, 13.987f, 21.99f, 14.471f, 22.367f, 14.821f)
                verticalLineTo(14.821f)
                lineTo(24.021f, 16.461f)
                curveTo(24.99f, 17.431f, 25.392f, 18.241f, 25.534f, 18.856f)
                curveTo(25.675f, 19.462f, 25.571f, 19.919f, 25.457f, 20.207f)
                curveTo(25.337f, 20.482f, 25.085f, 20.876f, 24.555f, 21.207f)
                curveTo(24.018f, 21.542f, 23.161f, 21.833f, 21.8f, 21.833f)
                horizontalLineTo(6.866f)
                curveTo(6.596f, 21.833f, 6.366f, 21.604f, 6.366f, 21.333f)
                curveTo(6.366f, 21.063f, 6.596f, 20.833f, 6.866f, 20.833f)
                horizontalLineTo(21.8f)
                curveTo(22.566f, 20.833f, 23.163f, 20.732f, 23.604f, 20.567f)
                curveTo(23.97f, 20.429f, 24.295f, 20.22f, 24.467f, 19.929f)
                lineTo(24.53f, 19.799f)
                curveTo(24.671f, 19.447f, 24.595f, 19.021f, 24.407f, 18.612f)
                curveTo(24.212f, 18.185f, 23.86f, 17.694f, 23.313f, 17.153f)
                horizontalLineTo(23.313f)
                lineTo(21.713f, 15.553f)
                lineTo(21.701f, 15.541f)
                lineTo(21.69f, 15.531f)
                lineTo(21.496f, 15.341f)
                curveTo(21.128f, 14.938f, 20.876f, 14.401f, 20.793f, 13.794f)
                lineTo(20.766f, 13.486f)
                curveTo(20.732f, 12.617f, 21.075f, 11.751f, 21.713f, 11.113f)
                lineTo(23.313f, 9.514f)
                curveTo(23.833f, 8.994f, 24.194f, 8.504f, 24.406f, 8.075f)
                curveTo(24.512f, 7.861f, 24.587f, 7.65f, 24.621f, 7.45f)
                curveTo(24.646f, 7.304f, 24.651f, 7.144f, 24.616f, 6.988f)
                lineTo(24.566f, 6.831f)
                lineTo(24.495f, 6.697f)
                curveTo(24.304f, 6.396f, 23.948f, 6.2f, 23.583f, 6.076f)
                curveTo(23.134f, 5.924f, 22.537f, 5.833f, 21.8f, 5.833f)
                horizontalLineTo(6.866f)
                curveTo(6.587f, 5.833f, 6.366f, 5.608f, 6.366f, 5.333f)
                curveTo(6.366f, 5.063f, 6.596f, 4.833f, 6.866f, 4.833f)
                close()
            }
        }
        .build()
        return _flag!!
    }

private var _flag: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Flag, contentDescription = "")
    }
}
