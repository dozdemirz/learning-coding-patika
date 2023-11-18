package Tourism.View;

import Tourism.Helper.Helper;
import Tourism.Model.Term;
import Tourism.Model.User;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PriceSetGUI extends JFrame {
    private JTextField fld_adult_price;
    private JTextField fld_child_price;
    private JFormattedTextField fld_start_date;
    private JFormattedTextField fld_end_date;
    private JButton ekleButton;
    private JComboBox cmb_board_type;
    private JPanel wrapper;
    int roomID;
    Term term;
    User user;

    public PriceSetGUI(int id) {
        roomID = id;
        this.add(wrapper);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Oda Fiyatlandırma");
        this.setSize(400, 400);
        int x = Helper.screenCenter("x", this.getSize());
        int y = Helper.screenCenter("y", this.getSize());
        setLocation(x, y);
        this.setVisible(true);
        addPriceListeners();
        ekleButton.addActionListener(e -> {
            addPrice();
            AddRoomGUI addRoomGUI = new AddRoomGUI(roomID, true);
        });

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                EmployeeGUI employeeGUI = new EmployeeGUI(user);

            }
        });
    }


    public void addPrice() {
        String roomBoardType = cmb_board_type.getSelectedItem().toString();
        String adultPriceStr = fld_adult_price.getText();
        String childrenPriceStr = fld_child_price.getText();
        String startDateStr = fld_start_date.getText();
        String endDateStr = fld_end_date.getText();

        // Boş değerleri kontrol et
        if (roomBoardType.isEmpty() || adultPriceStr.isEmpty() || childrenPriceStr.isEmpty() || startDateStr.isEmpty() || endDateStr.isEmpty()) {
            Helper.showMsg("Tüm alanları doldurmalısınız.");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate;
        Date endDate;
        try {
            startDate = (Date) dateFormat.parse(startDateStr);
            endDate = (Date) dateFormat.parse(endDateStr);
        } catch (ParseException e) {
            Helper.showMsg("Tarih biçimi hatalı.");
            return;
        }

        int roomID = this.roomID;

        // Tarihleri java.sql.Date türüne çevir
        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

        if (Term.addTermToDatabase(roomBoardType, sqlStartDate, sqlEndDate, Double.parseDouble(adultPriceStr), Double.parseDouble(childrenPriceStr), roomID)) {
            Helper.showMsg("done");
        }
        setVisible(false);
    }

    private void addPriceListeners() {
        fld_adult_price.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateChildPrice();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateChildPrice();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateChildPrice();
            }

            private void updateChildPrice() {
                try {
                    String adultPriceText = fld_adult_price.getText();
                    // Virgülü noktaya çevir
                    double adultPrice = Double.parseDouble(adultPriceText);
                    double childPrice = adultPrice * 0.8;
                    String formattedChildPrice = String.format("%.2f", childPrice);
                    formattedChildPrice = formattedChildPrice.replace(',', '.');
                    fld_child_price.setText(formattedChildPrice);


                } catch (NumberFormatException ex) {
                    fld_child_price.setText("");
                }
            }
        });
    }




}
