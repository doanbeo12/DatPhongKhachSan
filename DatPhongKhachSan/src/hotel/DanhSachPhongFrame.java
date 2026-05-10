package hotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DanhSachPhongFrame extends JFrame {

    private TaiKhoan taiKhoan;

    private JTable table;

    private DefaultTableModel model;

    public DanhSachPhongFrame(
            TaiKhoan taiKhoan
    ) {

        this.taiKhoan = taiKhoan;

        setTitle("Danh sách phòng");

        setSize(1000, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(15, 23, 42)
        );

        // =========================
        // TITLE
        // =========================
        JLabel lblTitle =
                new JLabel(
                        "DANH SÁCH PHÒNG",
                        SwingConstants.CENTER
                );

        lblTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        lblTitle.setForeground(Color.WHITE);

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

        model.addColumn("Loại phòng");

        model.addColumn("Giá phòng");

        model.addColumn("Trạng thái");

        model.addColumn("Mô tả");

        table =
                new JTable(model);

        table.setRowHeight(35);

        table.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        table.getTableHeader().setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        JScrollPane scrollPane =
                new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        // =========================
        // BOTTOM PANEL
        // =========================
        JPanel bottomPanel =
                new JPanel();

        bottomPanel.setBackground(
                new Color(15, 23, 42)
        );

        // chỉ admin thấy
        if (
                taiKhoan.getVaiTro()
                        .equals("admin")
        ) {

            JButton btnThemPhong =
                    new JButton("Thêm phòng");

            btnThemPhong.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            15
                    )
            );

            btnThemPhong.setBackground(
                    new Color(37, 99, 235)
            );

            btnThemPhong.setForeground(
                    Color.WHITE
            );

            btnThemPhong.setFocusPainted(false);

            bottomPanel.add(btnThemPhong);

            btnThemPhong.addActionListener(e -> {

                new ThemPhongFrame(this)
                        .setVisible(true);
            });
            JButton btnSuaPhong =
                    new JButton("Sửa phòng");

            btnSuaPhong.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            15
                    )
            );

            btnSuaPhong.setBackground(
                    new Color(234, 179, 8)
            );

            btnSuaPhong.setForeground(
                    Color.BLACK
            );

            btnSuaPhong.setFocusPainted(false);

            bottomPanel.add(btnSuaPhong);
            btnSuaPhong.addActionListener(e -> {

                int row =
                        table.getSelectedRow();

                if (row == -1) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Vui lòng chọn phòng cần sửa"
                    );

                    return;
                }

                String maPhong =
                        model.getValueAt(
                                row,
                                0
                        ).toString();

                PhongDAO dao =
                        new PhongDAO();

                Phong phong =
                        dao.timPhongTheoMa(maPhong);

                if (phong != null) {

                    new SuaPhongFrame(
                            this,
                            phong
                    ).setVisible(true);
                }
            });
            JButton btnXoaPhong =
                    new JButton("Xóa phòng");

            btnXoaPhong.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            15
                    )
            );

            btnXoaPhong.setBackground(
                    new Color(220, 38, 38)
            );

            btnXoaPhong.setForeground(
                    Color.WHITE
            );

            btnXoaPhong.setFocusPainted(false);

            bottomPanel.add(btnXoaPhong);
            btnXoaPhong.addActionListener(e -> {

                int row =
                        table.getSelectedRow();

                if (row == -1) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Vui lòng chọn phòng cần xóa"
                    );

                    return;
                }

                String maPhong =
                        model.getValueAt(
                                row,
                                0
                        ).toString();

                int confirm =
                        JOptionPane.showConfirmDialog(

                                this,

                                "Bạn có chắc muốn xóa phòng này?",

                                "Xóa phòng",

                                JOptionPane.YES_NO_OPTION
                        );

                if (
                        confirm ==
                        JOptionPane.YES_OPTION
                ) {

                    PhongDAO dao =
                            new PhongDAO();

                    boolean success =
                            dao.xoaPhong(maPhong);

                    if (success) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Xóa phòng thành công"
                        );

                        loadPhong();

                    } else {

                        JOptionPane.showMessageDialog(
                                this,
                                "Xóa phòng thất bại"
                        );
                    }
                }
            });
        }
        else {

            JButton btnChonPhong =
                    new JButton("Chọn phòng");

            btnChonPhong.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            15
                    )
            );

            btnChonPhong.setBackground(
                    new Color(34, 197, 94)
            );

            btnChonPhong.setForeground(
                    Color.WHITE
            );

            btnChonPhong.setFocusPainted(false);

            bottomPanel.add(btnChonPhong);

            // =========================
            // EVENT CHỌN PHÒNG
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

                PhongDAO dao =
                        new PhongDAO();

                Phong phong =
                        dao.timPhongTheoMa(maPhong);

                if (phong != null) {

                    if (phong.isTrangThai()) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Phòng đã được thuê"
                        );

                        return;
                    }

                    new ChiTietPhongFrame(
                            this,
                            taiKhoan,
                            phong
                    ).setVisible(true);
                }
            });
        }
        

        add(bottomPanel, BorderLayout.SOUTH);

        // =========================
        // LOAD DATABASE
        // =========================
        loadPhong();
    }

    // =========================
    // LOAD PHÒNG
    // =========================
    public void loadPhong() {

        model.setRowCount(0);

        String sql =
                "SELECT * FROM phong";

        try (

                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql);

                ResultSet rs =
                        stmt.executeQuery()

        ) {

            while (rs.next()) {

                String maPhong =
                        rs.getString("maPhong");

                String tenPhong =
                        rs.getString("tenPhong");

                String loaiPhong =
                        rs.getString("loaiPhong");

                double giaPhong =
                        rs.getDouble("giaPhong");

                boolean trangThai =
                        rs.getBoolean("trangThai");

                String moTa =
                        rs.getString("moTa");

                String textTrangThai;

                if (trangThai) {

                    textTrangThai =
                            "Đã sử dụng";

                } else {

                    textTrangThai =
                            "Còn trống";
                }

                model.addRow(
                        new Object[]{

                                maPhong,

                                tenPhong,

                                loaiPhong,

                                giaPhong,

                                textTrangThai,

                                moTa
                        }
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Lỗi load dữ liệu phòng"
            );
        }
    }
}