/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Warehouse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khoi
 */
@Local
public interface WarehouseFacadeLocal {

    void create(Warehouse warehouse);

    void edit(Warehouse warehouse);

    boolean remove(int id);

    Warehouse find(Object id);

    List<Warehouse> findAll();

    List<Warehouse> findRange(int[] range);

    int count();

    Warehouse findById(int id);

    boolean findByName(String name);

    boolean AddWarehouse(String name, String address, Integer status);

    boolean EditWarehouse(int id, String name, String address);
}
