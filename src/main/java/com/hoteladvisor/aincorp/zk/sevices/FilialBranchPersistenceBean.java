package com.hoteladvisor.aincorp.zk.sevices;

import com.hoteladvisor.aincorp.zk.models.FilialBranch;
import org.hibernate.HibernateException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class FilialBranchPersistenceBean implements FilialBranchPersistenceBeanRemote {

    @PersistenceContext(unitName = "EjbComponentDef")
    private EntityManager entityManager;

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
