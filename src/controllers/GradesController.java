package controllers;

import controllers.interfaces.iGradesController;
import models.grades;
import repository.interfaces.iGradesRepository;

import java.util.List;

public class GradesController implements iGradesController {
    private final iGradesRepository repo;

    public GradesController(iGradesRepository repo) {
        this.repo = repo;
    }

    @Override
    public String createGrade(int studentBarcode, float score, String courseName) {
        if (score < 0 || score > 100) {
            return "Invalid score value (must be 0-100)";
        }

        grades grade = new grades(studentBarcode, score, courseName);
        boolean created = repo.createGrade(grade);
        return created ? "Grade was created" : "Grade creation failed";
    }






    @Override
    public String getGradesByStudentBarcode(int studentBarcode) {
        List<grades> grades = repo.getGradesByStudentBarcode(studentBarcode);
        if (grades.isEmpty()) return "No grades found for this student";

        StringBuilder response = new StringBuilder();
        for (grades grade : grades) {
            response.append(grade.toString()).append("\n");
        }
        return response.toString();
    }


    public double convertGPA(int grade){
        if(grade >= 95) return 4.0;
        else if(grade >= 90) return 3.67;
        else if(grade >= 85) return 3.33;
        else if(grade >= 80) return 3.0;
        else if(grade >= 75) return 2.67;
        else if(grade >= 70) return 2.33;
        else if(grade >= 65) return 2.0;
        else if(grade >= 60) return 1.67;
        else if(grade >= 55) return 1.33;
        else if(grade >= 50) return 1.0;
        else return 0. ;
    }


    @Override
    public String calculateGPA(int studentBarcode) {
        List<grades> grades = repo.getGradesByStudentBarcode(studentBarcode);
        if (grades.isEmpty()) return "No grades available for GPA calculation";

        float total = 0;
        for (grades grade : grades) {
            total += grade.getScore();
        }
        float gpa = total / grades.size();
        return String.format("GPA for student %d: %.2f", studentBarcode, gpa);
    }


    @Override
    public String getAllGrades() {
        List<grades> grades = repo.getAllGrades();
        if (grades.isEmpty()) return "No grades found in system";

        StringBuilder response = new StringBuilder();
        for (grades grade : grades) {
            response.append(grade.toString()).append("\n");
        }
        return response.toString();
    }

}