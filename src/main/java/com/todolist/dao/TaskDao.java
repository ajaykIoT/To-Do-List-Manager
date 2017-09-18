package com.todolist.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.todolist.model.Task;

/**
 * @author ajay_kumar
 *
 */
public interface TaskDao {
	
	public List<Task> selectAll();

	public Task selectTask(final SqlParameterSource paramSource);

	public void deleteTask(final SqlParameterSource paramSource);
	
	public void saveOrUpdateTask(final Task task);
}
