package com.example.androidtest.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.androidtest.data.model.CarModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CarDetailScreen(car: CarModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = car.name,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Year: ${car.year}",
            style = TextStyle(fontSize = 18.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        GlideImage(
            model = car.image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
    }
}