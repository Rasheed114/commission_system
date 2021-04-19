/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commission_system.controllers;

import commission_system.controllers.exceptions.NonexistentEntityException;
import commission_system.controllers.exceptions.PreexistingEntityException;
import commission_system.objects.Bills;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 */
public class BillsJpaController implements Serializable {

    public BillsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Bills bills) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bills);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBills(bills.getBillId()) != null) {
                throw new PreexistingEntityException("Bills " + bills + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bills bills) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bills = em.merge(bills);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = bills.getBillId();
                if (findBills(id) == null) {
                    throw new NonexistentEntityException("The bills with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bills bills;
            try {
                bills = em.getReference(Bills.class, id);
                bills.getBillId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bills with id " + id + " no longer exists.", enfe);
            }
            em.remove(bills);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bills> findBillsEntities() {
        return findBillsEntities(true, -1, -1);
    }

    public List<Bills> findBillsEntities(int maxResults, int firstResult) {
        return findBillsEntities(false, maxResults, firstResult);
    }

    private List<Bills> findBillsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bills.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Bills findBills(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bills.class, id);
        } finally {
            em.close();
        }
    }

    public int getBillsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bills> rt = cq.from(Bills.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
