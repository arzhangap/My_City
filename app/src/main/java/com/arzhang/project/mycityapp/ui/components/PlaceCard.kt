package com.arzhang.project.mycityapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arzhang.project.mycityapp.R
import com.arzhang.project.mycityapp.data.Place
import com.arzhang.project.mycityapp.data.dataStore.LocalCityDataProvider
import com.arzhang.project.mycityapp.ui.screens.PlaceDetail
import com.arzhang.project.mycityapp.ui.theme.MyCItyAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceCard(
    place: Place,
    onItemClick: (Place) -> Unit ,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(place) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_height))
        ) {
           PlaceCardImage(
               place = place,
               Modifier.weight(3f)
           )
            Row(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = place.name,
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 5.dp)
                )
            }
        }
    }
}

@Composable
fun PlaceList(
    places: List<Place>,
    onClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier
    ) {
        items(places) {place ->
            PlaceCard(place = place, onItemClick = {onClick(it)} )
        }
    }
}

@Composable
private fun PlaceCardImage(place: Place, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(place.image),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun PlaceListAndDetail(
    places: List<Place>,
    onClickPlace: (Place) -> Unit,
    selectedPlace: Place,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        PlaceList(places = places, onClick = onClickPlace, modifier = modifier.weight(1f))
        PlaceDetail(selectedPlace = selectedPlace,  modifier = modifier.weight(1f))
    }
}

@Preview()
@Composable
fun PlaceCardPreview() {
    MyCItyAppTheme {
        PlaceCard(
            LocalCityDataProvider.defaultPlace,
            {}
        )
    }
}

@Preview(device = "spec:width=411dp,height=891dp", showBackground = true)
@Composable
fun PlaceListPreview() {
    MyCItyAppTheme {
        PlaceList(places =  listOf(LocalCityDataProvider.defaultPlace,LocalCityDataProvider.getCityData()[2]) , onClick = {})
    }
}