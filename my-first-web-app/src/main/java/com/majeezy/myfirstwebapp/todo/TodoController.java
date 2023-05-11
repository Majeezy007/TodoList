package com.majeezy.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todosService;
	

	public TodoController(TodoService todosService) {
		super();
		this.todosService = todosService;
	}


	@RequestMapping("todo-list")
	public String todoList(ModelMap model) {
		List<Todo> todos =todosService.findByUsername(getLoggedInUsername());
		model.put("todos", todos);
		return "todoList";
	}


	private String getLoggedInUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		Todo todo = new Todo(0, getLoggedInUsername(), "", LocalDate.now().plusYears(2), false);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors())
			return "addTodo";
		todosService.addTodo(getLoggedInUsername(), todo.getDescription(), todo.getTarget());
	
		return "redirect:todo-list";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todosService.deleteTodo(id);
		
		return "redirect:todo-list";
	}
	@RequestMapping(value ="update-todo", method = RequestMethod.GET)
	public String ShowUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo =todosService.findTodoById(id);
		model.put("todo", todo);
		return "addTodo";
	}
	@RequestMapping(value ="update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors())
			return "addTodo";
		
		int todoId = todo.getId();
		todo.setUsername(getLoggedInUsername());
		todosService.updateTodo(todoId, todo);
		return "redirect:todo-list";
	}
	
}
