/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Skills")
public class Skill {
    @Id
    @Column(name = "skid")
    private int skid;

    @Column(name = "skname")
    private String skname;

    @OneToMany(mappedBy = "skill")
    private List<EmployeeSkill> employeeSkills;

    // Getters and setters
    public int getSkid() { return skid; }
    public void setSkid(int skid) { this.skid = skid; }
    public String getSkname() { return skname; }
    public void setSkname(String skname) { this.skname = skname; }
    public List<EmployeeSkill> getEmployeeSkills() { return employeeSkills; }
    public void setEmployeeSkills(List<EmployeeSkill> employeeSkills) { this.employeeSkills = employeeSkills; }
}
