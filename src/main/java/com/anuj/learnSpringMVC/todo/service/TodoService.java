package com.anuj.learnSpringMVC.todo.service;

import com.anuj.learnSpringMVC.todo.entity.TodoEntity;
import com.anuj.learnSpringMVC.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<TodoEntity> findByUserName(String userName) {
        return todoRepository.findByUserName(userName);
    }

    public void addTodo(String userName, String description, LocalDate targetDate, Boolean isDone) {
        todoRepository.save(new TodoEntity(userName, description, targetDate, isDone));
    }

    public void deleteTodoById(Integer id) {
        todoRepository.deleteById(id);
    }

    public void updateTodoById(Integer id, TodoEntity updatedTodo) {
        Optional<TodoEntity> todo = todoRepository.findById(id);
        if(!todo.isPresent())
            return;
        if (updatedTodo.getDescription() != null && !updatedTodo.getDescription().isEmpty())
            todo.get().setDescription(updatedTodo.getDescription());
        if (updatedTodo.getTargetDate() != null)
            todo.get().setTargetDate(updatedTodo.getTargetDate());
        if (updatedTodo.getIsDone() != null)
            todo.get().setIsDone(updatedTodo.getIsDone());

        todoRepository.save(todo.get());
    }
}
