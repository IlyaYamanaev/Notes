package com.example.notes.ui.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notes.R

@Composable
fun HomeTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text("Заметеки",
                fontFamily = FontFamily(Font(R.font.fontik)),
                fontSize = 40.sp,
            )
        },
        modifier = Modifier.padding(start = 16.dp),
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
            )
        }
    )
}