package com.hoteladvisor.aincorp.zk.dao;

import com.hoteladvisor.aincorp.zk.domain.FilialBranch;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

public class FilialBranchDao {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public FilialBranchDao() {
        entityManager = Persistence.createEntityManagerFactory("default").createEntityManager();
    }

    public FilialBranch findById(Integer id) {
        return (FilialBranch) entityManager.createQuery("FROM FilialBranch bc WHERE bc.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    /**
     * save filial branch
     *
     * @param newFilialBranch
     * @return
     * @throws HibernateException
     */
    public FilialBranch save(FilialBranch newFilialBranch) throws HibernateException {
        entityManager.persist(newFilialBranch);
        entityManager.flush();
        return newFilialBranch;
    }

    public List<FilialBranch> findAll() {
        List<FilialBranch> filialBranchList = entityManager.createNativeQuery("SELECT fb FROM FilialBranch fb").getResultList();
        return filialBranchList;
    }
}
