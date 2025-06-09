/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import jakarta.persistence.EntityManager;
import java.util.List;
import model.Skill;


public class SkillDBContext extends DBContext {
    public List<Skill> getAllSkills() {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery("SELECT s FROM Skill s", Skill.class).getResultList();
        }
    }
}