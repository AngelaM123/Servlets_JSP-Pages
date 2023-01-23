package service;

import model.Faculty;

import java.sql.SQLException;
import java.util.List;

public interface FacultyService {

    Faculty getById(Integer id) throws SQLException;

    List<Faculty> getAll() throws SQLException;

    void update(Faculty faculty) throws SQLException;

    Integer save(Faculty faculty) throws SQLException;

    void delete(Integer id ) throws SQLException;
}
