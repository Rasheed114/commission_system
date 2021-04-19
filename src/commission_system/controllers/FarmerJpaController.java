/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commission_system.controllers;

import commission_system.controllers.exceptions.NonexistentEntityException;
import commission_system.controllers.exceptions.PreexistingEntityException;
import commission_system.objects.Farmer;
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
public class FarmerJpaController implements Serializable {

    public FarmerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Farmer farmer) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(farmer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFarmer(farmer.getFarmerId()) != null) {
                throw new PreexistingEntityException("Farmer " + farmer + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Farmer farmer) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            farmer = em.merge(farmer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = farmer.getFarmerId();
                if (findFarmer(id) == null) {
                    throw new NonexistentEntityException("The farmer with id " + id + " no longer exists.");
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
            Farmer farmer;
            try {
                farmer = em.getReference(Farmer.class, id);
                farmer.getFarmerId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The farmer with id " + id + " no longer exists.", enfe);
            }
            em.remove(farmer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Farmer> findFarmerEntities() {
        return findFarmerEntities(true, -1, -1);
    }

    public List<Farmer> findFarmerEntities(int maxResults, int firstResult) {
        return findFarmerEntities(false, maxResults, firstResult);
    }

    private List<Farmer> findFarmerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Farmer.class));
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

    public Farmer findFarmer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Farmer.class, id);
        } finally {
            em.close();
        }
    }

    public int getFarmerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Farmer> rt = cq.from(Farmer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
