package com.sla.acims.entity;

import com.sla.acims.entity.WebUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-09T08:53:24")
@StaticMetamodel(WebUserRole.class)
public class WebUserRole_ { 

    public static volatile SingularAttribute<WebUserRole, WebUser> retirer;
    public static volatile SingularAttribute<WebUserRole, String> retireComments;
    public static volatile SingularAttribute<WebUserRole, Date> activatedAt;
    public static volatile SingularAttribute<WebUserRole, String> description;
    public static volatile SingularAttribute<WebUserRole, Date> createdAt;
    public static volatile SingularAttribute<WebUserRole, String> name;
    public static volatile SingularAttribute<WebUserRole, WebUser> creater;
    public static volatile SingularAttribute<WebUserRole, String> activateComments;
    public static volatile SingularAttribute<WebUserRole, Date> retiredAt;
    public static volatile SingularAttribute<WebUserRole, Boolean> retired;
    public static volatile SingularAttribute<WebUserRole, Long> id;
    public static volatile SingularAttribute<WebUserRole, WebUser> activator;
    public static volatile SingularAttribute<WebUserRole, Boolean> activated;

}