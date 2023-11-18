package Tourism.Model;

import Tourism.Helper.DBConnector;
import Tourism.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Room {
    private int id;
    private String type;
    private int termId;
    private int hotelId;
    private int hotelTypeId;
    private String feature;
    private int adultPrice;
    private int childrenPrice;
    private int roomStock;
    private int bedCount;
    private int roomSize;
    Hotel hotel;

    public Room() {

    }

    public Room(int id, String type, int termId, int roomStock, int hotelId, int hotelTypeId, String feature, int adultPrice, int childrenPrice, int bedCount, int roomSize) {
        this.id = id;
        this.type = type;
        this.termId = termId;
        this.hotelId = hotelId;
        this.hotelTypeId = hotelTypeId;
        this.feature = feature;
        this.adultPrice = adultPrice;
        this.childrenPrice = childrenPrice;
        this.bedCount = bedCount;
        this.roomStock = roomStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getHotelTypeId() {
        return hotelTypeId;
    }

    public void setHotelTypeId(int hotelTypeId) {
        this.hotelTypeId = hotelTypeId;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
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

    public int getRoomStock() {
        return roomStock;
    }

    public void setRoomStock(int roomStock) {
        this.roomStock = roomStock;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public static ArrayList<Room> getList() {
        ArrayList<Room> roomList = new ArrayList<>();
        String query = "SELECT * FROM room";
        Room obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Room();
                obj.setId(rs.getInt("room_id"));
                obj.setType(rs.getString("room_type"));
                obj.setRoomStock(rs.getInt("room_stock"));
                obj.setHotelId(rs.getInt("hotel_id"));
                obj.setFeature(rs.getString("feature"));
                obj.setBedCount(rs.getInt("room_bed_count"));
                obj.setRoomSize(rs.getInt("room_size"));
                roomList.add(obj);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomList;
    }

    ///////////////////////BURAYA BAKCAM////////////////////////////
    public static String searchQuery(String city, String district, String hotelName, Date checkinDate, Date checkoutDate, int bedCount) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String formattedCheckinDate = (checkinDate != null) ? dateFormat.format(checkinDate) : "";
        String formattedCheckoutDate = (checkoutDate != null) ? dateFormat.format(checkoutDate) : "";

        String query = "SELECT r.room_id, r.room_type, r.room_stock, r.hotel_id, r.feature, t.term_start_date, t.term_end_date, r.room_bed_count, r.room_size,t.term_id,t.board_type,t.adult_price,t.children_price " +
                "FROM Room r " +
                "JOIN Term t ON r.room_id = t.room_id " +
                "JOIN Hotel h ON r.hotel_id = h.hotel_id " +
                "WHERE (h.hotel_city LIKE '%{{city}}%' OR h.hotel_district LIKE '%{{district}}%' OR h.hotel_name LIKE '%{{hotelName}}%')";

        query = query.replace("{{city}}", city);
        query = query.replace("{{district}}", district);
        query = query.replace("{{hotelName}}", hotelName);


        if (bedCount > 0) {
            query += "AND r.room_bed_count >= " + bedCount;
        }

        if (!formattedCheckinDate.isEmpty() && !formattedCheckoutDate.isEmpty()) {

            query += " AND (t.term_start_date <= '{{checkinDate}}' AND t.term_end_date >= '{{checkoutDate}}')";
            query = query.replace("{{checkinDate}}", formattedCheckinDate);
            query = query.replace("{{checkoutDate}}", formattedCheckoutDate);
        } else if (!formattedCheckinDate.isEmpty()) {

            query += " AND (t.term_start_date <= '{{checkinDate}}')";
            query = query.replace("{{checkinDate}}", formattedCheckinDate);
        } else if (!formattedCheckoutDate.isEmpty()) {

            query += " AND (t.term_end_date >= '{{checkoutDate}}')";
            query = query.replace("{{checkoutDate}}", formattedCheckoutDate);
        }

        return query;
    }

    public static boolean updateRoomForRoomStock(int roomID, int roomStock, String roomFeature, int roomSize, int roomBedCount) {
        String query = "UPDATE room SET room_stock = ?, feature = ?, room_size = ?, room_bed_count = ?  WHERE room_id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, roomStock);
            pr.setString(2, roomFeature);
            pr.setInt(3, roomSize);
            pr.setInt(4, roomBedCount);
            pr.setInt(5, roomID);


            int response = pr.executeUpdate();
            if (response == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Room> searchRoomList(String query) {
        ArrayList<Room> roomList = new ArrayList<>();
        Room obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                obj = new Room();
                obj.setId(rs.getInt("room_id"));
                obj.setType(rs.getString("room_type"));
                obj.setRoomStock(rs.getInt("room_stock"));
                obj.setHotelId(rs.getInt("hotel_id"));
                obj.setFeature(rs.getString("feature"));
                obj.setBedCount(rs.getInt("room_bed_count"));
                obj.setRoomSize(rs.getInt("room_size"));
                roomList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomList;
    }

    public static Room getRoom(int id) {
        Room obj = null;
        String query = "SELECT * FROM room WHERE room_id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                obj = new Room();
                obj.setId(rs.getInt("room_id"));
                obj.setHotelId(rs.getInt("hotel_id"));
                obj.setType(rs.getString("room_type"));
                obj.setRoomStock(rs.getInt("room_stock"));
                obj.setFeature(rs.getString("feature"));
                obj.setRoomSize(rs.getInt("room_size"));
                obj.setBedCount(rs.getInt("room_bed_count"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;

    }


    public static boolean addRoom(String roomType, int roomStock, int hotelId, String feature, int bedCount, int roomSize) {
        String query = "INSERT INTO room (room_type, room_stock, hotel_id, feature, room_bed_count, room_size) VALUES (?, ?, ?, ?, ?, ?)";

        Room room = Room.getRoomBYHotelAndRoomType(hotelId, roomType);
        if (room != null){
            Helper.showMsg("Bu otele ait bu tipte bir oda bulunmaktadır.");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pr.setString(1, roomType);
            pr.setInt(2, roomStock);
            pr.setInt(3, hotelId);
            pr.setString(4, feature);
            pr.setInt(5, bedCount);
            pr.setInt(6, roomSize);

            int response = pr.executeUpdate();
            if (response == -1) {
                Helper.showMsg("Oda eklenemedi.");
            }
            return response != -1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Room getRoomBYHotelAndRoomType(int hotel_id, String room_type) {
        Room obj = null;
        String query = "SELECT * FROM room WHERE hotel_id = ? and room_type = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, hotel_id);
            pr.setString(2, room_type);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                obj = new Room();
                obj.setId(rs.getInt("room_id"));
                obj.setHotelId(rs.getInt("hotel_id"));
                obj.setType(rs.getString("room_type"));
                obj.setRoomStock(rs.getInt("room_stock"));
                obj.setFeature(rs.getString("feature"));
                obj.setRoomSize(rs.getInt("room_size"));
                obj.setBedCount(rs.getInt("room_bed_count"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;

    }
    public static ArrayList<Room> getListRoomBYHotelID(int id) {
        ArrayList<Room> roomList = new ArrayList<>();
        String query = "SELECT * FROM room WHERE hotel_id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                Room obj = new Room();
                obj.setId(rs.getInt("room_id"));
                obj.setHotelId(rs.getInt("hotel_id"));
                obj.setType(rs.getString("room_type"));
                obj.setRoomStock(rs.getInt("room_stock"));
                obj.setFeature(rs.getString("feature"));
                obj.setRoomSize(rs.getInt("room_size"));
                obj.setBedCount(rs.getInt("room_bed_count"));
                roomList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roomList;
    }

}


