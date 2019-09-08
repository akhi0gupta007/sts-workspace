package org.akhi.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo deleteById(long id) {
		logger.info(":::::::::::::::::::DELETE REQUEST::::::::::::"+id);
		logger.info(":::::::::::::::::::DELETE REQUEST::::::::::::"+todos);
		Todo todo = findById(id);
		return todos.remove(todo) ? todo : null;

	}

	public Todo findById(long id) {
		return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
	}
}
