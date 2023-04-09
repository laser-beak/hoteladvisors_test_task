package com.hoteladvisor.aincorp.zk.service;

import com.hoteladvisor.aincorp.zk.dao.CompanyDao;
import com.hoteladvisor.aincorp.zk.domain.Company;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;

    public CompanyServiceImpl() {
        companyDao = new CompanyDao();
    }

    @Override
    public Company findById(Integer id) {
        return companyDao.findById(id);
    }

    @Override
    public Company save(Company company) {
        return companyDao.save(company);
    }

    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }
}
