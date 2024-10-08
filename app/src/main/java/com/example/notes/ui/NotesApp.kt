package com.example.notes.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notes.ui.presentation.addNote.AddNoteScreen
import com.example.notes.ui.presentation.home.HomeScreen
import com.example.notes.ui.presentation.updateNote.UpdateNoteScreen


sealed class NoteAppScreens(val name : String){
    object Home : NoteAppScreens("home")
    object AddNotes : NoteAppScreens("add_note")
    object UpdateNotes : NoteAppScreens("update_note/{id}")
}

@Composable
fun NotesApp(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = NoteAppScreens.Home.name,
    ) {
        composable(route = NoteAppScreens.Home.name) {
            HomeScreen(
                onFabClicked = { navController.navigate(NoteAppScreens.AddNotes.name) },
                navigateToUpdateNoteScreen = { noteId ->
                    navController.navigate("${NoteAppScreens.UpdateNotes.name}/$noteId")
                },
            )
        }
        composable(route = "${NoteAppScreens.UpdateNotes.name}/{noteId}",
            arguments = listOf(navArgument("noteId") { type = IntType })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt("noteId") ?: 0
            UpdateNoteScreen(
                noteId = noteId,
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(NoteAppScreens.AddNotes.name) {
            AddNoteScreen(navigateBack = { navController.popBackStack() })
        }
    }
}