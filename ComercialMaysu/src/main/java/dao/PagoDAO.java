package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import modelo.Pago;
import util.JPAUtil;

public class PagoDAO {
	public List<Pago> listarTodos() {
	    EntityManager em = JPAUtil.getEntityManager();
	    try {
	        return em.createQuery("SELECT p FROM Pago p JOIN FETCH p.pedido JOIN FETCH p.pedido.cliente", Pago.class)
	                 .getResultList();
	    } finally {
	        em.close();
	    }
	}


}
