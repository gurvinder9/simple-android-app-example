package com.example.simpletodo.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.simpletodo.data.TodoDataRepository
import com.example.simpletodo.data.TodoDatabase
import com.example.simpletodo.domain.AddTodoUseCase
import com.example.simpletodo.domain.Todo
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

open class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val db = Room.databaseBuilder(
        application,
        TodoDatabase::class.java,
        "todos_db"
    ).build()
    protected val todoRepository = TodoDataRepository(db.todoDao())
    private val addUseCase  = AddTodoUseCase(todoRepository)

    open val todos = todoRepository.getAllTodos().stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        emptyList()
    )

    fun addTodo(title: String) {
        val todo = Todo(
            id = 0,
            title = title,
            isCompleted = false
        )
        viewModelScope.launch {
            addUseCase.invoke(todoRepository, todo)
        }
    }

    fun toggleTodo(todo: Todo) {
        val updatedTodo = todo.copy(isCompleted = !todo.isCompleted)
        viewModelScope.launch {
            todoRepository.updateTodo(updatedTodo)
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            todoRepository.deleteTodo(todo)
        }
    }

    fun clearCompletedTodos() {
        viewModelScope.launch {
            val currentTodos = todos.value
            val completedTodos = currentTodos.filter { it.isCompleted }
            for (todo in completedTodos) {
                todoRepository.deleteTodo(todo)
            }
        }
    }

    fun updateTodoTitle(todo: Todo, newTitle: String) {
        val updatedTodo = todo.copy(title = newTitle)
        viewModelScope.launch {
            todoRepository.updateTodo(updatedTodo)
        }
    }



}