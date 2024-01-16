package com.anuj.learnSpringMVC.todo.controller;

import com.anuj.learnSpringMVC.todo.entity.Todo;
import com.anuj.learnSpringMVC.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = "/todo")
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showTodos(ModelMap map) {
        String userName = getLoggedInUserName();
        List<Todo> todosList = todoService.findByUserName(userName);
        map.addAttribute("todos", todosList);
        return "showTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String addTodo(ModelMap map) {
        map.addAttribute("todo", new Todo(0, getLoggedInUserName(), "", LocalDate.now(), false));
        return "addTodo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String showNewTodo(ModelMap map, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "addTodo";
        }
        todoService.addTodo(getLoggedInUserName(), todo.getDescription(), todo.getTargetDate(), todo.getIsDone());
        return "redirect:/todo/show";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.POST)
    public String deleteTodo(@RequestParam Integer id) {
        todoService.deleteTodoById(id);
        return "redirect:/todo/show";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String updateTodo(ModelMap map, @RequestParam Integer id) {
        map.addAttribute("todo", new Todo(id, getLoggedInUserName(), "", LocalDate.now(), false));
        return "updateTodo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodoRedirect(ModelMap map, @RequestParam Integer id, Todo todo) {
        todoService.updateTodoById(id, todo);
        return "redirect:/todo/show";
    }

    private String getLoggedInUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
