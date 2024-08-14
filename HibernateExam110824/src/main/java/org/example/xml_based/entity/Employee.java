package org.example.xml_based.entity;

import java.util.HashSet;
import java.util.Set;

public class Employee {
    private int empId;
    private String empName;
    private String empAddress;
    private String empEmail;
    private int empExp;
    private Set<Skill> skills = new HashSet<>();

    public int getEmpId() {
        return empId;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public int getEmpExp() {
        return empExp;
    }

    public void setEmpExp(int empExp) {
        this.empExp = empExp;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empExp=" + empExp +
                ", skills=" + skills +
                '}';
    }

    public void setId(int numericCellValue) {
    }

    public void setAddress(String stringCellValue) {
    }

    public void setName(String stringCellValue) {
    }

    public void setEmail(String stringCellValue) {
    }

    public void setExperience(int numericCellValue) {

    }
}
