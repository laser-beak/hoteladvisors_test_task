package com.hoteladvisor.aincorp.zk.dao;

import com.hoteladvisor.aincorp.zk.domain.Company;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CompanyDao {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public CompanyDao() {
        entityManager = Persistence.createEntityManagerFactory("default").createEntityManager();
    }

    public Company findById(Integer id) {
        return (Company) entityManager.createQuery("FROM Company c WHERE c.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    /**
     * save company
     *
     * @param newCompany
     * @return
     * @throws HibernateException
     */
    public Company save(Company newCompany) throws HibernateException {
        entityManager.persist(newCompany);
        entityManager.flush();
        return newCompany;
    }

    public List<Company> findAll() {
        List<Company> companyList = entityManager.createNativeQuery("SELECT с FROM Company с").getResultList();
        return companyList;
    }
}
