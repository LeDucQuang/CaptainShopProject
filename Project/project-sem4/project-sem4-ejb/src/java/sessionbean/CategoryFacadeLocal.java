/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Category;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khoi
 */
@Local
public interface CategoryFacadeLocal {

    void create(Category category);

    void edit(Category category);

    void remove(Category category);

    Category find(Object id);

    List<Category> findAll();

    List<Category> findRange(int[] range);

    int count();

    Category findById(int id);

    Category findByName(String name);

    List<Category> findCategoryByBrand(String brand);

}
