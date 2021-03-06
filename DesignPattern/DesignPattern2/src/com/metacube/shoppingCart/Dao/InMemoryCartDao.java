package com.metacube.shoppingCart.Dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingCart.Entity.BaseEntity;
import com.metacube.shoppingCart.Entity.CartProduct;

public class InMemoryCartDao implements ICartDao {
	private static InMemoryCartDao cartDao;
	private static Map<Integer, BaseEntity> cartItems;
	private InMemoryCartDao() {
		cartItems = new HashMap<Integer, BaseEntity>();
	}

	public static InMemoryCartDao getInstance(){
		if (cartDao == null) {
			synchronized (InMemoryProductStoreDao.class) {
				if (cartDao == null) 
					cartDao = new InMemoryCartDao();
			}
		}

		return cartDao;
	}

	
	public void resetCartList() {
		cartItems = new HashMap<Integer, BaseEntity>();
	}

	/**
	 * Add product to cartItems HashMap
	 * 
	 * @param productID
	 * @param product
	 *            - CartProduct Object
	 */
	public void add(int productID, BaseEntity product) {
		cartItems.put(productID, (CartProduct) product);
	}

	/**
	 * Remove product from cart
	 * 
	 * @param productId
	 */
	public void remove(int productId) {
		cartItems.remove(productId);
	}

	/**
	 * edit product quantity in Cart
	 * 
	 * @param productId
	 * @param quantity
	 *            - product quantity
	 */
	public void editProductQuantity(int productId, int quantity) {
		((CartProduct) cartItems.get(productId)).setQuantity(quantity);
	}

	/**
	 * Return the Map of CartItems
	 */
	public Map<Integer, BaseEntity> getList() {
		return cartItems;
	}
}
