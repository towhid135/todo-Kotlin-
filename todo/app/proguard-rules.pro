# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Keep data classes used for API serialization
-keep class com.example.todo.feature_todo.data.remote.dto.** { *; }

# Keep GSON annotations
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Keep generic signatures for Retrofit/GSON
-keepattributes Signature

# Preserve line numbers for crash reporting
-keepattributes SourceFile,LineNumberTable


# Keep generic signatures and annotation metadata needed by Retrofit/Gson for reflection.
# Without this, R8 may strip type info or annotations used at runtime.
-keepattributes Signature, *Annotation*

# Keep all Retrofit runtime classes (don't remove or rename them).
# Retrofit relies on these classes at runtime.
-keep class retrofit2.** { *; }

# Keep all OkHttp runtime classes (don't remove or rename them).
# OkHttp is the HTTP client used by Retrofit; keep its implementation.
-keep class okhttp3.** { *; }

# Preserve any methods annotated with Retrofit HTTP annotations (e.g. @GET, @POST).
# This prevents R8 from removing/renaming interface methods used to build requests.
-keepclassmembers class * {
    @retrofit2.http.* <methods>;
}

# Keep all Gson runtime classes (don't remove or rename them).
# Gson reflection code depends on these classes.
-keep class com.google.gson.** { *; }

# Preserve fields annotated with @SerializedName so Gson can map JSON to fields.
# If these are removed/renamed, JSON deserialization may fail.
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

# Keep your model/data classes used for API serialization/deserialization.
# Adjust the package to match your actual model package.
-keep class com.example.todo.model.** { *; }
