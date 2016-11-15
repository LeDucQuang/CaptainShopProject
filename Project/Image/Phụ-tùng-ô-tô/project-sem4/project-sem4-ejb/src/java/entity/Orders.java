/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Khoi
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByOId", query = "SELECT o FROM Orders o WHERE o.oId = :oId"),
    @NamedQuery(name = "Orders.findByOrderIdentifier", query = "SELECT o FROM Orders o WHERE o.orderIdentifier = :orderIdentifier"),
    @NamedQuery(name = "Orders.findByOrderAddress", query = "SELECT o FROM Orders o WHERE o.orderAddress = :orderAddress"),
    @NamedQuery(name = "Orders.findByOrderDate", query = "SELECT o FROM Orders o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Orders.findByOrderStatus", query = "SELECT o FROM Orders o WHERE o.orderStatus = :orderStatus"),
    @NamedQuery(name = "Orders.findByOrderNote", query = "SELECT o FROM Orders o WHERE o.orderNote = :orderNote")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "O_ID")
    private Integer oId;
    @Size(max = 100)
    @Column(name = "ORDER_IDENTIFIER")
    private String orderIdentifier;
    @Size(max = 100)
    @Column(name = "ORDER_ADDRESS")
    private String orderAddress;
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Size(max = 20)
    @Column(name = "ORDER_STATUS")
    private String orderStatus;
    @Size(max = 200)
    @Column(name = "ORDER_NOTE")
    private String orderNote;
    @Column(name = "ORDER_FEE")
    private Double orderFee;
    @JoinColumn(name = "C_ID", referencedColumnName = "C_ID")
    @ManyToOne
    private Customer cId;
    @JoinColumn(name = "W_ID", referencedColumnName = "W_ID")
    @ManyToOne
    private Warehouse wId;
    @OneToMany(mappedBy = "oId")
    private Collection<OrderProduct> orderProductCollection;

    public Orders() {
        
    }

    public Double getOrderFee() {
        return orderFee;
    }

    public void setOrderFee(Double orderFee) {
        this.orderFee = orderFee;
    }
    
    
    
    public int getProductQuantity() {
        return this.orderProductCollection.size();
    }
    
    public Orders(List<OrderProduct> listorderProduct){
        this.orderProductCollection = listorderProduct;
    }


    public double getOrdersFee() {
        double fee = 0;
        for (OrderProduct orderProduct : this.orderProductCollection) {
            fee = fee + (orderProduct.getPId().getProductPrice() * orderProduct.getQuantity());
        }
        return fee;
    }

    public Orders(Integer oId) {
        this.oId = oId;
    }

    public Integer getOId() {
        return oId;
    }

    public void setOId(Integer oId) {
        this.oId = oId;
    }

    public String getOrderIdentifier() {
        return orderIdentifier;
    }

    public void setOrderIdentifier(String orderIdentifier) {
        this.orderIdentifier = orderIdentifier;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }

    public Customer getCId() {
        return cId;
    }

    public void setCId(Customer cId) {
        this.cId = cId;
    }

    public Warehouse getWId() {
        return wId;
    }

    public void setWId(Warehouse wId) {
        this.wId = wId;
    }

    @XmlTransient
    public Collection<OrderProduct> getOrderProductCollection() {
        return orderProductCollection;
    }

    public void setOrderProductCollection(Collection<OrderProduct> orderProductCollection) {
        this.orderProductCollection = orderProductCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oId != null ? oId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.oId == null && other.oId != null) || (this.oId != null && !this.oId.equals(other.oId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orders[ oId=" + oId + " ]";
    }

}
