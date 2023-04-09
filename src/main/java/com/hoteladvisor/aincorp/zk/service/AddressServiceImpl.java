package com.hoteladvisor.aincorp.zk.service;

import com.hoteladvisor.aincorp.zk.dao.AddressDao;
import com.hoteladvisor.aincorp.zk.domain.Address;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao;

    public AddressServiceImpl() {
        addressDao = new AddressDao();
    }

    @Override
    public Address findById(Integer id) {
        return addressDao.findById(id);
    }

    @Override
    public Address save(Address address) {
        return addressDao.save(address);
    }

    @Override
    public List<Address> findAll() {
        return addressDao.findAll();
    }
}
