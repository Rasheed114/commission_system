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
@Table(name = "FARMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Farmer.findAll", query = "SELECT f FROM Farmer f")
    , @NamedQuery(name = "Farmer.findByFarmerId", query = "SELECT f FROM Farmer f WHERE f.farmerId = :farmerId")
    , @NamedQuery(name = "Farmer.findByFarmerName", query = "SELECT f FROM Farmer f WHERE f.farmerName = :farmerName")})
public class Farmer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FARMER_ID")
    private Integer farmerId;
    @Column(name = "FARMER_NAME")
    private String farmerName;

    public Farmer() {
    }

    public Farmer(Integer farmerId) {
        this.farmerId = farmerId;
    }

    public Integer getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Integer farmerId) {
        this.farmerId = farmerId;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (farmerId != null ? farmerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Farmer)) {
            return false;
        }
        Farmer other = (Farmer) object;
        if ((this.farmerId == null && other.farmerId != null) || (this.farmerId != null && !this.farmerId.equals(other.farmerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "commission_system.objects.Farmer[ farmerId=" + farmerId + " ]";
    }
    
}
