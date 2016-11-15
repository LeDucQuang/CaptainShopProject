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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Khoi
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p ORDER BY p.pId DESC"),
    @NamedQuery(name = "Product.findByPId", query = "SELECT p FROM Product p WHERE p.pId = :pId"),
    @NamedQuery(name = "Product.findByCateId", query = "SELECT p FROM Product p WHERE p.cateId = :cateId"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findByImageLink", query = "SELECT p FROM Product p WHERE p.imageLink = :imageLink"),
    @NamedQuery(name = "Product.findByProductPrice", query = "SELECT p FROM Product p WHERE p.productPrice = :productPrice"),
    @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByStatus", query = "SELECT p FROM Product p WHERE p.status = :status")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "P_ID")
    private Integer pId;
    @Size(max = 200)
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Size(max = 300)
    @Column(name = "IMAGE_LINK")
    private String imageLink;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCT_PRICE")
    private double productPrice;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Size(max = 300)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS")
    private Integer status;
    @JoinColumn(name = "CATE_ID", referencedColumnName = "CATE_ID")
    @ManyToOne
    private Category cateId;
    @OneToMany(mappedBy = "pId")
    private Collection<OrderProduct> orderProductCollection;

    public Product() {
    }

    public Product(Integer pId) {
        this.pId = pId;
    }

    public Product(Integer pId, double productPrice) {
        this.pId = pId;
        this.productPrice = productPrice;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Category getCateId() {
        return cateId;
    }

    public void setCateId(Category cateId) {
        this.cateId = cateId;
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
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ pId=" + pId + " ]";
    }
    
}
