public class Teacher {

    private int teacherId;

    private String teacherName;

    private String teacherQualification;

    public int getExperienceOfTeaching() {
        return experienceOfTeaching;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setExperienceOfTeaching(int experienceOfTeaching) {
        this.experienceOfTeaching = experienceOfTeaching;
    }

    public String getTeacherQualification() {
        return teacherQualification;
    }

    public void setTeacherQualification(String teacherQualification) {
        this.teacherQualification = teacherQualification;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    private int experienceOfTeaching;

    private Subject subject;


}

