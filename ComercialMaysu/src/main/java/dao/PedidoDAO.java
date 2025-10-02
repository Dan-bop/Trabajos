package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import modelo.Pedido;
import util.JPAUtil;

public class PedidoDAO {

    public void guardar(Pedido pedido) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public List<Pedido> listarPorCliente(int clienteId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT p FROM Pedido p WHERE p.cliente.id = :id ORDER BY p.fecha DESC", Pedido.class)
                .setParameter("id", clienteId)
                .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Pedido> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Pedido p ORDER BY p.fecha DESC", Pedido.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }

    public void actualizarEstado(int id, String nuevoEstado) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Pedido pedido = em.find(Pedido.class, id);
            if (pedido != null) {
                em.getTransaction().begin();
                pedido.setEstado(nuevoEstado);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Pedido buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            em.close();
        }
    }

    public double calcularTotalVentas() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT SUM(p.total) FROM Pedido p", Double.class).getSingleResult();
        } finally {
            em.close();
        }
    }

    public int contarPedidos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return ((Long) em.createQuery("SELECT COUNT(p) FROM Pedido p").getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }


}
