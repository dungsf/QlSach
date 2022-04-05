package services.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Book;
import utils.Validator;

public class BookServices {
	static List<Book> listBook = new ArrayList<>();

	// View list book
	public static void viewListBook() {
		// data test
		if ((utils.File.read(utils.Constant.BOOK_PATH)) == null) {
			System.out.println("There is not any book in application");
		} else {

			listBook = utils.File.read(utils.Constant.BOOK_PATH);

			System.out.printf("%-10s|%-15s|%-20s|%-15s|%-15s|%-18s|%s\n", "ID", "Name", "Title", "Author", "Brief",
					"Publisher", "Category");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------");
			for (Book book : listBook) {
				System.out.printf("%-10s|%-15s|%-20s|%-15s|%-15s|%-18s|%s\n", book.getBook_id(), book.getBook_name(),
						book.getBook_title(), book.getAuthor(), book.getBrief(), book.getPublisher(),
						book.getCategory());
			}
		}
	}

	// Search book

	// Read book
	public static void readBook() {
		Scanner scanner = new Scanner(System.in);

		try {
			boolean check = false;
			String bookID;

			do {
				System.out.println("Enter book id: ");
				bookID = scanner.next();

				if (!Validator.isId(bookID)) {
					System.err.println("Please enter the number!");
				} else {
					Integer.parseInt(bookID);
				}

			} while (!Validator.isId(bookID));
			listBook = utils.File.read(utils.Constant.BOOK_PATH);
			if (listBook.isEmpty()) {
				throw new IOException();
			} else {
				try {

					for (int i = 0; i < listBook.size(); i++) {

						if (listBook.get(i).getBook_id() == Integer.parseInt(bookID)) {
							System.out.println(listBook.get(i).getBook_name());
							System.out.println(listBook.get(i).getContent());
							check = true;
						}

					}

					if (check != true) {
						throw new NullPointerException();
					}

				} catch (NullPointerException e) {
					System.out.println("This book does not exist!");
				}

			}
		} catch (IOException e) {
			System.out.println("No Data!");
		}

	}

	public static void searchBook(int choice) {
		Scanner scanner = new Scanner(System.in);
		listBook = utils.File.read(utils.Constant.BOOK_PATH);
		if (listBook == null) {
			System.out.println("There is not any book in application");
		} else {

			switch (choice) {
			case 1:
				System.out.print("Please enter book's name : ");
				String name = scanner.nextLine();
				int count = 0;
				for (Book book : listBook) {
					if (book.getBook_name().equalsIgnoreCase(name))
						count++;
				}
				System.out.println("About " + count + " results:");
				System.out.printf("%-10s|%-15s|%-20s|%-15s|%-15s|%-18s|%s\n", "ID", "Name", "Title", "Author", "Brief",
						"Publisher", "Category");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------");
				for (Book book : listBook) {
					if (book.getBook_name().equalsIgnoreCase(name))
						System.out.printf("%-10s|%-15s|%-20s|%-15s|%-15s|%-18s|%s\n", book.getBook_id(),
								book.getBook_name(), book.getBook_title(), book.getAuthor(), book.getBrief(),
								book.getPublisher(), book.getCategory());
				}
				System.out.println("Enter 0 to back to the menu");
				if (scanner.nextInt() == 0)
					break;
			case 2:
				System.out.println("Please enter book's author : ");
				String author = scanner.nextLine();
				count = 0;
				for (Book book : listBook) {
					if (book.getAuthor().equalsIgnoreCase(author))
						count++;
				}
				System.out.println("About " + count + " results:");

				System.out.printf("%-10s|%-15s|%-20s|%-15s|%-15s|%-18s|%s\n", "ID", "Name", "Title", "Author", "Brief",
						"Publisher", "Category");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------");
				for (Book book : listBook) {
					if (book.getAuthor().equalsIgnoreCase(author))
						System.out.printf("%-10s|%-15s|%-20s|%-15s|%-15s|%-18s|%s\n", book.getBook_id(),
								book.getBook_name(), book.getBook_title(), book.getAuthor(), book.getBrief(),
								book.getPublisher(), book.getCategory());
				}
				System.out.println("Enter 0 to back to the menu");
				if (scanner.nextInt() == 0)
					break;
			case 3:
				System.out.println("Please enter book's category : ");
				String category = scanner.nextLine();
				count = 0;
				for (Book book : listBook) {
					if (book.getCategory().equalsIgnoreCase(category))
						count++;
				}
				System.out.println("About " + count + " results:");
				System.out.printf("%-10s|%-15s|%-20s|%-15s|%-15s|%-18s|%s\n", "ID", "Name", "Title", "Author", "Brief",
						"Publisher", "Category");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------");
				for (Book book : listBook) {
					if (book.getCategory().equalsIgnoreCase(category))
						System.out.printf("%-10s|%-15s|%-20s|%-15s|%-15s|%-18s|%s\n", book.getBook_id(),
								book.getBook_name(), book.getBook_title(), book.getAuthor(), book.getBrief(),
								book.getPublisher(), book.getCategory());
				}
				System.out.println("Enter 0 to back to the menu");
				if (scanner.nextInt() == 0)
					break;
			default:
				break;
			}

		}

	}

	public boolean checkBookId(int id) {
		listBook = utils.File.read(utils.Constant.BOOK_PATH);
		boolean flag = false;
		for (Book book : listBook) {
			if (book.getBook_id() == id) {
				return true;
			}
		}
		return flag;
	}
}
