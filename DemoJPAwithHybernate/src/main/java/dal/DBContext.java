/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author p14s
 */
public abstract class DBContext {

    private final EntityManagerFactory entityManagerFactory;

    public DBContext() {
        entityManagerFactory = Persistence.createEntityManagerFactory("sonnt_persistance");

    }

    protected EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
