package util;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.DB;

public class ProjectUtil {

    public static String juadge(String username) {
        String sql = " select * from users where  username=? ";
        String userID = "-1";
        Object[] params = {username};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            while (rs.next()) {
                userID = rs.getString("id");
                break;
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return userID;
    }

}
