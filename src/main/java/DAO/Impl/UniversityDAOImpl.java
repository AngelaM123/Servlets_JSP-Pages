package DAO.Impl;

import DAO.UniversityDAO;
import DTO.FacultyDTO;
import DTO.UniversityDTO;
import Singleton.SingletonConnection;
import model.University;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversityDAOImpl implements UniversityDAO {

    static Connection connection;

    static {
        try {
            connection = SingletonConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public University getById(Integer id) throws SQLException {

        University university = new University();
        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sql = new StringBuilder("select * from university where id = ");

            sql.append(id);
            ResultSet resultSet = statement.executeQuery(sql.toString());

            while (resultSet.next()) {
                university.setName(resultSet.getString("name"));
                university.setId(resultSet.getInt("id"));
                university.setDescription(resultSet.getString("description"));

            }
        } catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;

        }
        return university;

    }

    @Override
    public List<University> getAll() throws SQLException {

        List<University> universityList = new ArrayList<>();
        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from university");
            while (rs.next()) {
                University university = new University();
                university.setName(rs.getString("name"));
                university.setId(rs.getInt("id"));
                university.setDescription(rs.getString("description"));

                universityList.add(university);
            }
        } catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;

        }
        return universityList;

    }

    @Override
    public void update(University university) throws SQLException {

        try {
            connection = SingletonConnection.getInstance().getConnection();

            String sql = "UPDATE university SET name=?,description=? WHERE id=?";
            PreparedStatement statement1 = connection.prepareStatement(sql);
            statement1.setString(1, university.getName());
            statement1.setString(2, university.getDescription());
            statement1.setInt(3, university.getId());


            int rowsUpdated = statement1.executeUpdate(sql);
            if (rowsUpdated > 0) {
                System.out.println("An existing university was updated");
            }

        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
            throw e;
        }

    }

    @Override
    public Integer save(University university) throws SQLException {

        Integer id = 0;

        try {
            String sql = "INSERT INTO university (name, description) VALUES (?, ?)";
            PreparedStatement statement1 = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement1.setString(1, university.getName());
            statement1.setString(2, university.getDescription());


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
            String sql = "DELETE FROM university WHERE id=?";
            PreparedStatement statement1 = connection.prepareStatement(sql);
            statement1.setInt(1, id_deleting);

            int rowsUpdated = statement1.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("university with id " + id_deleting + " was deleted");
            }

        } catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;

        }

    }

    @Override
    public boolean cascadeUniFaxCheck(Integer uni_id_check) throws SQLException {
        try {
            String sql = "SELECT * FROM obrazovanie.faculty WHERE faculty.university_id = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql);
            statement1.setInt(1, uni_id_check);

            int rowsReturned = statement1.executeUpdate();
            if (rowsReturned == 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;
        }

    }

    @Override
    public UniversityDTO getUniversityDTOwithFac(Integer uni_id) throws SQLException {

        UniversityDTO universityDTO = new UniversityDTO();

        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sql = new StringBuilder("SELECT f.id as facId, f.ime as uniName, u.* \n" +
                    "FROM education.faculty as f \n" +
                    "inner join education.university as u on u.university_id = f.id AND u.id = ");

            sql.append(uni_id);
            ResultSet resultSet = statement.executeQuery(sql.toString());

            while (resultSet.next()) {

                universityDTO.setId(resultSet.getInt("id"));
                universityDTO.setName(resultSet.getString("name"));
                universityDTO.setDescription(resultSet.getString("description"));
            }
        }catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;

        }

        return universityDTO;
    }

    @Override
    public UniversityDTO getUniversityDTOwithOutFac(Integer uni_id) throws SQLException {

        UniversityDTO facultyDTO = new UniversityDTO();

        try {
            connection = SingletonConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sql = new StringBuilder("select * from university where id = ");
            sql.append(uni_id);
            ResultSet resultSet = statement.executeQuery(sql.toString());

            while (resultSet.next()) {

                facultyDTO.setId(resultSet.getInt("id"));
                facultyDTO.setName(resultSet.getString("name"));
                facultyDTO.setDescription(resultSet.getString("description"));

            }
        } catch (SQLException e) {
            System.out.println("error occured " + e.getMessage());
            throw e;

        }

        return facultyDTO;

    }
}




