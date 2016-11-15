/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Customer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khoi
 */
@Local
public interface CustomerFacadeLocal {

    void create(Customer customer);

    void edit(Customer customer);

    boolean remove(int id);

    Customer find(Object id);

    List<Customer> findAll();

    List<Customer> findLimit();

    List<Customer> findRange(int[] range);

    Customer findById(int id);

    int count();

    boolean checkLogin(String email, String pass);

    Customer findByEmail(String email);

    boolean AddCustomer(String name, String email, String pass, String repass);
}
