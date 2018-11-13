package com.ruchitaladha.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	
	static{
		todos.add(new Todo("Web application"));
		todos.add(new Todo("Spring MVC"));
		todos.add(new Todo("Spring rest webservices"));
	}
	
	public List<Todo> retrieveTodos(){
		return todos;
	}
	
	public void addTodo(Todo todo){
		todos.add(todo);
	}
	public void deleteTodo(Todo todo){
		todos.remove(todo);
	}
}
