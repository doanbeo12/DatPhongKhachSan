package hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaiKhoanDAO {

    // =========================
    // ĐĂNG KÝ
    // =========================
    public boolean dangKy(TaiKhoan tk) {

        String checkSQL =
                "SELECT * FROM taikhoan WHERE tenDangNhap = ?";

        String insertSQL =
                "INSERT INTO taikhoan(tenDangNhap, matKhau, vaiTro) VALUES (?, ?, ?)";

        try (

                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement checkStmt =
                        conn.prepareStatement(checkSQL)

        ) {

            checkStmt.setString(
                    1,
                    tk.getTenDangNhap()
            );

            ResultSet rs =
                    checkStmt.executeQuery();

            // tài khoản tồn tại
            if (rs.next()) {

                return false;
            }

            PreparedStatement insertStmt =
                    conn.prepareStatement(insertSQL);

            insertStmt.setString(
                    1,
                    tk.getTenDangNhap()
            );

            insertStmt.setString(
                    2,
                    tk.getMatKhau()
            );

            insertStmt.setString(
                    3,
                    tk.getVaiTro()
            );

            insertStmt.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // =========================
    // ĐĂNG NHẬP
    // =========================
    public TaiKhoan dangNhap(
            String tenDangNhap,
            String matKhau
    ) {

        String sql =
                "SELECT * FROM taikhoan WHERE tenDangNhap = ? AND matKhau = ?";

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

            stmt.setString(
                    2,
                    matKhau
            );

            ResultSet rs =
                    stmt.executeQuery();

            if (rs.next()) {

                return new TaiKhoan(

                        rs.getString("tenDangNhap"),

                        rs.getString("matKhau"),

                        rs.getString("vaiTro")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}