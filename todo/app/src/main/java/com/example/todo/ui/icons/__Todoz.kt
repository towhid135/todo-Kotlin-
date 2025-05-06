package com.example.todo.ui.icons

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.todo.ui.icons.todoz.Add
import com.example.todo.ui.icons.todoz.Arrowdown
import com.example.todo.ui.icons.todoz.Arrowleft
import com.example.todo.ui.icons.todoz.Arrowright
import com.example.todo.ui.icons.todoz.Calendar
import com.example.todo.ui.icons.todoz.Camera
import com.example.todo.ui.icons.todoz.Clock
import com.example.todo.ui.icons.todoz.Cross
import com.example.todo.ui.icons.todoz.Design
import com.example.todo.ui.icons.todoz.Dotmenu
import com.example.todo.ui.icons.todoz.Edit
import com.example.todo.ui.icons.todoz.Filter
import com.example.todo.ui.icons.todoz.Flag
import com.example.todo.ui.icons.todoz.Flash
import com.example.todo.ui.icons.todoz.Grocery
import com.example.todo.ui.icons.todoz.Health
import com.example.todo.ui.icons.todoz.Home
import com.example.todo.ui.icons.todoz.Homefill
import com.example.todo.ui.icons.todoz.Infooutline
import com.example.todo.ui.icons.todoz.Key
import com.example.todo.ui.icons.todoz.Like
import com.example.todo.ui.icons.todoz.Logout
import com.example.todo.ui.icons.todoz.Movie
import com.example.todo.ui.icons.todoz.Music
import com.example.todo.ui.icons.todoz.Search
import com.example.todo.ui.icons.todoz.Send
import com.example.todo.ui.icons.todoz.Setting
import com.example.todo.ui.icons.todoz.Social
import com.example.todo.ui.icons.todoz.Sport
import com.example.todo.ui.icons.todoz.Tag
import com.example.todo.ui.icons.todoz.Timer
import com.example.todo.ui.icons.todoz.Trash
import com.example.todo.ui.icons.todoz.University
import com.example.todo.ui.icons.todoz.User
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
    __Icons= listOf(Add, Arrowdown, Arrowleft, Arrowright, Calendar, Camera, Clock, Cross, Design,
        Dotmenu, Edit, Filter, Flag, Flash, Grocery, Health, Home, Homefill, Infooutline, Key, Like,
        Logout, Movie, Music, Search, Send, Setting, Social, Sport, Tag, Timer, Trash, University,
        User, Work)
    return __Icons!!
  }

private var __IconsNamed: ____KtMap<String, ImageVector>? = null

public val Todoz.IconsNamed: ____KtMap<String, ImageVector>
  get() {
    if (__IconsNamed != null) {
      return __IconsNamed!!
    }
    __IconsNamed= mapOf("add" to Add, "arrowdown" to Arrowdown, "arrowleft" to Arrowleft,
        "arrowright" to Arrowright, "calendar" to Calendar, "camera" to Camera, "clock" to Clock,
        "cross" to Cross, "design" to Design, "dotmenu" to Dotmenu, "edit" to Edit, "filter" to
        Filter, "flag" to Flag, "flash" to Flash, "grocery" to Grocery, "health" to Health, "home"
        to Home, "homefill" to Homefill, "infooutline" to Infooutline, "key" to Key, "like" to Like,
        "logout" to Logout, "movie" to Movie, "music" to Music, "search" to Search, "send" to Send,
        "setting" to Setting, "social" to Social, "sport" to Sport, "tag" to Tag, "timer" to Timer,
        "trash" to Trash, "university" to University, "user" to User, "work" to Work)
    return __IconsNamed!!
  }
