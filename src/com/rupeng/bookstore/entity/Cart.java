package com.rupeng.bookstore.entity;

import java.util.List;

public class Cart
{
    private List<CartItem> cartItemList;

    public List<CartItem> getCartItemList()
    {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList)
    {
        this.cartItemList = cartItemList;
    }
}
