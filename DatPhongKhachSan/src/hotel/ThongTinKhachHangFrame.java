package hotel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThongTinKhachHangFrame extends JFrame {

    private TaiKhoan taiKhoan;

    public ThongTinKhachHangFrame(
            TaiKhoan taiKhoan
    ) {

        this.taiKhoan = taiKhoan;

        setTitle("Thông tin khách hàng");

        setSize(1280, 720);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setResizable(false);

        // =========================
        // BACKGROUND
        // =========================
        ImageIcon bgIcon =
                new ImageIcon(
                        getClass().getResource(
                                "/hotel/bgr.jpg"
                        )
                );

        Image bgImage =
                bgIcon.getImage().getScaledInstance(
                        1280,
                        720,
                        Image.SCALE_SMOOTH
                );

        JLabel mainPanel =
                new JLabel(
                        new ImageIcon(bgImage)
                );

        mainPanel.setLayout(null);

        setContentPane(mainPanel);

        // =========================
        // TITLE
        // =========================
        JLabel lblTitle =
                new JLabel(
                        "THÔNG TIN KHÁCH HÀNG",
                        SwingConstants.CENTER
                );

        lblTitle.setBounds(
                340,
                40,
                600,
                50
        );

        lblTitle.setForeground(
                Color.WHITE
        );

        lblTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        36
                )
        );

        mainPanel.add(lblTitle);

        // =========================
        // MAIN PANEL
        // =========================
        RoundedPanel infoPanel =
                new RoundedPanel(
                        40,
                        new Color(
                                255,
                                255,
                                255,
                                235
                        )
                );

        infoPanel.setLayout(null);

        infoPanel.setBounds(
                280,
                130,
                720,
                470
        );

        infoPanel.setBorder(
                new EmptyBorder(
                        20,
                        20,
                        20,
                        20
                )
        );

        mainPanel.add(infoPanel);

        Font labelFont =
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                );

        Font textFont =
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        17
                );

        // =========================
        // HỌ TÊN
        // =========================
        JLabel lblHoTen =
                new JLabel("Họ và tên");

        lblHoTen.setBounds(
                70,
                50,
                200,
                30
        );

        lblHoTen.setFont(labelFont);

        infoPanel.add(lblHoTen);

        JTextField txtHoTen =
                new JTextField();

        txtHoTen.setBounds(
                70,
                85,
                580,
                40
        );

        txtHoTen.setFont(textFont);

        infoPanel.add(txtHoTen);

        // =========================
        // NGÀY SINH
        // =========================
        JLabel lblNgaySinh =
                new JLabel("Ngày sinh");

        lblNgaySinh.setBounds(
                70,
                145,
                200,
                30
        );

        lblNgaySinh.setFont(labelFont);

        infoPanel.add(lblNgaySinh);

        JTextField txtNgaySinh =
                new JTextField();

        txtNgaySinh.setBounds(
                70,
                180,
                580,
                40
        );

        txtNgaySinh.setFont(textFont);

        infoPanel.add(txtNgaySinh);

        // =========================
        // EMAIL
        // =========================
        JLabel lblEmail =
                new JLabel("Email");

        lblEmail.setBounds(
                70,
                240,
                200,
                30
        );

        lblEmail.setFont(labelFont);

        infoPanel.add(lblEmail);

        JTextField txtEmail =
                new JTextField();

        txtEmail.setBounds(
                70,
                275,
                580,
                40
        );

        txtEmail.setFont(textFont);

        infoPanel.add(txtEmail);

        // =========================
        // SỐ ĐIỆN THOẠI
        // =========================
        JLabel lblSDT =
                new JLabel("Số điện thoại");

        lblSDT.setBounds(
                70,
                335,
                200,
                30
        );

        lblSDT.setFont(labelFont);

        infoPanel.add(lblSDT);

        JTextField txtSDT =
                new JTextField();

        txtSDT.setBounds(
                70,
                370,
                580,
                40
        );

        txtSDT.setFont(textFont);

        infoPanel.add(txtSDT);

        // =========================
        // LOAD DATABASE
        // =========================
        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM thongtinkhachhang "
                    + "WHERE tenDangNhap = ?";

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setString(
                    1,
                    taiKhoan.getTenDangNhap()
            );

            ResultSet rs =
                    stmt.executeQuery();

            if (rs.next()) {

                txtHoTen.setText(
                        rs.getString("hoTen")
                );

                txtNgaySinh.setText(
                        rs.getString("ngaySinh")
                );

                txtEmail.setText(
                        rs.getString("email")
                );

                txtSDT.setText(
                        rs.getString("soDienThoai")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        // =========================
        // BUTTON SAVE
        // =========================
        JButton btnSave =
                new JButton("Lưu thông tin");

        btnSave.setBounds(
                500,
                620,
                220,
                45
        );

        btnSave.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        btnSave.setBackground(
                new Color(34,197,94)
        );

        btnSave.setForeground(
                Color.WHITE
        );

        btnSave.setFocusPainted(false);

        mainPanel.add(btnSave);

        // =========================
        // BUTTON BACK
        // =========================
        JButton btnBack =
                new JButton("← Trang chủ");

        btnBack.setBounds(
                30,
                620,
                180,
                40
        );

        btnBack.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        btnBack.setBackground(
                new Color(45,45,45)
        );

        btnBack.setForeground(
                Color.WHITE
        );

        btnBack.setFocusPainted(false);

        mainPanel.add(btnBack);

        // =========================
        // EVENT BACK
        // =========================
        btnBack.addActionListener(e -> {

            new HomeFrame(
                    taiKhoan
            ).setVisible(true);

            dispose();
        });

        // =========================
        // EVENT SAVE
        // =========================
        btnSave.addActionListener(e -> {

            try {

                Connection conn =
                        DBConnection.getConnection();

                String checkSql =
                        "SELECT * FROM thongtinkhachhang "
                        + "WHERE tenDangNhap=?";

                PreparedStatement checkStmt =
                        conn.prepareStatement(checkSql);

                checkStmt.setString(
                        1,
                        taiKhoan.getTenDangNhap()
                );

                ResultSet rs =
                        checkStmt.executeQuery();

                if (rs.next()) {

                    String updateSql =
                            "UPDATE thongtinkhachhang "
                            + "SET hoTen=?, ngaySinh=?, email=?, soDienThoai=? "
                            + "WHERE tenDangNhap=?";

                    PreparedStatement stmt =
                            conn.prepareStatement(updateSql);

                    stmt.setString(
                            1,
                            txtHoTen.getText()
                    );

                    stmt.setString(
                            2,
                            txtNgaySinh.getText()
                    );

                    stmt.setString(
                            3,
                            txtEmail.getText()
                    );

                    stmt.setString(
                            4,
                            txtSDT.getText()
                    );

                    stmt.setString(
                            5,
                            taiKhoan.getTenDangNhap()
                    );

                    stmt.executeUpdate();

                } else {

                    String insertSql =
                            "INSERT INTO thongtinkhachhang "
                            + "(tenDangNhap, hoTen, ngaySinh, email, soDienThoai) "
                            + "VALUES (?, ?, ?, ?, ?)";

                    PreparedStatement stmt =
                            conn.prepareStatement(insertSql);

                    stmt.setString(
                            1,
                            taiKhoan.getTenDangNhap()
                    );

                    stmt.setString(
                            2,
                            txtHoTen.getText()
                    );

                    stmt.setString(
                            3,
                            txtNgaySinh.getText()
                    );

                    stmt.setString(
                            4,
                            txtEmail.getText()
                    );

                    stmt.setString(
                            5,
                            txtSDT.getText()
                    );

                    stmt.executeUpdate();
                }

                JOptionPane.showMessageDialog(

                        this,

                        "Lưu thông tin thành công"
                );

            } catch (Exception ex) {

                ex.printStackTrace();
            }
        });
    }
}