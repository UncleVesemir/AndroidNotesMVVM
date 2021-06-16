package com.example.mvvm_room.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mvvm_room.database.firebase.AppFirebaseRepository
import com.example.mvvm_room.database.room.AppRoomDatabase
import com.example.mvvm_room.database.room.AppRoomRepository
import com.example.mvvm_room.utils.*

class StartFragmentViewmodel(application: Application): AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type: String, onSuccess:()->Unit) {
        when(type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase({onSuccess()},{showToast(it)})
            }
        }
    }
}