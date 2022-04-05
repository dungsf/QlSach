package group2.models;

import java.util.Date;
import java.util.Set;

public class BookCase {
	private int book_case_id;
	private String book_case_name;
	private Date create_date;
	private Set<Book> listBook;
	
	public BookCase() {
		super();
	}
	public BookCase(int book_case_id, String book_case_name, Date create_date, Set<Book> listBook) {
		super();
		this.book_case_id = book_case_id;
		this.book_case_name = book_case_name;
		this.create_date = create_date;
		this.listBook = listBook;
	}
	public int getBook_case_id() {
		return book_case_id;
	}
	public void setBook_case_id(int book_case_id) {
		this.book_case_id = book_case_id;
	}
	public String getBook_case_name() {
		return book_case_name;
	}
	public void setBook_case_name(String book_case_name) {
		this.book_case_name = book_case_name;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Set<Book> getListBook() {
		return listBook;
	}
	public void setListBook(Set<Book> listBook) {
		this.listBook = listBook;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + book_case_id;
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
		BookCase other = (BookCase) obj;
		if (book_case_id != other.book_case_id)
			return false;
		return true;
	}
}
