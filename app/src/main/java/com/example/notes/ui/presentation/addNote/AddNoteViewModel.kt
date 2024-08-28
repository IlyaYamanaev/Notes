package com.example.notes.ui.presentation.addNote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.data.models.NoteModel
import com.example.notes.domain.NoteRepository
import kotlinx.coroutines.launch

class AddNoteViewModel(application: Application) : AndroidViewModel(application) {
    private val noteRepo = NoteRepository(application)

    fun insertNote(noteModel: NoteModel) {
        viewModelScope.launch {
            noteRepo.insertNoteToRoom(noteModel)
        }
    }
}