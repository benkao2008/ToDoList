package com.tts.ToDoList.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.ToDoList.model.*;
import com.tts.ToDoList.repository.TaskPostRepository;

@Controller
public class TaskController {
	
	@Autowired
	private TaskPostRepository taskPostRepository;
	
	
	@GetMapping(value = "/")
	public String index(TaskPost taskPost, Model model) {
		model.addAttribute("tasks", taskPostRepository.findAll());
		return "index";
	}
	
	@GetMapping(value = "/task_posts/new")
    public String newTask (TaskPost taskPost) {
        return "new";
		
    }
	
	private TaskPost taskPost;
	@PostMapping(value = "/task_posts/new")
	public String addNewTask(TaskPost taskPost, Model model) {
		taskPostRepository.save(taskPost);
		model.addAttribute("title", taskPost.getTaskTitle());
		model.addAttribute("owner", taskPost.getTaskOwner());
		model.addAttribute("taskDetail", taskPost.getTaskDetail());
		return "result"; 
	}
	
	@GetMapping(value = "/task_posts/edit/{id}")
	public String editTask(Model model, @PathVariable Long id) {
		TaskPost post = taskPostRepository.findById(id).orElse(null);
		model.addAttribute("posts", post);
		return "edit";
	}
	
	@PutMapping(value = "/task_posts/edit/{id}")
	public String editWithId(@PathVariable Long id, TaskPost taskPost, Model model) {
		TaskPost post = taskPostRepository.findById(id).orElse(null);
		post.setTaskTitle(taskPost.getTaskTitle());
		post.setTaskOwner(taskPost.getTaskOwner());
		post.setTaskDetail(taskPost.getTaskDetail());
		
		taskPostRepository.save(post);
		
		model.addAttribute("title", post.getTaskTitle());
		model.addAttribute("owner", post.getTaskOwner());
		model.addAttribute("taskDetail", post.getTaskDetail());
		
		return "result";
	}
	
	@RequestMapping(value = "/task_posts/{id}", method =  RequestMethod.DELETE)
	public String deleteWithId(@PathVariable Long id, TaskPost taskPost) {
		
		taskPostRepository.deleteById(id);
		
		return "delete";
	}
	

	
		
	
}
