package dao;
import module.khachHang;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import database.JDBC;

public class khachHangDAO implements  daoInterface<khachHang>{
    public static khachHangDAO getInstance() {
        return new khachHangDAO();
    }

    //  thêm
    @Override
    public int insert(khachHang khachHang) {
        int ketQua;
        try {
            // Bước 1: Tạo kết nối đến CSDL
            Connection connection = JDBC.getConnection();

            // Bước 2: Tạo ra đối tượng statement
            String sql = "INSERT INTO khachHang (id, hoVaTen, ngaySinh, diaChi)" +
            " VALUES (?, ?, ?, ?)";
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, khachHang.getId());
            st.setString(2, khachHang.getHoVaTen());
            st.setString(3, khachHang.getNgaySinh());
            st.setString(4, khachHang.getDiaChi());

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

    //  sửa
    @Override
    public int update(khachHang khachHang) {
        int ketQua;
        try {
            // Bước 1: Tạo kết nối đến CSDL
            Connection connection = JDBC.getConnection();

            // Bước 2: Tạo ra đối tượng statement
            String sql = "UPDATE khachHang "+ "SET " +
                    " hoVaTen= ?" + ", ngaySinh= ?" + ", diaChi= ?" + " WHERE id= ?";
            PreparedStatement st = connection.prepareStatement(sql);            
            st.setString(1, khachHang.getHoVaTen());
            st.setString(2, khachHang.getNgaySinh());
            st.setString(3, khachHang.getDiaChi());
            st.setInt(4, khachHang.getId());

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
    public int delete(khachHang khachHang) {
        int ketQua;
        try {
            // Bước 1: Tạo kết nối đến CSDL
            Connection connection = JDBC.getConnection();

            // Bước 2: Tạo ra đối tượng statement
            String sql =  "DELETE FROM khachHang "+
            " WHERE id= ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, khachHang.getId());

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

    @Override
    public ArrayList<khachHang> selectAll() {
        ArrayList<khachHang> ketQua = new ArrayList<khachHang>();
            try {
                // Bước 1: Tạo kết nối đến CSDL
                Connection connection = JDBC.getConnection();
    
                // Bước 2: Tạo ra đối tượng statement
                String sql = "SELECT *FROM khachHang";
                PreparedStatement st = connection.prepareStatement(sql);
    
                // Bước 3: Thực thi câu lệnh SQL            
                ResultSet rs = st.executeQuery();
                
                // Bước 4: xử lý kết quả
                while(rs.next()) {
                    int id = rs.getInt("id");
                    String hoVaTen = rs.getString("hoVaTen");
                    String ngaySinh = rs.getString("ngaySinh");
                    String diaChi = rs.getString("diaChi");

                    khachHang khachHang = new khachHang(id, hoVaTen, ngaySinh, diaChi);
                    ketQua.add(khachHang);
                }
    
                // Bước 5: đóng kết kết
                JDBC.closeConnection(connection);
    
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return ketQua;
    }

    @Override
    public khachHang selectById(khachHang khachHang) {
            khachHang ketQua = null;
            try {
                // Bước 1: Tạo kết nối đến CSDL
                Connection connection = JDBC.getConnection();
    
                // Bước 2: Tạo ra đối tượng statement
                String sql = "SELECT *FROM khachHang where id = ?";
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, khachHang.getId());

                // Bước 3: Thực thi câu lệnh SQL            
                ResultSet rs = st.executeQuery();
                
                // Bước 4: xử lý kết quả
                while(rs.next()) {
                    int id = rs.getInt("id");
                    String hoVaTen = rs.getString("hoVaTen");
                    String ngaySinh = rs.getString("ngaySinh");
                    String diaChi = rs.getString("diaChi");

                    ketQua = new khachHang(id, hoVaTen, ngaySinh, diaChi);
                }
    
                // Bước 5: đóng kết kết
                JDBC.closeConnection(connection);
    
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return ketQua;
    }

    @Override
    public ArrayList<khachHang> selectByCondition(String condition) {
            ArrayList<khachHang> ketQua = new ArrayList<khachHang>();
            try {
                // Bước 1: Tạo kết nối đến CSDL
                Connection connection = JDBC.getConnection();
    
                // Bước 2: Tạo ra đối tượng statement
                String sql = "SELECT *FROM khachHang where "+condition;
                PreparedStatement st = connection.prepareStatement(sql);
    
                // Bước 3: Thực thi câu lệnh SQL            
                ResultSet rs = st.executeQuery();
                
                // Bước 4: xử lý kết quả
                while(rs.next()) {
                    int id = rs.getInt("id");
                    String hoVaTen = rs.getString("hoVaTen");
                    String ngaySinh = rs.getString("ngaySinh");
                    String diaChi = rs.getString("diaChi");

                    khachHang khachHang = new khachHang(id, hoVaTen, ngaySinh, diaChi);
                    ketQua.add(khachHang);
                }
    
                // Bước 5: đóng kết kết
                JDBC.closeConnection(connection);
    
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return ketQua;
    }
}