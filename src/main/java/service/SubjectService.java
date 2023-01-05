package service;

import model.Subject;

import java.sql.SQLException;
import java.util.List;

public interface SubjectService {

    Subject getById(Integer id) throws SQLException;
    List<Subject> getAll() throws SQLException;
    void update(Subject subject);
    Integer save(Subject subject);
    void delete(Integer id ) throws SQLException;
}
