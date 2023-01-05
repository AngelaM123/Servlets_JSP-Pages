package Singleton;

import model.Professor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestSingleton {
    Connection conn = null;
    Statement stmt = null;

    public void getData() {
        try {
            conn = SingletonConnection.getInstance().getConnection();

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from profesor");

            while (rs.next()) {
                System.out.println("id:" + rs.getInt("id"));
                System.out.println("name:" + rs.getString("name"));

            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void getData1() {
        try {
            conn = SingletonConnection.getInstance().getConnection();

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from profesor");

            while (rs.next()) {
                System.out.println("id:" + rs.getInt("id"));
                System.out.println("name:" + rs.getString("name"));

            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) throws SQLException {

        TestSingleton testObject = new TestSingleton();
        testObject.getData();
        testObject.getData1();

    }
}
