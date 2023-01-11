package service.impl;

import DAO.Impl.SubjectDAOImpl;
import model.Subject;
import service.SubjectService;

import java.sql.SQLException;
import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    SubjectDAOImpl subjectDAO = new SubjectDAOImpl();
    @Override
    public Subject getById(Integer id) throws SQLException {
        Subject subject = subjectDAO.getById(id);
        return subject;
    }

    @Override
    public List<Subject> getAll() throws SQLException {
        return subjectDAO.getAll();
    }

    @Override
    public void update(Subject subject) throws SQLException {
        subjectDAO.update(subject);
    }

    @Override
    public Integer save(Subject subject) throws SQLException {
        return subjectDAO.save(subject);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        subjectDAO.delete(id);
    }
}
