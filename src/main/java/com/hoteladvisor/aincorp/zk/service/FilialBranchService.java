package com.hoteladvisor.aincorp.zk.service;

import com.hoteladvisor.aincorp.zk.domain.FilialBranch;

import java.util.List;

public interface FilialBranchService {

    FilialBranch findById(Integer id);

    FilialBranch save(FilialBranch filialBranch);

    public List<FilialBranch> findAll();
}
