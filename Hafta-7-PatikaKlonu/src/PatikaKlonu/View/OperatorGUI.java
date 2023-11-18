package PatikaKlonu.View;

import PatikaKlonu.Helper.Config;
import PatikaKlonu.Helper.DbConnector;
import PatikaKlonu.Helper.Helper;
import PatikaKlonu.Model.Operator;
import PatikaKlonu.Model.Patika;
import PatikaKlonu.Model.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OperatorGUI extends JFrame {

    private final Operator operator;

    private JPanel wrapper;
    private JTabbedPane pnl_patika;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_userList;
    private JScrollPane scrl_userlist;
    private JTable tbl_userlist;
    private JPanel pnl_userform;
    private JTextField fld_username;
    private JTextField fld_uname;
    private JPasswordField fld_userpassword;
    private JComboBox cmb_usertype;
    private JButton btn_user_add;
    private JTextField fld_user_id;
    private JButton btn_user_delete;
    private JTextField fld_sh_username;
    private JTextField fld_sh_name;
    private JComboBox cmb_sh_usertype;
    private JButton btn_user_sh;
    private JScrollPane scrl_patika;
    private JTable tbl_patika;
    private DefaultTableModel mdl_userlist;
    private Object[] row_userlist;

    private DefaultTableModel mdl_patika;
    private Object[] row_patika;

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

        //ModelUserList
        mdl_userlist = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_userlist = {"ID", "Ad Soyad", "Kullanıcı Adı", "Şifre", "Üyelik Tipi"};
        mdl_userlist.setColumnIdentifiers(col_userlist);

        row_userlist = new Object[col_userlist.length];
        loadUserModel();


        tbl_userlist.setModel(mdl_userlist);
        tbl_userlist.getTableHeader().setReorderingAllowed(false);


        tbl_userlist.getSelectionModel().addListSelectionListener(e -> {
            try {
                String selectedRow = tbl_userlist.getValueAt(tbl_userlist.getSelectedRow(), 0).toString();
                fld_user_id.setText(selectedRow);
            } catch (Exception a) {

            }

        });

        tbl_userlist.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int user_id = Integer.parseInt(tbl_userlist.getValueAt(tbl_userlist.getSelectedRow(), 0).toString());
                String user_name = tbl_userlist.getValueAt(tbl_userlist.getSelectedRow(), 1).toString();
                String user_uname = tbl_userlist.getValueAt(tbl_userlist.getSelectedRow(), 2).toString();
                String user_password = tbl_userlist.getValueAt(tbl_userlist.getSelectedRow(), 3).toString();
                String user_type = tbl_userlist.getValueAt(tbl_userlist.getSelectedRow(), 4).toString();

                if (User.update(user_id, user_name, user_uname, user_password, user_type)) {
                    Helper.showMsg("done");
                }
                loadUserModel();
            }
        });


        //Patika List
        mdl_patika = new DefaultTableModel();
        Object[] col_patika = {"ID", "Patika Adı"};
        mdl_patika.setColumnIdentifiers(col_patika);
        row_patika = new Object[col_patika.length];
        loadPatikaModel();

        tbl_patika.setModel(mdl_patika);
        tbl_patika.getTableHeader().setReorderingAllowed(false);
        tbl_patika.getColumnModel().getColumn(0).setMaxWidth(75);


        btn_user_add.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_username) || Helper.isFieldEmpty(fld_uname) || Helper.isFieldEmpty(fld_userpassword)) {
                Helper.showMsg("fill");
            } else {
                String name = fld_username.getText();
                String uname = fld_uname.getText();
                String password = fld_userpassword.getText();
                String type = cmb_usertype.getSelectedItem().toString();

                if (User.add(name, uname, password, type)) {
                    Helper.showMsg("done");
                    loadUserModel();

                    fld_username.setText(null);
                    fld_uname.setText(null);
                    fld_userpassword.setText(null);
                }

            }
        });
        btn_user_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_user_id)) {
                    Helper.showMsg("fill");
                } else {
                    int user_id = Integer.parseInt(fld_user_id.getText());
                    if (User.delete(user_id)) {
                        Helper.showMsg("done");
                        loadUserModel();
                    } else {
                        Helper.showMsg("error");
                    }
                }
            }
        });
        btn_user_sh.addActionListener(e -> {
            String name = fld_sh_username.getText();
            String uname = fld_sh_name.getText();
            String type = cmb_sh_usertype.getSelectedItem().toString();

            String query = User.searchQuery(name, uname, type);
            ArrayList<User> filter = User.searchUserList(query);
            loadUserModel(filter);
        });
        btn_logout.addActionListener(e -> {
            dispose();
        });
    }

    private void loadPatikaModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patika.getModel();
        clearModel.setRowCount(0);

        int i = 0;
        for (Patika obj : Patika.getList()) {
            row_patika[i++] = obj.getId();
            row_patika[i++] = obj.getName();
            mdl_patika.addRow(row_patika);
        }
    }

    public void loadUserModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_userlist.getModel();
        clearModel.setRowCount(0);


        for (User obj : User.getList()) {
            int i = 0;
            row_userlist[i++] = obj.getId();
            row_userlist[i++] = obj.getName();
            row_userlist[i++] = obj.getUname();
            row_userlist[i++] = obj.getPassword();
            row_userlist[i++] = obj.getType();

            mdl_userlist.addRow(row_userlist);
        }
    }


    public void loadUserModel(ArrayList<User> list) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_userlist.getModel();
        clearModel.setRowCount(0);


        for (User obj : list) {
            int i = 0;
            row_userlist[i++] = obj.getId();
            row_userlist[i++] = obj.getName();
            row_userlist[i++] = obj.getUname();
            row_userlist[i++] = obj.getPassword();
            row_userlist[i++] = obj.getType();

            mdl_userlist.addRow(row_userlist);
        }
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

        DbConnector.getInstance();

    }
}
