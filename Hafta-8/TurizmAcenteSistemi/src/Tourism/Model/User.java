package Tourism.Model;

import Tourism.Helper.DBConnector;
import Tourism.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String uname;
    private String password;
    private String type;

    public User(){

    }

    public User(int id, String name, String uname, String password, String type) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.password = password;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public static ArrayList<User> getList() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";
        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("user_id"));
                obj.setName(rs.getString("user_name"));
                obj.setUname(rs.getString("user_uname"));
                obj.setPassword(rs.getString("user_password"));
                obj.setType(rs.getString("user_type"));
                userList.add(obj);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public static String searchQuery(String name, String uname, String type) {
        String query = "SELECT * FROM user WHERE user_name LIKE '%{{user_name}}%' AND user_uname LIKE '%{{user_uname}}%'";
        query = query.replace("{{user_uname}}", uname);
        query = query.replace("{{user_name}}", name);

        if (!type.isEmpty()) {
            query += " AND user_type = '{{user_type}}' ";
            query = query.replace("{{user_type}}", type);
        }
        return query;
    }

    public static ArrayList<User> searchUserList(String query){
        ArrayList<User> userList = new ArrayList<>();
        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("user_id"));
                obj.setName(rs.getString("user_name"));
                obj.setUname(rs.getString("user_uname"));
                obj.setPassword(rs.getString("user_password"));
                obj.setType(rs.getString("user_type"));
                userList.add(obj);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static boolean add(String name, String uname, String password, String type) {
        String query = "INSERT INTO user (user_name, user_uname, user_password, user_type) VALUES (?, ?, ?, ?)";

        User findUser = getFetch(uname);
        if (findUser != null) {
            Helper.showMsg("Bu kullanıcı daha önce eklenmiş. Lütfen farklı bir kullanıcı adı giriniz.");
            return false;
        }

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, uname);
            pr.setString(3, password);
            pr.setString(4, type);

            int response = pr.executeUpdate();
            if (response == -1) {
                Helper.showMsg("error");
            }
            return response != -1;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static User getFetch(String uname) {
        User obj = null;
        String query = "SELECT * FROM user WHERE user_uname = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, uname);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("user_id"));
                obj.setName(rs.getString("user_name"));
                obj.setUname(rs.getString("user_uname"));
                obj.setPassword(rs.getString("user_password"));
                obj.setType(rs.getString("user_type"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;

    }

    public static boolean delete(int id) {
        String query = "DELETE FROM user WHERE user_id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean update(int id, String name, String uname, String password, String type) {
        String query = "UPDATE user SET user_name=?, user_uname=?, user_password=?, user_type=? WHERE user_id=?";
        User findUser = getFetch(uname);
        if (findUser != null && findUser.getId() != id) {
            Helper.showMsg("Bu kullanıcı daha önce eklenmiş. Lütfen farklı bir kullanıcı adı giriniz.");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, uname);
            pr.setString(3, password);
            pr.setString(4, type);
            pr.setInt(5, id);
            return pr.executeUpdate() != -1;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}
