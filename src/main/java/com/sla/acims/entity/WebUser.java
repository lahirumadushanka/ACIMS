/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sla.acims.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Lt APLM
 */
@Entity
@Table(name = "WEBUSER")
public class WebUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String webUserPassword;
    @OneToOne
    Person webUserPerson;

    @Column(unique = true, nullable = false)
    String name;
    String description;
    @ManyToOne
    WebUser creater;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date createdAt;
    boolean retired;
    @ManyToOne
    WebUser retirer;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date retiredAt;
    String retireComments;
    boolean activated;
    @ManyToOne
    WebUser activator;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date activatedAt;
    String activateComments;

    @ManyToOne
    WebUserRole role;

    String telNo;
    String email;
    Boolean needPwReset;

    public Boolean getNeedPwReset() {
        return needPwReset;
    }

    public void setNeedPwReset(Boolean needPwReset) {
        this.needPwReset = needPwReset;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person getWebUserPerson() {
        return webUserPerson;
    }

    public void setWebUserPerson(Person webUserPerson) {
        this.webUserPerson = webUserPerson;
    }

    String primeTheme;
    String defLocale;

    public String getDefLocale() {
        return defLocale;
    }

    public void setDefLocale(String defLocale) {
        this.defLocale = defLocale;
    }

    public String getPrimeTheme() {
        return primeTheme;
    }

    public void setPrimeTheme(String primeTheme) {
        this.primeTheme = primeTheme;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public WebUser getCreater() {
        return creater;
    }

    public void setCreater(WebUser creater) {
        this.creater = creater;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRetireComments() {
        return retireComments;
    }

    public void setRetireComments(String retireComments) {
        this.retireComments = retireComments;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    public Date getRetiredAt() {
        return retiredAt;
    }

    public void setRetiredAt(Date retiredAt) {
        this.retiredAt = retiredAt;
    }

    public WebUser getRetirer() {
        return retirer;
    }

    public void setRetirer(WebUser retirer) {
        this.retirer = retirer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebUserPassword() {
        return webUserPassword;
    }

    public void setWebUserPassword(String webUserPassword) {
        this.webUserPassword = webUserPassword;
    }

    public String getActivateComments() {
        return activateComments;
    }

    public void setActivateComments(String activateComments) {
        this.activateComments = activateComments;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Date getActivatedAt() {
        return activatedAt;
    }

    public void setActivatedAt(Date activatedAt) {
        this.activatedAt = activatedAt;
    }

    public WebUser getActivator() {
        return activator;
    }

    public void setActivator(WebUser activator) {
        this.activator = activator;
    }

    public WebUserRole getRole() {
        return role;
    }

    public void setRole(WebUserRole role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof WebUser)) {
            return false;
        }
        WebUser other = (WebUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
