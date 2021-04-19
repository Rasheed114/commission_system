/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commission_system.objects;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@Entity
@Table(name = "BILL_PRODUCT_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillProductDetails.findAll", query = "SELECT b FROM BillProductDetails b")
    , @NamedQuery(name = "BillProductDetails.findById", query = "SELECT b FROM BillProductDetails b WHERE b.id = :id")
    , @NamedQuery(name = "BillProductDetails.findByBillId", query = "SELECT b FROM BillProductDetails b WHERE b.billId = :billId")
    , @NamedQuery(name = "BillProductDetails.findByProductId", query = "SELECT b FROM BillProductDetails b WHERE b.productId = :productId")
    , @NamedQuery(name = "BillProductDetails.findByFarmerId", query = "SELECT b FROM BillProductDetails b WHERE b.farmerId = :farmerId")
    , @NamedQuery(name = "BillProductDetails.findByPrice", query = "SELECT b FROM BillProductDetails b WHERE b.price = :price")
    , @NamedQuery(name = "BillProductDetails.findByQuantity", query = "SELECT b FROM BillProductDetails b WHERE b.quantity = :quantity")})
public class BillProductDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "BILL_ID")
    private Integer billId;
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @Column(name = "FARMER_ID")
    private Integer farmerId;
    @Column(name = "PRICE")
    private String price;
    @Column(name = "QUANTITY")
    private String quantity;

    public BillProductDetails() {
    }

    public BillProductDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Integer farmerId) {
        this.farmerId = farmerId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillProductDetails)) {
            return false;
        }
        BillProductDetails other = (BillProductDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "commission_system.objects.BillProductDetails[ id=" + id + " ]";
    }
    
}
