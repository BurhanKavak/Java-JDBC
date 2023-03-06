

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        DbConnect dbConnect = new DbConnect();
        Statement statement = null;
        ResultSet resultset;

        try {

            connection = dbConnect.getConnection();
            statement = connection.createStatement();
            resultset = statement.executeQuery("SELECT * FROM student");
            ArrayList<Student> students = new ArrayList<>();

            while (resultset.next()) {
                students.add(new Student(resultset.getInt(1),
                        resultset.getString("firstName")));
            }

            System.out.println("Veritabanindaki eleman sayisi = " + students.size());

            for (Student student : students) {

                System.out.println(student.getFirstName());
            }

        } catch (SQLException e) {
            dbConnect.showErrorMessage(e);
        } finally {
            connection.close();
        }

    }
}