/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commission_system.controllers;

import commission_system.exceptions.NonexistentEntityException;
import commission_system.exceptions.PreexistingEntityException;
import commission_system.objects.Dealer;
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
public class DealerJpaController implements Serializable {

    public DealerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dealer dealer) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(dealer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDealer(dealer.getDealerId()) != null) {
                throw new PreexistingEntityException("Dealer " + dealer + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dealer dealer) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            dealer = em.merge(dealer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dealer.getDealerId();
                if (findDealer(id) == null) {
                    throw new NonexistentEntityException("The dealer with id " + id + " no longer exists.");
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
            Dealer dealer;
            try {
                dealer = em.getReference(Dealer.class, id);
                dealer.getDealerId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dealer with id " + id + " no longer exists.", enfe);
            }
            em.remove(dealer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dealer> findDealerEntities() {
        return findDealerEntities(true, -1, -1);
    }

    public List<Dealer> findDealerEntities(int maxResults, int firstResult) {
        return findDealerEntities(false, maxResults, firstResult);
    }

    private List<Dealer> findDealerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dealer.class));
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

    public Dealer findDealer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dealer.class, id);
        } finally {
            em.close();
        }
    }

    public int getDealerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dealer> rt = cq.from(Dealer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
