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

public val Todoz.Edit: ImageVector
    get() {
        if (_edit != null) {
            return _edit!!
        }
        _edit = Builder(name = "Edit", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(21.154f, 2.404f)
                curveTo(22.393f, 2.369f, 23.707f, 2.945f, 25.097f, 4.257f)
                curveTo(26.486f, 5.569f, 27.135f, 6.849f, 27.17f, 8.087f)
                curveTo(27.203f, 9.249f, 26.699f, 10.477f, 25.554f, 11.771f)
                lineTo(25.316f, 12.03f)
                lineTo(14.37f, 23.617f)
                lineTo(14.368f, 23.618f)
                curveTo(13.944f, 24.073f, 13.17f, 24.518f, 12.513f, 24.699f)
                lineTo(12.239f, 24.76f)
                horizontalLineTo(12.235f)
                lineTo(7.96f, 25.49f)
                curveTo(7.707f, 25.506f, 7.576f, 25.527f, 7.387f, 25.527f)
                curveTo(6.774f, 25.527f, 6.213f, 25.342f, 5.786f, 25.014f)
                lineTo(5.611f, 24.865f)
                lineTo(5.507f, 24.76f)
                curveTo(5.01f, 24.228f, 4.758f, 23.449f, 4.856f, 22.576f)
                lineTo(5.35f, 18.257f)
                curveTo(5.389f, 17.917f, 5.517f, 17.495f, 5.707f, 17.085f)
                curveTo(5.85f, 16.778f, 6.019f, 16.496f, 6.194f, 16.273f)
                lineTo(6.371f, 16.07f)
                lineTo(6.377f, 16.064f)
                lineTo(17.323f, 4.477f)
                curveTo(18.636f, 3.088f, 19.916f, 2.439f, 21.154f, 2.404f)
                close()
                moveTo(21.24f, 3.38f)
                curveTo(20.149f, 3.38f, 19.232f, 3.976f, 18.401f, 4.781f)
                lineTo(18.05f, 5.137f)
                lineTo(7.103f, 16.737f)
                curveTo(6.915f, 16.934f, 6.746f, 17.227f, 6.62f, 17.495f)
                curveTo(6.525f, 17.699f, 6.438f, 17.927f, 6.385f, 18.139f)
                lineTo(6.345f, 18.345f)
                lineTo(6.343f, 18.357f)
                lineTo(5.85f, 22.677f)
                curveTo(5.785f, 23.221f, 5.909f, 23.757f, 6.297f, 24.123f)
                curveTo(6.639f, 24.446f, 7.093f, 24.55f, 7.556f, 24.517f)
                lineTo(7.755f, 24.494f)
                lineTo(7.765f, 24.492f)
                lineTo(12.058f, 23.759f)
                horizontalLineTo(12.059f)
                curveTo(12.328f, 23.712f, 12.639f, 23.582f, 12.901f, 23.441f)
                curveTo(13.099f, 23.335f, 13.305f, 23.203f, 13.474f, 23.062f)
                lineTo(13.629f, 22.918f)
                lineTo(13.63f, 22.916f)
                lineTo(24.577f, 11.33f)
                lineTo(24.578f, 11.329f)
                curveTo(25.42f, 10.433f, 26.091f, 9.475f, 26.157f, 8.38f)
                curveTo(26.225f, 7.259f, 25.653f, 6.152f, 24.399f, 4.973f)
                horizontalLineTo(24.4f)
                curveTo(23.288f, 3.902f, 22.25f, 3.38f, 21.24f, 3.38f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(15.797f, 6.241f)
                curveTo(16.034f, 6.208f, 16.26f, 6.346f, 16.346f, 6.569f)
                lineTo(16.374f, 6.67f)
                curveTo(16.901f, 10.01f, 19.539f, 12.602f, 22.866f, 13.072f)
                lineTo(23.191f, 13.111f)
                curveTo(23.457f, 13.137f, 23.657f, 13.377f, 23.635f, 13.65f)
                curveTo(23.597f, 13.905f, 23.371f, 14.1f, 23.12f, 14.1f)
                horizontalLineTo(23.06f)
                curveTo(19.135f, 13.703f, 15.981f, 10.721f, 15.375f, 6.821f)
                curveTo(15.335f, 6.55f, 15.517f, 6.292f, 15.797f, 6.241f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF000000)),
                    fillAlpha = 0.87f, strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin
                    = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(4.0f, 28.833f)
                horizontalLineTo(28.0f)
                curveTo(28.271f, 28.833f, 28.5f, 29.063f, 28.5f, 29.333f)
                curveTo(28.5f, 29.604f, 28.271f, 29.833f, 28.0f, 29.833f)
                horizontalLineTo(4.0f)
                curveTo(3.729f, 29.833f, 3.5f, 29.604f, 3.5f, 29.333f)
                curveTo(3.5f, 29.063f, 3.729f, 28.833f, 4.0f, 28.833f)
                close()
            }
        }
        .build()
        return _edit!!
    }

private var _edit: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Edit, contentDescription = "")
    }
}
