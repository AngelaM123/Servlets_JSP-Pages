package DAO;

import DTO.FacultyDTO;
import DTO.ProfessorDTO;
import model.*;


import java.sql.SQLException;
import java.util.List;

public interface ProfessorDAO {
    Professor getById(Integer id) throws SQLException;

    List<Professor> getAll() throws SQLException;

    Integer save(Professor professor) throws SQLException;

    void delete(Integer id) throws SQLException;

    void update(Professor professor) throws SQLException;

    ProfessorDTO getProfessorDTOwithFac(Integer professor_id) throws SQLException;

    ProfessorDTO getProfessorDTOwithOutFac(Integer professor_id) throws SQLException;


}
