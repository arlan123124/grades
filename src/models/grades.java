package models;

public class grades {
    private int studentBarcode;
    private float score;
    private String courseName;

    public grades() {
    }

    public grades(float score, String courseName) {
        setScore(score);
        setCourseName(courseName);
    }

    public grades(int studentBarcode, float score, String courseName) {
        this(score, courseName);
        setStudentBarcode(studentBarcode);
    }

    public int getStudentBarcode() {
        return studentBarcode;
    }

    public void setStudentBarcode(int studentBarcode) {
        this.studentBarcode = studentBarcode;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "studentBarcode=" + studentBarcode +
                ", score=" + score +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}