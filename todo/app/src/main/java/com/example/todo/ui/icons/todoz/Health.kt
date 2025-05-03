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

public val Todoz.Health: ImageVector
    get() {
        if (_health != null) {
            return _health!!
        }
        _health = Builder(name = "Health", defaultWidth = 30.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 30.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF00A3A3)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(19.845f, 0.503f)
                curveTo(23.393f, 0.503f, 26.311f, 3.287f, 26.49f, 6.766f)
                lineTo(26.499f, 7.104f)
                curveTo(26.486f, 8.011f, 26.356f, 8.908f, 26.102f, 9.88f)
                lineTo(25.938f, 10.507f)
                horizontalLineTo(28.015f)
                curveTo(28.218f, 10.502f, 28.332f, 10.571f, 28.399f, 10.646f)
                curveTo(28.476f, 10.73f, 28.525f, 10.859f, 28.525f, 11.006f)
                curveTo(28.525f, 11.153f, 28.476f, 11.283f, 28.399f, 11.367f)
                curveTo(28.332f, 11.442f, 28.218f, 11.511f, 28.015f, 11.507f)
                lineTo(28.003f, 11.988f)
                lineTo(28.015f, 11.506f)
                horizontalLineTo(25.593f)
                lineTo(25.467f, 11.82f)
                curveTo(24.97f, 13.062f, 24.312f, 14.309f, 23.519f, 15.523f)
                lineTo(23.17f, 16.04f)
                curveTo(21.139f, 18.976f, 18.358f, 21.653f, 15.251f, 23.433f)
                curveTo(15.098f, 23.52f, 14.91f, 23.52f, 14.757f, 23.433f)
                horizontalLineTo(14.756f)
                curveTo(10.04f, 20.732f, 6.2f, 16.266f, 4.492f, 11.827f)
                lineTo(4.369f, 11.506f)
                horizontalLineTo(1.996f)
                lineTo(1.985f, 11.507f)
                curveTo(1.781f, 11.511f, 1.667f, 11.442f, 1.6f, 11.367f)
                curveTo(1.523f, 11.283f, 1.474f, 11.153f, 1.474f, 11.007f)
                curveTo(1.474f, 10.86f, 1.524f, 10.73f, 1.601f, 10.646f)
                curveTo(1.651f, 10.59f, 1.728f, 10.537f, 1.849f, 10.516f)
                lineTo(1.985f, 10.507f)
                horizontalLineTo(4.032f)
                lineTo(3.887f, 9.892f)
                curveTo(3.695f, 9.081f, 3.539f, 8.028f, 3.502f, 7.091f)
                curveTo(3.509f, 3.461f, 6.497f, 0.503f, 10.154f, 0.503f)
                curveTo(11.855f, 0.503f, 13.449f, 1.153f, 14.656f, 2.257f)
                lineTo(14.994f, 2.565f)
                lineTo(15.331f, 2.257f)
                curveTo(16.538f, 1.151f, 18.141f, 0.503f, 19.845f, 0.503f)
                close()
                moveTo(11.361f, 9.862f)
                lineTo(10.418f, 11.278f)
                lineTo(10.416f, 11.28f)
                curveTo(10.324f, 11.421f, 10.166f, 11.506f, 9.998f, 11.506f)
                horizontalLineTo(5.513f)
                lineTo(5.849f, 12.22f)
                curveTo(7.569f, 15.872f, 10.834f, 19.669f, 14.74f, 22.093f)
                lineTo(15.004f, 22.257f)
                lineTo(15.268f, 22.093f)
                curveTo(17.799f, 20.522f, 20.204f, 18.392f, 21.996f, 15.962f)
                lineTo(22.346f, 15.473f)
                curveTo(23.085f, 14.404f, 23.71f, 13.301f, 24.204f, 12.213f)
                lineTo(24.525f, 11.506f)
                horizontalLineTo(20.206f)
                lineTo(18.354f, 13.357f)
                verticalLineTo(13.358f)
                curveTo(18.114f, 13.6f, 17.707f, 13.534f, 17.554f, 13.229f)
                horizontalLineTo(17.555f)
                lineTo(16.447f, 11.016f)
                lineTo(16.0f, 10.121f)
                lineTo(14.446f, 13.229f)
                curveTo(14.264f, 13.589f, 13.762f, 13.589f, 13.569f, 13.258f)
                lineTo(13.535f, 13.188f)
                lineTo(13.534f, 13.186f)
                lineTo(12.241f, 9.953f)
                lineTo(11.889f, 9.07f)
                lineTo(11.361f, 9.862f)
                close()
                moveTo(9.654f, 1.526f)
                curveTo(6.823f, 1.769f, 4.612f, 4.059f, 4.512f, 6.905f)
                verticalLineTo(6.937f)
                curveTo(4.539f, 7.964f, 4.742f, 9.05f, 5.033f, 10.136f)
                lineTo(5.132f, 10.507f)
                horizontalLineTo(9.734f)
                lineTo(9.883f, 10.283f)
                lineTo(11.582f, 7.729f)
                lineTo(11.584f, 7.727f)
                curveTo(11.675f, 7.588f, 11.83f, 7.503f, 11.996f, 7.501f)
                curveTo(12.177f, 7.499f, 12.342f, 7.595f, 12.432f, 7.747f)
                lineTo(12.465f, 7.815f)
                lineTo(13.639f, 10.753f)
                lineTo(14.053f, 11.787f)
                lineTo(15.555f, 8.783f)
                lineTo(15.554f, 8.782f)
                curveTo(15.739f, 8.416f, 16.263f, 8.417f, 16.447f, 8.784f)
                verticalLineTo(8.783f)
                lineTo(17.826f, 11.537f)
                lineTo(18.137f, 12.157f)
                lineTo(19.644f, 10.65f)
                curveTo(19.714f, 10.581f, 19.803f, 10.534f, 19.899f, 10.516f)
                lineTo(19.998f, 10.507f)
                horizontalLineTo(24.883f)
                lineTo(24.988f, 10.148f)
                curveTo(25.257f, 9.235f, 25.426f, 8.092f, 25.49f, 6.997f)
                lineTo(25.492f, 6.976f)
                lineTo(25.491f, 6.954f)
                curveTo(25.413f, 4.014f, 23.082f, 1.656f, 20.133f, 1.512f)
                lineTo(19.845f, 1.505f)
                horizontalLineTo(19.837f)
                curveTo(18.262f, 1.531f, 16.603f, 2.503f, 15.332f, 3.619f)
                lineTo(15.309f, 3.641f)
                curveTo(15.125f, 3.824f, 14.837f, 3.833f, 14.644f, 3.678f)
                lineTo(14.566f, 3.601f)
                curveTo(13.576f, 2.375f, 12.099f, 1.605f, 10.479f, 1.514f)
                lineTo(10.154f, 1.505f)
                horizontalLineTo(9.654f)
                verticalLineTo(1.526f)
                close()
            }
        }
        .build()
        return _health!!
    }

private var _health: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Health, contentDescription = "")
    }
}
