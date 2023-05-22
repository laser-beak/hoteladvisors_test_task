package com.hoteladvisor.aincorp.zk.sevices;

import com.hoteladvisor.aincorp.zk.models.Company;
import org.hibernate.HibernateException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CompanyPersistenceBean implements CompanyPersistenceBeanRemote {

    @PersistenceContext(unitName = "EjbComponentDef")
    private EntityManager entityManager;

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
