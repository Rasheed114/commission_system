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
@Table(name = "DRIVERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drivers.findAll", query = "SELECT d FROM Drivers d")
    , @NamedQuery(name = "Drivers.findByDriverName", query = "SELECT d FROM Drivers d WHERE d.driverName = :driverName")
    , @NamedQuery(name = "Drivers.findByDriverId", query = "SELECT d FROM Drivers d WHERE d.driverId = :driverId")})
public class Drivers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "DRIVER_NAME")
    private String driverName;
    @Id
    @Basic(optional = false)
    @Column(name = "DRIVER_ID")
    private Integer driverId;

    public Drivers() {
    }

    public Drivers(Integer driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (driverId != null ? driverId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drivers)) {
            return false;
        }
        Drivers other = (Drivers) object;
        if ((this.driverId == null && other.driverId != null) || (this.driverId != null && !this.driverId.equals(other.driverId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "commission_system.objects.Drivers[ driverId=" + driverId + " ]";
    }
    
}
