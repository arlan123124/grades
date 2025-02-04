package repository;

import database.interfaces.IDB;
import models.grades;
import repository.interfaces.iGradesRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradesRepository implements iGradesRepository {
    private final IDB db;

    public GradesRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createGrade(grades grade) {
        Connection connection = null;
        try {
            connection = db.getConnection();
            String sql = "INSERT INTO grades(student_barcode, score, course_name) VALUES (?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, grade.getStudentBarcode());
            st.setFloat(2, grade.getScore());
            st.setString(3, grade.getCourseName());

            st.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<grades> getGradesByStudentBarcode(int studentBarcode) {
        Connection connection = null;
        try {
            connection = db.getConnection();
            String sql = "SELECT * FROM grades WHERE student_barcode = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, studentBarcode);

            ResultSet rs = st.executeQuery();
            List<grades> grades = new ArrayList<>();
            while (rs.next()) {
                grades.add(new grades(
                        rs.getInt("student_barcode"),
                        rs.getFloat("score"),
                        rs.getString("course_name")
                ));
            }
            return grades;
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<grades> getAllGrades() {
        Connection connection = null;
        try {
            connection = db.getConnection();
            String sql = "SELECT student_barcode, score, course_name FROM grades";
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<grades> grades = new ArrayList<>();
            while (rs.next()) {
                grades.add(new grades(
                        rs.getInt("student_barcode"),
                        rs.getFloat("score"),
                        rs.getString("course_name")
                ));
            }
            return grades;
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }
        return null;
    }
}