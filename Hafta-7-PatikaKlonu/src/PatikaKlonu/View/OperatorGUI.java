package com.PatikaKlonu.View;

import com.PatikaKlonu.Helper.Config;
import com.PatikaKlonu.Helper.Helper;
import com.PatikaKlonu.Model.Operator;

import javax.swing.*;

public class OperatorGUI extends JFrame {

    private final Operator operator;

    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_userList;

    public OperatorGUI(Operator operator) {
        this.operator = operator;

        add(wrapper);
        setSize(1000, 500);
        setTitle(Config.PROJECT_TITLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        int x = Helper.screenCenter("x", getSize());
        int y = Helper.screenCenter("y", getSize());
        setLocation(x, y);
        setVisible(true);


        lbl_welcome.setText("Hoşgeldin " + operator.getName());
    }

    public static void main(String[] args) {
        Helper.setLayout();
        Operator op = new Operator();
        op.setId(1);
        op.setName("Dilan");
        op.setPassword("1234");
        op.setType("operator");
        op.setUname("dilan");
        OperatorGUI opGUI = new OperatorGUI(op);
    }
}
