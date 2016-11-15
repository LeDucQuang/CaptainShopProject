/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.OrderProduct;
import entity.Orders;
import entity.Product;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khoi
 */
@Local
public interface OrderProductFacadeLocal {

    void create(OrderProduct orderProduct);

    void edit(OrderProduct orderProduct);

    void remove(OrderProduct orderProduct);

    OrderProduct find(Object id);

    List<OrderProduct> findAll();
    
    List<OrderProduct> findLimit( int number );

    List<OrderProduct> findRange(int[] range);

    Product findProductById(int id);

    Orders findOrderById(int id);

    OrderProduct getProduct(int quantity, Product p);

    int count();

}
