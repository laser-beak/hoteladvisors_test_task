package com.hoteladvisor.aincorp.zk.service;

import com.hoteladvisor.aincorp.zk.domain.Address;

import java.util.List;

public interface AddressService {
    Address findById(Integer id);

    Address save(Address address);

    List<Address> findAll();
}
