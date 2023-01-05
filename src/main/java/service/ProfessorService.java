package service;

import model.Professor;

import java.sql.SQLException;
import java.util.List;

public interface ProfessorService {

    Professor getById(Integer id) throws SQLException;
    List<Professor> getAll() throws SQLException;
    void update(Professor professor) throws SQLException;
    Integer save(Professor professor) throws SQLException;
    void delete(Integer id );
}
