package com.example.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.ViewModelProvider
import com.example.notes.ui.NotesApp
import com.example.notes.ui.theme.NotesTheme
import com.example.notes.ui.presentation.home.HomeViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
            NotesTheme{
                Surface(modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.mainback)) {
                    NotesApp()
                }
            }
        }
    }
}

