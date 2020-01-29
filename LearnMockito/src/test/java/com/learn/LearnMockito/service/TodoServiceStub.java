package com.learn.LearnMockito.service;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {

	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn to dance","Learn Spring","Learn Spring boot");
	}

	public void deleteTodo(String todo) {

	}

}
