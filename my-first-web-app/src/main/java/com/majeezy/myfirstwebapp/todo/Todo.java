package com.majeezy.myfirstwebapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String description;
	private LocalDate target;
	private boolean done;

	public Todo() {
		super();
	}

	public Todo(int id, String username, String description, LocalDate target, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.target = target;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Size(min = 10, message = "You must enter at least 10 characters")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Future(message="must be a future date")
	public LocalDate getTarget() {
		return target;
	}

	public void setTarget(LocalDate target) {
		this.target = target;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", target=" + target
				+ ", done=" + done + "]";
	}

}
