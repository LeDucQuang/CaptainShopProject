package entity;

import entity.Customer;
import entity.OrderProduct;
import entity.Warehouse;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-11T21:54:45")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, String> orderAddress;
    public static volatile CollectionAttribute<Orders, OrderProduct> orderProductCollection;
    public static volatile SingularAttribute<Orders, Warehouse> wId;
    public static volatile SingularAttribute<Orders, String> orderNote;
    public static volatile SingularAttribute<Orders, String> orderStatus;
    public static volatile SingularAttribute<Orders, String> orderIdentifier;
    public static volatile SingularAttribute<Orders, Integer> oId;
    public static volatile SingularAttribute<Orders, Date> orderDate;
    public static volatile SingularAttribute<Orders, Customer> cId;

}