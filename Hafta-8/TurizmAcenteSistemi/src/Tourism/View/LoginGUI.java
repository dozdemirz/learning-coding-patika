package Tourism.View;

import Tourism.Helper.Helper;
import Tourism.Manager.UserManager;
import Tourism.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField fld_login_uname;
    private JPasswordField fld_login_password;
    private JButton btn_login;
    private JPanel wrapper;
    private UserManager userManager;


    public LoginGUI() {
        this.userManager = new UserManager();
        add(wrapper);
        setSize(300, 250);
        setTitle("Giriş");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x = Helper.screenCenter("x", this.getSize());
        int y = Helper.screenCenter("y", this.getSize());
        setLocation(x, y);

        setVisible(true);


        btn_login.addActionListener(e -> {

            if (Helper.isFieldEmpty(this.fld_login_uname) || Helper.isFieldEmpty(this.fld_login_password)) {
                Helper.showMsg("fill");
            } else {
                User loginUser = this.userManager.findByLogin(this.fld_login_uname.getText(), this.fld_login_password.getText());
                if (loginUser == null) {
                    Helper.showMsg("Kullanıcı Bulunamadı!");
                }else {
                    if ("admin".equals(loginUser.getType())){
                        AdminGUI adminGUI = new AdminGUI(loginUser);
                        dispose();
                    }else {
                        EmployeeGUI employeeGUI = new EmployeeGUI(loginUser);
                        dispose();
                    }

                }
            }


        });
    }


}