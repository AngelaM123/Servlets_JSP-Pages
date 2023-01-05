package service;

import model.University;

import java.sql.SQLException;
import java.util.List;

public interface UniversityService {

    University getById(Integer id);
    List<University> getAll() throws SQLException;
    void update(University university) throws SQLException;
    Integer save(University university);
    void delete(Integer id );

}
