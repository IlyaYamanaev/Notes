package com.example.notes.ui.presentation.addNote

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notes.R

@Composable
fun AddNoteScreen(
    navigateBack: () -> Unit,
) {
    val viewModel: AddNoteViewModel = viewModel()
    var title by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    Scaffold(
        topBar = { AddNoteTopBar(viewModel, navigateBack, title, notes) },
        backgroundColor = colorScheme.surface
    ) {
        Surface(
            color = colorResource(id = R.color.white),
            shape = RoundedCornerShape(32.dp, 32.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()
            ) {
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    placeholder = { Text("Название",
                        fontFamily = FontFamily(Font(R.font.main)),
                        color = Color.Black,
                        fontSize = 23.sp)
                        },
                    textStyle = TextStyle(color = colorScheme.onSurface,
                        fontFamily = FontFamily(Font(R.font.main)),
                        fontSize = 23.sp),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.LightGray,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        capitalization = KeyboardCapitalization.Sentences,
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {
                        focusManager.moveFocus(FocusDirection.Down) }
                    ),
                )
                TextField(
                    value = notes,
                    onValueChange = { notes = it },
                    placeholder = { Text("Текст",
                        fontFamily = FontFamily(Font(R.font.main)),
                        color = Color.Black,
                        fontSize = 18.sp) },
                    textStyle = TextStyle(color = colorScheme.onSurface,
                        fontFamily = FontFamily(Font(R.font.main)),
                        fontSize = 18.sp),

                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        capitalization = KeyboardCapitalization.Sentences,
                        keyboardType = KeyboardType.Text,
                    ),
                )
            }
        }
    }
}