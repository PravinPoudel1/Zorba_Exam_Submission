package org.example.xml_based.entity;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Set;

public class ReadFromExcel {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        try (FileInputStream file = new FileInputStream(new File("C:\\Users\\poude\\OneDrive - Lone Star College\\Desktop\\Hibernate-Class\\AbshikSirExam\\HibernateExam110824\\src\\main\\resources\\Exam_info.xlsx"))) {
            Workbook workbook = WorkbookFactory.create(file);

            // Read Employee Sheet
            Sheet employeeSheet = workbook.getSheetAt(0);
            Set<Employee> employees = new HashSet<>();
            for (Row row : employeeSheet) {
                // Assuming the first row is the header
                if (row.getRowNum() == 0) continue;

                Employee employee = new Employee();
                employee.setId((int) row.getCell(0).getNumericCellValue());
                employee.setName(row.getCell(1).getStringCellValue());
                employee.setAddress(row.getCell(2).getStringCellValue());
                employee.setEmail(row.getCell(3).getStringCellValue());
                employee.setExperience((int) row.getCell(4).getNumericCellValue());

                employees.add(employee);
            }

            // Configure Hibernate and build session factory
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Employee.class);
            sessionFactory = configuration.buildSessionFactory();

            // Open session and begin transaction
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            for (Employee emp : employees) {
                session.save(emp);
            }

            // Commit transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}