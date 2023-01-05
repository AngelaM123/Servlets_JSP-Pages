package service.impl;

import DAO.Impl.FacultyDAOImpl;
import model.Faculty;
import service.FacultyService;

import java.sql.SQLException;
import java.util.List;

public class FacultyServiceImpl implements FacultyService {
    FacultyDAOImpl facultyDAO = new FacultyDAOImpl();

    @Override
    public Faculty getById(Integer id) throws SQLException {
        Faculty fac = facultyDAO.getById(id);
        return fac;
    }

    @Override
    public List<Faculty> getAll() throws SQLException {
        return facultyDAO.getAll();
    }

    @Override
    public void update(Faculty faculty) throws SQLException {
        facultyDAO.update(faculty);
    }

    @Override
    public Integer save(Faculty faculty) throws SQLException {
        return facultyDAO.save(faculty);    }

    @Override
    public void delete(Integer id) throws SQLException {
        facultyDAO.delete(id);
    }
}
