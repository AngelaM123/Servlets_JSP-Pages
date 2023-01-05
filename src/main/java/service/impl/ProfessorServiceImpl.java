package service.impl;

import DAO.Impl.ProfessorDAOImpl;
import model.Professor;
import service.ProfessorService;

import java.sql.SQLException;
import java.util.List;

public class ProfessorServiceImpl implements ProfessorService {

    ProfessorDAOImpl professorDAO = new ProfessorDAOImpl();

    @Override

    public Professor getById(Integer id) throws SQLException {
        Professor professor = professorDAO.getById(id);
        return professor;
    }

    @Override
    public List<Professor> getAll() throws SQLException {
        return professorDAO.getAll();
    }

    @Override
    public void update(Professor professor) throws SQLException {
        professorDAO.update(professor);
    }

    @Override
    public Integer save(Professor professor) throws SQLException {
        return professorDAO.save(professor);    }

    @Override
    public void delete(Integer id) {
        professorDAO.delete(id);
    }
}
