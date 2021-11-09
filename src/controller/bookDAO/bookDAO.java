package controller.bookDAO;

import java.util.List;

import model.book.Book;

public interface bookDAO {

	void insertBook();

	void deleteBook();

	void updateBook();

	List<Book> findAllBook();

	public Book findByID(int ID);

}