package hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThemPhongDAO {

    // =========================
    // THÊM PHÒNG
    // =========================
    public boolean themPhong(
            Phong phong
    ) {

        String checkSQL =
                "SELECT * FROM phong WHERE maPhong = ?";

        String insertSQL =
                "INSERT INTO phong(maPhong, loaiPhong, giaPhong, trangThai) VALUES (?, ?, ?, ?)";

        try (

                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement checkStmt =
                        conn.prepareStatement(checkSQL)

        ) {

            // kiểm tra trùng mã phòng
            checkStmt.setString(
                    1,
                    phong.getMaPhong()
            );

            ResultSet rs =
                    checkStmt.executeQuery();

            if (rs.next()) {

                return false;
            }

            // insert phòng
            PreparedStatement insertStmt =
                    conn.prepareStatement(insertSQL);

            insertStmt.setString(
                    1,
                    phong.getMaPhong()
            );

            insertStmt.setString(
                    2,
                    phong.getLoaiPhong()
            );

            insertStmt.setDouble(
                    3,
                    phong.getGiaPhong()
            );

            insertStmt.setBoolean(
                    4,
                    phong.isTrangThai()
            );

            insertStmt.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}