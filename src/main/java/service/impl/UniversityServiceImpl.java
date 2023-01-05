package service.impl;

import DAO.Impl.UniversityDAOImpl;
import model.University;
import service.UniversityService;

import java.sql.SQLException;
import java.util.List;

public class UniversityServiceImpl implements UniversityService {
    UniversityDAOImpl universityDAO = new UniversityDAOImpl();
    @Override
    public University getById(Integer id) {
        University university = universityDAO.getById(id);
        return university;
    }

    @Override
    public List<University> getAll() throws SQLException {
        return universityDAO.getAll();
    }

    @Override
    public void update(University university) throws SQLException {
        universityDAO.update(university);
    }

    @Override
    public Integer save(University university) {
        return universityDAO.save(university);
    }

    @Override
    public void delete(Integer id) {

        universityDAO.delete(id);

    }
}
