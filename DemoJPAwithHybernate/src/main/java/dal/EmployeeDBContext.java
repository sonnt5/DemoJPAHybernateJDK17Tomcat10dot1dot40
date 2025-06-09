/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import model.Employee;

public class EmployeeDBContext extends DBContext {

    public void insert(Employee employee) {
        try (EntityManager entityManager = getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
        }
    }
    
    public List<Employee> list() {
        try (EntityManager entityManager = getEntityManager()) {
            return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        }
    }
    
    public List<Employee> search(String ename, String gender, String address, String didStr) {
        try (EntityManager em = getEntityManager()) {
            StringBuilder jpql = new StringBuilder("SELECT e FROM Employee e WHERE 1=1");
            if (ename != null && !ename.trim().isEmpty()) {
                jpql.append(" AND e.ename LIKE :ename");
            }
            if (gender != null && !gender.equals("all")) {
                jpql.append(" AND e.gender = :gender");
            }
            if (address != null && !address.trim().isEmpty()) {
                jpql.append(" AND e.address LIKE :address");
            }
            if (didStr != null && !didStr.isEmpty()) {
                jpql.append(" AND e.department.did = :did");
            }

            Query query = em.createQuery(jpql.toString(), Employee.class);

            if (ename != null && !ename.trim().isEmpty()) {
                query.setParameter("ename", "%" + ename + "%");
            }
            if (gender != null && !gender.equals("all")) {
                query.setParameter("gender", gender.equals("true"));
            }
            if (address != null && !address.trim().isEmpty()) {
                query.setParameter("address", "%" + address + "%");
            }
            if (didStr != null && !didStr.isEmpty()) {
                query.setParameter("did", Integer.valueOf(didStr));
            }

            return query.getResultList();
        }
    }
}
