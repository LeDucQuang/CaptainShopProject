package entity;

import entity.Orders;
import entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-11T21:54:45")
@StaticMetamodel(Warehouse.class)
public class Warehouse_ { 

    public static volatile SingularAttribute<Warehouse, Integer> wId;
    public static volatile SingularAttribute<Warehouse, String> wareAddress;
    public static volatile CollectionAttribute<Warehouse, Orders> ordersCollection;
    public static volatile SingularAttribute<Warehouse, String> wareName;
    public static volatile CollectionAttribute<Warehouse, Users> usersCollection;
    public static volatile SingularAttribute<Warehouse, Integer> status;

}