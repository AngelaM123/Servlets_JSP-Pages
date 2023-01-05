package DAO;

import DTO.FacultyDTO;
import DTO.UniversityDTO;
import model.University;

import java.sql.SQLException;
import java.util.List;

public interface UniversityDAO {

    University getById(Integer id) throws SQLException;

    List<University> getAll() throws SQLException;

    void update(University university) throws SQLException;

    Integer save(University university) throws SQLException;

    void delete(Integer id) throws SQLException;

    boolean cascadeUniFaxCheck(Integer uni_id_check) throws SQLException;

    UniversityDTO getUniversityDTOwithFac(Integer uni_id) throws SQLException;

    UniversityDTO getUniversityDTOwithOutFac(Integer uni_id) throws SQLException;
}
