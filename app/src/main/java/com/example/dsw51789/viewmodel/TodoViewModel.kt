package com.example.dsw51789.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dsw51789.MainApplication
import com.example.dsw51789.model.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import java.time.Instant

class TodoViewModel: ViewModel() {
    val todoDao = MainApplication.todoDatabase.getTodoDao()

    val todoList : LiveData<List<Todo>> = todoDao.getAllTodo()

    fun addTodo(title : String){
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.addTodo(Todo(title = title, createdAt = Date.from(Instant.now())))
        }
    }
    fun deleteTodo(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.deleteTodo(id)
        }
    }

}