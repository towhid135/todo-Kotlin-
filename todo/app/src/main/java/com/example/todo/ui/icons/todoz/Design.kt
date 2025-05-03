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
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.ui.icons.Todoz
import kotlin.Unit

public val Todoz.Design: ImageVector
    get() {
        if (_design != null) {
            return _design!!
        }
        _design = Builder(name = "Design", defaultWidth = 25.0.dp, defaultHeight = 26.0.dp,
                viewportWidth = 25.0f, viewportHeight = 26.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.7f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(6.28f, 24.6f)
                curveTo(8.754f, 24.6f, 10.76f, 22.594f, 10.76f, 20.12f)
                curveTo(10.76f, 17.645f, 8.754f, 15.64f, 6.28f, 15.64f)
                curveTo(3.806f, 15.64f, 1.8f, 17.645f, 1.8f, 20.12f)
                curveTo(1.8f, 22.594f, 3.806f, 24.6f, 6.28f, 24.6f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.7f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(22.8f, 10.6f)
                horizontalLineTo(15.6f)
                curveTo(15.12f, 10.6f, 14.8f, 10.28f, 14.8f, 9.8f)
                verticalLineTo(2.6f)
                curveTo(14.8f, 2.12f, 15.12f, 1.8f, 15.6f, 1.8f)
                horizontalLineTo(22.8f)
                curveTo(23.28f, 1.8f, 23.6f, 2.12f, 23.6f, 2.6f)
                verticalLineTo(9.8f)
                curveTo(23.6f, 10.28f, 23.28f, 10.6f, 22.8f, 10.6f)
                close()
            }
            path(fill = SolidColor(Color(0xFF00A372)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(22.8f, 24.6f)
                curveTo(22.64f, 24.6f, 22.48f, 24.6f, 22.32f, 24.44f)
                lineTo(14.96f, 17.08f)
                curveTo(14.64f, 16.76f, 14.64f, 16.28f, 14.96f, 15.96f)
                curveTo(15.28f, 15.64f, 15.76f, 15.64f, 16.08f, 15.96f)
                lineTo(23.44f, 23.32f)
                curveTo(23.76f, 23.64f, 23.76f, 24.12f, 23.44f, 24.44f)
                curveTo(23.28f, 24.6f, 23.12f, 24.6f, 22.8f, 24.6f)
                close()
            }
            group {
                path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(22.32f, 24.44f)
                    lineTo(21.118f, 25.642f)
                    lineTo(22.32f, 24.44f)
                    close()
                    moveTo(14.96f, 17.08f)
                    lineTo(16.162f, 15.878f)
                    lineTo(14.96f, 17.08f)
                    close()
                    moveTo(16.08f, 15.96f)
                    lineTo(14.878f, 17.162f)
                    lineTo(16.08f, 15.96f)
                    close()
                    moveTo(23.44f, 23.32f)
                    lineTo(24.642f, 22.118f)
                    lineTo(23.44f, 23.32f)
                    close()
                    moveTo(23.44f, 24.44f)
                    lineTo(22.238f, 23.238f)
                    lineTo(23.44f, 24.44f)
                    close()
                    moveTo(22.8f, 24.6f)
                    verticalLineTo(22.9f)
                    curveTo(22.688f, 22.9f, 22.817f, 22.892f, 22.972f, 22.931f)
                    curveTo(23.065f, 22.954f, 23.169f, 22.992f, 23.273f, 23.051f)
                    curveTo(23.377f, 23.109f, 23.46f, 23.176f, 23.522f, 23.238f)
                    lineTo(22.32f, 24.44f)
                    lineTo(21.118f, 25.642f)
                    curveTo(21.806f, 26.33f, 22.615f, 26.3f, 22.8f, 26.3f)
                    verticalLineTo(24.6f)
                    close()
                    moveTo(22.32f, 24.44f)
                    lineTo(23.522f, 23.238f)
                    lineTo(16.162f, 15.878f)
                    lineTo(14.96f, 17.08f)
                    lineTo(13.758f, 18.282f)
                    lineTo(21.118f, 25.642f)
                    lineTo(22.32f, 24.44f)
                    close()
                    moveTo(14.96f, 17.08f)
                    lineTo(16.162f, 15.878f)
                    curveTo(16.31f, 16.026f, 16.42f, 16.255f, 16.42f, 16.52f)
                    curveTo(16.42f, 16.785f, 16.31f, 17.013f, 16.162f, 17.162f)
                    lineTo(14.96f, 15.96f)
                    lineTo(13.758f, 14.758f)
                    curveTo(12.774f, 15.741f, 12.774f, 17.298f, 13.758f, 18.282f)
                    lineTo(14.96f, 17.08f)
                    close()
                    moveTo(14.96f, 15.96f)
                    lineTo(16.162f, 17.162f)
                    curveTo(16.013f, 17.31f, 15.785f, 17.42f, 15.52f, 17.42f)
                    curveTo(15.255f, 17.42f, 15.026f, 17.31f, 14.878f, 17.162f)
                    lineTo(16.08f, 15.96f)
                    lineTo(17.282f, 14.758f)
                    curveTo(16.298f, 13.774f, 14.741f, 13.774f, 13.758f, 14.758f)
                    lineTo(14.96f, 15.96f)
                    close()
                    moveTo(16.08f, 15.96f)
                    lineTo(14.878f, 17.162f)
                    lineTo(22.238f, 24.522f)
                    lineTo(23.44f, 23.32f)
                    lineTo(24.642f, 22.118f)
                    lineTo(17.282f, 14.758f)
                    lineTo(16.08f, 15.96f)
                    close()
                    moveTo(23.44f, 23.32f)
                    lineTo(22.238f, 24.522f)
                    curveTo(22.089f, 24.373f, 21.98f, 24.145f, 21.98f, 23.88f)
                    curveTo(21.98f, 23.615f, 22.089f, 23.386f, 22.238f, 23.238f)
                    lineTo(23.44f, 24.44f)
                    lineTo(24.642f, 25.642f)
                    curveTo(25.626f, 24.658f, 25.626f, 23.101f, 24.642f, 22.118f)
                    lineTo(23.44f, 23.32f)
                    close()
                    moveTo(23.44f, 24.44f)
                    lineTo(22.238f, 23.238f)
                    curveTo(22.301f, 23.174f, 22.395f, 23.097f, 22.522f, 23.03f)
                    curveTo(22.648f, 22.963f, 22.764f, 22.929f, 22.846f, 22.913f)
                    curveTo(22.919f, 22.898f, 22.963f, 22.898f, 22.944f, 22.899f)
                    curveTo(22.923f, 22.899f, 22.889f, 22.9f, 22.8f, 22.9f)
                    verticalLineTo(24.6f)
                    verticalLineTo(26.3f)
                    curveTo(22.982f, 26.3f, 23.906f, 26.378f, 24.642f, 25.642f)
                    lineTo(23.44f, 24.44f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF00A372)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(15.44f, 24.6f)
                    curveTo(15.6f, 24.6f, 15.76f, 24.6f, 15.92f, 24.44f)
                    lineTo(23.28f, 17.08f)
                    curveTo(23.6f, 16.76f, 23.6f, 16.28f, 23.28f, 15.96f)
                    curveTo(22.96f, 15.64f, 22.48f, 15.64f, 22.16f, 15.96f)
                    lineTo(14.8f, 23.32f)
                    curveTo(14.48f, 23.64f, 14.48f, 24.12f, 14.8f, 24.44f)
                    curveTo(15.12f, 24.6f, 15.28f, 24.6f, 15.44f, 24.6f)
                    close()
                }
            }
            group {
                path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(15.92f, 24.44f)
                    lineTo(14.717f, 23.238f)
                    lineTo(14.717f, 23.238f)
                    lineTo(15.92f, 24.44f)
                    close()
                    moveTo(23.28f, 17.08f)
                    lineTo(24.482f, 18.282f)
                    lineTo(24.482f, 18.282f)
                    lineTo(23.28f, 17.08f)
                    close()
                    moveTo(22.16f, 15.96f)
                    lineTo(23.362f, 17.162f)
                    lineTo(23.362f, 17.162f)
                    lineTo(22.16f, 15.96f)
                    close()
                    moveTo(14.8f, 23.32f)
                    lineTo(13.597f, 22.118f)
                    lineTo(13.597f, 22.118f)
                    lineTo(14.8f, 23.32f)
                    close()
                    moveTo(14.8f, 24.44f)
                    lineTo(13.597f, 25.642f)
                    lineTo(13.793f, 25.837f)
                    lineTo(14.039f, 25.96f)
                    lineTo(14.8f, 24.44f)
                    close()
                    moveTo(15.44f, 24.6f)
                    verticalLineTo(26.3f)
                    curveTo(15.625f, 26.3f, 16.433f, 26.33f, 17.122f, 25.642f)
                    lineTo(15.92f, 24.44f)
                    lineTo(14.717f, 23.238f)
                    curveTo(14.78f, 23.176f, 14.862f, 23.109f, 14.966f, 23.051f)
                    curveTo(15.071f, 22.992f, 15.174f, 22.954f, 15.267f, 22.931f)
                    curveTo(15.423f, 22.892f, 15.551f, 22.9f, 15.44f, 22.9f)
                    verticalLineTo(24.6f)
                    close()
                    moveTo(15.92f, 24.44f)
                    lineTo(17.122f, 25.642f)
                    lineTo(24.482f, 18.282f)
                    lineTo(23.28f, 17.08f)
                    lineTo(22.077f, 15.878f)
                    lineTo(14.717f, 23.238f)
                    lineTo(15.92f, 24.44f)
                    close()
                    moveTo(23.28f, 17.08f)
                    lineTo(24.482f, 18.282f)
                    curveTo(25.465f, 17.298f, 25.465f, 15.741f, 24.482f, 14.758f)
                    lineTo(23.28f, 15.96f)
                    lineTo(22.077f, 17.162f)
                    curveTo(21.929f, 17.013f, 21.82f, 16.785f, 21.82f, 16.52f)
                    curveTo(21.82f, 16.255f, 21.929f, 16.026f, 22.077f, 15.878f)
                    lineTo(23.28f, 17.08f)
                    close()
                    moveTo(23.28f, 15.96f)
                    lineTo(24.482f, 14.758f)
                    curveTo(23.498f, 13.774f, 21.941f, 13.774f, 20.958f, 14.758f)
                    lineTo(22.16f, 15.96f)
                    lineTo(23.362f, 17.162f)
                    curveTo(23.213f, 17.31f, 22.985f, 17.42f, 22.72f, 17.42f)
                    curveTo(22.455f, 17.42f, 22.226f, 17.31f, 22.077f, 17.162f)
                    lineTo(23.28f, 15.96f)
                    close()
                    moveTo(22.16f, 15.96f)
                    lineTo(20.958f, 14.758f)
                    lineTo(13.597f, 22.118f)
                    lineTo(14.8f, 23.32f)
                    lineTo(16.002f, 24.522f)
                    lineTo(23.362f, 17.162f)
                    lineTo(22.16f, 15.96f)
                    close()
                    moveTo(14.8f, 23.32f)
                    lineTo(13.597f, 22.118f)
                    curveTo(12.614f, 23.101f, 12.614f, 24.658f, 13.597f, 25.642f)
                    lineTo(14.8f, 24.44f)
                    lineTo(16.002f, 23.238f)
                    curveTo(16.15f, 23.386f, 16.26f, 23.615f, 16.26f, 23.88f)
                    curveTo(16.26f, 24.145f, 16.15f, 24.373f, 16.002f, 24.522f)
                    lineTo(14.8f, 23.32f)
                    close()
                    moveTo(14.8f, 24.44f)
                    lineTo(14.039f, 25.96f)
                    curveTo(14.302f, 26.092f, 14.566f, 26.191f, 14.846f, 26.247f)
                    curveTo(15.127f, 26.303f, 15.357f, 26.3f, 15.44f, 26.3f)
                    verticalLineTo(24.6f)
                    verticalLineTo(22.9f)
                    curveTo(15.417f, 22.9f, 15.41f, 22.9f, 15.405f, 22.9f)
                    curveTo(15.402f, 22.9f, 15.407f, 22.9f, 15.417f, 22.9f)
                    curveTo(15.44f, 22.902f, 15.474f, 22.905f, 15.513f, 22.913f)
                    curveTo(15.55f, 22.92f, 15.576f, 22.929f, 15.588f, 22.933f)
                    curveTo(15.598f, 22.936f, 15.59f, 22.934f, 15.56f, 22.919f)
                    lineTo(14.8f, 24.44f)
                    close()
                }
                path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                        strokeLineWidth = 1.7f, strokeLineCap = Butt, strokeLineJoin = Miter,
                        strokeLineMiter = 4.0f, pathFillType = NonZero) {
                    moveTo(9.96f, 10.6f)
                    horizontalLineTo(2.6f)
                    curveTo(1.96f, 10.6f, 1.64f, 10.12f, 1.8f, 9.64f)
                    lineTo(5.48f, 2.28f)
                    curveTo(5.8f, 1.8f, 6.6f, 1.8f, 6.76f, 2.28f)
                    lineTo(10.44f, 9.64f)
                    curveTo(10.76f, 10.12f, 10.44f, 10.6f, 9.96f, 10.6f)
                    close()
                }
            }
        }
        .build()
        return _design!!
    }

private var _design: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Todoz.Design, contentDescription = "")
    }
}
