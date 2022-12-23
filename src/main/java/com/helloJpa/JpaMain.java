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
            Member member = new Member();
            member.setId(1L);
            member.setName("도도랍니다.");

            //영속
            System.out.println("====BEFORE====");
            em.persist(member);
            System.out.println("====AFTER====");

            tx.commit(); //이 시점에 DB에 쿼리가 날라가는거임!!!
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }

        emf.close();

    }
}
