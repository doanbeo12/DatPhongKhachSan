package hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatPhongDAO {

    public boolean datPhong(
            DatPhong dp
    ) {

        String sql =
                "INSERT INTO datphong(maDatPhong, tenDangNhap, maPhong, ngayNhan, ngayTra) VALUES (?, ?, ?, ?, ?)";

        try (

                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setInt(
                    1,
                    dp.getMaDatPhong()
            );

            stmt.setString(
                    2,
                    dp.getTenDangNhap()
            );

            stmt.setString(
                    3,
                    dp.getMaPhong()
            );

            stmt.setDate(
                    4,
                    dp.getNgayNhan()
            );

            stmt.setDate(
                    5,
                    dp.getNgayTra()
            );

            stmt.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}