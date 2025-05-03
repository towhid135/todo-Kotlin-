package com.example.todo.ui.icons

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.todo.ui.icons.todoz.Add
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
import kotlin.String
import kotlin.collections.List as ____KtList
import kotlin.collections.Map as ____KtMap

public object Todoz

private var __Icons: ____KtList<ImageVector>? = null

public val Todoz.Icons: ____KtList<ImageVector>
  get() {
    if (__Icons != null) {
      return __Icons!!
    }
    __Icons= listOf(Add, Design, Grocery, Health, Home, Movie, Music, Social, Sport, University,
        Work)
    return __Icons!!
  }

private var __IconsNamed: ____KtMap<String, ImageVector>? = null

public val Todoz.IconsNamed: ____KtMap<String, ImageVector>
  get() {
    if (__IconsNamed != null) {
      return __IconsNamed!!
    }
    __IconsNamed= mapOf("add" to Add, "design" to Design, "grocery" to Grocery, "health" to Health,
        "home" to Home, "movie" to Movie, "music" to Music, "social" to Social, "sport" to Sport,
        "university" to University, "work" to Work)
    return __IconsNamed!!
  }
