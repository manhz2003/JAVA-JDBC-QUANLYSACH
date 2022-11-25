package dao;

import database.JDBC;
import module.Sach;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class sachDAO implements daoInterface<Sach> {

    public static sachDAO getInstance() {
        return new sachDAO();
    }
    // thêm
    @Override
    public int insert(Sach sach) {
        int ketQua;
        try {
            // Bước 1: Tạo kết nối đến CSDL
            Connection connection = JDBC.getConnection();

            String sql = "INSERT INTO sach (id, tenSach, giaBan, namXuatBan) " +
                    " VALUES (?,?,?,?)";
            // Bước 2: Tạo ra đối tượng statement
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sach.getId());
            st.setString(2, sach.getTenSach());
            st.setFloat(3, sach.getGiaBan());
            st.setInt(4, sach.getNamXuatBan());
            // Bước 3: Thực thi câu lệnh SQL            
            ketQua = st.executeUpdate();

            // Bước 4: xử lý kết quả
            System.out.println("bạn đã thực thi: " + sql);
            System.out.println("có "+ketQua + " dòng bị thay đổi !");

            // Bước 5: đóng kết kết
            JDBC.closeConnection(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    // sửa
    @Override
    public int update(Sach sach) {
        int ketQua;
        try {
            // Bước 1: Tạo kết nối đến CSDL
            Connection connection = JDBC.getConnection();

            // Bước 2: Tạo ra đối tượng statement
            String sql = "UPDATE sach "+
            "SET " +
            " tenSach= ?"+
            ", giaBan= ?"+
            ", namXuatBan= ?"+
            " WHERE id= ?";
            PreparedStatement st = connection.prepareStatement(sql);            
            st.setString(1, sach.getTenSach());
            st.setFloat(2, sach.getGiaBan());
            st.setInt(3, sach.getNamXuatBan());
            st.setString(4, sach.getId());

            // Bước 3: Thực thi câu lệnh SQL          
            ketQua = st.executeUpdate();

            // Bước 4: xử lý kết quả
            System.out.println("bạn đã thực thi: " + sql);
            System.out.println("có "+ketQua + " dòng bị thay đổi !");

            // Bước 5: đóng kết kết
            JDBC.closeConnection(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    // xóa
    @Override
    public int delete(Sach sach) {
        int ketQua;
        try {
            // Bước 1: Tạo kết nối đến CSDL
            Connection connection = JDBC.getConnection();

            // Bước 2: Tạo ra đối tượng statement
            String sql =  "DELETE FROM sach "+
                    " WHERE id= ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sach.getId());

            // Bước 3: Thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 4: xử lý kết quả
            System.out.println("bạn đã thực thi: " + sql);
            System.out.println("có "+ketQua + " dòng bị thay đổi !");

            // Bước 5: đóng kết kết
            JDBC.closeConnection(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    // truy vấn tất cả
    @Override
    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> ketQua = new ArrayList<Sach>();
        try {
            // Bước 1: Tạo kết nối đến CSDL
            Connection connection = JDBC.getConnection();

            // Bước 2: Tạo ra đối tượng statement
            String sql = "SELECT *FROM sach";
            PreparedStatement st = connection.prepareStatement(sql);

            // Bước 3: Thực thi câu lệnh SQL            
            ResultSet rs = st.executeQuery();

            // Bước 4: xử lý kết quả
            while(rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				ketQua.add(sach);
			}
            // Bước 5: đóng kết kết
            JDBC.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    // truy vấn theo id
    @Override
    public Sach selectById(Sach sach) {
        Sach ketQua = null;
        try {
            // Bước 1: Tạo kết nối đến CSDL
            Connection connection = JDBC.getConnection();

            // Bước 2: Tạo ra đối tượng statement
            String sql = "SELECT *FROM sach where id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sach.getId());

            // Bước 3: Thực thi câu lệnh SQL           
            ResultSet rs = st.executeQuery();

            // Bước 4: xử lý kết quả
            while(rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				ketQua = new Sach(id, tenSach, giaBan, namXuatBan);
			}

            // Bước 5: đóng kết kết
            JDBC.closeConnection(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    // truy vấn theo 1 điều kiện nào đó
    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        ArrayList<Sach> ketQua = new ArrayList<Sach>();
        try {
            // Bước 1: Tạo kết nối đến CSDL
            Connection connection = JDBC.getConnection();

            // Bước 2: Tạo ra đối tượng statement
            String sql = "SELECT *FROM sach where "+condition;
            PreparedStatement st = connection.prepareStatement(sql);

            // Bước 3: Thực thi câu lệnh SQL            
            ResultSet rs = st.executeQuery();
            
            // Bước 4: xử lý kết quả
            while(rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				ketQua.add(sach);
			}

            // Bước 5: đóng kết kết
            JDBC.closeConnection(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

}
