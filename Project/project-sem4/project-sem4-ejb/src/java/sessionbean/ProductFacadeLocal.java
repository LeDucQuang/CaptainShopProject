/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Category;
import entity.Product;
import java.util.List;
import javax.ejb.Local;
import javax.servlet.http.Part;

/**
 *
 * @author Khoi
 */
@Local
public interface ProductFacadeLocal {

    void create(Product product);

    void edit(Product product);

    boolean remove(int id);

    Product find(Object id);

    List<Product> findAll();

    List<Product> findRange(int[] range);

    int count();

    Product findById(int id);

    boolean findByName(String name);

    boolean AddProduct(Category category, String proname, String imglink, double price, int quantity, String des);

    boolean EditProduct(int id, Category category, String proname, double price, int quantity, String des);

    List<Product> findByCateId(Category cateId);
    
    List<Product> findLimit( int number );
}
