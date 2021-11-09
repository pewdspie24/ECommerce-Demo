package controller.bookitemDAO;

import java.util.List;

import model.bookitem.Bookitem;

public interface bookitemDAO {
	
	public void insertBookItem(Bookitem bki);
	
	public void updateBookItem(Bookitem bki, int numbers);
	
	public boolean deleteBookitem(int id);
	
	public List <Bookitem> findAllBookitem(int customerID);
	
	public boolean checkItem(int cartID, int bookID);
	
	public int getNum(int cartID, int bookID);
}
