package com.hoteladvisor.aincorp.zk.sevices;

import com.hoteladvisor.aincorp.zk.models.FilialBranch;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface FilialBranchPersistenceBeanRemote {

    FilialBranch findById(Integer id);

    FilialBranch save(FilialBranch filialBranch);

    public List<FilialBranch> findAll();
}
