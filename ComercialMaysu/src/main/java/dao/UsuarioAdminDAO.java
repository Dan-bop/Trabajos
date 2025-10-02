package dao;

import jakarta.persistence.*;
import modelo.UsuarioAdmin;
import util.JPAUtil;
import java.util.List;

public class UsuarioAdminDAO {

    public UsuarioAdmin buscarPorUsername(String username) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT u FROM UsuarioAdmin u WHERE u.username = :username", UsuarioAdmin.class)
                     .setParameter("username", username)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public List<UsuarioAdmin> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT u FROM UsuarioAdmin u ORDER BY u.fechaCreacion DESC", UsuarioAdmin.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }

    public void crear(UsuarioAdmin usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void actualizarRol(int id, String nuevoRol) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            UsuarioAdmin usuario = em.find(UsuarioAdmin.class, id);
            usuario.setRol(nuevoRol);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void eliminar(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            UsuarioAdmin usuario = em.find(UsuarioAdmin.class, id);
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
