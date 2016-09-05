/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sla.acims.ejb;

import com.sla.acims.bean.util.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import com.sla.acims.entity.Person;
import com.sla.acims.entity.Ration;
import com.sla.acims.entity.WebUser;
import com.sla.acims.facade.PersonFacade;
import com.sla.acims.facade.RetionFacade;
import com.sla.acims.facade.WebUserFacade;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 *
 * @author Lt APLM
 */
@Named("sessionController")
@SessionScoped
public class SessionController implements Serializable {

    @EJB
    private RetionFacade retionFacade;
    private List<Ration> items = null;
    private WebUser loggedUser = null;
    boolean logged = false;
    boolean activated = false;
    private String userName;
    private String password;
    private DirContext dirContext = null;
    @EJB
    WebUserFacade webUserFacade;
    WebUser webUser;
    @EJB
    PersonFacade personFacade;

    public SessionController() {
    }

    public String loginAction() {

        HttpServletRequest request;
        request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Enumeration headerIter = request.getHeaderNames();
        String userAgent = request.getHeader("User-Agent");

        while (headerIter.hasMoreElements()) {
            String headername = (String) headerIter.nextElement();
            System.out.println("headername + : " + request.getHeader(headername));
        }

        String clientAddr = request.getRemoteAddr();
        String clientPc = request.getRemoteHost();
        System.out.println("Client : " + clientPc + " & client address : " + clientAddr + " & Browser : " + userAgent);
        if (login()) {
            JsfUtil.addSuccessMessage("Login Success");
            System.out.println("logged");
            return "";
        } else {
            JsfUtil.addErrorMessage("Login Failure. Please try again");
            System.out.println("Not logged");
            return "";
        }
    }

    private boolean login() {
        if (userName.trim().equals("")) {
            JsfUtil.addErrorMessage("Please enter a username");
            System.out.println("login bool");
            return false;
        } //        if (isFirstVisit()) {
        //            prepareFirstVisit();
        //            return true;
        //        } 
        else {
            return checkUsers();
        }
    }

    private boolean isFirstVisit() {
        return getWebUserFacade().count() <= 0;

    }

    private void prepareFirstVisit() {
        WebUser user = new WebUser();
        Person person = new Person();
        person.setName(userName);
        personFacade.create(person);
        user.setName(HOSecurity.encrypt(userName));
        user.setWebUserPassword(HOSecurity.hash(password));
        user.setWebUserPerson(person);
        user.setActivated(true);
        webUserFacade.create(user);

    }

//    private boolean checkUsers() {
//        String temSQL;
//        temSQL = "SELECT u FROM WebUser u WHERE u.retired = false";
//        List<WebUser> allUsers = getWebUserFacade().findBySQL(temSQL);
//        for (WebUser u : allUsers) {
//            if (HOSecurity.decrypt(u.getName()).equalsIgnoreCase(userName)) {
//                if (HOSecurity.matchPassword(password, u.getWebUserPassword())) {
//                    setLoggedUser(u);
//                    setLogged(Boolean.TRUE);
//                    setActivated(u.isActivated());
//                    JsfUtil.addSuccessMessage("Logged successfully");
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    private void ldapEntry() {
        System.out.println("ldap entry");
        try {
            String url = "ldap://172.16.60.33:389";
            String conntype = "simple";
            String AdminDn = "cn=admin,dc=test,dc=com";
            String password = "abc@123";

            Hashtable<String, String> environment = new Hashtable<>();

            environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            environment.put(Context.PROVIDER_URL, url);
            environment.put(Context.SECURITY_AUTHENTICATION, conntype);
            environment.put(Context.SECURITY_PRINCIPAL, AdminDn);
            environment.put(Context.SECURITY_CREDENTIALS, password);

            dirContext = new InitialDirContext(environment);
            System.out.println("context created");
        } catch (Exception ee) {
        }
    }

    private boolean checkUsers() {
        ldapEntry();
        System.out.println("check users");
        String[] data = new String[2];
        try {
            String searchDn = "uid=" + userName + "," + "ou=onservice,ou=person,dc=test,dc=com";
            // uid=142,ou=alzebra,dc=mathsdep,dc=college,dc=org,dc=in
            System.out.println("searchDn = " + searchDn);
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            NamingEnumeration results2 = dirContext.search(searchDn, "(uid=" + userName + ")", searchControls);

            if (!results2.hasMore()) {
                System.out.println("has no results");
                return false;
            }
            while (results2.hasMore()) {
                System.out.println("while");
                SearchResult sr2 = (SearchResult) results2.next();
                Attributes attrs = sr2.getAttributes();

                Attribute attrId = attrs.get("uid");
                Attribute attrSn = attrs.get("sn");
//                Attribute attrMail = attrs.get("mail");
//                Attribute attrMobile = attrs.get("Mobile");
//                Attribute attrName = attrs.get("givenname");
//                Attribute attrPrslTitle = attrs.get("PersonalTitle");
//                Attribute attrPassword = attrs.get("userPassword");
//                Attribute attrStatus = attrs.get("userstatus");

                data[0] = (String) attrId.get();
                System.out.println("attrId = " + attrId);
                data[1] = (String) attrSn.get();
                System.out.println("attrSn = " + attrSn);
//                data[2] = (String) attrMail.get();
//                data[3] = (String) attrMobile.get();
//                data[4] = (String) attrName.get();
//                data[5] = (String) attrPrslTitle.get();
//                data[6] = (String) attrPassword.get();
//                data[7] = (String) attrStatus.get();

                if (data[0].equals((String) userName)) {
                    System.out.println("if 01");
                    if (data[1].equals((String) password)) {
                        System.out.println("if 02");
//                        setLoggedUser(u);
                        setLogged(Boolean.TRUE);
//                    setActivated(u.isActivated());
                        return true;
                    }
                }
            }
        } catch (Exception exception) {
        }
        return false;
    }

    public void logout() {
        setLoggedUser(null);
        setLogged(false);
        setActivated(false);
    }

    public WebUser getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(WebUser loggedUser) {
        this.loggedUser = loggedUser;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public WebUserFacade getWebUserFacade() {
        return webUserFacade;
    }

    public void setWebUserFacade(WebUserFacade webUserFacade) {
        this.webUserFacade = webUserFacade;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public WebUser getWebUser() {
        return webUser;
    }

    public void setWebUser(WebUser webUser) {
        this.webUser = webUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public RetionFacade getRetionFacade() {
        return retionFacade;
    }

    public void setRetionFacade(RetionFacade retionFacade) {
        this.retionFacade = retionFacade;
    }

    public List<Ration> getItems() {
        return items;
    }

    public void setItems(List<Ration> items) {
        this.items = items;
    }

    public PersonFacade getPersonFacade() {
        return personFacade;
    }

    public void setPersonFacade(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }

    public DirContext getDirContext() {
        return dirContext;
    }

    public void setDirContext(DirContext dirContext) {
        this.dirContext = dirContext;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

}
