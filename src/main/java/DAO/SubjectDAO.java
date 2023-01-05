package DAO;

import DTO.FacultyDTO;
import DTO.SubjectDTO;
import model.Subject;

import java.sql.SQLException;
import java.util.List;

public interface SubjectDAO {

    Subject getById(Integer id) throws SQLException;

    List<Subject> getAll() throws SQLException;

    void update(Subject subject) throws SQLException;

    Integer save(Subject subject) throws SQLException;

    void delete(Integer id) throws SQLException;

    SubjectDTO getSubjectDTOwithProf(Integer subject_id) throws SQLException;

    SubjectDTO getSubjectDTOwithOutProf(Integer subject_id) throws SQLException;

}
