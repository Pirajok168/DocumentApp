package ru.kaer.documentsapp.component

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes

data class TabBarItem(
    val route: String,
    @DrawableRes val icon: Int,
    val label: String? = null,
    val noticeCount: Int = 0
)