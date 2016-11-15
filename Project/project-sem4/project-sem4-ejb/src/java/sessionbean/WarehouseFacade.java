/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Warehouse;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Khoi
 */
@Stateless
public class WarehouseFacade extends AbstractFacade<Warehouse> implements WarehouseFacadeLocal {

    @PersistenceContext(unitName = "project-sem4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WarehouseFacade() {
        super(Warehouse.class);
    }

    @Override
    public Warehouse findById(int id) {
        Query query = em.createNamedQuery("Warehouse.findByWId");
        query.setParameter("wId", id);
        Warehouse warehouse = (Warehouse) query.getSingleResult();
        return warehouse;
    }

    @Override
    public boolean findByName(String name) {
        try {
            Query query = em.createNamedQuery("Warehouse.findByWareName");
            query.setParameter("wareName", name);
            Warehouse warehouse = (Warehouse) query.getSingleResult();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean AddWarehouse(String name, String address, Integer status) {
        try {
            Warehouse warehouse = new Warehouse();
            warehouse.setStatus(status);
            warehouse.setWareName(name);
            warehouse.setWareAddress(address);
            em.persist(warehouse);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean EditWarehouse(int id, String name, String address, int status) {
        try {
            Warehouse warehouse = findById(id);
            warehouse.setWareName(name);
            warehouse.setWareAddress(address);
            warehouse.setStatus(status);
            em.merge(warehouse);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        try {
            Warehouse warehouse = findById(id);
            if (warehouse == null) {
                return false;
            } else {
                if (warehouse.getStatus() == 1) {
                    warehouse.setStatus(2);
                } else {
                    warehouse.setStatus(1);
                }
                em.persist(warehouse);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
