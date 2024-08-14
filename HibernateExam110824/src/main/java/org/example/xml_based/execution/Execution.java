package org.example.xml_based.execution;

import org.example.xml_based.entity.Employee;
import org.example.xml_based.entity.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Execution<EmployeeSkill> {
    public void saveEmployees(List<Employee> employees, Session session) {
        Transaction transaction = session.beginTransaction();
        for (Employee employee : employees) {
            session.save(employee);
        }
        transaction.commit();

    }
    public void saveSkills(List<Skill> skills, Session session) {
        Transaction transaction = session.beginTransaction();
        for (Skill skill : skills) {
            session.save(skill);
        }
        transaction.commit();
    }
    public void saveEmployeeSkills(List<EmployeeSkill> employeeSkills, Session session) {
        Transaction transaction = session.beginTransaction();
        for (EmployeeSkill employeeSkill : employeeSkills) {
            session.save(employeeSkill);
        }
        transaction.commit();
    }
}





