/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Users;
import entity.Warehouse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khoi
 */
@Local
public interface UsersFacadeLocal {

    void create(Users users);

    void edit(Users users);

    boolean remove(int id);

    Users find(Object id);

    List<Users> findAll();

    List<Users> findRange(int[] range);

    int count();

    boolean AddUser(String username, String pass, String repass, String role, Warehouse warehouse);

    boolean EditUser(int id, String roles, Warehouse warehouse);

    Users findById(int id);

    Users findByName(String name);

    boolean checkLogin(String email, String pass);
}
