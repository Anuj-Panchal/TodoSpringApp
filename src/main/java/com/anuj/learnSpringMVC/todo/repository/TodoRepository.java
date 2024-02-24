package com.anuj.learnSpringMVC.todo.repository;

import com.anuj.learnSpringMVC.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {

    Optional<TodoEntity> findById(Integer id);

    List<TodoEntity> findByUserName(String userName);
}
