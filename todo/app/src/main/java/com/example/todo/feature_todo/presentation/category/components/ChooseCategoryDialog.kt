package com.example.todo.feature_todo.presentation.category.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.todo.core.presentation.components.CustomButton
import com.example.todo.core.util.ButtonSize
import com.example.todo.core.util.ButtonTitle
import com.example.todo.core.util.ButtonType
import com.example.todo.core.util.Category
import com.example.todo.core.util.CategoryBoxType
import com.example.todo.core.util.CategoryColor
import com.example.todo.feature_todo.presentation.home.components.CategoryBox
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Design
import com.example.todo.ui.icons.todoz.Grocery
import com.example.todo.ui.icons.todoz.Health
import com.example.todo.ui.icons.todoz.Home
import com.example.todo.ui.icons.todoz.Movie
import com.example.todo.ui.icons.todoz.Music
import com.example.todo.ui.icons.todoz.Social
import com.example.todo.ui.icons.todoz.Sport
import com.example.todo.ui.icons.todoz.University
import com.example.todo.ui.icons.todoz.Work
import com.example.todo.ui.theme.LocalTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChooseCategoryDialog(
    showCategory: Boolean,
    selectedCategory: Category,
    toggleShowCategory: () -> Unit,
    onCategoryChange: (category: Category) -> Unit
) {
    val theme = LocalTheme.current
    val categories = listOf(
        Category(
            id = "1",
            title = Todoz.Grocery.name,
            bgColor = CategoryColor.GREEN.colorCode,
            icon = Todoz.Grocery.name.lowercase()
        ),
        Category(
            id = "2",
            title = Todoz.Work.name,
            bgColor = CategoryColor.PERU.colorCode,
            icon = Todoz.Work.name.lowercase()
        ),
        Category(
            id = "3",
            title = Todoz.Sport.name,
            bgColor = CategoryColor.SEA_RIDGE.colorCode,
            icon = Todoz.Sport.name.lowercase()
        ),
        Category(
            id = "4",
            title = Todoz.Design.name,
            bgColor = CategoryColor.MINT_JELLY.colorCode,
            icon = Todoz.Design.name.lowercase()
        ),
        Category(
            id = "5",
            title = Todoz.University.name,
            bgColor = CategoryColor.WORN_DENIM.colorCode,
            icon = Todoz.University.name.lowercase()
        ),
        Category(
            id = "6",
            title = Todoz.Social.name,
            bgColor = CategoryColor.PURPLE_VANITY.colorCode,
            icon = Todoz.Social.name.lowercase()
        ),
        Category(
            id = "7",
            title = Todoz.Music.name,
            bgColor = CategoryColor.PURPLE_VANITY.colorCode,
            icon = Todoz.Music.name.lowercase()
        ),
        Category(
            id = "8",
            title = Todoz.Health.name,
            bgColor = CategoryColor.GREEN.colorCode,
            icon = Todoz.Health.name.lowercase()
        ),
        Category(
            id = "9",
            title = Todoz.Movie.name,
            bgColor = CategoryColor.FUCHSIA_ROSE.colorCode,
            icon = Todoz.Movie.name.lowercase()
        ),
        Category(
            id = "10",
            title = Todoz.Home.name,
            bgColor = CategoryColor.YELLOW.colorCode,
            icon = Todoz.Home.name.lowercase()
        )

    )

    fun onCategoryBoxPress(category: Category) {
        onCategoryChange(category)
    }

    if (showCategory) {
        Dialog(onDismissRequest = { toggleShowCategory() }) {
            Card(
                shape = CardDefaults.shape
            ) {
                Column(
                    modifier = Modifier
                        .background(color = theme.colors.backgroundSecondary)
                        .padding(horizontal = 20.dp, vertical = 15.dp),

                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Choose a Category",
                        color = theme.colors.textPrimary,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(800)
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                        thickness = 1.dp,
                        color = theme.colors.borderSecondary
                    )
                    FlowRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        maxItemsInEachRow = 3,
                        verticalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        categories.map { category ->
                            CategoryBox(
                                category = category.copy(isSelected = selectedCategory.id == category.id),
                                type = CategoryBoxType.SQUARE,
                                onPress = { categoryItem ->
                                    onCategoryBoxPress(categoryItem)
                                }
                            )
                        }
                    }
                    CustomButton(
                        type = ButtonType.FILLED,
                        size = ButtonSize.LARGE,
                        title = ButtonTitle.CLOSE,
                        onPress = { toggleShowCategory() }
                    )
                }

            }
        }
    }


}