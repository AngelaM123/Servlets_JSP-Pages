package service;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    Student getById(Integer id) throws SQLException;
    List<Student> getAll();
    void update(Student student) throws SQLException;
    Integer save(Student student);
    void delete(Integer id );

}
