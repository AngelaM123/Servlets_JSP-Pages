package DAO;

import DTO.FacultyDTO;
import DTO.StudentDTO;
import model.Student;
import model.Subject;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface StudentDAO {

    Student getById(Integer id) throws SQLException;

    List<Student> getAll() throws SQLException;

    void update(Student student) throws SQLException;

    Integer save(Student student) throws SQLException;

    void delete(Integer id) throws SQLException;

    StudentDTO getStudentDTOwithUni(Integer student_id) throws SQLException;

    StudentDTO getStudentDTOwithOutUni(Integer student_id) throws SQLException;

}
