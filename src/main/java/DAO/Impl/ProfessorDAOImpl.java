package DAO.Impl;

import DAO.ProfessorDAO;
import DTO.FacultyDTO;
import DTO.ProfessorDTO;
import Singleton.SingletonConnection;
import model.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfessorDAOImpl implements ProfessorDAO {

    static Connection connection;

    static {
        try {
            connection = SingletonConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Professor getById(Integer id) throws SQLException {

        Professor professor = new Professor();
        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sql = new StringBuilder("select * from professor where id = ");
            sql.append(id);
            ResultSet resultSet = statement.executeQuery(sql.toString());

            while (resultSet.next()) {
                professor.setName(resultSet.getString("name"));
                professor.setId(resultSet.getInt("id"));
                professor.setSurname(resultSet.getString("surname"));
                professor.setPrimary_subject1(resultSet.getString("primary_subject1"));
                professor.setPrimary_subject2(resultSet.getString("primary_subject2"));
                professor.setAge(resultSet.getInt("age"));

            }
        } catch (SQLException e) {
            System.out.println("error");
            throw e;
        }
        return professor;
    }

    @Override
    public List<Professor> getAll() throws SQLException {

        List<Professor> professorList = new ArrayList<>();
        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from professor");
            while (rs.next()) {
                Professor professor = new Professor();
                professor.setName(rs.getString("name"));
                professor.setSurname(rs.getString("surname"));
                professor.setId(rs.getInt("id"));
                professor.setAge(rs.getInt("age"));
                professor.setPrimary_subject1(rs.getString("primary_subject1"));
                professor.setPrimary_subject2(rs.getString("primary_subject2"));
                professorList.add(professor);
            }
        } catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;
        }
        return professorList;

    }

    @Override
    public Integer save(Professor professor) throws SQLException {

        Integer id = 0;

        try {
            String sql = "INSERT INTO profesor (name, surname, primary_subject1, " +
                    "primary_subject2, age, profesor_fakultet) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement1 = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement1.setString(1, professor.getName());
            statement1.setString(2, professor.getSurname());
            statement1.setString(3, professor.getPrimary_subject1());
            statement1.setString(4, professor.getPrimary_subject2());
            statement1.setInt(5, professor.getAge());
            statement1.setInt(6, 1);

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
            System.out.println("error");
            throw e;
        }

        return id;
    }

    @Override
    public void update(Professor professor) throws SQLException {

        try {
            String sql = "UPDATE profesor  SET name=?, surname=?, primary_subject1=?, primary_subject2 =?, age =? WHERE id=?";
            PreparedStatement statement1 = connection.prepareStatement(sql);
            statement1.setString(1, professor.getName());
            statement1.setString(2, professor.getSurname());
            statement1.setString(3, professor.getPrimary_subject1());
            statement1.setString(4, professor.getPrimary_subject2());
            statement1.setInt(5, professor.getAge());
            statement1.setInt(6, professor.getId());

            int rowsUpdated = statement1.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing professor was updated");
            }

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
            throw e;
        }
    }

    @Override
    public ProfessorDTO getProfessorDTOwithFac(Integer professor_id) throws SQLException {
        ProfessorDTO professorDTO = new ProfessorDTO();

        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();

            StringBuilder sql = new StringBuilder("SELECT p.id as profId, p.name as prfName, f.* \n" +
                    "FROM education.professor as p \n" +
                    "inner join education.professor as f on f.faculty_id = p.id AND f.id = ");
            sql.append(professor_id);
            ResultSet resultSet = statement.executeQuery(sql.toString());

            while (resultSet.next()) {

                professorDTO.setId(resultSet.getInt("id"));
                professorDTO.setName(resultSet.getString("name"));
                professorDTO.setSurname(resultSet.getString("surname"));
                professorDTO.setAge(resultSet.getInt("age"));
                professorDTO.setPrimary_subject1(resultSet.getString("primary_subject1"));
                professorDTO.setPrimary_subject2(resultSet.getString("primary_subject2"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException in getFacultyDTOwithUniv" + e.getMessage());
            throw e;
        }
        return professorDTO;
    }

    @Override
    public ProfessorDTO getProfessorDTOwithOutFac(Integer professor_id) throws SQLException {
        ProfessorDTO professorDTO = new ProfessorDTO();

        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sql = new StringBuilder("select * from professor where id = ");
            sql.append(professor_id);
            ResultSet resultSet = statement.executeQuery(sql.toString());

            while (resultSet.next()) {

                professorDTO.setId(resultSet.getInt("id"));
                professorDTO.setName(resultSet.getString("name"));
                professorDTO.setSurname(resultSet.getString("surname"));
                professorDTO.setAge(resultSet.getInt("age"));
                professorDTO.setPrimary_subject1(resultSet.getString("primary_subject1"));
                professorDTO.setPrimary_subject2(resultSet.getString("primary_subject2"));

            }
        } catch (SQLException e) {
            System.out.println("SQLException in getProfessorDTOwithOutFac" + e.getMessage());
            throw e;
        }

        return professorDTO;
    }

    @Override
    public void delete(Integer id_deleting) throws SQLException {

        try {
            String sql = "DELETE FROM profesor WHERE id=?";
            PreparedStatement statement1 = connection.prepareStatement(sql);
            statement1.setInt(1, id_deleting);

            int rowsUpdated = statement1.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("professor with id " + id_deleting + " was deleted");
            }

        } catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;

        }
    }


}


