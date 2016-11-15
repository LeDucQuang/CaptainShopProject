/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Khoi
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {

    @PersistenceContext(unitName = "project-sem4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Customer> findAll() {
        return em.createNamedQuery("Customer.findAll").getResultList();
    }

    @Override
    public List<Customer> findLimit() {
        return em.createNamedQuery("Customer.findAll").setMaxResults(50).getResultList();
    }

    @Override
    public Customer findById(int id) {
        try {
            Customer cus = (Customer) em.createNamedQuery("Customer.findByCId").setParameter("cId", id).getSingleResult();
            return cus;
        } catch (NoResultException e) {
            System.out.println("No result for customer details");
        }
        return null;
    }

    @Override
    public Customer findByEmail(String email) {
        try {
            Customer cus = (Customer) em.createNamedQuery("Customer.findByEmail").setParameter("email", email).getSingleResult();
            return cus;
        } catch (NoResultException e) {
            System.out.println("No result for customer details");
        }
        return null;
    }

    @Override
    public void edit(Customer customer) {
        em.merge(customer);
    }

    @Override
    public boolean remove(int id) {
        Customer cus = this.findById(id);
        if (cus == null) {
            return false;
        } else {
            if (cus.getStatus() == 1) {
                cus.setStatus(2);
            } else {
                cus.setStatus(1);
            }
            em.persist(cus);
        }
        return true;
    }

    @Override
    public boolean checkLogin(String email, String pass) {
        try {
            Customer cus = findByEmail(email);
            if (cus != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Login Fails!");
        }
        return false;
    }

    @Override
    public boolean AddCustomer(String name, String email, String pass, String repass) {
        try {
            Customer customer = findByEmail(email);
            if( customer == null )
                throw new Exception("test");
            System.out.println("This customer Email already exists!");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            Customer customer = new Customer();
            customer.setCustomerName(name);
            customer.setEmail(email);
            customer.setStatus(1);
            customer.setRate(0);
            if (!(pass.equals(repass))) {
                return false;
            }
            customer.setPasswords(pass);
            em.persist(customer);
        }
        return true;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

}
