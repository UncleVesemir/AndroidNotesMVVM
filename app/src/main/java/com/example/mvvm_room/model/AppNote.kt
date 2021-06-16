package com.example.mvvm_room.model

import androidx.annotation.ArrayRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes_tables")
data class AppNote (
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        @ColumnInfo val name: String = "",
        @ColumnInfo val text: String = "",
        var idFirebase: String = ""
):Serializable