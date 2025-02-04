package repository.interfaces;

import models.grades;

import java.util.List;

public interface iGradesRepository {
    boolean createGrade(grades grade);

    List<grades> getGradesByStudentBarcode(int studentBarcode);

    List<grades> getAllGrades();
}