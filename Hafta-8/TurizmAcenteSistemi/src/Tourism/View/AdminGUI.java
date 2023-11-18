package Tourism.View;

import Tourism.Helper.Helper;
import Tourism.Model.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AdminGUI extends JFrame {
    private JButton btn_logout;
    private JPanel pnl_top;
    private JTable tbl_userlist;
    private JTextField fld_search_name;
    private JTextField fld_search_uname;
    private JButton btn_search;
    private JComboBox cmb_search_type;
    private JPanel wrapper;
    private JPanel tab_users;
    private JPanel pnl_userform;
    private JTextField fld_add_name;
    private JTextField fld_add_uname;
    private JPasswordField fld_add_password;
    private JComboBox cmb_add_usertype;
    private JButton btn_add;
    private JButton btn_delete;
    private JTextField fld_delete_id;
    private JLabel fld_welcome_admin;
    private JPopupMenu userMenu;
    private DefaultTableModel mdl_userlist;
    private Object[] row_userlist;


    public AdminGUI(User user) {
        add(wrapper);
        setSize(900, 500);
        setTitle("Admin Paneli");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x = Helper.screenCenter("x", this.getSize());
        int y = Helper.screenCenter("y", this.getSize());
        setLocation(x, y);

        setVisible(true);


        //User List
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


        btn_logout.addActionListener(e -> {
            dispose();
        });

        btn_search.addActionListener(e -> {
            String name = fld_search_name.getText();
            String uname = fld_search_uname.getText();
            String type = cmb_search_type.getSelectedItem().toString();

            String query = User.searchQuery(name, uname, type);
            ArrayList<User> filter = User.searchUserList(query);
            loadUserModel(filter);
        });

        btn_add.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_add_name) || Helper.isFieldEmpty(fld_add_uname) || Helper.isFieldEmpty(fld_add_password)) {
                Helper.showMsg("fill");
            } else {
                String name = fld_add_name.getText();
                String uname = fld_add_uname.getText();
                String password = fld_add_password.getText();
                String type = cmb_add_usertype.getSelectedItem().toString();

                if (User.add(name, uname, password, type)) {
                    Helper.showMsg("done");
                    loadUserModel();

                    fld_add_name.setText(null);
                    fld_add_uname.setText(null);
                    fld_add_password.setText(null);
                }

            }
        });


        btn_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_delete_id)) {
                Helper.showMsg("fill");
            } else {
                int user_id = Integer.parseInt(fld_delete_id.getText());
                if (User.delete(user_id)) {
                    Helper.showMsg("done");
                    loadUserModel();
                } else {
                    Helper.showMsg("error");
                }
            }

        });

        tbl_userlist.getSelectionModel().addListSelectionListener(e -> {
            try {
                String selectedRow = tbl_userlist.getValueAt(tbl_userlist.getSelectedRow(), 0).toString();
                fld_delete_id.setText(selectedRow);
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


}
