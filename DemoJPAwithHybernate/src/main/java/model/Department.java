/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Departments")
public class Department {
    @Id
    @Column(name = "did")
    private int did;

    @Column(name = "dname")
    private String dname;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    // Getters and setters
    public int getDid() { return did; }
    public void setDid(int did) { this.did = did; }
    public String getDname() { return dname; }
    public void setDname(String dname) { this.dname = dname; }
    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
}