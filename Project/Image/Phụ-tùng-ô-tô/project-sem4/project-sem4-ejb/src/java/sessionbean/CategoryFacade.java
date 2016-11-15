/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Category;
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
public class CategoryFacade extends AbstractFacade<Category> implements CategoryFacadeLocal {

    @PersistenceContext(unitName = "project-sem4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }

    @Override
    public Category findById(int id) {
        try {
            Query query = em.createNamedQuery("Category.findByCateId");
            query.setParameter("cateId", id);
            Category category = (Category) query.getSingleResult();
            return category;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Category findByName(String name) {
        try {
            Query query = em.createNamedQuery("Category.findByCategoryName");
            query.setParameter("categoryName", name);
            Category category = (Category) query.getSingleResult();
            return category;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Category> findCategoryByBrand(String brand) {
        try {
            List<Category> listCategory = em.createNamedQuery("Category.findByBrand").setParameter("brand", brand).getResultList();
            return listCategory;
        } catch (NoResultException e) {
            System.out.println("No result for list category");
        }
        return null;
    }
}
