package com.boot.todo.websocket.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.boot.todo.websocket.config.ToDoProperties;
import com.boot.todo.websocket.model.ToDo;

@Component
@RepositoryEventHandler(ToDo.class)
public class ToDoEventHandler {
	private Logger log = LoggerFactory.getLogger(ToDoEventHandler.class);
	private SimpMessagingTemplate simpMessagingTemplate;
	private ToDoProperties toDoProperties;

	public ToDoEventHandler(SimpMessagingTemplate simpMessagingTemplate, ToDoProperties toDoProperties) {
		this.simpMessagingTemplate = simpMessagingTemplate;
		this.toDoProperties = toDoProperties;
	}

	@HandleAfterCreate
	public void handleToDoSave(ToDo toDo) {
		this.simpMessagingTemplate.convertAndSend(this.toDoProperties.getBroker() + "/new", toDo);
		log.info(">> Sending Message to WS: ws://todo/new - " + toDo);
	}
}