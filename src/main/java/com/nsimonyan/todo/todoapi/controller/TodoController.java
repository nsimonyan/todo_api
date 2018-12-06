package com.nsimonyan.todo.todoapi.controller;

import com.nsimonyan.todo.todoapi.model.Todo;
import com.nsimonyan.todo.todoapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoController extends BaseController{

    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    private List<Todo> getAllTodos() {
       return todoService.getAllTodos();
    }

    @GetMapping("/todos/done_count")
    private Integer countDoneTodos() {
        return todoService.countDoneTodos();
    }

    @GetMapping("/todos/not_done")
    private List<Todo> getNotDoneTodos(){
        return todoService.getNotDoneTodos();
    }

    @GetMapping("/todos/{id}")
    private ResponseEntity<Todo> getTodo(@PathVariable("id") Integer id) {
        return ResponseEntity.of(todoService.getTodo(id));
    }

    @DeleteMapping("/todos/delete/{id}")
    private ResponseEntity<String> deleteTodo(@PathVariable("id") Integer id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().body("Deleted successfully");
    }

    @PostMapping("/todos/create")
    private ResponseEntity<String> saveTodo(@RequestBody Todo todo) {
        todoService.saveTodo(todo);
        return ResponseEntity.ok().body("Created successfully");
    }

    @PutMapping(value = {"/todos/update", "/todos/update/{id}"})
    public ResponseEntity<String> updateOrCreateTodo(@RequestBody Todo todo, @PathVariable(required = false) Integer id) {
        todoService.saveOrUpdateTodo(todo, id);
        return ResponseEntity.ok().body("Updated or Created successfully");
    }

    @PatchMapping("/todos/update/{id}")
    public ResponseEntity updateTodo(@RequestBody Todo todo, @PathVariable Integer id) {
        todoService.updateTodo(todo, id);
        return ResponseEntity.ok().body("Updated successfully");
    }}
