/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commission_system.controllers;

import commission_system.controllers.exceptions.NonexistentEntityException;
import commission_system.controllers.exceptions.PreexistingEntityException;
import commission_system.objects.BillProductDetails;
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
public class BillProductDetailsJpaController implements Serializable {

    public BillProductDetailsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BillProductDetails billProductDetails) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(billProductDetails);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBillProductDetails(billProductDetails.getId()) != null) {
                throw new PreexistingEntityException("BillProductDetails " + billProductDetails + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BillProductDetails billProductDetails) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            billProductDetails = em.merge(billProductDetails);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = billProductDetails.getId();
                if (findBillProductDetails(id) == null) {
                    throw new NonexistentEntityException("The billProductDetails with id " + id + " no longer exists.");
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
            BillProductDetails billProductDetails;
            try {
                billProductDetails = em.getReference(BillProductDetails.class, id);
                billProductDetails.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The billProductDetails with id " + id + " no longer exists.", enfe);
            }
            em.remove(billProductDetails);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BillProductDetails> findBillProductDetailsEntities() {
        return findBillProductDetailsEntities(true, -1, -1);
    }

    public List<BillProductDetails> findBillProductDetailsEntities(int maxResults, int firstResult) {
        return findBillProductDetailsEntities(false, maxResults, firstResult);
    }

    private List<BillProductDetails> findBillProductDetailsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BillProductDetails.class));
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

    public BillProductDetails findBillProductDetails(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BillProductDetails.class, id);
        } finally {
            em.close();
        }
    }

    public int getBillProductDetailsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BillProductDetails> rt = cq.from(BillProductDetails.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
