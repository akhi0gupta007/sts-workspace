package org.akhi.spring.model;

import java.util.Date;

public class Todo {

	private long id = -1;
	private String userName;
	private String description;
	private Date targetDate;

	private boolean isDone;

	public Todo(long id, String userName, String description, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.userName = userName;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public Todo() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public long getId() {
		return id;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public String getUserName() {
		return userName;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
