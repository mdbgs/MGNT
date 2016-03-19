package BeanPackage;

import java.util.ArrayList;
import java.util.List;

import ModelPackage.User;

public class UserBean {
	//
	// FIELDS
	//
	private List<User> userList = new ArrayList<User>();
 	//
	// GETTER & SETTER
	//
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public List<User> getUserList() {
		return userList;
	}
}
