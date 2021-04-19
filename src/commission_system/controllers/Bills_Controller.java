/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commission_system.controllers;

import commission_system.objects.Bills;
import commission_system.controllers.BillsJpaController;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 */
public class Bills_Controller {
    
    
    private List<Bills> custBills;
    private BillsJpaController billCont;
    private static EntityManagerFactory factory;
    
    public Bills_Controller(){
        
        factory = Persistence.createEntityManagerFactory("commission_systemPU");
        billCont= new BillsJpaController(factory);
        this.setCustBills();
    }

    public List<Bills> getCustBills() {      
        return custBills;
    }

    public void setCustBills() {
        if(billCont!= null)
            custBills =  billCont.findBillsEntities();
    }
    
    
 
   public static void main(String[] args) throws Exception {
        Bills_Controller dao = new Bills_Controller();
        
        for(Bills b : dao.getCustBills()){
        
            System.out.println("Bill name "+ b.getDriverName());
        }
        
        
    }
    
    
    
    
    
    
}
