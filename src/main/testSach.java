package main;
import module.Sach;
import java.util.ArrayList;
import dao.sachDAO;


public class testSach {
    public static void main(String[] args) {

//         test insert
         Sach sach1 = new Sach("aaa", "Lập trình ruby", 70000, 2000);
//         Sach sach2 = new Sach("LTCc", "Lập trình C", 52000, 2005);
//
//         chèn 1 quyển sách
         sachDAO.getInstance().insert(sach1);
//
//         Chèn nhiều quyển sách
//         for (int i = 0; i < 20; i++) {
//         Sach sach = new Sach("LT"+i, "Lập trình "+i, 52000, 2005);
//         sachDAO.getInstance().insert(sach);
//         }
//
//         test update
//         Sach sach3 = new Sach("LTJV", "Lập trình java", 10, 2030);
//         sachDAO.getInstance().update(sach1);
//
//         test delete
//         for (int i = 0; i < 1000; i++) {
//         Sach sach = new Sach("LT"+i, "Lập trình i: "+i, 20000, 2015);
//         sachDAO.getInstance().delete(sach2);
//         }
//
//         xóa
//         sachDAO.getInstance().delete(sach1);
//
//         select all
//         ArrayList<Sach> list = sachDAO.getInstance().selectAll();
//         for (Sach sach : list) {
//             System.out.println(sach.toString());
//         }
//
//         select by id
//         Sach find = new Sach();
//         find.setId("LTC");
//         Sach sach = sachDAO.getInstance().selectById(find);
//         System.out.println(sach);
//
//         select theo điều kiện
//         String condition1 = "giaBan > 50000";
//         String condition2 = "namXuatBan = 2000";
//         String condition3 = "id = 'aaa'";
//
//         ArrayList<Sach> list = sachDAO.getInstance().selectByCondition(condition3);
//         for (Sach sach : list) {
//             System.out.println(sach.toString());
//         }
    }
}

