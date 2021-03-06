package org.akhi.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.akhi.spring.errors.ResourceNotFoundException;
import org.akhi.spring.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int idCounter = 0;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	static {
		todos.add(new Todo(++idCounter, "akhilesh", "Learn Angular", new Date(), false));
		todos.add(new Todo(++idCounter, "akhilesh", "Learn Java 8", new Date(), false));
		todos.add(new Todo(++idCounter, "akhilesh", "Learn Microservice", new Date(), false));
		todos.add(new Todo(++idCounter, "akhilesh", "Learn Guitar", new Date(), false));
		todos.add(new Todo(++idCounter, "akhilesh", "Learn React", new Date(), false));
		todos.add(new Todo(++idCounter, "akhilesh", "Learn Hiking", new Date(), false));
	
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo deleteById(long id) {
		logger.info(":::::::::::::::::::DELETE REQUEST::::::::::::" + id);
		logger.info(":::::::::::::::::::DELETE REQUEST::::::::::::" + todos);
		Todo todo = null;
		try {
			todo = findById(id);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return todos.remove(todo) ? todo : null;

	}

	public Todo save(Todo todo) {
		if (todo.getId() == -1) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

	public Todo findById(long id) throws ResourceNotFoundException {
		Optional<Todo> todo = todos.stream().filter(todo1 -> todo1.getId() == id).findFirst();
		if (todo.isPresent())
			return todo.get();
		else
			 throw new ResourceNotFoundException();
	}
}
