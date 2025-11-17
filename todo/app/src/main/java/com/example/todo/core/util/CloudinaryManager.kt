package com.example.todo.core.util

import android.content.Context
import android.net.Uri
import com.cloudinary.Cloudinary
import com.cloudinary.utils.ObjectUtils
import com.example.todo.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object CloudinaryManager {
    private val cloudinary: Cloudinary = Cloudinary(
        ObjectUtils.asMap(
            "cloud_name", BuildConfig.CLOUDINARY_CLOUD_NAME,
            "api_key", BuildConfig.CLOUDINARY_API_KEY,
            "api_secret", BuildConfig.CLOUDINARY_API_SECRET
        )
    )

    suspend fun uploadImageToCloudinary(uri: Uri, context: Context): String? = withContext(Dispatchers.IO) {
        try {
            val inputStream = context.contentResolver.openInputStream(uri)
            val byteArray = inputStream?.readBytes()
            inputStream?.close()

            byteArray?.let {
                val result = cloudinary.uploader().upload(it, ObjectUtils.emptyMap())
                result["url"] as? String
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}