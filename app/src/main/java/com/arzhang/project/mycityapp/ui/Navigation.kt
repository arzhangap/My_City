package com.arzhang.project.mycityapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arzhang.project.mycityapp.R
import com.arzhang.project.mycityapp.data.RecommendListUiState
import com.arzhang.project.mycityapp.ui.components.CityAppBar
import com.arzhang.project.mycityapp.ui.components.PlaceList
import com.arzhang.project.mycityapp.ui.components.PlaceListAndDetail
import com.arzhang.project.mycityapp.ui.screens.CityAppViewModel
import com.arzhang.project.mycityapp.ui.screens.PlaceDetail
import com.arzhang.project.mycityapp.ui.screens.SelectionScreen
import com.arzhang.project.mycityapp.utils.CityContentType

enum class CityScreen(@StringRes val address: Int) {
    Selection(R.string.selection),
    PlaceList(R.string.place_list),
    Detail(R.string.detail),
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAppNavigation(
    contentType: CityContentType,
    viewModel: CityAppViewModel,
    uiState: RecommendListUiState,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    Scaffold(
        topBar = { CityAppBar(onBackButtonClick = { navController.navigateUp()}, uiState) },
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = CityScreen.Selection.name,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(CityScreen.Selection.name) {
                viewModel.setHome()
                SelectionScreen(onTypeClick = {
                    viewModel.updateCurrentPlaceType(it)
                    viewModel.setNew()
                    navController.navigate(CityScreen.PlaceList.name)
                },
                contentType)
            }

            composable(CityScreen.PlaceList.name) {
                viewModel.unsetHome()
                if (contentType == CityContentType.ListOnly) {
                    PlaceList(
                        places = uiState.currentList,
                        onClick = {
                            viewModel.updateDetailsScreenStates(it)
                            navController.navigate(CityScreen.Detail.name)
                        }
                    )
                } else if(contentType == CityContentType.ListAndDetail) {
                    PlaceListAndDetail(places = uiState.currentList, onClickPlace = {
                        viewModel.updateDetailsScreenStates(it)
                    } ,
                        selectedPlace = uiState.currentSelectedPlace)
                }
            }
            composable(CityScreen.Detail.name) {
                if (contentType == CityContentType.ListOnly) {
                    PlaceDetail(selectedPlace = uiState.currentSelectedPlace)
                }
            }
        }

    }

}