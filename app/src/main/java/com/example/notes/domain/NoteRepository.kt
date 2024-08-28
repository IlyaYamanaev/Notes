package com.example.notes.domain

import android.app.Application
import com.example.notes.data.daos.NoteDao
import com.example.notes.data.database.NoteDatabase
import com.example.notes.data.models.NoteModel
import kotlinx.coroutines.flow.Flow

class NoteRepository(application: Application) {
    private var noteDao: NoteDao

    init {
        val database = NoteDatabase.getInstance(application)
        noteDao = database.noteDao()
    }

    fun getAllNotesFromRoom(): Flow<List<NoteModel>> = noteDao.getAllNotes()
    fun getNoteByIdFromRoom(noteId: Int):Flow<NoteModel> = noteDao.getNoteById(noteId)
    suspend fun insertNoteToRoom(noteModel: NoteModel) = noteDao.insertNote(noteModel)
    suspend fun updateNoteInRoom(noteModel: NoteModel) = noteDao.updateNote(noteModel)
    suspend fun deleteNoteFromRoom(noteModel: NoteModel) = noteDao.deleteNote(noteModel)
}