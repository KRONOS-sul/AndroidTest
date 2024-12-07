package com.example.androidtest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.androidtest.data.model.CarModel

@Composable
fun CarsScreen(onClick: (CarModel) -> Unit) {
    val carList = listOf(
        CarModel(
            1, "Lamborghini",
            "https://dorsiafinance.co.uk/wp-content/uploads/10-Facts-About-Lamborghini.webp",
            2016
        ),
        CarModel(
            2,
            "Koenigsegg",
            "https://www.thesupercarblog.com/wp-content/uploads/2023/10/Koenigsegg-Jesko-Attack-Plus-Green-spec-3-1000x600.jpg",
            2021
        ),
        CarModel(
            3,
            "Maserati",
            "https://di-uploads-pod13.dealerinspire.com/maseratilouisville/uploads/2022/09/2209-Maserati-Levante-History.jpg",
            2010
        )
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp, 16.dp)
    ) {
        for (x in 1..4) {
            items(carList) { car ->
                CarItem(car, onClick = { onClick(car) })
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CarItem(car: CarModel, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.DarkGray)
            .clickable { onClick() }

    ) {
        Row {
            GlideImage(
                modifier = Modifier.width(140.dp),
                contentScale = ContentScale.Crop,
                model = car.image,
                contentDescription = "Character Image"
            )
            Spacer(modifier = Modifier.padding(12.dp, 0.dp))
            Column {
                Text(
                    modifier = Modifier.padding(0.dp, 4.dp),
                    text = car.name,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Year: ${car.year}",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                )
            }
        }
    }
    Spacer(modifier = Modifier.padding(0.dp, 12.dp))
}
