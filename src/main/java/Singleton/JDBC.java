package Singleton;

import model.Professor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBC {
    public static void main(String[] args) {

        List<Professor> professorList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/education", "root", "AngjelaWork123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from professor ");

            while (resultSet.next()) {
                Professor professor = new Professor();
                System.out.println(resultSet.getString("name"));
                professor.setName(resultSet.getString("name"));
                professor.setId(resultSet.getInt("id"));
                professor.setAge(resultSet.getInt("age"));
                professor.setSurname(resultSet.getString("surname"));
                professor.setPrimary_subject1(resultSet.getString("primary_subject1"));
                professor.setPrimary_subject2(resultSet.getString("primary_subject2"));

                professorList.add(professor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < professorList.size(); i++) {
            System.out.println("Professor id is " + professorList.get(i).getId() + " name is " + professorList.get(i).getName());
        }
    }
}

