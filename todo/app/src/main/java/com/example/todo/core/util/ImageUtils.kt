package com.example.todo.core.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.net.Uri
import androidx.core.content.FileProvider
import androidx.exifinterface.media.ExifInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream

object ImageUtils {

    fun getFileProviderUri(context: Context, file: File): Uri {
        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            file
        )
    }

    suspend fun storeBitmapToFile(bitmap: Bitmap, file: File): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                FileOutputStream(file).use { outPutStream ->
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outPutStream)
                }
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    suspend fun getBitmapFromUri(context: Context, uri: Uri): Bitmap? {
        return withContext(Dispatchers.IO) {
            try {
                val inputStream = context.contentResolver.openInputStream(uri)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                inputStream?.close()

                // check and correct rotation
                val rotatedBitmap = bitMapRotationCorrection(context, uri, bitmap)
                rotatedBitmap
            } catch (e: Exception) {
                null
            }
        }
    }

    private fun bitMapRotationCorrection(context: Context, uri: Uri, bitmap: Bitmap): Bitmap {
        try {
            val inputStream = context.contentResolver.openInputStream(uri)
            val exif = ExifInterface(inputStream!!)
            val orientation = exif.getAttributeInt(
                ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_UNDEFINED
            )
            inputStream.close()

            return when (orientation) {
                ExifInterface.ORIENTATION_ROTATE_90 -> bitmapRotation(bitmap, 90f)
                ExifInterface.ORIENTATION_ROTATE_180 -> bitmapRotation(bitmap, 180f)
                ExifInterface.ORIENTATION_ROTATE_270 -> bitmapRotation(bitmap, 270f)
                else -> bitmap
            }
        } catch (e: Exception) {
            return bitmap
        }
    }

    private fun bitmapRotation(bitmap: Bitmap, degrees: Float): Bitmap {
        val matrix = Matrix().apply { postRotate(degrees) }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
    }


}