package com.arzhang.project.mycityapp.ui.screens

import android.graphics.ColorSpace.Rgb
import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arzhang.project.mycityapp.R
import com.arzhang.project.mycityapp.data.Place
import com.arzhang.project.mycityapp.data.PlaceType
import com.arzhang.project.mycityapp.ui.theme.MyCItyAppTheme
import com.arzhang.project.mycityapp.utils.CityContentType

@Composable
fun SelectionButtons(
    onTypeClick: (PlaceType) -> Unit,
    placeType: PlaceType,
    modifier: Modifier = Modifier
) {
        Spacer(Modifier.padding(10.dp))
        Button(
            onClick = { onTypeClick(placeType) },
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(placeType.color),
                contentColor = Color.White
            ),
            modifier = modifier
                .fillMaxSize()
        ) {
            Icon(painter = painterResource(id = placeType.icon), contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
            )
        }
}
@Composable
fun SelectionScreen(
    onTypeClick: (PlaceType) -> Unit,
    contentType: CityContentType,
    modifier: Modifier = Modifier
) {
    if(contentType == CityContentType.ListOnly) {
        Column(
            modifier = modifier.padding(horizontal = 30.dp)
        ) {
            for (place in PlaceType.values()) {
                SelectionButtons(onTypeClick = onTypeClick, place, Modifier.weight(1f))
            }
            Spacer(Modifier.padding(10.dp))
        }
    } else if(contentType == CityContentType.ListAndDetail) {
        Row(
            modifier = modifier.padding(vertical = 30.dp)
        ) {
            for (place in PlaceType.values()) {
                SelectionButtons(onTypeClick = onTypeClick, place,Modifier.weight(1f))
            }
            Spacer(Modifier.padding(10.dp))
        }
        }

   }

@Preview(device = "spec:width=411dp,height=891dp")
@Composable
fun SelectionScreenPreview() {
    MyCItyAppTheme {
        SelectionScreen(onTypeClick = {}, contentType = CityContentType.ListOnly)
    }
}