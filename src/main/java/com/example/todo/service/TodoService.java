package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
    
    public List<Todo> getCompletedTodos() {
        return todoRepository.findByCompleted(true);
    }
    
    public List<Todo> getIncompleteTodos() {
        return todoRepository.findByCompleted(false);
    }
    
    public List<Todo> searchTodos(String searchTerm) {
        return todoRepository.findByTitleContainingIgnoreCase(searchTerm);
    }
    
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }
    
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }
    
    public Todo updateTodo(Long id, Todo todoDetails) {
        Todo todo = getTodoById(id);
        todo.setTitle(todoDetails.getTitle());
        todo.setDescription(todoDetails.getDescription());
        return todoRepository.save(todo);
    }
    
    public Todo toggleTodoStatus(Long id) {
        Todo todo = getTodoById(id);
        if (todo.isCompleted()) {
            todo.markIncomplete();
        } else {
            todo.markComplete();
        }
        return todoRepository.save(todo);
    }
    
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}