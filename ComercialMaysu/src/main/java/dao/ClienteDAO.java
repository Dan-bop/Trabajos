package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import modelo.Cliente;
import util.JPAUtil;

public class ClienteDAO {

    public Cliente validar(String correo, String clave) {
        EntityManager em = JPAUtil.getEntityManager();
        Cliente cliente = null;
        try {
            TypedQuery<Cliente> query = em.createQuery(
                "SELECT c FROM Cliente c WHERE c.correo = :correo AND c.clave = :clave", Cliente.class);
            query.setParameter("correo", correo);
            query.setParameter("clave", clave);
            cliente = query.getSingleResult();
        } catch (Exception e) {
            cliente = null; // No encontrado o error
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return cliente;
    }

    public void guardar(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("❌ Error al registrar cliente: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
            public boolean existeCorreo(String correo) {
                EntityManager em = JPAUtil.getEntityManager();
                boolean existe = false;
                try {
                    Long count = em.createQuery(
                        "SELECT COUNT(c) FROM Cliente c WHERE c.email = :correo", Long.class)
                        .setParameter("correo", correo)
                        .getSingleResult();
                    existe = count > 0;
                } catch (Exception e) {
                    existe = false;
                } finally {
                    if (em != null && em.isOpen()) {
                        em.close();
                    }
                }
                return existe;
            }

            public void actualizar(Cliente cliente) {
                EntityManager em = JPAUtil.getEntityManager();
                try {
                    em.getTransaction().begin();
                    em.merge(cliente);
                    em.getTransaction().commit();
                } catch (Exception e) {
                    em.getTransaction().rollback();
                } finally {
                    if (em != null && em.isOpen()) {
                        em.close();
                    }
                }
            }

            public Cliente buscarPorCorreo(String correo) {
                EntityManager em = JPAUtil.getEntityManager();
                Cliente cliente = null;
                try {
                    cliente = em.createQuery(
                        "SELECT c FROM Cliente c WHERE c.email = :correo", Cliente.class)
                        .setParameter("correo", correo)
                        .getSingleResult();
                } catch (Exception e) {
                    cliente = null;
                } finally {
                    if (em != null && em.isOpen()) {
                        em.close();
                    }
                }
                return cliente;
            }

            public List<Cliente> listarTodos() {
                EntityManager em = JPAUtil.getEntityManager();
                try {
                    return em.createQuery("SELECT c FROM Cliente c ORDER BY c.nombre ASC", Cliente.class)
                             .getResultList();
                } finally {
                    em.close();
                }
            }

            public Cliente buscarPorId(int id) {
                EntityManager em = JPAUtil.getEntityManager();
                try {
                    return em.find(Cliente.class, id);
                } finally {
                    em.close();
                }
            }

            public int contarClientes() {
                EntityManager em = JPAUtil.getEntityManager();
                try {
                    return ((Long) em.createQuery("SELECT COUNT(c) FROM Cliente c").getSingleResult()).intValue();
                } finally {
                    em.close();
                }
            }


			}