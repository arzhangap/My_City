package com.arzhang.project.mycityapp.ui.screens

import androidx.lifecycle.ViewModel
import com.arzhang.project.mycityapp.data.Place
import com.arzhang.project.mycityapp.data.PlaceType
import com.arzhang.project.mycityapp.data.RecommendListUiState
import com.arzhang.project.mycityapp.data.dataStore.LocalCityDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CityAppViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(RecommendListUiState())
    val uiState: StateFlow<RecommendListUiState> = _uiState
    val places: Map<PlaceType, List<Place>> =
        LocalCityDataProvider.getCityData().groupBy { it.placeType }

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        _uiState.value =
            RecommendListUiState(
                placesList = places,
                currentSelectedPlace = places[PlaceType.Cafe]?.get(0)
                    ?: LocalCityDataProvider.defaultPlace
            )
    }

    fun setNew() {
        _uiState.update {
            it.copy(
                currentSelectedPlace = places[it.currentType]?.get(0)
                    ?: LocalCityDataProvider.defaultPlace
            )
        }
    }

    fun setHome() {
        _uiState.update {
            it.copy(
                isShowingHomePage = true
            )
        }
    }

    fun unsetHome() {
        _uiState.update {
            it.copy(
                isShowingHomePage = false
            )
        }
    }


    fun updateDetailsScreenStates(place: Place) {
        _uiState.update {
            it.copy(
                currentSelectedPlace = place
            )
        }
    }

    fun updateCurrentPlaceType(placeType: PlaceType) {
        _uiState.update {
            it.copy(
                currentType = placeType
            )
        }
    }
}
