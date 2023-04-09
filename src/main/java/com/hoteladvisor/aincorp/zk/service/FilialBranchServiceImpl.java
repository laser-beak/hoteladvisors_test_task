package com.hoteladvisor.aincorp.zk.service;

import com.hoteladvisor.aincorp.zk.dao.FilialBranchDao;
import com.hoteladvisor.aincorp.zk.domain.FilialBranch;

import java.util.List;

public class FilialBranchServiceImpl implements FilialBranchService {

    private final FilialBranchDao filialBranchDao;

    public FilialBranchServiceImpl() {
        filialBranchDao = new FilialBranchDao();
    }

    @Override
    public FilialBranch findById(Integer id) {
        return filialBranchDao.findById(id);
    }

    @Override
    public FilialBranch save(FilialBranch filialBranch) {
        return filialBranchDao.save(filialBranch);
    }

    @Override
    public List<FilialBranch> findAll() {
        return filialBranchDao.findAll();
    }
}
