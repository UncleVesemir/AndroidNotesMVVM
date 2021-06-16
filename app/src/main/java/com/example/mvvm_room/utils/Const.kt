package com.example.mvvm_room.utils

import com.example.mvvm_room.MainActivity
import com.example.mvvm_room.database.DatabaseRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

lateinit var APP_ACTIVITY:MainActivity
lateinit var REPOSITORY:DatabaseRepository
lateinit var EMAIL:String
lateinit var PASSWORD:String

lateinit var AUTH: FirebaseAuth
lateinit var CURRENT_ID: String
lateinit var REF_DATABASE: DatabaseReference

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"

const val ID_FIREBASE = "idFirebase"
const val NOTES = "APP_NOTES"
const val NAME = "name"
const val TEXT = "text"
const val TYPE_FIREBASE = "type_firebase"
