package controllers.interfaces;

public interface iGradesController {
    String createGrade(int studentBarcode, int courseId, int percentage);
    String getGradesByStudentBarcode(int studentBarcode);
    String calculateGPA(int studentBarcode);
    String getAllGrades();
}
