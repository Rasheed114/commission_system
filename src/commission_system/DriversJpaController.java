/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commission_system;

import commission_system.exceptions.NonexistentEntityException;
import commission_system.exceptions.PreexistingEntityException;
import commission_system.objects.Drivers;
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
public class DriversJpaController implements Serializable {

    public DriversJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Drivers drivers) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(drivers);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDrivers(drivers.getDriverId()) != null) {
                throw new PreexistingEntityException("Drivers " + drivers + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Drivers drivers) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            drivers = em.merge(drivers);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = drivers.getDriverId();
                if (findDrivers(id) == null) {
                    throw new NonexistentEntityException("The drivers with id " + id + " no longer exists.");
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
            Drivers drivers;
            try {
                drivers = em.getReference(Drivers.class, id);
                drivers.getDriverId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The drivers with id " + id + " no longer exists.", enfe);
            }
            em.remove(drivers);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Drivers> findDriversEntities() {
        return findDriversEntities(true, -1, -1);
    }

    public List<Drivers> findDriversEntities(int maxResults, int firstResult) {
        return findDriversEntities(false, maxResults, firstResult);
    }

    private List<Drivers> findDriversEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Drivers.class));
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

    public Drivers findDrivers(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Drivers.class, id);
        } finally {
            em.close();
        }
    }

    public int getDriversCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Drivers> rt = cq.from(Drivers.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
