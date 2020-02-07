package com.learn.LearnMockito.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.learn.LearnMockito.service.TodoService;
import com.learn.LearnMockito.service.TodoServiceStub;

public class ToDoBusinessImplStubTest {

	@Test
	public void test() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

}
