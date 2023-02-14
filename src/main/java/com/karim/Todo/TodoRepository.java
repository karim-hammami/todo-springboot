package com.karim.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component("todoRepository")
public interface TodoRepository extends JpaRepository<Todo, Integer> {


}
