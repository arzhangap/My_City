package com.arzhang.project.mycityapp.data

import com.arzhang.project.mycityapp.data.dataStore.LocalCityDataProvider

data class RecommendListUiState(
    val currentType: PlaceType = PlaceType.Cafe,
    val placesList: Map<PlaceType, List<Place>> = emptyMap(),
    val currentSelectedPlace: Place = LocalCityDataProvider.defaultPlace,
    var isShowingHomePage: Boolean = true,
) {
    val currentList: List<Place> by lazy { placesList[currentType]!! }
}