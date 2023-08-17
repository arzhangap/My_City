package com.arzhang.project.mycityapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.arzhang.project.mycityapp.ui.CityAppNavigation
import com.arzhang.project.mycityapp.ui.components.CityAppBar
import com.arzhang.project.mycityapp.utils.CityContentType


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityApp(
    windowSize: WindowWidthSizeClass
) {
    val viewModel: CityAppViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val navController = rememberNavController()
    val contentType: CityContentType
        when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            contentType = CityContentType.ListOnly

        }
        WindowWidthSizeClass.Medium -> {
            contentType = CityContentType.ListOnly
        }
        WindowWidthSizeClass.Expanded -> {
            contentType = CityContentType.ListAndDetail
        }
        else -> {
            contentType =  CityContentType.ListOnly
        }
    }

            CityAppNavigation(
                contentType = contentType,
                viewModel = viewModel,
                uiState = uiState,
                navController = navController
            )
        }