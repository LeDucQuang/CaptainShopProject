package entity;

import entity.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-11T21:54:45")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> customerAddress;
    public static volatile SingularAttribute<Customer, Double> balances;
    public static volatile SingularAttribute<Customer, String> passport;
    public static volatile SingularAttribute<Customer, String> passwords;
    public static volatile SingularAttribute<Customer, Integer> rate;
    public static volatile SingularAttribute<Customer, String> phonenumber;
    public static volatile CollectionAttribute<Customer, Orders> ordersCollection;
    public static volatile SingularAttribute<Customer, String> customerName;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, Integer> cId;
    public static volatile SingularAttribute<Customer, Integer> status;

}