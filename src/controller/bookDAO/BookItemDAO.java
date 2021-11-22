package controller.bookDAO;

import java.util.List;

import model.book.BookItem;

public interface BookItemDAO {

	void addBookItem();

	void deleteBookItem();

	public void updateBookItem(int ID, int numbers);
	
	public List <BookItem> findAllComicsItem();
	
	public List <BookItem> findAllLightNovelItem();
	
	public List <BookItem> findAllMagazineItem();
	
	public BookItem getBookItemByID(int ID);

}