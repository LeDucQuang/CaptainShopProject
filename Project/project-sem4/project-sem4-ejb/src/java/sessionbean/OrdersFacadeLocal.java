/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Orders;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khoi
 */
@Local
public interface OrdersFacadeLocal {

    void create(Orders orders);

    void edit(Orders orders);

    void remove(Orders orders);

    Orders find(Object id);

    List<Orders> findAll();

    List<Orders> findLimit( int number );

    Orders findById(int id);

    List<Orders> findRange(int[] range);

    int count();

    List<Orders> findByCustomerId(int CusId);

    void AddOrder(Orders order);
    Orders createAndReturn( Orders orders );
}
