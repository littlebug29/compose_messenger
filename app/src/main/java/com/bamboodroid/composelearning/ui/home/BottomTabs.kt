package com.bamboodroid.composelearning.ui.home

import androidx.annotation.DrawableRes
import com.bamboodroid.composelearning.R

enum class BottomTabs(val tabName: String, @DrawableRes val iconRes: Int) {
    CHATS("Chats", R.drawable.ic_chats),
    FRIENDS("People", R.drawable.ic_people)
}
