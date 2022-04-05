package models;

import java.io.Serializable;

import utils.InvalidIdException;
import utils.Validator;

public class Book implements Serializable{
	private int book_id;
	private String book_name;
	private String book_title;
	private String author;
	private String brief;
	private String publisher;
	private String content;
	private String category;
	
	public Book() {
		super();
	}
	
	public Book(int book_id,String book_name, String book_title, String author, String brief, String publisher, String content,
			String category) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_title = book_title;
		this.author = author;
		this.brief = brief;
		this.publisher = publisher;
		this.content = content;
		this.category = category;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) throws InvalidIdException {
		if(Validator.isExisted(book_id)) {
			this.book_id = book_id;
		}else {
			throw new InvalidIdException("Book Id in invalid");
		}
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", book_title=" + book_title + ", author="
				+ author + ", brief=" + brief + ", publisher=" + publisher + ", content=" + content + ", category="
				+ category + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + book_id;
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
		Book other = (Book) obj;
		if (book_id != other.book_id)
			return false;
		return true;
	}

	
}
