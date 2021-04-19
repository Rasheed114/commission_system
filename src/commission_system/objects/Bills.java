/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commission_system.objects;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@Entity
@Table(name = "BILLS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bills.findAll", query = "SELECT b FROM Bills b")
    , @NamedQuery(name = "Bills.findByBillId", query = "SELECT b FROM Bills b WHERE b.billId = :billId")
    , @NamedQuery(name = "Bills.findByDealerId", query = "SELECT b FROM Bills b WHERE b.dealerId = :dealerId")
    , @NamedQuery(name = "Bills.findByDriverName", query = "SELECT b FROM Bills b WHERE b.driverName = :driverName")
    , @NamedQuery(name = "Bills.findByBillIssueDate", query = "SELECT b FROM Bills b WHERE b.billIssueDate = :billIssueDate")
    , @NamedQuery(name = "Bills.findByBoxNumber", query = "SELECT b FROM Bills b WHERE b.boxNumber = :boxNumber")
    , @NamedQuery(name = "Bills.findByRefNum", query = "SELECT b FROM Bills b WHERE b.refNum = :refNum")
    , @NamedQuery(name = "Bills.findByBoxPrice", query = "SELECT b FROM Bills b WHERE b.boxPrice = :boxPrice")
    , @NamedQuery(name = "Bills.findByPreviousBalance", query = "SELECT b FROM Bills b WHERE b.previousBalance = :previousBalance")
    , @NamedQuery(name = "Bills.findByCurrentBalance", query = "SELECT b FROM Bills b WHERE b.currentBalance = :currentBalance")
    , @NamedQuery(name = "Bills.findByLastPayment", query = "SELECT b FROM Bills b WHERE b.lastPayment = :lastPayment")})
public class Bills implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BILL_ID")
    private Integer billId;
    @Column(name = "DEALER_ID")
    private Integer dealerId;
    @Column(name = "DRIVER_NAME")
    private String driverName;
    @Column(name = "BILL_ISSUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date billIssueDate;
    @Column(name = "BOX_NUMBER")
    private String boxNumber;
    @Column(name = "REF_NUM")
    private String refNum;
    @Column(name = "BOX_PRICE")
    private String boxPrice;
    @Column(name = "PREVIOUS_BALANCE")
    private String previousBalance;
    @Column(name = "CURRENT_BALANCE")
    private String currentBalance;
    @Column(name = "LAST_PAYMENT")
    private String lastPayment;

    public Bills() {
    }

    public Bills(Integer billId) {
        this.billId = billId;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Date getBillIssueDate() {
        return billIssueDate;
    }

    public void setBillIssueDate(Date billIssueDate) {
        this.billIssueDate = billIssueDate;
    }

    public String getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(String boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getRefNum() {
        return refNum;
    }

    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }

    public String getBoxPrice() {
        return boxPrice;
    }

    public void setBoxPrice(String boxPrice) {
        this.boxPrice = boxPrice;
    }

    public String getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(String previousBalance) {
        this.previousBalance = previousBalance;
    }

    public String getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = previousBalance+currentBalance;
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
        hash += (billId != null ? billId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bills)) {
            return false;
        }
        Bills other = (Bills) object;
        if ((this.billId == null && other.billId != null) || (this.billId != null && !this.billId.equals(other.billId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "commission_system.objects.Bills[ billId=" + billId + " ]";
    }
    
}
