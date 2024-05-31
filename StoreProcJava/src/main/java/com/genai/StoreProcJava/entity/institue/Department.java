package com.genai.StoreProcJava.entity.institue;

import javax.persistence.*;

@Entity
public class Department {

    public Department(String dept_name, String building, float budget) {
        this.dept_name = dept_name;
        this.building = building;
        this.budget = budget;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String dept_name;

    @Column
    private String building;

    @Column
    private float budget;

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }
}
