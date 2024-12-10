package com.rai.nearby.data.model

import androidx.annotation.DrawableRes

data class NearbyCategory(
    val id: String,
    val name: String
){
    //diz que no get a gente vai retornar um Drawable
    @get:DrawableRes
    val icon: Int?
        get() = NearbyCategoryFilterChipView.fromDescription(description = name)?.icon
}
