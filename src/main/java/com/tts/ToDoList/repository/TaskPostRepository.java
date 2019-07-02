package com.tts.ToDoList.repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.ToDoList.model.TaskPost;

public interface TaskPostRepository extends CrudRepository<TaskPost, Long> {

}
