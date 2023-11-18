package Tourism.Dao;

import Tourism.Helper.DBConnector;
import Tourism.Model.User;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    private final Connection connection;


    public UserDao() {
        this.connection = DBConnector.getInstance();
    }


    public ArrayList<User> findAll() {
        ArrayList<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM user";

        try {
            ResultSet rs = this.connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                userList.add(this.match(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public User findByLogin(String username, String password) {
        User obj = null;
        String query = "SELECT * FROM user WHERE user_uname = ? AND user_password = ?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                obj = this.match(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public User match(ResultSet rs) throws SQLException {
        User obj = new User();
        obj.setId(rs.getInt("user_id"));
        obj.setName(rs.getString("user_name"));
        obj.setUname(rs.getString("user_uname"));
        obj.setPassword(rs.getString("user_password"));
        obj.setType(rs.getString("user_type"));
        return obj;
    }
}
