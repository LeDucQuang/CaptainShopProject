/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Khoi
 */
@Entity
@Table(name = "order_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderProduct.findAll", query = "SELECT o FROM OrderProduct o"),
    @NamedQuery(name = "OrderProduct.findByOrderProductId", query = "SELECT o FROM OrderProduct o WHERE o.orderProductId = :orderProductId"),
    @NamedQuery(name = "OrderProduct.findByQuantity", query = "SELECT o FROM OrderProduct o WHERE o.quantity = :quantity")})
public class OrderProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDER_PRODUCT_ID")
    private Integer orderProductId;
    @Column(name = "QUANTITY")
    private Integer quantity=0;
    @JoinColumn(name = "O_ID", referencedColumnName = "O_ID")
    @ManyToOne
    private Orders oId;
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    @ManyToOne
    private Product pId;

//    public OrderProduct(Product product, int quantity, Orders orders) {
//        this.pId = product;
//        this.oId = orders;
//        this.quantity = quantity;
//    }
    public OrderProduct() {

    }

    public OrderProduct(Integer orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Integer getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Integer orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {

        this.quantity += quantity;
    }

    public Orders getOId() {
        return oId;
    }

    public void setOId(Orders oId) {
        this.oId = oId;
    }

    public Product getPId() {
        return pId;
    }

    public void setPId(Product pId) {
        this.pId = pId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderProductId != null ? orderProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderProduct)) {
            return false;
        }
        OrderProduct other = (OrderProduct) object;
        if ((this.orderProductId == null && other.orderProductId != null) || (this.orderProductId != null && !this.orderProductId.equals(other.orderProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderProduct[ orderProductId=" + orderProductId + " ]";
    }

}
