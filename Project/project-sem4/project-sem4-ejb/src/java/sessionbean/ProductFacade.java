/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Category;
import entity.Product;
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
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {

    @PersistenceContext(unitName = "project-sem4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }

    @Override
    public Product findById(int id) {
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
    public boolean findByName(String name) {
        try {
            Query query = em.createNamedQuery("Product.findByProductName");
            query.setParameter("productName", name);
            Product product = (Product) query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Product> findByCateId(Category cateId) {
        try {
            return em.createNamedQuery("Product.findByCateId").setParameter("cateId", cateId).getResultList();
        } catch (NoResultException e) {
            e.printStackTrace();
            System.out.println("No result for list product");
        }
        return null;
    }

    @Override
    public boolean AddProduct(Category category, String proname, String imglink, double price, int quantity, String des) {
        

        Product product = new Product();
        product.setCateId(category);
        product.setProductName(proname);
        product.setImageLink(imglink);
        product.setProductPrice(price);
        product.setQuantity(quantity);
        product.setDescription(des);
        product.setStatus(1);
        em.persist(product);
        return true;

    }

    @Override
    public boolean EditProduct(int id, Category category, String proname, double price, int quantity, String des) {
        try {
            Product product = findById(id);
            product.setCateId(category);
            product.setProductName(proname);
            product.setProductPrice(price);
            product.setQuantity(quantity);
            product.setDescription(des);
            em.merge(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public List<Product> findLimit( int number ) {
        return em.createNamedQuery("Product.findAll").setMaxResults( number ).getResultList();
    }

    @Override
    public boolean remove(int id) {
        try {
            Product product = findById(id);
            if (product == null) {
                return false;
            } else {
                em.remove(product);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
