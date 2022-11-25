package dao;
// dao là viết tắt của Data Access Object: đối tượng truy xuất dữ liệu
import java.sql.SQLException;
import java.util.ArrayList;

public interface daoInterface<T> {

    public int insert(T t) throws SQLException;

    public int update(T t);

    public int delete(T t);

    public ArrayList<T> selectAll();

    public T selectById(T t);

    public ArrayList<T> selectByCondition(String condition);

}
