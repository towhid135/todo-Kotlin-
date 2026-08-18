# Add project specific ProGuard rules here.

# Preserve line numbers and source file attributes for crash reporting & debugging
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Preserve generic signatures and annotations for Retrofit / Gson / Room / Hilt reflection
-keepattributes Signature, *Annotation*, InnerClasses, EnclosingMethod

# Keep Retrofit classes and annotated interface methods
-keep class retrofit2.** { *; }
-keepclassmembers class * {
    @retrofit2.http.* <methods>;
}
-keep interface com.example.todo.feature_todo.data.remote.TodoApi { *; }

# Keep OkHttp runtime classes
-keep class okhttp3.** { *; }

# Keep Gson runtime classes and fields with @SerializedName
-keep class com.google.gson.** { *; }
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

# Keep Data Transfer Objects (DTOs), Domain Models, and Core Utilities
-keep class com.example.todo.feature_todo.data.remote.dto.** { *; }
-keep class com.example.todo.feature_todo.data.local.dto.** { *; }
-keep class com.example.todo.feature_todo.domain.model.** { *; }
-keep class com.example.todo.core.util.** { *; }

# Keep Enum classes & members so Enum.name() and Enum.valueOf() work properly at runtime
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Keep Room Database classes and Entities
-keep class * extends androidx.room.RoomDatabase { *; }
-keep @androidx.room.Entity class * { *; }
-dontwarn androidx.room.paging.**

# Keep Cloudinary SDK classes & suppress warnings for optional third-party integrations (Glide, Picasso)
-keep class com.cloudinary.** { *; }
-dontwarn com.cloudinary.android.download.glide.**
-dontwarn com.cloudinary.android.download.picasso.**
-dontwarn com.bumptech.glide.**
-dontwarn com.squareup.picasso.**

# Jetpack DataStore Preferences & Protobuf Lite
-keepclassmembers class * extends androidx.datastore.preferences.protobuf.GeneratedMessageLite {
    <fields>;
}
-keep class androidx.datastore.preferences.protobuf.** { *; }
-keep class androidx.datastore.preferences.core.** { *; }


