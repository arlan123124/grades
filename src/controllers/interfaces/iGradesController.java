package controllers.interfaces;

public interface iGradesController {
    String createGrade(int studentBarcode, float score, String courseName);
    String getGradesByStudentBarcode(int studentBarcode);
    String calculateGPA(int studentBarcode);
    String getAllGrades();
}