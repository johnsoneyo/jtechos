/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johnson3yo
 */
@Entity
@Table(name = "contact_us")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactUs.findAll", query = "SELECT c FROM ContactUs c"),
    @NamedQuery(name = "ContactUs.findByContactId", query = "SELECT c FROM ContactUs c WHERE c.contactId = :contactId"),
    @NamedQuery(name = "ContactUs.findByContactOrgName", query = "SELECT c FROM ContactUs c WHERE c.contactOrgName = :contactOrgName"),
    @NamedQuery(name = "ContactUs.findByContactMessage", query = "SELECT c FROM ContactUs c WHERE c.contactMessage = :contactMessage"),
    @NamedQuery(name = "ContactUs.findByTimeCreated", query = "SELECT c FROM ContactUs c WHERE c.timeCreated = :timeCreated")})
public class ContactUs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    @Column(name = "contact_id")
    private Integer contactId;
    @Size(max = 32)
    @Column(name = "contact_org_name")
    private String contactOrgName;
    @Size(max = 256)
    @Column(name = "contact_message")
    private String contactMessage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeCreated;

    public ContactUs() {
    }

    public ContactUs(Integer contactId) {
        this.contactId = contactId;
    }

    public ContactUs(Integer contactId, Date timeCreated) {
        this.contactId = contactId;
        this.timeCreated = timeCreated;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getContactOrgName() {
        return contactOrgName;
    }

    public void setContactOrgName(String contactOrgName) {
        this.contactOrgName = contactOrgName;
    }

    public String getContactMessage() {
        return contactMessage;
    }

    public void setContactMessage(String contactMessage) {
        this.contactMessage = contactMessage;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactUs)) {
            return false;
        }
        ContactUs other = (ContactUs) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ContactUs[ contactId=" + contactId + " ]";
    }
    
}
