package entity;

import entity.Orders;
import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-05T12:26:26")
@StaticMetamodel(OrderProduct.class)
public class OrderProduct_ { 

    public static volatile SingularAttribute<OrderProduct, Integer> quantity;
    public static volatile SingularAttribute<OrderProduct, Product> pId;
    public static volatile SingularAttribute<OrderProduct, Integer> orderProductId;
    public static volatile SingularAttribute<OrderProduct, Orders> oId;

}