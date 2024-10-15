package org.cuervo.Infrastructure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.cuervo.Domain.Ropa;
import org.cuervo.Interface.RopaRepository;


import java.util.List;

public class FileRopaRepository implements RopaRepository {

    private final EntityManagerFactory emf;

    public FileRopaRepository() {
        emf = Persistence.createEntityManagerFactory("RopaUp");
    }

    public void saveRopa(Ropa ropa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ropa);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateRopa(Ropa ropa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(ropa);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteRopa(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Ropa ropa = em.find(Ropa.class, id);
            if (ropa != null) {
                em.remove(ropa);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Ropa findRopaById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Ropa.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Ropa> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM Ropa p", Ropa.class)
                    .getResultList();
        }
    }

    public void cerrar() {
        emf.close();
    }

}
