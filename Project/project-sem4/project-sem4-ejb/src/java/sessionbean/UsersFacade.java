/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Users;
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
public class UsersFacade extends AbstractFacade<Users> implements UsersFacadeLocal {

    @PersistenceContext(unitName = "project-sem4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

    @Override
    public boolean AddUser(String username, String pass, String repass, String role, Warehouse warehouse) {
        if ((findByName(username)) == null) {
            return false;
        } else {
            try {
                Users users = new Users();
                users.setUsername(username);
                if (pass.equals(repass)) {
                    users.setPasswords(pass);
                } else {
                    return false;
                }
                users.setRoles(role);
                users.setWId(warehouse);
                em.persist(users);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Users findById(int id) {
        try {
            Query query = em.createNamedQuery("Users.findByUId");
            query.setParameter("uId", id);
            Users users = (Users) query.getSingleResult();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Users findByName(String name) {
        try {
            Query query = em.createNamedQuery("Users.findByUsername");
            query.setParameter("username", name);
            Users users = (Users) query.getSingleResult();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean EditUser(int id, String roles, Warehouse warehouse) {
        try {
            Users users = findById(id);
            users.setRoles(roles);
            users.setWId(warehouse);
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
            Users users = findById(id);
            if (users == null) {
                return false;
            } else {
                em.remove(users);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean checkLogin(String name, String pass) {
        try {
            Users u = this.findByName(name);           
            if (u != null && u.getPasswords().equals(pass) ) {
                return true;
            } else {
                System.out.println("u null");
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Login Fails!");
        }
        return false;
    }
}
