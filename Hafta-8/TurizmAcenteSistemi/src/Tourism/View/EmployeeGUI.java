package Tourism.View;

import Tourism.Helper.DBConnector;
import Tourism.Helper.Helper;
import Tourism.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EmployeeGUI extends JFrame {
    private JTabbedPane tabbedPane1;
    private JButton btn_emp_logout;
    private JTable tbl_hotellist;
    private JPanel wrapper;
    private JTable tbl_roomlist;
    private JLabel fld_welcome;
    private JFormattedTextField fld_start_date;
    private JTextField fld_place;
    private JButton btn_room_search;
    private JTextField fld_person_number;
    private JScrollPane pnl_hotellist;
    private JTextField fld_end_date;
    private JTable tbl_reservation_list;
    private JButton btn_refresh;
    private Object[] row_hotellist;
    private DefaultTableModel mdl_hotellist;
    private DefaultTableModel mdl_reservation_list;
    private JPopupMenu hotelMenu;
    private JPopupMenu roomMenu;
    private JPopupMenu reservationMenu;
    private DefaultTableModel mdl_roomlist;
    private Object[] row_roomlist;
    private Object[] row_reservation_list;
    Connection connection;
    User user;
    Reservation reservation;


    public EmployeeGUI(User user) {
        add(wrapper);
        setSize(1500, 500);
        setTitle("Çalışan Paneli");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.connection = DBConnector.getInstance();
        setVisible(true);
        int x = Helper.screenCenter("x", this.getSize());
        int y = Helper.screenCenter("y", this.getSize());
        setLocation(x, y);



        //Otel Listesi
        mdl_hotellist = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_hotellist = {"ID", "Otel Adı", "Şehir", "Bölge", "Otel Özellikleri", "Adres", "Mail", "Telefon", "Yıldız"};
        mdl_hotellist.setColumnIdentifiers(col_hotellist);

        row_hotellist = new Object[col_hotellist.length];
        loadHotelModel();

        tbl_hotellist.setModel(mdl_hotellist);
        tbl_hotellist.setComponentPopupMenu(hotelMenu);

        tbl_hotellist.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selectedrow = tbl_hotellist.rowAtPoint(point);
                tbl_hotellist.setRowSelectionInterval(selectedrow, selectedrow);
            }
        });


        mdl_roomlist = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_roomlist = {"Term ID", "Oda ID", "Otel Adı", "Şehir", "Bölge", "Oda Tipi", "Pansiyon Tipi", "Stok Sayısı", "Oda Özellikleri", "Metrekare", "Yatak Sayısı", "Dönem Başlangıcı", "Dönem Bitişi", "Yetişkin Ücreti", "Çocuk Ücreti"};
        mdl_roomlist.setColumnIdentifiers(col_roomlist);

        row_roomlist = new Object[col_roomlist.length];
        loadPriceTable();

        tbl_roomlist.setModel(mdl_roomlist);
        tbl_roomlist.setComponentPopupMenu(roomMenu);


        //Otel Silme ve Ekleme
        tbl_hotellist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Sağ tıklama gerçekleştiyse
                if (e.getButton() == MouseEvent.BUTTON3) {
                    // Sağ tıklanan satırın indeksini al
                    int row = e.getPoint().y / tbl_hotellist.getRowHeight();

                    // Sağ tıklanan satırın ID'sini al
                    int id = (int) tbl_hotellist.getValueAt(row, 0);

                    // Popup menü oluştur
                    JPopupMenu hotelMenu = new JPopupMenu();

                    // Popup menüsüne öğeler ekle
                    JMenuItem deleteMenuItem = new JMenuItem("Sil");
                    JMenuItem addMenu = new JMenuItem("Otel Yönetimi");
                    JMenuItem addRoomMenu = new JMenuItem("Oda Ekle");

                    deleteMenuItem.addActionListener(event4 -> {
                        // Sil butonuna tıklandığında
                        Connection connection = DBConnector.getInstance();

                        String sql = "DELETE FROM room WHERE hotel_id = ?";
                        PreparedStatement statement = null;
                        try {
                            statement = connection.prepareStatement(sql);
                            statement.setInt(1, id);
                            statement.executeUpdate();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        loadPriceTable();

                        sql = "DELETE FROM hotel WHERE hotel_id = ?";
                        statement = null;
                        try {
                            statement = connection.prepareStatement(sql);
                            statement.setInt(1, id);
                            statement.executeUpdate();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                        // Tabloyu güncelleme metodu
                        loadHotelModel();

                        // JPopupMenu'yi kapat
                        hotelMenu.setVisible(false);

                        // Kullanıcıyı uyar
                        Helper.showMsg("Otel başarıyla silindi.");
                    });

                    hotelMenu.add(deleteMenuItem);
                    hotelMenu.add(addMenu);
                    hotelMenu.add(addRoomMenu);

                    // Popup menüyü göster
                    hotelMenu.show(e.getComponent(), e.getX(), e.getY());


                    addMenu.addActionListener(event1 -> {
                        AddHotelGUI addHotelGUI = new AddHotelGUI(id, true);
                        dispose();


                    });

                    addRoomMenu.addActionListener(event1 -> {
                        AddRoomGUI addRoomGUI = new AddRoomGUI(id, false);
                        dispose();


                    });


                }
            }
        });

        tbl_hotellist.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    createAddHotelRightClick(e);
                }
            }
        });

        pnl_hotellist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    createAddHotelRightClick(e);
                }
            }
        });


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        btn_room_search.addActionListener(e -> {
            String place = fld_place.getText();
            String start = fld_start_date.getText();
            String end = fld_end_date.getText();
            String personNumberText = fld_person_number.getText();

            // Dolu olan alanları kontrol etmek için boş veya null olmayan sayacı
            int filledFieldCount = 0;

            java.util.Date startDate = null;
            java.util.Date endDate = null;

            if (!place.isEmpty()) {
                filledFieldCount++;
            }

            if (!start.isEmpty()) {
                try {
                    startDate = dateFormat.parse(start);
                    filledFieldCount++;
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }

            if (!end.isEmpty()) {
                try {
                    endDate = dateFormat.parse(end);
                    filledFieldCount++;
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }

            Integer personNumber = null;

            if (!personNumberText.isEmpty()) {
                try {
                    personNumber = Integer.parseInt(personNumberText);
                    filledFieldCount++;
                } catch (NumberFormatException ex) {
                    throw new RuntimeException(ex);
                }
            }

            if (filledFieldCount > 0) {
                if (personNumber == null) {
                    personNumber = 0; // personNumber null ise 0 olarak varsayalım
                }
                String query = Room.searchQuery(place, place, place, startDate, endDate, personNumber);
                ArrayList<Term> filter = Term.searchTermList(query);
                loadRoomModel(filter);
            } else {
                // Tüm alanlar boşsa geri listeyi görüntüleme
                loadPriceTable();
            }
        });


        tbl_roomlist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Sağ tıklama gerçekleştiyse
                if (e.getButton() == MouseEvent.BUTTON3) {


                    int row = e.getPoint().y / tbl_roomlist.getRowHeight();
                    tbl_roomlist.setRowSelectionInterval(row, row);


                    int id = (int) tbl_roomlist.getValueAt(row, 1);
                    int termID = (int) tbl_roomlist.getValueAt(row, 0);

                    JPopupMenu roomMenu = new JPopupMenu();
                    JMenuItem roomManagement = new JMenuItem("Oda Yönetimi");
                    JMenuItem deleteRoom = new JMenuItem("Sil");
                    JMenuItem reservation = new JMenuItem("Rezervasyon");

                    roomManagement.addActionListener(event3 -> {
                        EmployeeGUI.this.showRoomDetails(id);
                        dispose();

                    });

                    deleteRoom.addActionListener(event4 -> {
                        // Sil butonuna tıklandığında
                        Connection connection = DBConnector.getInstance();

                        String sql = "DELETE FROM room WHERE room_id = ?";
                        PreparedStatement statement = null;
                        try {
                            statement = connection.prepareStatement(sql);
                            statement.setInt(1, id);
                            statement.executeUpdate();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        loadPriceTable();

                        // Tabloyu güncelleme metodu
                        loadPriceTable();

                        roomMenu.setVisible(false);

                        Helper.showMsg("Oda başarıyla silindi.");
                    });

                    reservation.addActionListener(event3 -> {
                        ReservationGUI reservationGUI = new ReservationGUI(termID);
                        dispose();

                    });
                    roomMenu.add(roomManagement);
                    roomMenu.add(deleteRoom);
                    roomMenu.add(reservation);


                    roomMenu.show(e.getComponent(), e.getX(), e.getY());


                }
            }
        });

        mdl_reservation_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_reservation_list = {"ID", "Otel Adı", "Adı ve Soyadı", "Telefon No", "E-mail Adresi", "Misafir Sayısı", "Rezervasyon Başlangıç Tarihi", "Rezervasyon Bitiş Tarihi", "Fiyat"};
        mdl_reservation_list.setColumnIdentifiers(col_reservation_list);
        row_reservation_list = new Object[col_reservation_list.length];
        loadReservationModel();
        tbl_reservation_list.setModel(mdl_reservation_list);
        tbl_reservation_list.setComponentPopupMenu(reservationMenu);
        tbl_reservation_list.getTableHeader().setReorderingAllowed(false);

        tbl_reservation_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Sağ tıklama gerçekleştiyse
                if (e.getButton() == MouseEvent.BUTTON3) {


                    int row = e.getPoint().y / tbl_reservation_list.getRowHeight();
                    tbl_reservation_list.setRowSelectionInterval(row, row);


                    int reservationID = (int) tbl_reservation_list.getValueAt(row, 0);

                    JPopupMenu reservationMenu = new JPopupMenu();
                    JMenuItem deleteReservation = new JMenuItem("Rezervasyonu Sil");


                    deleteReservation.addActionListener(event4 -> {

                        // Sil butonuna tıklandığında
                        Reservation.deleteReservation(reservationID);
                        loadReservationModel();
                        loadPriceTable();

                        reservationMenu.setVisible(false);

                        Helper.showMsg("Rezervasyon başarıyla silindi.");
                    });

                    reservationMenu.add(deleteReservation);
                    reservationMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        btn_refresh.addActionListener(e -> {
            loadReservationModel();
            loadHotelModel();
            loadPriceTable();

        });
        btn_emp_logout.addActionListener(e -> {
            dispose();
        });
    }

    private void loadReservationModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_reservation_list.getModel();
        clearModel.setRowCount(0);


        for (Reservation obj : Reservation.getListReservation()) {
            int i = 0;
            row_reservation_list[i++] = obj.getReservationID();
            Term term = Term.getTermBYTermID(obj.getTermID());
            Hotel hotel = Hotel.getFetch(term.getHotelID());
            row_reservation_list[i++] = hotel.getName();
            row_reservation_list[i++] = obj.getCustomerName();
            row_reservation_list[i++] = obj.getCustomerPhone();
            row_reservation_list[i++] = obj.getCustomerMail();
            row_reservation_list[i++] = obj.getCustomerNumber();
            row_reservation_list[i++] = obj.getReservationStartDate();
            row_reservation_list[i++] = obj.getReservationEndDate();
            row_reservation_list[i++] = obj.getCustomerPrice();
            mdl_reservation_list.addRow(row_reservation_list);

        }
    }

    private void showRoomDetails(int roomId) {
        AddRoomGUI addRoomGUI = new AddRoomGUI(roomId, true);
    }


    private void createAddHotelRightClick(MouseEvent e) {
        JPopupMenu hotelPanelMenu = new JPopupMenu();
        JMenuItem addMenuItem = new JMenuItem("Otel Ekle");
        addMenuItem.addActionListener(event3 -> {
            createAddHotelGUIPopup();
            dispose();
        });
        hotelPanelMenu.add(addMenuItem);
        hotelPanelMenu.show(e.getComponent(), e.getX(), e.getY());
    }


    private void createAddHotelGUIPopup() {

        AddHotelGUI addHotelGUI = new AddHotelGUI(0, false);


    }

    public void loadHotelModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_hotellist.getModel();
        clearModel.setRowCount(0);


        for (Hotel obj : Hotel.getList()) {
            int i = 0;
            row_hotellist[i++] = obj.getId();
            row_hotellist[i++] = obj.getName();
            row_hotellist[i++] = obj.getCity();
            row_hotellist[i++] = obj.getDistrict();
            row_hotellist[i++] = obj.getHotelFeature();
            row_hotellist[i++] = obj.getAddress();
            row_hotellist[i++] = obj.getMail();
            row_hotellist[i++] = obj.getPhone();
            row_hotellist[i++] = obj.getStar();

            mdl_hotellist.addRow(row_hotellist);
        }
    }


    public void loadPriceTable() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_roomlist.getModel();
        clearModel.setRowCount(0);

        for (Term obj : Term.getListTerm()) {
            int i = 0;
            Room room = Room.getRoom(obj.getRoomID());
            row_roomlist[i++] = obj.getTermId();
            row_roomlist[i++] = room.getId();
            Hotel hotel = Hotel.getFetch(obj.getHotelID());
            row_roomlist[i++] = hotel.getName();
            row_roomlist[i++] = hotel.getCity();
            row_roomlist[i++] = hotel.getDistrict();
            row_roomlist[i++] = room.getType();
            row_roomlist[i++] = obj.getBoardType();
            row_roomlist[i++] = room.getRoomStock();
            row_roomlist[i++] = room.getFeature();
            row_roomlist[i++] = room.getRoomSize();
            row_roomlist[i++] = room.getBedCount();
            row_roomlist[i++] = obj.getTermStartDate();
            row_roomlist[i++] = obj.getTermEndDate();
            row_roomlist[i++] = obj.getAdultPrice();
            row_roomlist[i++] = obj.getChildrenPrice();
            mdl_roomlist.addRow(row_roomlist);
        }

    }

    public void loadRoomModel(ArrayList<Term> list) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_roomlist.getModel();
        clearModel.setRowCount(0);


        for (Term obj : list) {
            int i = 0;
            Room room = Room.getRoom(obj.getRoomID());
            row_roomlist[i++] = obj.getTermId();
            row_roomlist[i++] = room.getId();
            Hotel hotel = Hotel.getFetch(obj.getHotelID());
            row_roomlist[i++] = hotel.getName();
            row_roomlist[i++] = hotel.getCity();
            row_roomlist[i++] = hotel.getDistrict();
            row_roomlist[i++] = room.getType();
            row_roomlist[i++] = obj.getBoardType();
            row_roomlist[i++] = room.getRoomStock();
            row_roomlist[i++] = room.getFeature();
            row_roomlist[i++] = room.getRoomSize();
            row_roomlist[i++] = room.getBedCount();
            row_roomlist[i++] = obj.getTermStartDate();
            row_roomlist[i++] = obj.getTermEndDate();
            row_roomlist[i++] = obj.getAdultPrice();
            row_roomlist[i++] = obj.getChildrenPrice();
            mdl_roomlist.addRow(row_roomlist);
        }
    }
}





