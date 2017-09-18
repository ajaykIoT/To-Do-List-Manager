package com.todolist.model;

import java.io.Serializable;

/**
 * @author ajay_kumar
 *
 */

public class Task implements Serializable {

	private static final long serialVersionUID = -7858133705308993477L;
	
	int taskIndex;
	String taskDescription;
	String taskStatus;
	String taskDate;



	public Task() {
		// required for adding new record on the TaskForm page

	}

	/**
	 * @param taskDescription
	 * @param taskStatus
	 */


	public Task(String taskDescription, String taskStatus, String taskDate) {
		this.taskDescription = taskDescription;
		this.taskStatus = taskStatus;
		this.taskDate = taskDate;
	}

	public int getTaskIndex() {
		return taskIndex;
	}

	/**
	 * @param taskIndex
	*/
	public void setTaskIndex(int taskIndex) {
		this.taskIndex = taskIndex;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	/**
	 * @param taskDescription
	*/
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	/**
	 * @param taskStatus
	*/
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskDate() {
		return taskDate;
	}

	/**
	 * @param task_date
	*/
	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Task [taskIndex=" + taskIndex + ", taskDescription=" + taskDescription + ", taskStatus=" + taskStatus
				+ ", taskDate=" + taskDate + "]";
	}

	
}