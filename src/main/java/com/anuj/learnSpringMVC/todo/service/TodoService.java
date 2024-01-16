package com.anuj.learnSpringMVC.todo.service;

import com.anuj.learnSpringMVC.todo.entity.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todosList;

    private static int todoCount = 0;

    static {
        todosList = new ArrayList<>(Arrays.asList(
                new Todo(todoCount++, "Anuj", "Learn Spring", LocalDate.now().plusDays(21), false),
                new Todo(todoCount++, "Anuj", "Learn AWS", LocalDate.now().plusDays(25), false),
                new Todo(todoCount++, "Anuj", "Learn NLP", LocalDate.now().plusDays(45), false)
        ));
    }

    public List<Todo> findByUserName(String userName) {
        return todosList
                .stream()
                .filter(todo -> todo.getUserName().equals(userName))
                .toList();
    }

    public void addTodo(String userName, String description, LocalDate targetDate, Boolean isDone) {
        todosList.add(new Todo(todoCount++, userName, description, targetDate, isDone));
    }

    public void deleteTodoById(Integer id) {
        Iterator<Todo> it = todosList.iterator();
        while(it.hasNext()) {
            Todo todo = it.next();
            if(todo.getId().equals(id)) {
                it.remove();
            }
        }
    }

    public void updateTodoById(Integer id, Todo updatedTodo) {
        for (Todo todo : todosList) {
            if (todo.getId().equals(id)) {
                if (updatedTodo.getDescription() != null && !updatedTodo.getDescription().isEmpty())
                    todo.setDescription(updatedTodo.getDescription());
                if (updatedTodo.getTargetDate() != null)
                    todo.setTargetDate(updatedTodo.getTargetDate());
                if (updatedTodo.getIsDone() != null)
                    todo.setIsDone(updatedTodo.getIsDone());
                return;
            }
        }
    }
}
