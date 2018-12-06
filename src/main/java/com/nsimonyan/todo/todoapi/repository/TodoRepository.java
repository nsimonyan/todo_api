package com.nsimonyan.todo.todoapi.repository;

import com.nsimonyan.todo.todoapi.model.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository  extends CrudRepository<Todo, Integer> {
    List<Todo> findByIsDoneFalse();
    @Query("select count(id) from Todo where isDone=true")
    Integer countDoneTodos();
}
