package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.Book;
import models.User;

public class Validator {
	private static final String VALID_NUMBER = "^\\d{1,}$";
	private static final String VALID_PASS = "^\\w{6,}$";
	
	private static Set<Integer> ids = new HashSet<Integer>();
	private static Set<String> userNames = new HashSet<String>();
	public static boolean isId(String id) {
		Pattern pattern = Pattern.compile(VALID_NUMBER);
		Matcher matcher = pattern.matcher(id);
		return matcher.matches();
	}
	public static boolean isPass(String pass) {
		Pattern pattern = Pattern.compile(VALID_PASS);
		Matcher matcher = pattern.matcher(pass);
		return matcher.matches();
	}
	public static boolean isExisted(int id) {
		if(File.read(Constant.BOOK_PATH) != null) {
			List<Book> listOfBooks = File.read(Constant.BOOK_PATH);
			for(Book book : listOfBooks) {
				ids.add(book.getBook_id());
			}
		}
		if((!ids.contains(id))) {
			ids.add(id);
			return true;
		}else {
			return false;
		}
	}
	public static Set<Integer> getIds() {
		return ids;
	}
	
	public static boolean isExistedUsername(String name) {
		if(File.read(Constant.USER_PATH) != null) {
			List<User> listOfUsers = File.read(Constant.USER_PATH);
			for(User user : listOfUsers) {
				userNames.add(user.getUser_name());
			}
		}
		if((!userNames.contains(name))) {
			userNames.add(name);
			return true;
		}else {
			return false;
		}
	}
	public static Set<String> getUserName() {
		return userNames;
	}
}
