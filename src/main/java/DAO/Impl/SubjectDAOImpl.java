package DAO.Impl;

import DAO.SubjectDAO;
import DTO.FacultyDTO;
import DTO.SubjectDTO;
import Singleton.SingletonConnection;
import model.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {

    // Connection connection = null;
    static Connection connection;

    static {
        try {
            connection = SingletonConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Subject getById(Integer id) throws SQLException {

        Subject subject = new Subject();
        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sql = new StringBuilder("select * from subject where id = ");
            sql.append(id);
            ResultSet resultSet = statement.executeQuery(sql.toString());

            while (resultSet.next()) {
                subject.setId(resultSet.getInt("id"));
                subject.setName(resultSet.getString("name"));
                subject.setSemester(resultSet.getString("semester"));
                subject.setCredits(resultSet.getInt("credits"));

            }
        } catch (SQLException e) {
            System.out.println("error " + e.getMessage());
            throw e;
        }
        return subject;

    }

    @Override
    public List<Subject> getAll() throws SQLException {

        List<Subject> subjectList = new ArrayList<>();
        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from subject");
            while (rs.next()) {
                Subject subject = new Subject();

                subject.setId(rs.getInt("id"));
                subject.setName(rs.getString("name"));
                subject.setSemester(rs.getString("semester"));
                subject.setCredits(rs.getInt("credits"));
                subjectList.add(subject);
            }
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
            throw e;
        }
        return subjectList;

    }

    @Override
    public void update(Subject subject) throws SQLException {

        try {
            String sql = "UPDATE predmet SET name=?, semester=?, credits=? WHERE id=?";
            PreparedStatement statement1 = connection.prepareStatement(sql);
            statement1.setString(1, subject.getName());
            statement1.setString(2, subject.getSemester());
            statement1.setInt(3, subject.getCredits());
            statement1.setInt(4, subject.getId());


            int rowsUpdated = statement1.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing subject was updated");
            }

        } catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;
        }

    }

    @Override
    public Integer save(Subject subject) throws SQLException {
        Integer id = 0;

        try {
            String sql = "INSERT INTO subject (name, semester, credits) VALUES (?, ?, ?)";
            PreparedStatement statement1 = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement1.setString(1, subject.getName());
            statement1.setString(2, subject.getSemester());
            statement1.setInt(3, subject.getCredits());
            //statement1.setInt(4, subject.getProfessor().getId());

            int affectedRows = statement1.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("error");
            }

            try (ResultSet generatedKeys = statement1.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("error2");
                }
            }
        } catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;

        }

        return id;

    }

    @Override
    public void delete(Integer id_deleting) throws SQLException {
        try {
            String sql = "DELETE FROM subject WHERE id=?";
            PreparedStatement statement1 = connection.prepareStatement(sql);
            statement1.setInt(1, id_deleting);

            int rowsUpdated = statement1.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("subject with id " + id_deleting + " was deleted");
            }

        } catch (SQLException e) {
            System.out.println("error happened in delete " + e.getMessage());
            throw e;
        }

    }

    @Override
    public SubjectDTO getSubjectDTOwithProf(Integer subject_id) throws SQLException {

        SubjectDTO subjectDTO = new SubjectDTO();

        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sql = new StringBuilder("SELECT p.id as profId, p.name as profName, f.* \n" +
                    "FROM education.professor as p \n" +
                    "inner join education.subject as f on f.subject_id = u.id AND f.id = ");
            sql.append(subject_id);
            ResultSet resultSet = statement.executeQuery(sql.toString());

            while (resultSet.next()) {

                subjectDTO.setId(resultSet.getInt("id"));
                subjectDTO.setName(resultSet.getString("name"));
                subjectDTO.setCredits(resultSet.getInt("credits"));
                subjectDTO.setSemester(resultSet.getString("semester"));
                subjectDTO.setProfName(resultSet.getString("profName"));
            }
        } catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;

        }

        return subjectDTO;

    }

    @Override
    public SubjectDTO getSubjectDTOwithOutProf(Integer subject_id) throws SQLException {

        SubjectDTO subjectDTO = new SubjectDTO();

        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sql = new StringBuilder("select * from subject where id = ");
            sql.append(subject_id);
            ResultSet resultSet = statement.executeQuery(sql.toString());

            while (resultSet.next()) {

                subjectDTO.setId(resultSet.getInt("id"));
                subjectDTO.setName(resultSet.getString("name"));
                subjectDTO.setCredits(resultSet.getInt("credits"));
                subjectDTO.setSemester(resultSet.getString("semester"));

            }
        } catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;

        }

        return subjectDTO;

    }

}
