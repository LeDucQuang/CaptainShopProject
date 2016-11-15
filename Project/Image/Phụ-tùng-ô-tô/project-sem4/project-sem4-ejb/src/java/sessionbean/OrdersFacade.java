/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Orders;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Khoi
 */
@Stateless
public class OrdersFacade extends AbstractFacade<Orders> implements OrdersFacadeLocal {
    @PersistenceContext(unitName = "project-sem4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public List<Orders> findAll() {
        return em.createNamedQuery("Orders.findAll").getResultList();
    }
    
    @Override
    public List<Orders> findLimit() {
        return em.createNamedQuery("Orders.findAll").setMaxResults(50).getResultList();
    }
    
    @Override
    public Orders findById( int id ) {
        try {
            Orders order = (Orders)em.createNamedQuery("Orders.findByOId").setParameter("oId", id).getSingleResult();
            return order;
        }catch(NoResultException e) {
            System.out.println("No result for customer details");
        }
        return null;
    }
        @Override
    public List<Orders> findByCustomerId(int CusId) {
        try {
            List<Orders> listProduct = em.createNamedQuery("Orders.findbyCusId").setParameter("cId", CusId).getResultList();
            return listProduct;
        }catch(NoResultException e) {
            System.out.println("No result for list order");
        }
        return null;
    }
    @Override
    public void edit( Orders order ) {
        em.merge(order);
    }
 
    @Override
    public void AddOrder(Orders order) {
        try {
            em.persist(order);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
   
    }
    public OrdersFacade() {
        super(Orders.class);
    }
    
}
