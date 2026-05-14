package hotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class LichSuThuePhongFrame extends JFrame {

    private TaiKhoan taiKhoan;

    private JTable table;

    private DefaultTableModel model;

    public LichSuThuePhongFrame(
            TaiKhoan taiKhoan
    ) {

        this.taiKhoan = taiKhoan;

        setTitle("Lịch sử thuê phòng");

        setSize(1000, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(15,23,42)
        );

        // =========================
        // TITLE
        // =========================
        JLabel lblTitle =
                new JLabel(
                        "LỊCH SỬ THUÊ PHÒNG",
                        SwingConstants.CENTER
                );

        lblTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        lblTitle.setForeground(
                Color.WHITE
        );

        lblTitle.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        0,
                        20,
                        0
                )
        );

        add(lblTitle, BorderLayout.NORTH);

        // =========================
        // TABLE
        // =========================
        model =
                new DefaultTableModel();

        model.addColumn("Mã phòng");

        model.addColumn("Tên phòng");

        model.addColumn("Ngày nhận");

        model.addColumn("Ngày trả");

        model.addColumn("Giá phòng");

        table =
                new JTable(model);

        table.setRowHeight(35);

        table.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        table.getTableHeader().setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15
                )
        );

        JScrollPane scrollPane =
                new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        // =========================
        // LOAD DATA
        // =========================
        loadLichSu();
    }

    // =========================
    // LOAD DATABASE
    // =========================
    private void loadLichSu() {

        model.setRowCount(0);

        try {

            String sql =
                    "SELECT * FROM datphong "
                    + "INNER JOIN phong "
                    + "ON datphong.maPhong = phong.maPhong "
                    + "WHERE tenDangNhap = ? "
                    + "ORDER BY ngayNhan DESC";

            java.sql.Connection conn =
                    DBConnection.getConnection();

            java.sql.PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setString(
                    1,
                    taiKhoan.getTenDangNhap()
            );

            ResultSet rs =
                    stmt.executeQuery();

            while (rs.next()) {

                model.addRow(
                        new Object[] {

                                rs.getString("maPhong"),

                                rs.getString("tenPhong"),

                                rs.getString("ngayNhan"),

                                rs.getString("ngayTra"),

                                rs.getDouble("giaPhong")
                        }
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}