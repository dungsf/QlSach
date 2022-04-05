package services.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;

import models.Book;
import models.User;
import utils.Constant;
import utils.File;
import utils.InvalidIdException;
import utils.Validator;

public class AdminServices {
	// create book
	public List<Book> listOfBook;
	ListIterator li = null;
	Scanner sc = new Scanner(System.in);

	public void inputBook() {
		if (File.read(Constant.BOOK_PATH) == null) {
			listOfBook = new ArrayList<Book>();
		} else {
			listOfBook = File.read(Constant.BOOK_PATH);
		}
		String id, author, name, title, brief, publisher, content, category, x;
		Book book;

		int n = 0;

		do {
			System.out.print("Please enter the number:");
			x = sc.next();
			if (Validator.isId(x)) {
				n = Integer.parseInt(x);
			} else {
				System.out.println("Please enter the number!!!");
			}
		} while (!Validator.isId(x));

		for (int i = 0; i < n; i++) {
			if (n > 1) {
				System.out.println("Enter book " + (i + 1) + " : ");
			}
			book = new Book();
			boolean check = true;
			do {
				System.out.print("Enter the id:");
				id = sc.next();
				if (Validator.isId(id)) {
					try {
						book.setBook_id(Integer.parseInt(id));
						check = true;
					} catch (NumberFormatException | InvalidIdException e) {
						System.out.println("ID the invalid");
						check = false;
					}
				} else {
					System.out.println("Please enter the number!!!");
					check = false;
				}
			} while (!check);

			System.out.print("Enter the name: ");
			sc.nextLine();
			name = sc.nextLine();
			book.setBook_name(name);

			System.out.print("Enter the author: ");
			author = sc.nextLine();
			book.setAuthor(author);

			System.out.print("Enter the category:");
			category = sc.nextLine();
			book.setCategory(category);

			System.out.print("Enter the brief:");
			brief = sc.nextLine();
			book.setBrief(brief);

			System.out.print("Enter the title:");
			title = sc.nextLine();
			book.setBook_title(title);

			System.out.print("Enter the publisher:");
			publisher = sc.nextLine();
			book.setPublisher(publisher);

			System.out.print("Enter the content:");
			content = sc.nextLine();
			book.setContent(content);
			try {
				listOfBook.add(book);
			} catch (Exception e) {
				System.out.println("book fail created!");
			}
		}
		if (File.write(Constant.BOOK_PATH, listOfBook)) {
			System.out.println("book successfully created!");
		} else {
			System.out.println("book fail created!");
		}
	}

	public void display() {
		List<Book> listOfBooks = File.read(Constant.BOOK_PATH);
		System.out.println("=============BOOK LIST==============");
		for (Book book : listOfBooks) {
			System.out.println(book.toString());
		}
	}

	// edit book
	public void editBookContent(int id) throws Exception {
		List<Book> listOfBooks = File.read(Constant.BOOK_PATH);
		if (listOfBooks == null) {
			throw new IOException();
		}

		boolean flag = false;
		li = listOfBooks.listIterator();
		while (li.hasNext()) {
			Book book = (Book) li.next();
			if (book.getBook_id() == id) {
				System.out.print("Please enter the new content: ");
				String newContent = sc.nextLine();
				book.setContent(newContent);
				li.set(book);
				flag = true;
			}
		}
		if (flag) {
			File.write(Constant.BOOK_PATH, listOfBooks);
			System.out.println("Book successfully updated!");
		} else {
			System.out.println("Book_id is not exists!");
		}
	}

	public void editBookName(int id) throws Exception {
		List<Book> listOfBooks = File.read(Constant.BOOK_PATH);
		if (listOfBooks == null) {
			throw new IOException();
		}

		boolean flag = false;
		li = listOfBooks.listIterator();
		while (li.hasNext()) {
			Book book = (Book) li.next();
			if (book.getBook_id() == id) {
				System.out.print("Please enter the new book name: ");
				String newName = sc.nextLine();
				book.setBook_name(newName);
				li.set(book);
				flag = true;
			}
		}
		if (flag) {
			File.write(Constant.BOOK_PATH, listOfBooks);
			System.out.println("Book successfully updated!");
		} else {
			System.out.println("Book_id is not exists!");
		}
	}

	public void editBookAthor(int id) throws Exception {
		List<Book> listOfBooks = File.read(Constant.BOOK_PATH);
		if (listOfBooks == null) {
			throw new IOException();
		}

		boolean flag = false;
		li = listOfBooks.listIterator();
		while (li.hasNext()) {
			Book book = (Book) li.next();
			if (book.getBook_id() == id) {
				System.out.print("Please enter the new book author: ");
				String newAuthor = sc.nextLine();
				book.setAuthor(newAuthor);
				li.set(book);
				flag = true;
			}
		}
		if (flag) {
			File.write(Constant.BOOK_PATH, listOfBooks);
			System.out.println("Book successfully updated!");
		} else {
			System.out.println("Book_id is not exists!");
		}
	}

	public void editBookTitle(int id) throws Exception {
		List<Book> listOfBooks = File.read(Constant.BOOK_PATH);
		if (listOfBooks == null) {
			throw new IOException();
		}

		boolean flag = false;
		li = listOfBooks.listIterator();
		while (li.hasNext()) {
			Book book = (Book) li.next();
			if (book.getBook_id() == id) {
				System.out.print("Please enter the new book title: ");
				String newTitle = sc.nextLine();
				book.setBook_title(newTitle);
				li.set(book);
				flag = true;
			}
		}
		if (flag) {
			File.write(Constant.BOOK_PATH, listOfBooks);
			System.out.println("Book successfully updated!");
		} else {
			System.out.println("Book_id is not exists!");
		}
	}

	// remove
	public void remove(int id) throws Exception {
		boolean removed = false;

		List<Book> listOfBooks = File.read(Constant.BOOK_PATH);
		if (listOfBooks == null) {
			throw new IOException();
		}

		Iterator<Book> iterator = listOfBooks.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getBook_id() == id) {
				iterator.remove();
				removed = true;
				break;
			}
		}

		if (removed) {
			try {
				File.write(Constant.BOOK_PATH, listOfBooks);
			} catch (Exception e) {
				throw new Exception();
			}
			System.out.println("Delete successfully!");
		} else {
			System.err.println("Book is not existed!");
		}
	}

	public void changeRole(String id) {
		List<User> listOfUsers = File.read(Constant.USER_PATH);
		ListIterator li = listOfUsers.listIterator();
		boolean check = true, check2 = true;

		do {

			for (User user : listOfUsers) {
				if (user.getId() == Integer.parseInt(id)) {
					System.out.println("--------------INFORMATION-----------------");
					System.out.println(user.toString());
					check = true;
					break;
				} else {

					check = false;
				}
			}
			if (!check) {
				System.err.println("User is not existed!");
				System.err.println("Please enter again: ");
			}
		} while (!check);

		String choise;
		do {
			System.out.println("You want to change role to: ");
			System.out.println("1. User");
			System.out.println("2. Admin");
			do {
				System.out.print("Your choise is: ");
				choise = sc.next();
				if (!Validator.isId(choise)) {
					System.err.println("Please enter the number!");
				}
			} while (!Validator.isId(choise));

			switch (choise) {
			case "1":
				while (li.hasNext()) {
					User user = (User) li.next();
					if (user.getId() == Integer.parseInt(id)) {
						user.setRole(0);
						li.set(user);
						File.write(Constant.USER_PATH, listOfUsers);
						System.out.println("Role successfully updated!");
						check2 = false;
					}
				}
				break;
			case "2":
				while (li.hasNext()) {
					User user = (User) li.next();
					if (user.getId() == Integer.parseInt(id)) {
						user.setRole(1);
						li.set(user);
						File.write(Constant.USER_PATH, listOfUsers);
						System.out.println("Role successfully updated!");
						check2 = false;
					}
				}
				break;
			default:
				System.err.println("Your choice is invalid! Please input another choice.");
				break;
			}
		} while (check2);

	}

}
