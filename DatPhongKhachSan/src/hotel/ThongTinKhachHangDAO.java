package hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThongTinKhachHangDAO {

    public String layHoTen(
            String tenDangNhap
    ) {

        String sql =
                "SELECT hoTen FROM thongtinkhachhang "
                + "WHERE tenDangNhap = ?";

        try (

                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setString(
                    1,
                    tenDangNhap
            );

            ResultSet rs =
                    stmt.executeQuery();

            if (rs.next()) {

                return rs.getString("hoTen");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}