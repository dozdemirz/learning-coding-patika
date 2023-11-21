package PatikaKlonu.View;

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wbot;
    private JPanel wtop;
    private JTextField fld_username;
    private JPasswordField fld_password;
    private JButton btn_login;

    public LoginGUI() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        this.add(wrapper);
        setSize(400, 300);
        setTitle("Patika Klonu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2;
        setLocation(x, y);
        setVisible(true);
        btn_login.addActionListener(e -> {
            if (fld_username.getText().isEmpty() || fld_password.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tüm alanları doldurunuz!", "Hata", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

}
