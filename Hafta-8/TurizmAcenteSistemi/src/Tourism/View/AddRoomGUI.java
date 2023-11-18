package Tourism.View;

import Tourism.Helper.DBConnector;
import Tourism.Helper.Helper;
import Tourism.Model.Hotel;
import Tourism.Model.Room;
import Tourism.Model.Term;
import Tourism.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class AddRoomGUI extends JFrame {
    private JPanel wrapper;
    private JCheckBox cb_tv;
    private JCheckBox cb_minibar;
    private JCheckBox cb_game;
    private JCheckBox cb_vault;
    private JCheckBox cb_projection;
    private JTextField fld_adult;
    private JTextField fld_child;
    private JButton btn_update;
    private JButton btn_add;
    private JComboBox cmb_type;
    private JTextField fld_stock;
    private JTextField fld_m;
    private JTextField fld_bed;
    private JTable tbl_term_list_byroom;
    private JButton btn_price_add;
    private JPanel pnl_tbl_term_list;
    private JPanel pnl_end;
    private Hotel hotel;
    Connection connection;
    Room room;
    private JCheckBox[] checkBoxList;
    private DefaultTableModel mdl_room_list_byroom;
    private Object[] row_room_list_byroom;
    int hotelID;
    int roomID;
    private JPopupMenu roomMenu;
    User user;


    public AddRoomGUI() {

    }

    public AddRoomGUI(int id, Boolean edit) {
        hotelID = id;
        roomID = id;
        this.add(wrapper);
        setSize(600, 400);
        setTitle("Otel Yönetimi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        checkBoxList = new JCheckBox[]{cb_tv, cb_minibar, cb_game, cb_vault, cb_projection};
        this.connection = DBConnector.getInstance();

        if (edit) {
            btn_add.setVisible(false);
            tbl_term_list_byroom.setVisible(true);

            room = Room.getRoom(id);

            List<String> featureList = Arrays.stream(room.getFeature().split(",")).toList();

            for (String feature : featureList) {
                for (JCheckBox checkBox : checkBoxList) {
                    if (feature.equals(checkBox.getText())) {
                        checkBox.setSelected(true);
                    }
                }

            }
            loadRoomData(id);
        } else {
            btn_add.setVisible(true);
            tbl_term_list_byroom.setVisible(false);
            pnl_tbl_term_list.setVisible(false);
            btn_price_add.setVisible(false);


        }

        mdl_room_list_byroom = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_room_list = {"ID", "Oda ID", "Oda Tipi", "Pansiyon tipi", "Dönem Başlangıç", "Dönem Bitiş", "Stok sayısı", "Oda Özellikleri", "Metrekare", "Yatak Sayısı", "Yetişkin Fiyat", "Çocuk Fiyat"};
        mdl_room_list_byroom.setColumnIdentifiers(col_room_list);
        row_room_list_byroom = new Object[col_room_list.length];
        loadTermModelRoomPage(roomID);
        tbl_term_list_byroom.setModel(mdl_room_list_byroom);
        tbl_term_list_byroom.setComponentPopupMenu(roomMenu);
        tbl_term_list_byroom.getTableHeader().setReorderingAllowed(false);

        btn_add.addActionListener(e -> {
            addRoom();
            dispose();
            AddHotelGUI addHotelGUI = new AddHotelGUI(hotelID, true);

        });

        btn_price_add.addActionListener(e -> {
            PriceSetGUI priceSetGUI = new PriceSetGUI(roomID);
            dispose();
        });

    }


    public void loadTermModelRoomPage(int roomID) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_term_list_byroom.getModel();
        clearModel.setRowCount(0);

        for (Term obj : Term.getTermListByRoomID(roomID)) {
            int i = 0;
            Room room = Room.getRoom(obj.getRoomID());
            row_room_list_byroom[i++] = obj.getTermId();
            row_room_list_byroom[i++] = room.getId();
            row_room_list_byroom[i++] = room.getType();
            row_room_list_byroom[i++] = obj.getBoardType();
            row_room_list_byroom[i++] = obj.getTermStartDate();
            row_room_list_byroom[i++] = obj.getTermEndDate();
            row_room_list_byroom[i++] = room.getRoomStock();
            row_room_list_byroom[i++] = room.getFeature();
            row_room_list_byroom[i++] = room.getRoomSize();
            row_room_list_byroom[i++] = room.getBedCount();
            row_room_list_byroom[i++] = obj.getAdultPrice();
            row_room_list_byroom[i++] = obj.getChildrenPrice();
            mdl_room_list_byroom.addRow(row_room_list_byroom);
        }

    }

    public void loadRoomData(int roomId) {
        String query = "SELECT room_stock, room_size, room_bed_count, room_type FROM room WHERE room_id = " + roomId;

        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int roomStock = resultSet.getInt("room_stock");
                int roomSize = resultSet.getInt("room_size");
                int roomBedCount = resultSet.getInt("room_bed_count");
                String roomType = resultSet.getString("room_type");

                fld_stock.setText(String.valueOf(roomStock));
                fld_m.setText(String.valueOf(roomSize));
                fld_bed.setText(String.valueOf(roomBedCount));
                cmb_type.setSelectedItem(roomType);


            } else {
                // Eğer oda bulunamazsa, hata mesajı veya varsayılan bir değer kullanabilirsiniz.
                fld_stock.setText("Oda bulunamadı");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public String getCurrentFeatures() {
        String features = "";
        for (JCheckBox checkbox : checkBoxList) {
            if (checkbox.isSelected()) {
                features += checkbox.getText() + ",";
            }
        }
        return features;
    }

    public void addRoom() {
        String roomType = cmb_type.getSelectedItem().toString();
        int roomStock = Integer.parseInt(fld_stock.getText());
        String roomFeature = getSelectedFeatures();
        int roomSize = Integer.parseInt(fld_m.getText());
        int roomBedCount = Integer.parseInt(fld_bed.getText());


        if (Room.addRoom(roomType, roomStock, hotelID, roomFeature, roomBedCount, roomSize)) {
            Helper.showMsg("done");
        }
        setVisible(false);
    }

    public String getSelectedFeatures() {
        String selectedFeatures = "";
        for (JCheckBox checkbox : checkBoxList) {
            if (checkbox.isSelected()) {
                selectedFeatures += checkbox.getText() + ",";
            }
        }
        if (!selectedFeatures.isEmpty()) {
            // Son virgülü kaldırın
            selectedFeatures = selectedFeatures.substring(0, selectedFeatures.length() - 1);
        }
        return selectedFeatures;
    }
}





