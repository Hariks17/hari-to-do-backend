package com.hari.service;


import com.hari.model.TodoList;
import com.hari.model.User;
import com.hari.repository.TodoListRepository;
import com.hari.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListServiceImpl implements TodoListService{

    private TodoListRepository todoListRepository;
    private UserRepository userRepository;

    @Autowired
    public TodoListServiceImpl(TodoListRepository todoListRepository,UserRepository userRepository){
        this.todoListRepository = todoListRepository;
        this.userRepository = userRepository;
    }



    @Override
    public TodoList addTodo(TodoList todoList, String useremail) {

        User user1 = userRepository.findByUseremail(useremail);

        todoList.setUser(user1);

        return todoListRepository.save(todoList);
    }



    @Override
    public TodoList updateToto(TodoList todoList,String useremail) {
        return null;
    }

    @Override
    public void deleteTodo(Long id) {



    }
}
