package service.impl;

import DAO.Impl.StudentDAOImpl;
import model.Student;
import service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentDAOImpl studentDAO = new StudentDAOImpl();

    @Override
    public Student getById(Integer id) throws SQLException {
        Student student = studentDAO.getById(id);
        return student;
    }

    @Override
    public List<Student> getAll() {
        return studentDAO.getAll();
    }

    @Override
    public void update(Student student) throws SQLException {
        studentDAO.update(student);
    }

    @Override
    public Integer save(Student student) {
        return studentDAO.save(student);    }

    @Override
    public void delete(Integer id) {
        studentDAO.delete(id);
    }
}
