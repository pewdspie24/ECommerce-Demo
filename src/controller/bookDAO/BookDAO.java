package controller.bookDAO;

import java.util.List;

import model.book.Comics;
import model.book.LightNovel;
import model.book.Magazine;

public interface BookDAO {

	// void insertBook(String title, String author, int years, String publication, float price);

	// void deleteBook(int id);

	// void updateBook(int id, String title, String author, int years, String publication, float price);

	public List <Comics> findAllComics();
	
	public List <LightNovel> findAllLightNovel();
	
	public List <Magazine> findAllMagazine();
	
	public int checkType(int ID);

	public Comics findComicByID(int ID);
	
	public LightNovel findLightNovelByID(int ID);
	
	public Magazine findMagazineByID(int ID);

}
