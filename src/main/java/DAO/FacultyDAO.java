package DAO;

import DTO.FacultyDTO;
import model.*;


import java.sql.SQLException;
import java.util.List;

public interface FacultyDAO {
    Faculty getById(Integer id) throws SQLException;

    List<Faculty> getAll() throws SQLException;

    void update(Faculty faculty) throws SQLException;

    Integer save(Faculty faculty) throws SQLException;

    void delete(Integer id) throws SQLException;

    FacultyDTO getFacultyDTOwithUni(Integer faculty_id) throws SQLException;

    FacultyDTO getFacultyDTOwithOutUni(Integer faculty_id) throws SQLException;
}
