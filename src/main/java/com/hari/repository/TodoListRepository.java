package com.hari.repository;

import com.hari.model.TodoList;
import com.hari.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoListRepository extends JpaRepository<TodoList,Long> {
    List<TodoList> findByUser(User user);
}
