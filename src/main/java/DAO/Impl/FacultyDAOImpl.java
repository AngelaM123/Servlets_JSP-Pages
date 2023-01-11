package DAO.Impl;

import DAO.FacultyDAO;
import DTO.FacultyDTO;
import Singleton.SingletonConnection;
import model.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacultyDAOImpl implements FacultyDAO {
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
    public Faculty getById(Integer id) throws SQLException {

        Faculty faculty = new Faculty();
        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sql = new StringBuilder("select * from faculty where id = ");
            sql.append(id);
            ResultSet resultSet = statement.executeQuery(sql.toString());
            //Faculty faculty = new Faculty();
            while (resultSet.next()) {
                //System.out.println(resultSet.getString("name"));
                faculty.setName(resultSet.getString("name"));
                faculty.setId(resultSet.getInt("id"));
                faculty.setLocation(resultSet.getString("location"));
                faculty.setStudy_field(resultSet.getString("study_field"));
            }
        } catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;

        }

        return faculty;
    }

    @Override
    public List<Faculty> getAll() throws SQLException {
        List<Faculty> facultyList = new ArrayList<>();
        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from faculty");
            while (rs.next()) {
                Faculty faculty = new Faculty();
                faculty.setName(rs.getString("name"));
                faculty.setId(rs.getInt("id"));
                faculty.setLocation(rs.getString("location"));
                faculty.setStudy_field(rs.getString("study_field"));
                facultyList.add(faculty);
            }
        } catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;

        }
        return facultyList;
    }

    @Override
    public void update(Faculty faculty) throws SQLException {
        try {
            String sql = "UPDATE faculty SET name=?, location=?, study_field=? WHERE id=?";
            PreparedStatement statement1 = connection.prepareStatement(sql);
            statement1.setString(1, faculty.getName());
            statement1.setString(2, faculty.getLocation());
            statement1.setInt(4, faculty.getId());
            statement1.setString(3, faculty.getStudy_field());

            int rowsUpdated = statement1.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing faculty was updated!");
            }

        } catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;

        }

    }

        //i need to make explenation like this one for every method

        /**
        * @param faculty
        * @return
        */


    @Override
    public Integer save(Faculty faculty) throws SQLException {

        Integer id = 0;
        try {
            String sql = "INSERT INTO faculty(name, location, study_field, univerzitet_id) VALUES (?, ?, ?, ?)";
            PreparedStatement statement1 = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement1.setString(1, faculty.getName());
            statement1.setString(2, faculty.getLocation());
            statement1.setString(3, faculty.getStudy_field());
            statement1.setInt(4, 1);

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
            System.out.println("Error " + e.getMessage());
            throw e;
        }
        return id;
    }

    @Override
    public void delete(Integer id_deleting) throws SQLException {
        try {
            String sql = "DELETE FROM faculty WHERE id=?";
            PreparedStatement statement1 = connection.prepareStatement(sql);
            statement1.setInt(1, id_deleting);

            int rowsUpdated = statement1.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("faculty with id " + id_deleting + " was deleted");
            }

        } catch (SQLException e) {
            System.out.println("Error during delete faculty " + e.getMessage());
            throw e;
        }
    }

    @Override
    public FacultyDTO getFacultyDTOwithUni(Integer faculty_id) throws SQLException {

        FacultyDTO facultyDTO = new FacultyDTO();

        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sql = new StringBuilder("SELECT u.id as uniId, u.name as uniName, f.* \n" +
                    "FROM education.university as u \n" +
                    "inner join education.faculty as f on f.university_id = u.id AND f.id = ");
            sql.append(faculty_id);
            ResultSet resultSet = statement.executeQuery(sql.toString());

            while (resultSet.next()) {

                facultyDTO.setId(resultSet.getInt("id"));
                facultyDTO.setName(resultSet.getString("name"));
                facultyDTO.setLocation(resultSet.getString("location"));
                facultyDTO.setStudy_field(resultSet.getString("study_field"));
                facultyDTO.setUniName(resultSet.getString("uniName"));
            }
        } catch (SQLException e) {
            System.out.println("Error in the method " + e.getMessage());
            throw e;
        }

        return facultyDTO;

    }

    @Override
    public FacultyDTO getFacultyDTOwithOutUni(Integer faculty_id) throws SQLException {

        FacultyDTO facultyDTO = new FacultyDTO();

        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sql = new StringBuilder("select * from faculty where id = ");
            sql.append(faculty_id);
            ResultSet resultSet = statement.executeQuery(sql.toString());

            while (resultSet.next()) {

                facultyDTO.setId(resultSet.getInt("id"));
                facultyDTO.setName(resultSet.getString("name"));
                facultyDTO.setLocation(resultSet.getString("location"));
                facultyDTO.setStudy_field(resultSet.getString("study_field"));

            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
            throw e;
        }

        return facultyDTO;

    }
}



