package controller.shoesDAO;

import java.util.List;

import model.shoes.Boot;
import model.shoes.Sandal;
import model.shoes.Sneaker;

public interface ShoesDAO {

	void addShoes();

	void deleteShoes();

	void updateShoes();
	
	public List <Boot> findAllBoot();
	
	public List <Sandal> findAllSandal();
	
	public List <Sneaker> findAllSneaker();
	
	public int checkType(int ID);
	
	public Boot findBootByID(int ID);
	
	public Sandal findSandalByID(int ID);
	
	public Sneaker findSneakerByID(int ID);

}