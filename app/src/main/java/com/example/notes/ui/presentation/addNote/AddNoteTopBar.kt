package com.example.notes.ui.presentation.addNote

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.notes.R
import com.example.notes.data.models.NoteModel

@Composable
fun AddNoteTopBar(
    viewModel: AddNoteViewModel,
    navigateBack: () -> Unit,
    title: String,
    notes: String,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = ("новая заметка"),
                fontFamily = FontFamily(Font(R.font.fontik)),
                fontSize = 26.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(painterResource(R.drawable.ic_baseline_clear_24),
                    contentDescription = "logo")
            }
        },
        actions = {
            IconButton(onClick = {
                if (title.isNotEmpty() || notes.isNotEmpty()){
                    val noteModel = NoteModel(id = 0, title = title, notes = notes)
                    viewModel.insertNote(noteModel)
                    navigateBack()
                }else{
                    navigateBack()
                }
            }) {
                Icon(painterResource(R.drawable.ic_baseline_check_24),
                    contentDescription = "Git")
            }
        }
    )
}