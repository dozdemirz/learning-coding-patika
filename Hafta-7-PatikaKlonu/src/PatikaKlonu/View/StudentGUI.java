package PatikaKlonu.View;

import PatikaKlonu.Helper.Helper;
import PatikaKlonu.Model.Patika;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentGUI extends JFrame {
    private JTable tbl_patikalist;
    private javax.swing.JScrollPane JScrollPane;

    private DefaultTableModel mdl_patikalist;
    private Object[] row_patikalist;


    public StudentGUI (){
        setTitle("Öğrenci Bilgi Sistemi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setResizable(false);
        int x = Helper.screenCenter("x", getSize());
        int y = Helper.screenCenter("y", getSize());
        setLocation(x, y);
        setVisible(true);

        mdl_patikalist = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_patikalist = {"ID", "Patika Adı"};
        mdl_patikalist.setColumnIdentifiers(col_patikalist);

        row_patikalist = new Object[col_patikalist.length];
        loadPatikaModel();


        tbl_patikalist.setModel(mdl_patikalist);
        tbl_patikalist.getTableHeader().setReorderingAllowed(false);


    }


    private void loadPatikaModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patikalist.getModel();
        clearModel.setRowCount(0);

        int i = 0;
        for (Patika obj : Patika.getList()) {
            row_patikalist[i++] = obj.getId();
            row_patikalist[i++] = obj.getName();
            mdl_patikalist.addRow(row_patikalist);
        }

    }
}
