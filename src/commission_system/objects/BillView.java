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
@Table(name = "BILL_VIEW", catalog = "", schema = "COMESSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillView.findAll", query = "SELECT b FROM BillView b")
    , @NamedQuery(name = "BillView.findByBillId", query = "SELECT b FROM BillView b WHERE b.billId = :billId")
    , @NamedQuery(name = "BillView.findByDriverName", query = "SELECT b FROM BillView b WHERE b.driverName = :driverName")
    , @NamedQuery(name = "BillView.findByBillIssueDate", query = "SELECT b FROM BillView b WHERE b.billIssueDate = :billIssueDate")
    , @NamedQuery(name = "BillView.findByBoxNumber", query = "SELECT b FROM BillView b WHERE b.boxNumber = :boxNumber")
    , @NamedQuery(name = "BillView.findByDealerName", query = "SELECT b FROM BillView b WHERE b.dealerName = :dealerName")})
public class BillView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "bill_id")
    private int billId;
    @Column(name = "driver_name")
    private String driverName;
    @Column(name = "bill_issue_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date billIssueDate;
    @Column(name = "box_number")
    private String boxNumber;
    @Column(name = "dealer_name")
    private String dealerName;

    public BillView() {
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
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

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }
    
}
