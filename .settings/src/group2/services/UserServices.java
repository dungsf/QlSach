package group2.services;

import java.util.Set;

import group2.models.Book;
import group2.models.IBookCaseServices;
import group2.models.IBookServices;

public class UserServices implements IBookServices, IBookCaseServices{

	@Override
	public Set<Book> viewListBook() {
		return null;
	}

	@Override
	public void viewBookDetail() {
		
	}

	@Override
	public Book searchBook() {
		return null;
	}

	@Override
	public void viewBookCase() {
		
	}

	@Override
	public boolean editBookCase() {
		return false;
	}

}
