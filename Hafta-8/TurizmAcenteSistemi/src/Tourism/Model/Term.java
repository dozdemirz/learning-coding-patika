package Tourism.Model;

import Tourism.Helper.DBConnector;
import Tourism.Helper.Helper;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;


public class Term {

    private int termId;
    private String termName;
    private int hotelID;
    private int roomID;
    private Date termStartDate;
    private Date termEndDate;
    private int adultPrice;
    private int childrenPrice;
    private String boardType;

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public Date getTermStartDate() {
        return termStartDate;
    }

    public void setTermStartDate(Date termStartDate) {
        this.termStartDate = termStartDate;
    }

    public Date getTermEndDate() {
        return termEndDate;
    }

    public void setTermEndDate(Date termEndDate) {
        this.termEndDate = termEndDate;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(int adultPrice) {
        this.adultPrice = adultPrice;
    }

    public int getChildrenPrice() {
        return childrenPrice;
    }

    public void setChildrenPrice(int childrenPrice) {
        this.childrenPrice = childrenPrice;
    }

    public Term() {
    }


    public String getBoardType() {
        return boardType;
    }

    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }

    public static Term getTerm(int id) {
        Term obj = null;
        String query = "SELECT * FROM term WHERE term_id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                obj = new Term();
                obj.setTermId(rs.getInt("term_id"));
                obj.setHotelID(rs.getInt("hotel_id"));
                obj.setRoomID(rs.getInt("room_id"));
                obj.setBoardType(rs.getString("board_type"));
                obj.setTermStartDate(rs.getDate("term_start_date"));
                obj.setTermEndDate(rs.getDate("term_end_date"));
                obj.setAdultPrice(rs.getInt("adult_price"));
                obj.setChildrenPrice(rs.getInt("children_price"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;

    }

    public static Term getTermByRoom(int id) {
        Term obj = null;
        String query = "SELECT * FROM term WHERE room_id = ?";
        Hotel hotel = Hotel.getHotelByRoomID(id);
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                obj = new Term();
                obj.setTermId(rs.getInt("term_id"));
                hotel.setId(rs.getInt("hotel_id"));
                obj.setRoomID(rs.getInt("room_id"));
                obj.setBoardType(rs.getString("room_board_type"));
                obj.setTermStartDate(rs.getDate("term_start_date"));
                obj.setTermEndDate(rs.getDate("term_end_date"));
                obj.setAdultPrice(rs.getInt("adult_price"));
                obj.setChildrenPrice(rs.getInt("children_price"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;

    }

    public static ArrayList<Term> getTermList(int room, int hotel) {
        ArrayList<Term> termList = new ArrayList<>();
        String query = "SELECT * FROM term where room_id = " + room + " and hotel_id = " + hotel;
        Term obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Term();
                obj.setTermId(rs.getInt("term_id"));
                obj.setHotelID(rs.getInt("hotel_id"));
                obj.setRoomID(rs.getInt("room_id"));
                obj.setBoardType(rs.getString("board_type"));
                obj.setTermStartDate(rs.getDate("term_start_date"));
                obj.setTermEndDate(rs.getDate("term_end_date"));
                obj.setAdultPrice(rs.getInt("adult_price"));
                obj.setChildrenPrice(rs.getInt("children_price"));
                termList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return termList;
    }

    public static Term getFetchTerm(int id) {
        Term obj = null;
        String query = "SELECT * FROM term WHERE room_id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                obj = new Term();
                obj.setTermId(rs.getInt("term_id"));
                obj.setHotelID(rs.getInt("hotel_id"));
                obj.setRoomID(rs.getInt("room_id"));
                obj.setBoardType(rs.getString("board_type"));
                obj.setTermStartDate(rs.getDate("term_start_date"));
                obj.setTermEndDate(rs.getDate("term_end_date"));
                obj.setAdultPrice(rs.getInt("adult_price"));
                obj.setChildrenPrice(rs.getInt("children_price"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;

    }


    public static boolean add(int hotel, int room, String roomBoardType, Date termStartDate, Date termEndDate, int adultPrice, int childrenPrice) {
        String query = "INSERT INTO term (hotel_id, room_id, board_type, term_start_date, term_end_date, adult_price, children_price) VALUES (?, ?, ?, ?, ?, ?, ?)";


        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, hotel);
            pr.setInt(2, room);
            pr.setString(3, roomBoardType);
            pr.setDate(4, (java.sql.Date) termStartDate);
            pr.setDate(5, (java.sql.Date) termEndDate);
            pr.setInt(6, adultPrice);
            pr.setInt(7, childrenPrice);
            int response = pr.executeUpdate();

            if (response == -1) {
                Helper.showMsg("error");
            }

            return response != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;

    }

    public static ArrayList<Term> getTermListByRoomID(int room) {
        ArrayList<Term> termList = new ArrayList<>();
        String query = "SELECT * FROM term WHERE room_id = " + room;
        Term obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Term();
                obj.setTermId(rs.getInt("term_id"));
                obj.setHotelID(rs.getInt("hotel_id"));
                obj.setRoomID(rs.getInt("room_id"));
                obj.setBoardType(rs.getString("board_type"));
                obj.setTermStartDate(rs.getDate("term_start_date"));
                obj.setTermEndDate(rs.getDate("term_end_date"));
                obj.setAdultPrice(rs.getInt("adult_price"));
                obj.setChildrenPrice(rs.getInt("children_price"));
                termList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return termList;
    }


    public static int[] getRoomAndHotelID(int roomID) {


        int[] ids = new int[2]; // room_id ve hotel_id için dizi
        String query = "SELECT room_id, hotel_id FROM room WHERE room_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, roomID);
            ResultSet rs = pr.executeQuery();



            if (rs.next()) {
                ids[0] = rs.getInt("room_id");
                ids[1] = rs.getInt("hotel_id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Hata işleme kodu ekleyin
        }

        return ids;
    }

    public static boolean addTermToDatabase(String boardType, Date startDate, Date endDate, double adultPrice, double childPrice, int selectedRoomID) {
        int[] roomAndHotelID = getRoomAndHotelID(selectedRoomID);
        int roomID = roomAndHotelID[0];
        int hotelID = roomAndHotelID[1];

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String insertSQL = "INSERT INTO term (hotel_id, room_id, board_type, term_start_date, term_end_date, adult_price, children_price) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = DBConnector.getInstance();

            preparedStatement = connection.prepareStatement(insertSQL);

            preparedStatement.setInt(1, hotelID);
            preparedStatement.setInt(2, roomID);
            preparedStatement.setString(3, boardType);
            preparedStatement.setDate(4, (java.sql.Date) startDate);
            preparedStatement.setDate(5, (java.sql.Date) endDate);
            preparedStatement.setDouble(6, adultPrice);
            preparedStatement.setDouble(7, childPrice);
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0; // Eklemenin başarılı olup olmadığını döndür

        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }
    }
    public static ArrayList<Term> getListTerm() {
        ArrayList<Term> termList = new ArrayList<>();
        String query = "SELECT * FROM term";
        Term obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Term();
                obj.setTermId(rs.getInt("term_id"));
                obj.setHotelID(rs.getInt("hotel_id"));
                obj.setRoomID(rs.getInt("room_id"));
                obj.setBoardType(rs.getString("board_type"));
                obj.setTermStartDate(rs.getDate("term_start_date"));
                obj.setTermEndDate(rs.getDate("term_end_date"));
                obj.setAdultPrice(rs.getInt("adult_price"));
                obj.setChildrenPrice(rs.getInt("children_price"));


                termList.add(obj);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return termList;
    }

    public static ArrayList<Term> searchTermList(String query) {
        ArrayList<Term> termList = new ArrayList<>();
        Term obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Term();
                obj.setTermId(rs.getInt("term_id"));
                obj.setHotelID(rs.getInt("hotel_id"));
                obj.setRoomID(rs.getInt("room_id"));
                obj.setBoardType(rs.getString("board_type"));
                obj.setTermStartDate(rs.getDate("term_start_date"));
                obj.setTermEndDate(rs.getDate("term_end_date"));
                obj.setAdultPrice(rs.getInt("adult_price"));
                obj.setChildrenPrice(rs.getInt("children_price"));
                termList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return termList;
    }


    public static Term getTermBYTermID(int termId) {
        Term obj = null;
        String query = "SELECT * FROM term WHERE term_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, termId);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                obj = new Term();
                obj.setTermId(rs.getInt("term_id"));
                obj.setHotelID(rs.getInt("hotel_id"));
                obj.setRoomID(rs.getInt("room_id"));
                obj.setBoardType(rs.getString("board_type"));
                obj.setTermStartDate(rs.getDate("term_start_date"));
                obj.setTermEndDate(rs.getDate("term_end_date"));
                obj.setAdultPrice(rs.getInt("adult_price"));
                obj.setChildrenPrice(rs.getInt("children_price"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;

    }
}

