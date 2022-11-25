package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.JDBC;
import module.User;

public class userDAO implements daoInterface<User>{

	public static userDAO getInstance() {
		return new userDAO();
	}
	
	@Override
	public int insert(User t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC.getConnection();
			
			// Bước 2: tạo ra đối tượng PreparedStatement
			String sql = "INSERT INTO User (userName, passWord, fullName) "+
					" VALUES (?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUserName());
			st.setString(2, t.getPassWord());
			st.setString(3, t.getFullName());
			
			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();
			
			// Bước 4: xử lý kết quả
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5: đóng kết nối
			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int update(User t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE User "+
					 " SET " +
					 " passWord=?"+
					 ", fullName=?"+
					 " WHERE userName=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getPassWord());
			st.setString(2, t.getFullName());
			st.setString(3, t.getUserName());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4: xử lý kết quả
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5: đóng kết nối
			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int delete(User t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from User "+
					 " WHERE userName=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUserName());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4: xử lý kết quả
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5: đóng kết nối
			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	// truy vấn tất cả không điều kiện
	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> ketQua = new ArrayList<User>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM User";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4: xử lý kết quả
			while(rs.next()) {
				String userName = rs.getString("userName");
				String passWord = rs.getString("passWord");
				String fullName = rs.getString("fullName");
				
				User User = new User(userName, passWord, fullName);
				ketQua.add(User);
			}
			
			// Bước 5: đóng kết nối
			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	// truy vấn theo id
	@Override
	public User selectById(User t) {
		User ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM User where userName=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUserName());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4: xử lý kết quả
			while(rs.next()) {
				String userName = rs.getString("userName");
				String passWord = rs.getString("passWord");
				String fullName = rs.getString("fullName");				
				ketQua = new User(userName, passWord, fullName);				
			}						
			// Bước 5: đóng kết nối
			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	// truy vấn theo điều kiện
	@Override
	public ArrayList<User> selectByCondition(String condition) {
		ArrayList<User> ketQua = new ArrayList<User>();	
		try {
            // Bước 1: Tạo kết nối đến CSDL
            Connection connection = JDBC.getConnection();
			String sql = "SELECT *FROM user where "+ condition;
            // Bước 2: Tạo ra đối tượng statement
            PreparedStatement st = connection.prepareStatement(sql);
            // Bước 3: Thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            // Bước 4: xử lý kết quả
            while(rs.next()) {
				String userName = rs.getString("userName");
				String passWord = rs.getString("passWord");
				String fullName = rs.getString("fullName");
				User user = new User(userName, passWord, fullName);
				ketQua.add(user);
			}

            // Bước 5: đóng kết kết
            JDBC.closeConnection(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
	}

}