package services.client;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;

import models.Book;
import models.BookCase;
import models.User;
import utils.Constant;
import utils.File;
import utils.InvalidIdException;
import utils.UsernameException;
import utils.Validator;

public class UserServices {

	List<User> listOfUser = new ArrayList<User>();
	List<BookCase> listBookCase1 = new ArrayList<>();
	User user;

	public void addBookCase(int UserID) {
		if (File.read(Constant.BOOKCASE_PATH) != null) {
			listBookCase1 = File.read(Constant.BOOKCASE_PATH);
		}
		Set<Book> listBook = new HashSet<>();
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		BookCase bookcase = new BookCase(UserID, "bookcase_"+UserID,date, listBook);
		listBookCase1.add(bookcase);
		if(!File.write(Constant.BOOKCASE_PATH, listBookCase1)) {
			System.out.println("Add BookCase Error");
		}
	}
	// Add user- role mặc định của user = 0, admin = 1
	public void addUser() {
		if (File.read(Constant.USER_PATH) == null) {

			// add user
			user = new User();
			user.setId(1);
			try {
				user.setUser_name("user");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setPassword("user");
			user.setRole(0);
			listOfUser.add(user);
			
			// add admin
			user = new User();
			user.setId(2);
			try {
				user.setUser_name("admin");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setPassword("admin");
			user.setRole(1);
			listOfUser.add(user);
			
			File.write(Constant.USER_PATH, listOfUser);
			addBookCase(1);
		}
	}

	public void register() {
		if (File.read(Constant.USER_PATH) != null) {
			listOfUser = File.read(Constant.USER_PATH);
		}
		user = new User();
		String name, pass;
		Scanner sc = new Scanner(System.in);
		user.setId((listOfUser.size() + 1));
		boolean check = true;
		do {
			
			System.out.print("Enter user name: ");
			name = sc.next();
			try {
				user.setUser_name(name);
				check = true;
			} catch (UsernameException e) {
				System.err.println("User name is existed!");
				System.err.println("Please enter again: ");
				check = false;
			}
		}while(!check);
		do {
			System.out.print("Enter user password: ");
			pass = sc.next();
			if(Validator.isPass(pass)) {
				user.setPassword(pass);
			}else {
				System.err.println("Password length must be greater than 6");
			}
			
		}while(!Validator.isPass(pass));
		

		user.setRole(0);
		listOfUser.add(user);

		if(File.write(Constant.USER_PATH, listOfUser)) {
			System.out.println("Register successfully");
			addBookCase(user.getId());
		}else {
			System.out.println("Register error");
		}
	}

	public void display() {
		List<User> listOfUsers = File.read(Constant.USER_PATH);
		System.out.println("=============BOOK LIST==============");
		for (User user : listOfUsers) {
			System.out.println(user.toString());
		}
	}
	
	public int getIdLogin(String name) {
		List<User> listOfUsers = File.read(Constant.USER_PATH);
		int id = -1;
		for(User user : listOfUsers) {
			if(name.equals(user.getUser_name())) {
				id = user.getId();
			}
		}
		return id;
	}
	
	public void changePassword(int id) {
		List<User> listOfUsers = File.read(Constant.USER_PATH);
		String newPass;
		ListIterator li = listOfUsers.listIterator();
		while(li.hasNext()) {
			User user = (User)li.next();
			if(user.getId()==id) {
				do {
					System.out.print("Please enter the new password: ");
					newPass = new Scanner(System.in).nextLine();
					if(Validator.isPass(newPass)) {
						user.setPassword(newPass);
					}else {
						System.err.println("Password length must be greater than 6");
					}
				}while(!Validator.isPass(newPass));
				
				
				li.set(user);
				File.write(Constant.USER_PATH, listOfUsers);
				System.out.println("Password successfully updated!");
			}
		}
		
	}
}
