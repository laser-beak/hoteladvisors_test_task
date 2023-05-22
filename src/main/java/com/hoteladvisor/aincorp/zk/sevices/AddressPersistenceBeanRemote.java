package com.hoteladvisor.aincorp.zk.sevices;

import com.hoteladvisor.aincorp.zk.models.Address;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface AddressPersistenceBeanRemote {
    Address findById(Integer id);

    Address save(Address address);

    List<Address> findAll();
}
