/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EmployeeSkillId implements Serializable {
    @Column(name = "eid")
    private int eid;

    @Column(name = "skid")
    private int skid;

    // Default constructor
    public EmployeeSkillId() {}

    // Parameterized constructor
    public EmployeeSkillId(int eid, int skid) {
        this.eid = eid;
        this.skid = skid;
    }

    // Getters and setters
    public int getEid() { return eid; }
    public void setEid(int eid) { this.eid = eid; }
    public int getSkid() { return skid; }
    public void setSkid(int skid) { this.skid = skid; }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeSkillId that = (EmployeeSkillId) o;
        return eid == that.eid && skid == that.skid;
    }

    @Override
    public int hashCode() {
        return 31 * eid + skid;
    }
}