package com.sla.acims.entity;

import com.sla.acims.entity.WebUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-09T08:53:24")
@StaticMetamodel(WebTheme.class)
public class WebTheme_ { 

    public static volatile SingularAttribute<WebTheme, Date> createdAt;
    public static volatile SingularAttribute<WebTheme, WebUser> retirer;
    public static volatile SingularAttribute<WebTheme, String> retireComments;
    public static volatile SingularAttribute<WebTheme, String> name;
    public static volatile SingularAttribute<WebTheme, WebUser> creater;
    public static volatile SingularAttribute<WebTheme, String> description;
    public static volatile SingularAttribute<WebTheme, Date> retiredAt;
    public static volatile SingularAttribute<WebTheme, Boolean> retired;
    public static volatile SingularAttribute<WebTheme, Long> id;

}