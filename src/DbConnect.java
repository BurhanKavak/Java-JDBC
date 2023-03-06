import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

    private String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    private String user = "root";
    private String password = "kajmer5858";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public void showErrorMessage(SQLException exception)  {
        System.out.println("Hata mesaji : " + exception.getMessage());
    }
}
