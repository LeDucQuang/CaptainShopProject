/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.OrderProduct;
import entity.Orders;
import entity.Product;
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
public class OrderProductFacade extends AbstractFacade<OrderProduct> implements OrderProductFacadeLocal {

    @PersistenceContext(unitName = "project-sem4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderProductFacade() {
        super(OrderProduct.class);
    }

    @Override
    public Product findProductById(int id) {
        try {
            Query query = em.createNamedQuery("Product.findByPId");
            query.setParameter("pId", id);
            Product product = (Product) query.getSingleResult();
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
     
    @Override
    public Orders findOrderById( int id ) {
        try {
            Orders order = (Orders)em.createNamedQuery("Orders.findByOId").setParameter("oId", id).getSingleResult();
            return order;
        }catch(NoResultException e) {
            System.out.println("No result for customer details");
        }
        return null;
    }

    @Override
    public OrderProduct getProduct(int quantity, Product p) {
        try {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setQuantity(quantity);
            orderProduct.setPId(p);
            return orderProduct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
