package com.hari.service;

import com.hari.model.TodoList;

public interface TodoListService {

    TodoList addTodo(TodoList todoList,String useremail);
    TodoList updateToto(TodoList todoList,String useremail);
    void deleteTodo(Long id);

}
