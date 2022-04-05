package group2.models;

import java.util.Set;

public interface IBookServices {
	Set<Book> viewListBook();
	void viewBookDetail();
	Book searchBook();
}
