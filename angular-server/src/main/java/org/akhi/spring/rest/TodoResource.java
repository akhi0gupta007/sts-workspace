package org.akhi.spring.rest;

import java.net.URI;
import java.util.List;

import org.akhi.spring.errors.ResourceNotFoundException;
import org.akhi.spring.model.Todo;
import org.akhi.spring.service.TodoHardCodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TodoResource {

	@Autowired
	private TodoHardCodedService todoService;

	@GetMapping("/users/{userName}/todos")
	public List<Todo> getAllTodos(String userName) {
		return todoService.findAll();

	}

	@GetMapping("/users/{userName}/todos/{id}")
	public Todo getAllTodos(@PathVariable String userName, @PathVariable long id) throws ResourceNotFoundException {
		return todoService.findById(id);

	}

	@DeleteMapping("/users/{userName}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String userName, @PathVariable long id) {
		Todo todo = todoService.deleteById(id);
		if (todo != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/users/{userName}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String userName, @PathVariable long id,
			@RequestBody Todo todo) {
		Todo toDoUpdated = todoService.save(todo);
		return new ResponseEntity<Todo>(toDoUpdated, HttpStatus.OK);

	}

	@PostMapping("/users/{userName}/todos")
	public ResponseEntity<Todo> updateTodo(@PathVariable String userName, @RequestBody Todo todo) {
		Todo createdTodo = todoService.save(todo);
		// Get current resource URL
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

}
