package com.tts.ToDoList.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskPost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String taskTitle;
	private String taskOwner;
	private String taskDetail;
	
	public TaskPost(Long id, String taskTitle, String taskOwner, String taskDetail) {
		super();
		this.id = id;
		this.taskTitle = taskTitle;
		this.taskOwner = taskOwner;
		this.taskDetail = taskDetail;
	}
	
	public TaskPost() {
		
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskOwner() {
		return taskOwner;
	}

	public void setTaskOwner(String taskOwner) {
		this.taskOwner = taskOwner;
	}

	public String getTaskDetail() {
		return taskDetail;
	}

	public void setTaskDetail(String taskDetail) {
		this.taskDetail = taskDetail;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "List [id=" + id + ", taskTitle=" + taskTitle + ", taskOwner=" + taskOwner + ", taskDetail=" + taskDetail
				+ "]";
	}

}
