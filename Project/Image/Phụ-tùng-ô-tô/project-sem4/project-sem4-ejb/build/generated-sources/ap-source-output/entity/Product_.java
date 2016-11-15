package entity;

import entity.Category;
import entity.OrderProduct;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-05T12:26:25")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> imageLink;
    public static volatile CollectionAttribute<Product, OrderProduct> orderProductCollection;
    public static volatile SingularAttribute<Product, Integer> quantity;
    public static volatile SingularAttribute<Product, Category> cateId;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Integer> pId;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, Double> productPrice;

}