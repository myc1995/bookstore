package com.rupeng.bookstore.service;

import java.util.List;

import com.rupeng.bookstore.dao.AddressDao;
import com.rupeng.bookstore.entity.Address;

public class AddressService
{
    private AddressDao addressDao = new AddressDao();

    public List<Address> findAddressById(int userId)
    {
        try
        {
            return addressDao.list(userId);
        }
        catch (Exception e)
        {
            throw new RuntimeException();
        }
    }

}
