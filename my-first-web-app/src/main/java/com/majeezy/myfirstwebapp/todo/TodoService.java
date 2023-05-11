package com.majeezy.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int count = 0;
	
	static {
		todos.add(new Todo(++count,"Majeezy", "Learn Spring Boot", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++count,"Majeezy", "Learn Spring Security", LocalDate.now().plusMonths(6), false));
		todos.add(new Todo(++count,"Majeezy", "Learn Aws", LocalDate.now().plusMonths(2), false));
	}
	
	public List<Todo> findByUsername(String username){
		return todos.stream()
				.filter(todo->todo.getUsername().equalsIgnoreCase(username))
				.toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate) {
		todos.add(new Todo(++count, username, description, targetDate, false));
	}
	
	public int findIndexOfTodoById(int id) {
		for(int i = 0; i < todos.size(); i++) {
			if(todos.get(i).getId() == id)
				return i;
		}
		return -1;
	}
	
	public Todo findTodoById(int id) {
		return todos.stream().filter(todo-> todo.getId()==id).findFirst().get();
//		if(todoNotFound(id))
//			return null;
//		return todos.get(findIndexOfTodoById(id));
	}
	
	public void deleteTodo(int id) {
		if(todoNotFound(id))
			return;
		
		todos.remove(findIndexOfTodoById(id));
	}
	
	public void updateTodo(int id, Todo todo) {
		int todoIndex = findIndexOfTodoById(id);
		deleteTodo(id);
		todos.add(todoIndex, todo);
	}
	
	public boolean todoNotFound(int id) {
		return findIndexOfTodoById(id) == -1;
	}
}
