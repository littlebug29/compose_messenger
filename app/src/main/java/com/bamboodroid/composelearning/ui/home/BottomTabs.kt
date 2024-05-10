package com.bamboodroid.composelearning.ui.home

import androidx.annotation.DrawableRes
import com.bamboodroid.composelearning.R

enum class BottomTabs(val order: Int, val tabName: String, @DrawableRes val iconRes: Int) {
    CHATS(0,"Chats", R.drawable.ic_chats),
    FRIENDS(1,"People", R.drawable.ic_people)
}
