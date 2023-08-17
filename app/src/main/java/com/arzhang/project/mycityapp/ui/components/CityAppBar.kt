package com.arzhang.project.mycityapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.arzhang.project.mycityapp.R
import com.arzhang.project.mycityapp.data.RecommendListUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAppBar(
    onBackButtonClick: () -> Unit,
    uiState: RecommendListUiState,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(text =
            if (uiState.isShowingHomePage) {
                "مکان های گردشگری کرج"
            }
            else {
                uiState.currentType.name
            },
                fontWeight = FontWeight.Bold,
            )
        },
        navigationIcon = if (!uiState.isShowingHomePage) {
            {
                IconButton(onClick = onBackButtonClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        } else {
            { Box() {} }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        modifier = modifier
    )
}