package com.example.simpletodo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.simpletodo.domain.Todo
import com.example.simpletodo.presentation.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen(todoViewModel: TodoViewModel) {
    var task by remember { mutableStateOf("") }
    val todoList by todoViewModel.todos.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Simple Todo") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = task,
                    onValueChange = { task = it },
                    label = { Text("Add a task") },
                    modifier = Modifier.weight(1f)
                )
                Button(onClick = {
                    if (task.isNotBlank()) {
                        todoViewModel.addTodo(task)
                        task = ""
                    }
                }, colors = ButtonDefaults.buttonColors(Color(.5f, .2f, .2f))) {
                    Text("Add")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = Color.LightGray)
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(items = todoList, key = {it.id}) { todo ->
                    val isEditing = remember(todo.id) { mutableStateOf(false) }
                    val newTitle = remember(todo.id) { mutableStateOf(todo.title) }

                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                            Checkbox(
                                checked = todo.isCompleted,
                                onCheckedChange = { todoViewModel.toggleTodo(todo) },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = MaterialTheme.colorScheme.primary,
                                    uncheckedColor = MaterialTheme.colorScheme.onSurface
                                )
                            )

                            if(isEditing.value) {
                                OutlinedTextField(
                                    value = newTitle.value,
                                    onValueChange = { newTitle.value = it },
                                    modifier = Modifier.weight(1f).padding(end = 8.dp),
                                    shape = RoundedCornerShape(8.dp)
                                )

                                Button(onClick = {
                                    todoViewModel.updateTodoTitle(todo, newTitle.value)
                                    isEditing.value = false
                                }) {
                                    Text("Save")
                                }
                            } else {
                                Text(
                                    text = todo.title,
                                    modifier = Modifier.padding(start = 8.dp).weight(1f),
                                    style = if (todo.isCompleted)
                                        MaterialTheme.typography.bodyLarge.copy(
                                            color = Color.Gray,
                                            textDecoration = TextDecoration.LineThrough
                                        )
                                    else
                                        MaterialTheme.typography.bodyLarge
                                )
                            }
                        }

                        if(!isEditing.value) {
                            Row {
                                Button(
                                    onClick = { isEditing.value = true },
                                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
                                ) {
                                    Text("Edit")
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                                Button(
                                    onClick = { todoViewModel.deleteTodo(todo) },
                                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error)
                                ) {
                                    Text("Delete")
                                }
                            }
                        }
                    }
                }

            }
        }
    }



}
