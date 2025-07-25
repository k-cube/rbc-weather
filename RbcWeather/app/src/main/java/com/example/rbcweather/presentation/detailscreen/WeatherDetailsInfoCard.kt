package com.example.rbcweather.presentation.detailscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rbcweather.domain.DisplayInfo
import com.example.rbcweather.domain.getIcon

@Composable
fun WeatherDetailsInfoCard(
    modifier: Modifier = Modifier,
    displayInfo: DisplayInfo
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .aspectRatio(1f)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = displayInfo.getIcon()),
                    contentDescription = displayInfo.name,
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    displayInfo.name,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${displayInfo.value}${displayInfo.unit ?: ""}",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 20.sp
                )
            }
        }
    }
}