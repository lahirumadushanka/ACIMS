package com.sla.acims.entity;

import com.sla.acims.entity.WebUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-05T12:41:08")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, Date> dateOfDead;
    public static volatile SingularAttribute<Person, String> address;
    public static volatile SingularAttribute<Person, WebUser> retirer;
    public static volatile SingularAttribute<Person, String> initials;
    public static volatile SingularAttribute<Person, String> givenName;
    public static volatile SingularAttribute<Person, String> retireComments;
    public static volatile SingularAttribute<Person, String> description;
    public static volatile SingularAttribute<Person, String> nic;
    public static volatile SingularAttribute<Person, String> title;
    public static volatile SingularAttribute<Person, Date> createdAt;
    public static volatile SingularAttribute<Person, String> surname;
    public static volatile SingularAttribute<Person, Date> dob;
    public static volatile SingularAttribute<Person, String> familyName;
    public static volatile SingularAttribute<Person, String> name;
    public static volatile SingularAttribute<Person, WebUser> creater;
    public static volatile SingularAttribute<Person, Date> retiredAt;
    public static volatile SingularAttribute<Person, String> otherName;
    public static volatile SingularAttribute<Person, Boolean> retired;
    public static volatile SingularAttribute<Person, Long> id;
    public static volatile SingularAttribute<Person, String> designation;
    public static volatile SingularAttribute<Person, Integer> ageInWeek;
    public static volatile SingularAttribute<Person, Integer> age;

}