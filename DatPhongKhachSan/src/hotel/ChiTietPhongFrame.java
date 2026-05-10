package hotel;

import javax.swing.*;
import java.awt.*;

public class ChiTietPhongFrame extends JFrame {

    private DanhSachPhongFrame parent;

    private Phong phong;

    private TaiKhoan taiKhoan;

    public ChiTietPhongFrame(
            DanhSachPhongFrame parent,
            TaiKhoan taiKhoan,
            Phong phong
    ) {

        this.parent = parent;

        this.taiKhoan = taiKhoan;

        this.phong = phong;

        setTitle("Chi tiết phòng");

        setSize(500, 650);

        setLocationRelativeTo(null);

        setLayout(null);

        getContentPane().setBackground(
                new Color(15, 23, 42)
        );

        // =========================
        // TITLE
        // =========================
        JLabel lblTitle =
                new JLabel(
                        "CHI TIẾT PHÒNG",
                        SwingConstants.CENTER
                );

        lblTitle.setBounds(
                80,
                20,
                320,
                40
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

        add(lblTitle);

        Font font =
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                );

        int y = 100;

        addLabel(
                "Mã phòng: "
                        + phong.getMaPhong(),
                y,
                font
        );

        y += 50;

        addLabel(
                "Tên phòng: "
                        + phong.getTenPhong(),
                y,
                font
        );

        y += 50;

        addLabel(
                "Loại phòng: "
                        + phong.getLoaiPhong(),
                y,
                font
        );

        y += 50;

        addLabel(
                "Giá phòng: "
                        + phong.getGiaPhong(),
                y,
                font
        );

        y += 50;

        addLabel(
                "Mô tả: "
                        + phong.getMoTa(),
                y,
                font
        );

        // =========================
        // NGÀY NHẬN
        // =========================
        JLabel lblNgayNhan =
                new JLabel("Ngày nhận:");

        lblNgayNhan.setBounds(
                40,
                320,
                120,
                30
        );

        lblNgayNhan.setForeground(
                Color.WHITE
        );

        add(lblNgayNhan);

        JTextField txtNgayNhan =
                new JTextField();

        txtNgayNhan.setBounds(
                180,
                320,
                200,
                35
        );

        txtNgayNhan.setToolTipText(
                "dd/MM/yyyy"
        );

        add(txtNgayNhan);

        // =========================
        // NGÀY TRẢ
        // =========================
        JLabel lblNgayTra =
                new JLabel("Ngày trả:");

        lblNgayTra.setBounds(
                40,
                380,
                120,
                30
        );

        lblNgayTra.setForeground(
                Color.WHITE
        );

        add(lblNgayTra);

        JTextField txtNgayTra =
                new JTextField();

        txtNgayTra.setBounds(
                180,
                380,
                200,
                35
        );

        txtNgayTra.setToolTipText(
                "dd/MM/yyyy"
        );

        add(txtNgayTra);

        // =========================
        // BUTTON XÁC NHẬN
        // =========================
        JButton btnXacNhan =
                new JButton(
                        "Xác nhận thuê"
                );

        btnXacNhan.setBounds(
                140,
                470,
                200,
                45
        );

        btnXacNhan.setBackground(
                new Color(34, 197, 94)
        );

        btnXacNhan.setForeground(
                Color.WHITE
        );

        btnXacNhan.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        add(btnXacNhan);

        // =========================
        // EVENT
        // =========================
        btnXacNhan.addActionListener(e -> {

            int confirm =
                    JOptionPane.showConfirmDialog(

                            this,

                            "Xác nhận thuê phòng?",

                            "Xác nhận",

                            JOptionPane.YES_NO_OPTION
                    );

            if (
                    confirm
                            !=
                    JOptionPane.YES_OPTION
            ) {

                return;
            }

            // =========================
            // KIỂM TRA ĐÃ THUÊ
            // =========================
            if (
                    phong.isTrangThai()
            ) {

                JOptionPane.showMessageDialog(

                        this,

                        "Phòng này đã được thuê"
                );

                return;
            }

            try {

                // =========================
                // FORMAT DATE
                // =========================
                java.time.format.DateTimeFormatter formatter =
                        java.time.format.DateTimeFormatter.ofPattern(
                                "d/M/yyyy"
                        );

                java.time.LocalDate ngayNhan =
                        java.time.LocalDate.parse(
                                txtNgayNhan.getText(),
                                formatter
                        );

                java.time.LocalDate ngayTra =
                        java.time.LocalDate.parse(
                                txtNgayTra.getText(),
                                formatter
                        );

                // =========================
                // KIỂM TRA NGÀY
                // =========================
                if (
                        ngayTra.isBefore(ngayNhan)
                        ||
                        ngayTra.isEqual(ngayNhan)
                ) {

                    JOptionPane.showMessageDialog(

                            this,

                            "Ngày trả phải sau ngày nhận"
                    );

                    return;
                }

                // =========================
                // TẠO ĐẶT PHÒNG
                // =========================
                DatPhong dp =
                        new DatPhong(

                                0,

                                taiKhoan.getTenDangNhap(),

                                phong.getMaPhong(),

                                java.sql.Date.valueOf(
                                        ngayNhan
                                ),

                                java.sql.Date.valueOf(
                                        ngayTra
                                )
                        );

                // =========================
                // INSERT DATABASE
                // =========================
                DatPhongDAO datPhongDAO =
                        new DatPhongDAO();

                boolean datPhongSuccess =
                        datPhongDAO.datPhong(dp);

                if (!datPhongSuccess) {

                    JOptionPane.showMessageDialog(

                            this,

                            "Đặt phòng thất bại"
                    );

                    return;
                }

                // =========================
                // UPDATE TRẠNG THÁI PHÒNG
                // =========================
                PhongDAO phongDAO =
                        new PhongDAO();

                phongDAO.capNhatTrangThaiPhong(

                        phong.getMaPhong(),

                        true
                );

                // =========================
                // HÓA ĐƠN
                // =========================
                HoaDon hd =
                        new HoaDon(

                                "HD"
                                        + System.currentTimeMillis(),

                                dp,

                                phong.getGiaPhong()
                        );

                hd.hienThiHoaDon();

                // =========================
                // SUCCESS
                // =========================
                JOptionPane.showMessageDialog(

                        this,

                        "Thuê phòng thành công"
                );

                parent.loadPhong();

                dispose();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(

                        this,

                        "Ngày phải có dạng dd/MM/yyyy",

                        "Lỗi",

                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    // =========================
    // LABEL
    // =========================
    private void addLabel(

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

        add(label);
    }
}