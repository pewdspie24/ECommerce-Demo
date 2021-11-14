package controller.bookDAO;

import java.util.List;

import model.book.Book;
import model.book.Comics;
import model.book.LightNovel;
import model.book.Magazine;

public interface bookDAO {

	// void insertBook(String title, String author, int years, String publication, float price);

	// void deleteBook(int id);

	// void updateBook(int id, String title, String author, int years, String publication, float price);

	public List <Comics> findAllComics();
	
	public List <LightNovel> findAllLN();
	
	public List <Magazine> findAllMagazine();
	
	public int checkType(int ID);

	public Comics findComicByID(int ID);
	
	public LightNovel findLNByID(int ID);
	
	public Magazine findMagazineByID(int ID);

}