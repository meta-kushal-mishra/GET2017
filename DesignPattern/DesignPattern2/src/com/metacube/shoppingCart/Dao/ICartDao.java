package com.metacube.shoppingCart.Dao;

import com.metacube.shoppingCart.Entity.CartProduct;

public interface ICartDao extends IBaseDao<CartProduct> {
	public void editProductQuantity(int productId, int quantity);
}
