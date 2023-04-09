package com.hoteladvisor.aincorp.zk.service;

import com.hoteladvisor.aincorp.zk.domain.Company;

import java.util.List;

public interface CompanyService {

    Company findById(Integer id);

    Company save(Company company);

    List<Company> findAll();
}
