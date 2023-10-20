import java.sql.*;

public class DBConnect {
    public static void main(String[] args) {
        Connection connect = null;
        Statement st = null;
        String sql = "SELECT * FROM employees";
        String url = "jdbc:mysql://localhost/employees?user=root&password=mysql";
        try {
            connect = DriverManager.getConnection(url);
            st = connect.createStatement();
            ResultSet data = st.executeQuery(sql);

            System.out.println(" ---- Çalışan listesi: ----");
            while (data.next()) {
                System.out.println("ID: " + data.getInt("employee_id"));
                System.out.println("İsim: " + data.getString("employee_name"));
                System.out.println("Pozisyon: " + data.getString("employee_position"));
                System.out.println("Maaş: " + data.getDouble("employee_salary"));
                System.out.println("--------");
            }
        } catch (SQLException a) {
            System.out.println(a.getMessage());

        }


    }
}
