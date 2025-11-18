package com.example.todo.core.util

import android.content.Context
import android.net.Uri
import android.util.Log
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
            // Using 'use' is safer as it automatically closes the stream.
            // No need for a separate close() call.
            val inputStream = context.contentResolver.openInputStream(uri)
            val byteArray = inputStream?.use { it.readBytes() }

            byteArray?.let {
                val options = ObjectUtils.asMap("upload_preset", BuildConfig.CLOUDINARY_UPLOAD_PRESET)
                val result = cloudinary.uploader().upload(it, options)

                // Use "secure_url" for the https link
                val secureUrl = result["secure_url"] as? String
                Log.d("CloudinaryUpload", "Upload successful: $secureUrl")
                secureUrl
            }
        } catch (e: Exception) {
            Log.e("CloudinaryUpload", "Upload failed", e) // Log the full exception
            null
        }
    }
}
