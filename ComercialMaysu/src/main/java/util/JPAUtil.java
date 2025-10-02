package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("ComercialMaysuPU");
        } catch (Throwable ex) {
            System.err.println("❌ Error al inicializar EntityManagerFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Devuelve un EntityManager listo para usar
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Cierra el factory al apagar la app
    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
