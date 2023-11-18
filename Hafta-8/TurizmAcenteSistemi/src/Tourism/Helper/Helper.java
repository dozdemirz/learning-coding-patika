package Tourism.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();

    }

    public static void showMsg(String str) {
        optionPageTR();
        String msg;
        String title;
        switch (str) {
            case "fill":
                msg = "Lütfen tüm alanları doldurunuz!";
                title = "Hata";
                break;
            case "done":
                msg = "İşlem başarılı!";
                title = "Sonuç";
                break;
            case "error":
                msg = "Bir hata oluştu";
                title = "Hata";
                break;
            default:
                msg = str;
                title = "Mesaj";
                break;
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void optionPageTR() {
        UIManager.put("OptionPane.okButtonText", "Tamam");
    }

    public static int screenCenter(String axis, Dimension size) {
        int point = 0;
        switch (axis) {
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;

        }
        return point;

    }
}


