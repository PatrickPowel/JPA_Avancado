package br.com.rpires;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestaBanco {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicioPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("✅ Banco inicializado e tabelas criadas!");
    }
}
