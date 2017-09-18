package com.todolist.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.todolist.dao.TaskDao;
import com.todolist.model.Task;

@Controller
public class HomeController {
	
	public static final String TASK_INDEX = "taskIndex";

	@Autowired
	private TaskDao taskDao;

	@RequestMapping(value = "/")
	public ModelAndView listTasks(ModelAndView model) throws IOException {
		model.addObject("listTasks", taskDao.selectAll());
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/editTask", method = RequestMethod.GET)
	public ModelAndView editTask(HttpServletRequest request) {
		Long taskIndex = Long.valueOf(request.getParameter("id"));
		Task task = taskDao.selectTask(new MapSqlParameterSource(TASK_INDEX, taskIndex));
		ModelAndView model = new ModelAndView("TaskForm");
		model.addObject("task", task);
		return model;
	}

	@RequestMapping(value = "/deleteTask", method = RequestMethod.GET)
	public ModelAndView deleteTask(HttpServletRequest request) {
		Long taskIndex = Long.valueOf(request.getParameter("id"));
		taskDao.deleteTask(new MapSqlParameterSource(TASK_INDEX, taskIndex));
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/newTask", method = RequestMethod.GET)
	public ModelAndView newTask(ModelAndView model) {
		model.addObject("task", new Task());
		model.setViewName("TaskForm");
		return model;
	}

	@RequestMapping(value = "/saveTask", method = RequestMethod.POST)
	public ModelAndView saveTask(@ModelAttribute Task task) {
		taskDao.saveOrUpdateTask(task);
		return new ModelAndView("redirect:/");
	}
}
