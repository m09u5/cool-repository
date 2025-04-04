package com.example.dsw51789.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dsw51789.model.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo ORDER BY createdAt DESC")
    fun getAllTodo() : LiveData<List<Todo>>

    @Insert
    fun addTodo(todo: Todo)

    @Query("Delete FROM todo where id = :id")
    fun deleteTodo(id : Int)


}