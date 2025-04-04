package com.example.dsw51789.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dsw51789.model.Todo

@Database(entities = [Todo::class], version = 1)
@TypeConverters(Converters::class)
abstract class TodoDatabase : RoomDatabase(){

    companion object{
        const val NAME = "Todo_DB"
    }

    abstract fun getTodoDao(): TodoDao
}

