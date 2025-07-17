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

object ContentDescriptions {
    const val DELETE_TODO_ITEM = "Delete Todo Item"
    const val COMPLETE_TODO_ITEM = "Complete Todo Item"
    const val ARCHIVE_TODO_ITEM = "Archive Todo Item"
    const val SELECTED = "Selected"
    const val ADD_TODO = "Add Todo Item"
    const val SORTING_MENU = "Sorting Menu"
    const val BACKGROUND_IMAGE = "Background Image"
    const val LOADING_INDICATOR = "Loading"
    const val SAVE_TODO = "Save Todo Item"
    const val BACK = "Back"
}

object NewUpdateStrings {
    const val SAVE_ERROR = "Unable to save todo. Ensure the title and description are not blank."
    const val SAVE_TODO_COMPLETE = "Todo has been saved"
    const val CONFIRM_DELETE = "Are you sure you want to delte this todo item?"
    const val YES = "Yes"
    const val TITLE_PLACE_HOLDER = "Title..."
    const val DESCRIPTION_PLACE_HOLDER = "Description..."
}

enum class ButtonSize {
    SMALL,
    MEDIUM,
    LARGE
}

enum class ButtonType {
    FILLED,
    OUTLINED,
}

enum class ButtonTitle(val value: String) {
    LOGIN("Login with Google"),
    GET_STARTED("Login with Apple"),
    CLOSE("Close"),
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
)

enum class BottomTabItemTitle(val title:String) {
    INDEX("Index"),
    CALENDER("Calendar"),
    FOCUS("Focus"),
    PROFILE("Profile")
}



