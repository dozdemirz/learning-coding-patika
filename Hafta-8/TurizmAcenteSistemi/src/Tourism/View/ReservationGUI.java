package Tourism.View;

import Tourism.Helper.DBConnector;
import Tourism.Helper.Helper;
import Tourism.Model.Reservation;
import Tourism.Model.Term;
import Tourism.Model.User;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservationGUI extends JFrame {
    private JLabel fld_contact;
    private JTextField fld_name;
    private JTextField fld_phone;
    private JTextField fld_mail;
    private JPanel wrapper;
    private JTextField fld_adult;
    private JTextField fld_children;
    private JFormattedTextField fld_start_date;
    private JFormattedTextField fld_end_date;
    private JButton btn_reservation;
    private JTextField fld_total_price;
    private JTextField fld_info;
    private JLabel lbl_info;
    Connection connection;
    int termID;
    User user;


    public ReservationGUI(int termID) {

        add(wrapper);
        setSize(700, 400);
        setTitle("Çalışan Paneli");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.connection = DBConnector.getInstance();
        this.termID = termID;
        setVisible(true);
        int x = Helper.screenCenter("x", this.getSize());
        int y = Helper.screenCenter("y", this.getSize());
        setLocation(x, y);

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                EmployeeGUI employeeGUI = new EmployeeGUI(user);

            }
        });

        btn_reservation.addActionListener(e -> {
            addReservation();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startDate = dateFormat.parse(fld_start_date.getText());
                Date endDate = dateFormat.parse(fld_end_date.getText());
                if (endDate.before(startDate)){
                    Helper.showMsg("Rezervasyon çıkış tarihi giriş tarihinden önce olamaz!");
                }
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
            EmployeeGUI employeeGUI = new EmployeeGUI(new User());

        });


        Term term = Term.getTermBYTermID(termID);
        fld_info.setText(term.getTermStartDate().toString() + " / " + term.getTermEndDate().toString());

        fld_adult.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePriceByNumber();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePriceByNumber();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePriceByNumber();
            }
        });

        fld_children.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePriceByNumber();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePriceByNumber();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePriceByNumber();
            }
        });
        fld_start_date.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePriceByDate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePriceByDate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePriceByDate();
            }
        });

        fld_end_date.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePriceByDate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePriceByDate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePriceByDate();
            }
        });

    }

    public void addReservation() {
        try {
            if (Helper.isFieldEmpty(fld_adult) || Helper.isFieldEmpty(fld_start_date) || Helper.isFieldEmpty(fld_end_date) || Helper.isFieldEmpty(fld_name) || Helper.isFieldEmpty(fld_phone) || Helper.isFieldEmpty(fld_mail)) {
                Helper.showMsg("fill");
                return;
            }

            int adultCount = 0;
            int childCount = 0;
            if (!fld_adult.getText().isEmpty()) {
                adultCount = Integer.parseInt(fld_adult.getText());
            }
            if (!fld_children.getText().isEmpty()) {
                childCount = Integer.parseInt(fld_children.getText());
            }

            if (Integer.parseInt(fld_adult.getText()) <= 0) {
                Helper.showMsg("Yetişkin olmadan rezervasyon yapılamaz.");
                return;
            }

            Term term = Term.getTermBYTermID(termID);

            if (!isDateFieldsValid()) {
                return;
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = dateFormat.parse(fld_start_date.getText());
            Date endDate = dateFormat.parse(fld_end_date.getText());

            if (endDate.before(startDate)) {
                Helper.showMsg("Bitiş tarihi, başlangıç tarihinden önce olamaz.");
                return;
            }

            long dayCount = calculateDayCount(startDate, endDate);

            double customerPrice = (adultCount * term.getAdultPrice()) + (childCount * term.getChildrenPrice());
            customerPrice *= dayCount;

            if (Reservation.add(fld_name.getText(), fld_phone.getText(), fld_mail.getText(), adultCount + childCount, new java.sql.Date(startDate.getTime()), new java.sql.Date(endDate.getTime()), customerPrice, termID)) {
                Helper.showMsg("done");
            }

            setVisible(false);
        } catch (ParseException ex) {
            Helper.showMsg("Tarih biçimi hatalı.");
        }
    }

    private boolean isDateFieldsValid() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


            String startDateStr = fld_start_date.getText();
            String endDateStr = fld_end_date.getText();

            if (startDateStr.isEmpty() || endDateStr.isEmpty()) {

                return false;
            }

            Date startDate = dateFormat.parse(startDateStr);
            Date endDate = dateFormat.parse(endDateStr);


            if (endDate.before(startDate)) {
                return false;
            }

            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private long calculateDayCount(Date startDate, Date endDate) {
        long diff = endDate.getTime() - startDate.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
    }

    private void updatePriceByNumber() {
        try {
            int adultCount = 0;
            int childCount = 0;

            if (!fld_adult.getText().isEmpty()) {
                adultCount = Integer.parseInt(fld_adult.getText());
            }

            if (!fld_children.getText().isEmpty()) {
                childCount = Integer.parseInt(fld_children.getText());
            }

            Term term = Term.getTermBYTermID(termID);
            double customerPrice = (adultCount * term.getAdultPrice()) + (childCount * term.getChildrenPrice());
            String formattedPrice = String.format("%.2f", customerPrice);
            fld_total_price.setText(formattedPrice);
        } catch (NumberFormatException ex) {
            fld_total_price.setText("");
        }
    }

    private void updatePriceByDate() {
        try {
            if (!isDateFieldsValid()) {
                return;
            }

            int adultCount = 0;
            int childCount = 0;

            if (!fld_adult.getText().isEmpty()) {
                adultCount = Integer.parseInt(fld_adult.getText());
            }

            if (!fld_children.getText().isEmpty()) {
                childCount = Integer.parseInt(fld_children.getText());
            }

            Term term = Term.getTermBYTermID(termID);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = dateFormat.parse(fld_start_date.getText());
            Date endDate = dateFormat.parse(fld_end_date.getText());

            long dayCount = calculateDayCount(startDate, endDate);

            double customerPrice = (adultCount * term.getAdultPrice()) + (childCount * term.getChildrenPrice());
            customerPrice *= dayCount;

            String formattedPrice = String.format("%.2f", customerPrice);
            fld_total_price.setText(formattedPrice);
        } catch (NumberFormatException | ParseException ex) {
            fld_total_price.setText("");
        }
    }



}
