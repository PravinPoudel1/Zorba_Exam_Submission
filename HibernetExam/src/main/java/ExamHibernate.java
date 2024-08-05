import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class ExamHibernate {
    private static SessionFactory factory;

    public static void main(String[] args) {
        factory = new Configuration().configure().buildSessionFactory();
        Scanner scanner = new Scanner(System.in);

        // 1. Insert subjects
        insertSubjects(scanner);

        // 2. Insert students
        insertStudents(scanner);

        // 3. Insert teachers
        insertTeachers(scanner);

        // 4. Select all records
        selectAllRecords();

        // 5. Update subject name
        updateSubject();

        // 6. Delete records of students with subject Physics
        deleteStudentsWithSubject("Physics");

        factory.close();
        scanner.close();
    }

    private static void insertSubjects(Scanner scanner) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            for (int i = 0; i < 4; i++) {
                System.out.println("Enter subject name:");
                String subName = scanner.nextLine();
                Subject subject = new Subject();
                subject.setSubName(subName);
                session.save(subject);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void insertStudents(Scanner scanner) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            List<Subject> subjects = session.createQuery("FROM Subject").list();
            for (Subject subject : subjects) {
                System.out.println(subject.getSubjectId() + ". " + subject.getSubName());
            }

            System.out.println("Enter student name:");
            String studName = scanner.nextLine();
            System.out.println("Enter roll number:");
            int studRollNumber = scanner.nextInt();
            System.out.println("Choose a subject ID:");
            int subId = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Subject subject = session.get(Subject.class, subId);
            Student student = new Student();
            student.setStudName(studName);
            student.setStudRollNumber(studRollNumber);
            student.setSubject(subject);

            session.save(student);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void insertTeachers(Scanner scanner) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            List<Subject> subjects = session.createQuery("FROM Subject").list();
            for (Subject subject : subjects) {
                System.out.println(subject.getSubjectId() + ". " + subject.getSubName());
            }

            System.out.println("Enter teacher name:");
            String teacherName = scanner.nextLine();
            System.out.println("Enter qualification:");
            String teacherQualification = scanner.nextLine();
            System.out.println("Enter years of experience:");
            int experienceOfTeaching = scanner.nextInt();
            System.out.println("Choose a subject ID:");
            int subId = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Subject subject = session.get(Subject.class, subId);
            Teacher teacher = new Teacher();
            teacher.setTeacherName(teacherName);
            teacher.setTeacherQualification(teacherQualification);
            teacher.setExperienceOfTeaching(experienceOfTeaching);
            teacher.setSubject(subject);

            session.save(teacher);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void selectAllRecords() {
        Session session = factory.openSession();

        List<Student> students = session.createQuery("FROM Student").list();
        List<Teacher> teachers = session.createQuery("FROM Teacher").list();
        List<Subject> subjects = session.createQuery("FROM Subject").list();

        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student.getStudName() + " - " + student.getSubject().getSubName());
        }

        System.out.println("Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getTeacherName() + " - " + teacher.getSubject().getSubName());
        }

        System.out.println("Subjects:");
        for (Subject subject : subjects) {
            System.out.println(subject.getSubName());
        }

        session.close();
    }

    private static void updateSubject() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Query<Subject> query = session.createQuery("FROM Subject WHERE Subject = 'Mathematics'", Subject.class);
            Subject subject = query.getSingleResult();



            if (subject != null) {
                subject.setSubName("Astronomy");
                session.update(subject);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void deleteStudentsWithSubject(String subjectName) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Subject subject = (Subject) session.createQuery("FROM Subject WHERE substring() = :subjectName")
                    .setParameter("subjectName", subjectName)
                    .uniqueResult();

            if (subject != null) {
                List students = session.createQuery("FROM Student WHERE subject = :subject")
                        .setParameter("subject", subject)
                        .list();
                for (Student student : students) {
                    session.delete(student);
                }
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }
    }
}
