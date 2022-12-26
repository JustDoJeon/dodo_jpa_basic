package com.helloJpa;

import javax.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx  = em.getTransaction();

        //실제 동작 코드
        tx.begin();

        try {
            //비영속
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);

            System.out.println("====================");

            tx.commit(); //이 시점에 DB에 쿼리가 날라가는거임!!!
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }

        emf.close();

    }
}
