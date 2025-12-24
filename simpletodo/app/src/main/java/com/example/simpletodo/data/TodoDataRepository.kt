package com.example.simpletodo.data

import com.example.simpletodo.domain.Todo
import com.example.simpletodo.domain.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoDataRepository(private val dao: TodoDao): TodoRepository {
    override suspend fun getAllTodos(): Flow<List<Todo>> {
        return dao.getAllTodos().map { entities ->
            entities.map { entity ->
                Todo(
                    id = entity.id,
                    title = entity.title,
                    isCompleted = entity.isCompleted
                )
            }
        }
    }

    override suspend fun insertTodo(todo: Todo) {
        val entity = TodoEntity(
            id = todo.id,
            title = todo.title,
            isCompleted = todo.isCompleted
        )
        dao.insertTodo(entity)
    }

    override suspend fun updateTodo(todo: Todo) {
        val entity = TodoEntity(
            id = todo.id,
            title = todo.title,
            isCompleted = todo.isCompleted
        )
        dao.updateTodo(entity)
    }

    override suspend fun deleteTodo(todo: Todo) {
        val entity = TodoEntity(
            id = todo.id,
            title = todo.title,
            isCompleted = todo.isCompleted
        )
        dao.deleteTodo(entity)
    }


}