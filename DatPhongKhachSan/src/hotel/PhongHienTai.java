package hotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class PhongHienTai extends JFrame {

    private TaiKhoan taiKhoan;

    private JTable table;

    private DefaultTableModel model;

    public PhongHienTai(
            TaiKhoan taiKhoan
    ) {

        this.taiKhoan = taiKhoan;

        setTitle("Phòng hiện tại");

        setSize(900, 600);

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
                        "PHÒNG ĐANG ĐẶT",
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
        // BUTTON PANEL
        // =========================
        JPanel bottomPanel =
                new JPanel();

        bottomPanel.setBackground(
                new Color(15,23,42)
        );

        JButton btnChonPhong =
                new JButton("Chọn phòng");

        btnChonPhong.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        btnChonPhong.setBackground(
                new Color(59,130,246)
        );

        btnChonPhong.setForeground(
                Color.WHITE
        );

        btnChonPhong.setFocusPainted(false);

        bottomPanel.add(btnChonPhong);

        add(bottomPanel, BorderLayout.SOUTH);

        // =========================
        // LOAD DATA
        // =========================
        loadPhongDangDat();

        // =========================
        // BUTTON EVENT
        // =========================
        btnChonPhong.addActionListener(e -> {

            int row =
                    table.getSelectedRow();

            if (row == -1) {

                JOptionPane.showMessageDialog(

                        this,

                        "Vui lòng chọn phòng"
                );

                return;
            }

            String maPhong =
                    model.getValueAt(
                            row,
                            0
                    ).toString();

            hienThiChiTietPhong(maPhong);
        });
    }

    // =========================
    // LOAD ROOM
    // =========================
    private void loadPhongDangDat() {

        model.setRowCount(0);

        try {

            String sql =
                    "SELECT * FROM datphong "
                    + "INNER JOIN phong "
                    + "ON datphong.maPhong = phong.maPhong "
                    + "WHERE tenDangNhap = ?";

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
                        new Object[]{

                                rs.getString("maPhong"),

                                rs.getString("tenPhong"),

                                rs.getString("ngayNhan"),

                                rs.getString("ngayTra")
                        }
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // =========================
    // SHOW DETAIL
    // =========================
    private void hienThiChiTietPhong(
            String maPhong
    ) {

        try {

            String sql =
                    "SELECT * FROM datphong "
                    + "INNER JOIN phong "
                    + "ON datphong.maPhong = phong.maPhong "
                    + "WHERE datphong.maPhong = ? "
                    + "AND tenDangNhap = ?";

            java.sql.Connection conn =
                    DBConnection.getConnection();

            java.sql.PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setString(
                    1,
                    maPhong
            );

            stmt.setString(
                    2,
                    taiKhoan.getTenDangNhap()
            );

            ResultSet rs =
                    stmt.executeQuery();

            if (rs.next()) {

                JFrame frame =
                        new JFrame("Chi tiết phòng");

                frame.setSize(500, 550);

                frame.setLocationRelativeTo(null);

                frame.setLayout(null);

                frame.getContentPane().setBackground(
                        new Color(15,23,42)
                );

                Font font =
                        new Font(
                                "Segoe UI",
                                Font.PLAIN,
                                18
                        );

                JLabel lblMaPhong =
                        createLabel(
                                "Mã phòng: "
                                + rs.getString("maPhong"),
                                40,
                                font
                        );

                frame.add(lblMaPhong);

                JLabel lblTenPhong =
                        createLabel(
                                "Tên phòng: "
                                + rs.getString("tenPhong"),
                                90,
                                font
                        );

                frame.add(lblTenPhong);

                JLabel lblNgayNhan =
                        createLabel(
                                "Ngày nhận: "
                                + rs.getString("ngayNhan"),
                                140,
                                font
                        );

                frame.add(lblNgayNhan);

                JLabel lblNgayTra =
                        createLabel(
                                "Ngày trả: "
                                + rs.getString("ngayTra"),
                                190,
                                font
                        );

                frame.add(lblNgayTra);

                JLabel lblGia =
                        createLabel(
                                "Giá phòng: "
                                + rs.getDouble("giaPhong"),
                                240,
                                font
                        );

                frame.add(lblGia);

                JButton btnHoaDon =
                        new JButton("Xem hóa đơn");

                btnHoaDon.setBounds(
                        150,
                        350,
                        180,
                        45
                );

                btnHoaDon.setBackground(
                        new Color(34,197,94)
                );

                btnHoaDon.setForeground(
                        Color.WHITE
                );

                btnHoaDon.setFocusPainted(false);

                btnHoaDon.setFont(
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                16
                        )
                );

                frame.add(btnHoaDon);

                String maPhongHD =
                        rs.getString("maPhong");

                String tenPhongHD =
                        rs.getString("tenPhong");

                String ngayNhanHD =
                        rs.getString("ngayNhan");

                String ngayTraHD =
                        rs.getString("ngayTra");

                double giaPhongHD =
                        rs.getDouble("giaPhong");

                btnHoaDon.addActionListener(ev -> {

                    try {

                        java.time.LocalDate ngayNhan =
                                java.time.LocalDate.parse(
                                        ngayNhanHD
                                );

                        java.time.LocalDate ngayTra =
                                java.time.LocalDate.parse(
                                        ngayTraHD
                                );

                        long soNgay =
                                java.time.temporal.ChronoUnit.DAYS.between(
                                        ngayNhan,
                                        ngayTra
                                );

                        double tongTien =
                                soNgay * giaPhongHD;

                        DatPhong dp =
                                new DatPhong(

                                        0,

                                        taiKhoan.getTenDangNhap(),

                                        maPhongHD,

                                        java.sql.Date.valueOf(ngayNhanHD),

                                        java.sql.Date.valueOf(ngayTraHD)
                                );

                        HoaDon hd =
                                new HoaDon(

                                        "HD" + System.currentTimeMillis(),

                                        dp,

                                        giaPhongHD
                                );

                        JOptionPane.showMessageDialog(

                                frame,

                                hd.toString(),

                                "Hóa đơn",

                                JOptionPane.INFORMATION_MESSAGE
                        );

                    } catch (Exception ex) {

                        ex.printStackTrace();
                    }
                });

                frame.setVisible(true);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // =========================
    // CREATE LABEL
    // =========================
    private JLabel createLabel(
            String text,
            int y,
            Font font
    ) {

        JLabel label =
                new JLabel(text);

        label.setBounds(
                40,
                y,
                400,
                30
        );

        label.setForeground(
                Color.WHITE
        );

        label.setFont(font);

        return label;
    }
}