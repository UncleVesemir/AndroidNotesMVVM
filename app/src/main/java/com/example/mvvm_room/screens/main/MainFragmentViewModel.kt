package com.example.mvvm_room.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mvvm_room.utils.REPOSITORY

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {

    val allNotes = REPOSITORY.allNotes

    fun signOut(){
        REPOSITORY.signOut()
    }

}