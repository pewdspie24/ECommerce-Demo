package controller.cartDAO;

import model.cart.Cart;

public interface cartDAO {
	
	public void createCart(Cart cart);
	
	public void updateCart(Cart cart, float price);

	public Cart findCart(int ID);
	
	public boolean deleteCart(int id);
}