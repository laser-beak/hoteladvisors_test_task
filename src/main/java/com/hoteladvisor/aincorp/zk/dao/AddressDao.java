package com.hoteladvisor.aincorp.zk.dao;

import com.hoteladvisor.aincorp.zk.domain.Address;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AddressDao {
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public AddressDao() {
        entityManager = Persistence.createEntityManagerFactory("default").createEntityManager();
    }

    public Address findById(Integer id) {
        return (Address) entityManager.createQuery("FROM Address ad WHERE ad.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    /**
     * rollback is handled in filter.
     *
     * @param newAddress
     * @return
     * @throws HibernateException
     */
    public Address save(Address newAddress) throws HibernateException {
        entityManager.persist(newAddress);
        entityManager.flush();
        return newAddress;
    }

    public List<Address> findAll() {
        List<Address> addressList = entityManager.createQuery("SELECT ad FROM Address ad").getResultList();
        return addressList;
    }
}
