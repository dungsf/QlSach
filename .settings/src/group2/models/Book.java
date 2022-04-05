package group2.models;

public class Book {
	private int book_id;
	private String book_title;
	private String author;
	private String brief;
	private String publisher;
	private String content;
	private String category;
	private int book_case_id;
	
	public Book() {
		super();
	}
	public Book(int book_id, String book_title, String author, String brief, String publisher, String content,
			String category, int book_case_id) {
		super();
		this.book_id = book_id;
		this.book_title = book_title;
		this.author = author;
		this.brief = brief;
		this.publisher = publisher;
		this.content = content;
		this.category = category;
		this.book_case_id = book_case_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
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
	public int getBook_case_id() {
		return book_case_id;
	}
	public void setBook_case_id(int book_case_id) {
		this.book_case_id = book_case_id;
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
