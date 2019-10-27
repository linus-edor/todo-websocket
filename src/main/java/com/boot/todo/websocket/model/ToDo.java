package com.boot.todo.websocket.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class ToDo {
	@NotNull
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	@NotNull
	@NotBlank
	private String description;
	private Timestamp created;
	private Timestamp modified;
	private boolean completed;

	public ToDo() {
		this.id = UUID.randomUUID().toString();
		this.created = new Timestamp(System.currentTimeMillis());
		this.modified = new Timestamp(System.currentTimeMillis());
	}

	public ToDo(String description) {
		this();
		this.description = description;
	}
}