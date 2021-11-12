package controller.bookDAO;

import java.util.List;

import model.book.Book;

public interface bookDAO {

	void insertBook();

	void deleteBook();

	void updateBook();

	List<Book> findAllBook();

	public Book findComicByID(int ID);
	
	public Book findLNByID(int ID);
	
	public Book findMagazineByID(int ID);

}