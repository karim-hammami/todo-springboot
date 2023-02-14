package com.karim.Todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TodoApplication {

    @Autowired
    final TodoRepository todoRepository; 

    public TodoApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @GetMapping("/")
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    record NewTodoRequest(
            String title,
            String desc,
            String status) {
        
    }

    @PostMapping("/todo")
    public void addTodo(@RequestBody NewTodoRequest request) {
        Todo todo = new Todo();
        todo.setTitle(request.title());
        todo.setDesc(request.desc());
        todo.setStatus(request.status());
        todoRepository.save(todo);
    }

}
