/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;


import jakarta.persistence.EntityManager;
import java.util.List;
import model.Department;
/**
 *
 * @author p14s
 */
public class DepartmentDBContext extends DBContext {

    public List<Department> list() {
        try (EntityManager entityManager = getEntityManager()) {
            return entityManager.createQuery("SELECT d FROM Department d", Department.class).getResultList();
        }
    }
}
