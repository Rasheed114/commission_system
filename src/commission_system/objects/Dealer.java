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
@Table(name = "DEALER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dealer.findAll", query = "SELECT d FROM Dealer d")
    , @NamedQuery(name = "Dealer.findByDealerId", query = "SELECT d FROM Dealer d WHERE d.dealerId = :dealerId")
    , @NamedQuery(name = "Dealer.findByDealerName", query = "SELECT d FROM Dealer d WHERE d.dealerName = :dealerName")
    , @NamedQuery(name = "Dealer.findByBalance", query = "SELECT d FROM Dealer d WHERE d.balance = :balance")
    , @NamedQuery(name = "Dealer.findByLastPayment", query = "SELECT d FROM Dealer d WHERE d.lastPayment = :lastPayment")})
public class Dealer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DEALER_ID")
    private Integer dealerId;
    @Column(name = "DEALER_NAME")
    private String dealerName;
    @Column(name = "BALANCE")
    private String balance;
    @Column(name = "LAST_PAYMENT")
    private String lastPayment;

    public Dealer() {
    }

    public Dealer(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(String lastPayment) {
        this.lastPayment = lastPayment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dealerId != null ? dealerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dealer)) {
            return false;
        }
        Dealer other = (Dealer) object;
        if ((this.dealerId == null && other.dealerId != null) || (this.dealerId != null && !this.dealerId.equals(other.dealerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "commission_system.objects.Dealer[ dealerId=" + dealerId + " ]";
    }
    
}
