package com.hoteladvisor.aincorp.zk.sevices;

import com.hoteladvisor.aincorp.zk.models.Address;
import org.hibernate.HibernateException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AddressPersistenceBean implements AddressPersistenceBeanRemote {
    @PersistenceContext(unitName = "EjbComponentDef")
    private EntityManager entityManager;

    public Address findById(Integer id) {
        return (Address) entityManager.createQuery("FROM Address ad WHERE ad.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    /**
     * save address
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
