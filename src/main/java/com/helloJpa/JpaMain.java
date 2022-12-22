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
            Member member = em.find(Member.class, 2L);

            System.out.println("member.getId() = " + member.getId());
            System.out.println("member.getName() = " + member.getName());
            member.setName("도도도");

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }

        emf.close();

    }
}
