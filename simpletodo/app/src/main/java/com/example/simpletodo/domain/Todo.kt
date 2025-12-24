package com.example.simpletodo.domain

data class Todo(
    val id: Int = 0,
    val title: String,
    val isCompleted: Boolean = false
)
