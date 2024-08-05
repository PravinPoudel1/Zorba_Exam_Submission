public class Student {

    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    public int getStudRollNumber() {
        return studRollNumber;
    }

    public void setStudRollNumber(int studRollNumber) {
        this.studRollNumber = studRollNumber;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    private String studName;

    private int studRollNumber;

    private Subject subject;


}
