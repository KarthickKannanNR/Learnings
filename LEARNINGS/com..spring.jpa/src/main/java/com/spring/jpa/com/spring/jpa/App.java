package com.spring.jpa.com.spring.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
       EntityManager em = emf.createEntityManager();
    }
}
