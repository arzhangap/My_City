package com.arzhang.project.mycityapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arzhang.project.mycityapp.data.Place
import com.arzhang.project.mycityapp.data.dataStore.LocalCityDataProvider

@Composable
fun PlaceDetail(
    selectedPlace: Place,
    modifier: Modifier = Modifier
) {
        Surface(modifier = modifier.fillMaxWidth()) {
            Column(modifier = Modifier.verticalScroll (rememberScrollState())) {
                Image(
                    painter = painterResource(id = selectedPlace.image), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                    Text(
                        selectedPlace.name,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 10.dp)
                    )
                Card(
                    modifier = Modifier.padding()
                        .fillMaxHeight()
                        .padding(top = 10.dp)
                ) {
                    Text(
                        selectedPlace.placeDetails,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.fillMaxWidth().padding(20.dp)
                    )
                }
            }

        }
}

@Preview
@Composable
fun PlaceDetailPreview() {
    PlaceDetail(selectedPlace = LocalCityDataProvider.defaultPlace)
}