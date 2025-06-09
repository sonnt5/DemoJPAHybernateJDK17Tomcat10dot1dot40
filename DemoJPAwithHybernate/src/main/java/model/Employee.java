/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid")
    private int eid;

    @Column(name = "ename")
    private String ename;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "did")
    private Department department;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeSkill> employeeSkills;

    // Getters and setters
    public int getEid() { return eid; }
    public void setEid(int eid) { this.eid = eid; }
    public String getEname() { return ename; }
    public void setEname(String ename) { this.ename = ename; }
    public boolean isGender() { return gender; }
    public void setGender(boolean gender) { this.gender = gender; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
    public List<EmployeeSkill> getEmployeeSkills() { return employeeSkills; }
    public void setEmployeeSkills(List<EmployeeSkill> employeeSkills) { this.employeeSkills = employeeSkills; }
}
