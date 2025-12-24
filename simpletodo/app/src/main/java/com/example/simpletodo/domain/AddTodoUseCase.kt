package com.example.simpletodo.domain

class AddTodoUseCase(private val todoRepository: TodoRepository) {
    suspend operator fun invoke(todoRepository: TodoRepository, todo: Todo) {
        todoRepository.insertTodo(todo)
    }
}