package hotel;

import javax.swing.*;
import java.awt.*;

public class SuaPhongFrame extends JFrame {

    private DanhSachPhongFrame parent;

    private Phong phong;

    private JTextField txtTenPhong;

    private JTextField txtLoaiPhong;

    private JTextField txtGiaPhong;

    private JTextArea txtMoTa;

    private JCheckBox chkTrangThai;

    public SuaPhongFrame(
            DanhSachPhongFrame parent,
            Phong phong
    ) {

        this.parent = parent;

        this.phong = phong;

        setTitle("Sửa phòng");

        setSize(500, 600);

        setLocationRelativeTo(null);

        setLayout(null);

        getContentPane().setBackground(
                new Color(15, 23, 42)
        );

        JLabel lblTitle =
                new JLabel(
                        "SỬA PHÒNG",
                        SwingConstants.CENTER
                );

        lblTitle.setBounds(
                100,
                20,
                300,
                40
        );

        lblTitle.setForeground(
                Color.WHITE
        );

        lblTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        add(lblTitle);

        Font font =
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                );

        JLabel lblTen =
                new JLabel("Tên phòng");

        lblTen.setBounds(
                40,
                100,
                120,
                30
        );

        lblTen.setForeground(
                Color.WHITE
        );

        lblTen.setFont(font);

        add(lblTen);

        txtTenPhong =
                new JTextField(
                        phong.getTenPhong()
                );

        txtTenPhong.setBounds(
                180,
                100,
                250,
                35
        );

        add(txtTenPhong);

        JLabel lblLoai =
                new JLabel("Loại phòng");

        lblLoai.setBounds(
                40,
                160,
                120,
                30
        );

        lblLoai.setForeground(
                Color.WHITE
        );

        lblLoai.setFont(font);

        add(lblLoai);

        txtLoaiPhong =
                new JTextField(
                        phong.getLoaiPhong()
                );

        txtLoaiPhong.setBounds(
                180,
                160,
                250,
                35
        );

        add(txtLoaiPhong);

        JLabel lblGia =
                new JLabel("Giá phòng");

        lblGia.setBounds(
                40,
                220,
                120,
                30
        );

        lblGia.setForeground(
                Color.WHITE
        );

        lblGia.setFont(font);

        add(lblGia);

        txtGiaPhong =
                new JTextField(
                        String.valueOf(
                                phong.getGiaPhong()
                        )
                );

        txtGiaPhong.setBounds(
                180,
                220,
                250,
                35
        );

        add(txtGiaPhong);

        JLabel lblMoTa =
                new JLabel("Mô tả");

        lblMoTa.setBounds(
                40,
                280,
                120,
                30
        );

        lblMoTa.setForeground(
                Color.WHITE
        );

        lblMoTa.setFont(font);

        add(lblMoTa);

        txtMoTa =
                new JTextArea(
                        phong.getMoTa()
                );

        JScrollPane scroll =
                new JScrollPane(txtMoTa);

        scroll.setBounds(
                180,
                280,
                250,
                90
        );

        add(scroll);

        chkTrangThai =
                new JCheckBox("Đã sử dụng");

        chkTrangThai.setSelected(
                phong.isTrangThai()
        );

        chkTrangThai.setBounds(
                180,
                390,
                150,
                30
        );

        chkTrangThai.setBackground(
                new Color(15, 23, 42)
        );

        chkTrangThai.setForeground(
                Color.WHITE
        );

        add(chkTrangThai);

        JButton btnLuu =
                new JButton("Lưu");

        btnLuu.setBounds(
                150,
                460,
                180,
                45
        );

        btnLuu.setBackground(
                new Color(37, 99, 235)
        );

        btnLuu.setForeground(
                Color.WHITE
        );

        btnLuu.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        add(btnLuu);

        btnLuu.addActionListener(e -> {

            try {

                phong.setTenPhong(
                        txtTenPhong.getText()
                );

                phong.setLoaiPhong(
                        txtLoaiPhong.getText()
                );

                phong.setGiaPhong(
                        Double.parseDouble(
                                txtGiaPhong.getText()
                        )
                );

                phong.setMoTa(
                        txtMoTa.getText()
                );

                phong.setTrangThai(
                        chkTrangThai.isSelected()
                );

                PhongDAO dao =
                        new PhongDAO();

                boolean success =
                        dao.suaPhong(phong);

                if (success) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Sửa phòng thành công"
                    );

                    parent.loadPhong();

                    dispose();
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Dữ liệu không hợp lệ"
                );
            }
        });
    }
}