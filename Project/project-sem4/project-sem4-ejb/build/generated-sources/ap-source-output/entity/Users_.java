package entity;

import entity.Warehouse;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-11T21:54:45")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Integer> uId;
    public static volatile SingularAttribute<Users, Warehouse> wId;
    public static volatile SingularAttribute<Users, String> passwords;
    public static volatile SingularAttribute<Users, String> roles;
    public static volatile SingularAttribute<Users, String> username;

}