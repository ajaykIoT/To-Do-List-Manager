package com.todolist.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.todolist.model.Task;

/**
 * @author ajay_kumar
 *
 */
public class TaskDaoImpl implements TaskDao {

	public static final String SELECT_ALL = "SELECT * FROM tasks order by task_date desc;";
	public static final String SELECT_BY_INDEX = "SELECT * FROM tasks WHERE task_index = :taskIndex;";
	public static final String UPDATE_BY_INDEX = "UPDATE tasks SET task_description = :taskDescription, task_status = :taskStatus, task_date = :taskDate WHERE task_index = :taskIndex;";
	public static final String INSERT_VALUES = "INSERT INTO tasks (task_description, task_status, task_date) VALUES (:taskDescription, :taskStatus, :taskDate);";
	public static final String DELETE_BY_INDEX = "DELETE FROM tasks WHERE task_index = :taskIndex;";

	private NamedParameterJdbcTemplate jdbcTemplate;

	public TaskDaoImpl(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Task> selectAll() {
		return jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<Task>(Task.class));
	}

	@Override
	public Task selectTask(final SqlParameterSource paramSource) {
		return jdbcTemplate.queryForObject(SELECT_BY_INDEX, paramSource, new RowMapper<Task> () {
			@Override  
		    public Task mapRow(ResultSet rs, int rownumber) throws SQLException {  
		        Task task = new Task();  
		        task.setTaskIndex(rs.getInt(1));  
		        task.setTaskDescription(rs.getString(2));  
		        task.setTaskStatus(rs.getString(3));  
		        task.setTaskDate(rs.getString(4));  
		        return task;
		        }
			});
		}
	

	@Override
	public void deleteTask(final SqlParameterSource paramSource) {
		jdbcTemplate.update(DELETE_BY_INDEX, paramSource);
	}

	@Override
	public void saveOrUpdateTask(final Task task) {
		String sql = task.getTaskIndex() > 0 ? UPDATE_BY_INDEX : INSERT_VALUES;
		jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(task));
	}
}