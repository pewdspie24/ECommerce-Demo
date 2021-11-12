package controller.bookDAO;

import java.util.List;

import model.book.Book;

public interface bookDAO {

	void insertBook(String title, String author, int years, String publication, float price);

	void deleteBook(int id);

	void updateBook(int id, String title, String author, int years, String publication, float price);

	List<Book> findAllBook();

	public Book findByID(int ID);

}