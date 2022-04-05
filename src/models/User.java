package models;

import java.io.Serializable;

import jdk.jshell.spi.ExecutionControl.UserException;
import utils.InvalidIdException;
import utils.UsernameException;
import utils.Validator;

public class User implements Serializable {
	private int id;
	private String user_name;
	private String password;
	private int role;
	
	public User() {
		super();
	}
	public User(int id, String user_name, String password, int role) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) throws UsernameException {
		if(Validator.isExistedUsername(user_name)) {
			this.user_name = user_name;
		}else {
			throw new UsernameException("User name in invalid");
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
