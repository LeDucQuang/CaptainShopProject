/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Khoi
 */
@Entity
@Table(name = "warehouse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warehouse.findAll", query = "SELECT w FROM Warehouse w"),
    @NamedQuery(name = "Warehouse.findByWId", query = "SELECT w FROM Warehouse w WHERE w.wId = :wId"),
    @NamedQuery(name = "Warehouse.findByWareName", query = "SELECT w FROM Warehouse w WHERE w.wareName = :wareName"),
    @NamedQuery(name = "Warehouse.findByWareAddress", query = "SELECT w FROM Warehouse w WHERE w.wareAddress = :wareAddress"),
    @NamedQuery(name = "Warehouse.findByStatus", query = "SELECT w FROM Warehouse w WHERE w.status = :status")})
public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "W_ID")
    private Integer wId;
    @Size(max = 100)
    @Column(name = "WARE_NAME")
    private String wareName;
    @Size(max = 100)
    @Column(name = "WARE_ADDRESS")
    private String wareAddress;
    @Column(name = "STATUS")
    private Integer status;
    @OneToMany(mappedBy = "wId")
    private Collection<Orders> ordersCollection;
    @OneToMany(mappedBy = "wId")
    private Collection<Users> usersCollection;

    public Warehouse() {
    }

    public Warehouse(Integer wId) {
        this.wId = wId;
    }

    public Integer getWId() {
        return wId;
    }

    public void setWId(Integer wId) {
        this.wId = wId;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public String getWareAddress() {
        return wareAddress;
    }

    public void setWareAddress(String wareAddress) {
        this.wareAddress = wareAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wId != null ? wId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warehouse)) {
            return false;
        }
        Warehouse other = (Warehouse) object;
        if ((this.wId == null && other.wId != null) || (this.wId != null && !this.wId.equals(other.wId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Warehouse[ wId=" + wId + " ]";
    }
    
}
