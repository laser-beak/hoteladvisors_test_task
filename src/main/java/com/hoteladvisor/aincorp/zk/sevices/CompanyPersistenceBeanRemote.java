package com.hoteladvisor.aincorp.zk.sevices;

import com.hoteladvisor.aincorp.zk.models.Company;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CompanyPersistenceBeanRemote {

    Company findById(Integer id);

    Company save(Company company);

    List<Company> findAll();
}
