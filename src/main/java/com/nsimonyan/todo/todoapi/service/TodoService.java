package com.nsimonyan.todo.todoapi.service;

import com.nsimonyan.todo.todoapi.model.Todo;
import com.nsimonyan.todo.todoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getNotDoneTodos(){
        return todoRepository.findByIsDoneFalse();
    }
    public Integer countDoneTodos(){
        return todoRepository.countDoneTodos();
    }

    public List<Todo> getAllTodos(){
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todo -> todos.add(todo));
        return todos;
    }

    public Optional<Todo> getTodo(Integer id){
        return todoRepository.findById(id);
    }

    public void  deleteTodo(Integer id){
        todoRepository.deleteById(id);
    }

    public void saveTodo(Todo todo){
        todoRepository.save(todo);
    }

    public void saveOrUpdateTodo(Todo todo, Integer id){
       if(id !=null){
           Optional<Todo> todoFromDb = todoRepository.findById(id);
            if(todoFromDb.isPresent()) {
                if(todo.isDone() != null)todoFromDb.get().setDone(todo.isDone());
                if(todo.getName() != null)todoFromDb.get().setName(todo.getName());
            }
       }
        saveTodo(todo);
    }

    public void updateTodo(Todo todo, Integer id){
        Optional<Todo> todoFromDb = todoRepository.findById(id);
        if(todoFromDb.get() != null) {
            todoFromDb.get().setDone(todo.isDone());
            todoFromDb.get().setName(todo.getName());
            saveTodo(todo);
        }
    }
}
