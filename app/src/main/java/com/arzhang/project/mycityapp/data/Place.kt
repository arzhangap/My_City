package com.arzhang.project.mycityapp.data

import androidx.annotation.DrawableRes
import com.arzhang.project.mycityapp.R

data class Place(
    val id: Int,
    val name: String,
    val placeType: PlaceType,
    @DrawableRes val image: Int,
    val placeDetails: String
)

enum class PlaceType(val icon: Int, val color: Int) {
    Cafe(R.drawable.baseline_coffee_24, R.color.coffee_icon_color),
    Park(R.drawable.baseline_park_24, R.color.park_icon_color),
    Shop(R.drawable.baseline_shopping_cart_24, R.color.shop_icon_color)
}