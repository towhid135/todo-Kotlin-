package com.example.todo.core.util

import com.example.todo.R

object TodoConstants {
    const val EMPTY_TITLE_OR_DESCRIPTION = "Both the todo title and description must be populated."
}

object TodoListStrings {
    const val CANT_GET_TODOS = "Error: Could not retrieve Todo Items"
    const val HOME = "Home"
    const val TITLE = "Title"
    const val TIME = "Time"
    const val Completed = "Completed"
    const val SORT_UP = "Sort Up"
    const val SORT_DOWN = "Sort Down"
    const val DETAILS = "Details"
    const val SORT_BY = "Sort"
    const val TODO_ITEM_DELETED = "Todo Item has been deleted"
    const val UNDO = "Undo"
}

object TodoDetailsStrings {
    const val DUE_DATE = "Due Date:"
    const val TASK_CATEGORY = "Task Category:"
    const val TASK_PRIORITY = "Task Priority:"
    const val DELETE_TASK = "Delete Task"
}

object ContentDescriptions {
    const val ADD_TODO = "Add Todo Item"
    const val SORTING_MENU = "Sorting Menu"
    const val LOADING_INDICATOR = "Loading"
}

object AuthStrings {
    const val REGISTER = "Register"
    const val EMAIL = "Email"
    const val USER_NAME_PLACEHOLDER = "Enter your username"
    const val PASSWORD = "Password"
    const val PASSWORD_PLACEHOLDER = "Enter your password"
    const val CONFIRM_PASSWORD = "Confirm Password"
    const val CONFIRM_PASSWORD_PLACEHOLDER = "Confirm your password"
    const val OR = "or"
    const val ALREADY_HAVE_AN_ACCOUNT = "Already have an account?"
    const val LOG_IN = "Login"
    const val DONT_HAVE_AN_ACCOUNT = "Don't have an account?"
}

enum class ButtonSize {
    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE,
}

enum class ButtonType {
    FILLED,
    OUTLINED,
}

enum class ButtonTitle(val value: String) {
    CLOSE("Close"),
    EDIT_TASK("Edit Task"),
    REGISTER("Register"),
    REGISTER_WITH_GOOGLE("Register with Google"),
    LOGIN("Login"),
    LOGIN_WITH_GOOGLE("Login with Google"),
}

enum class IconAsset(val id:Int) {
    GOOGLE_LOGIN(R.drawable.google),
    APPLE_LOGIN(R.drawable.applelogin),
}

enum class CategoryBoxType(){
    RECTANGLE,
    SQUARE,
}

data class FormattedDate(
    val dayName: String,
    val dayNumber: Int,
    val monthName: String = "",
    val monthNumber: Int = 0,
    val year: Int = 0
)

enum class BottomTabItemTitle(val title:String) {
    INDEX("Index"),
    CALENDER("Calendar"),
    FOCUS("Focus"),
    PROFILE("Profile")
}



