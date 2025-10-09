package com.example.todo.core.util

import android.content.Context
import android.net.Uri
import android.util.Log
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object FileUtils {


    fun getTempImageFile(context: Context): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val imageFileName = "TODOZ_${timeStamp}_"

        return File.createTempFile(
            imageFileName,
            ".jpg",
            context.cacheDir
        )
    }


    fun getCroppedImageFile(context: Context): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val imageFileName = "CROPPED_${timeStamp}.jpg"

        return File(context.cacheDir, imageFileName)
    }


    fun deleteTempFile(file: File?) {
        try {
            file?.let {
                if (it.exists()) {
                    it.delete()
                }
            }
        } catch (e: Exception) {
            Log.e("FileUtils", "Error deleting temp file: ${e.message}")
        }
    }


    fun getFileExtension(context: Context, uri: Uri): String {
        return context.contentResolver.getType(uri)?.let { mimeType ->
            when (mimeType) {
                "image/png" -> "png"
                "image/jpeg" -> "jpg"
                "image/webp" -> "webp"
                else -> "jpg"
            }
        } ?: "jpg"
    }
}