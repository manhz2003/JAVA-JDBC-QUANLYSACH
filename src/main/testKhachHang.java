package main;

import java.util.ArrayList;

import dao.khachHangDAO;
import module.khachHang;

public class testKhachHang {
    public static void main(String[] args) {
//         test insert
        khachHang khachHang = new khachHang(100, "Lương Thị Lan Anh", "11-05-2003", "Tuyên Quang");
        khachHangDAO.getInstance().insert(khachHang);

//         test update
//         khachHangDAO.getInstance().update(khachHang);
//
//         test delete
//         khachHangDAO.getInstance().delete(khachHang);
//
//         select all
//         ArrayList<khachHang> list = khachHangDAO.getInstance().selectAll();
//         for (khachHang khachHang2 : list) {
//             System.out.println(khachHang2.toString());
//         }
//
//         select by id
//         khachHang find = new khachHang();
//         find.setId(5);
//         khachHang khachHang2 = khachHangDAO.getInstance().selectById(find);
//         System.out.println(khachHang2);
//
//         select theo điều kiện
//         String condition1 = "diachi = 'Hà Nội'";
//         String condition2 = "namsinh = '05-03-2003'";
//         String condition3 = "id = 5";
//
//         ArrayList<khachHang> list = khachHangDAO.getInstance().selectByCondition(condition3);
//         for (khachHang khachHang2 : list) {
//             System.out.println(khachHang2.toString());
//         }
    }
}
