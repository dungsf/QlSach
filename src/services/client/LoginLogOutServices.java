package services.client;

import java.util.List;

import models.User;
import utils.Constant;
import utils.File;

public class LoginLogOutServices {
	
	//Check user/admin
	public int checkRole(String name, String pass) {
		List<User> listOfUsers = File.read(Constant.USER_PATH);
		int role = -1;
		for(User user : listOfUsers) {
			if(name.equals(user.getUser_name()) & pass.equals(user.getPassword())) {
				role = user.getRole();
			}
		}
		return role;
	}

}
