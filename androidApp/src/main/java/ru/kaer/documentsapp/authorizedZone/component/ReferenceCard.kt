package ru.kaer.documentsapp.authorizedZone.component

import androidx.annotation.DrawableRes

data class ReferenceCard(
   val title: String,
   @DrawableRes val icon: Int,
   val descriptions: List<String>
)
