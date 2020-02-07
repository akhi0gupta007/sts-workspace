package com.learn.LearnMockito.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void letsMockListSizeMethod() {
		@SuppressWarnings("rawtypes")
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());		
	}
	
	@Test
	public void letsMockListGetMethod() {
		@SuppressWarnings("rawtypes")
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn(2).thenReturn(3); //anyInt is argument matchers
		assertEquals(2, listMock.get(0));
		assertEquals(3, listMock.get(1));		
	}

	@Test(expected = RuntimeException.class)
	public void letsMockList_throwAnException() {
		@SuppressWarnings("rawtypes")
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException());
		assertEquals(2, listMock.get(0));
	}
}
