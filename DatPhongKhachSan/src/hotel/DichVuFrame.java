package hotel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DichVuFrame extends JFrame {

    private TaiKhoan taiKhoan;

    public DichVuFrame(
            TaiKhoan taiKhoan
    ) {

        this.taiKhoan = taiKhoan;

        setTitle("Dịch vụ khách sạn");

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
                        "DỊCH VỤ KHÁCH SẠN",
                        SwingConstants.CENTER
                );

        lblTitle.setBounds(
                390,
                40,
                500,
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
        // PANEL
        // =========================
        RoundedPanel servicePanel =
                new RoundedPanel(
                        40,
                        new Color(
                                255,
                                255,
                                255,
                                235
                        )
                );

        servicePanel.setLayout(
                new GridLayout(
                        2,
                        3,
                        25,
                        25
                )
        );

        servicePanel.setBounds(
                120,
                140,
                1040,
                450
        );

        servicePanel.setBorder(
                new EmptyBorder(
                        25,
                        25,
                        25,
                        25
                )
        );

        // =========================
        // SERVICES
        // =========================
        servicePanel.add(
                createServiceCard(
                        "🍽",
                        "Ăn uống",
                        "Nhà hàng cao cấp"
                )
        );

        servicePanel.add(
                createServiceCard(
                        "🏊",
                        "Hồ bơi",
                        "Hồ bơi ngoài trời"
                )
        );

        servicePanel.add(
                createServiceCard(
                        "🏋",
                        "Gym",
                        "Phòng gym hiện đại"
                )
        );

        servicePanel.add(
                createServiceCard(
                        "💊",
                        "Sức khỏe",
                        "Dịch vụ chăm sóc sức khỏe"
                )
        );

        servicePanel.add(
                createServiceCard(
                        "🎮",
                        "Giải trí",
                        "Khu vui chơi giải trí"
                )
        );

        servicePanel.add(
                createServiceCard(
                        "💆",
                        "Spa",
                        "Massage & thư giãn"
                )
        );

        mainPanel.add(servicePanel);

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

        btnBack.addActionListener(e -> {

            new HomeFrame(
                    taiKhoan
            ).setVisible(true);

            dispose();
        });

        mainPanel.add(btnBack);
    }

    // =========================
    // CREATE CARD
    // =========================
    private RoundedPanel createServiceCard(

            String icon,

            String title,

            String desc
    ) {

        RoundedPanel panel =
                new RoundedPanel(
                        30,
                        Color.WHITE
                );

        panel.setLayout(null);

        JLabel lblIcon =
                new JLabel(
                        icon,
                        SwingConstants.CENTER
                );

        lblIcon.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        50
                )
        );

        lblIcon.setBounds(
                80,
                20,
                120,
                70
        );

        panel.add(lblIcon);

        JLabel lblTitle =
                new JLabel(
                        title,
                        SwingConstants.CENTER
                );

        lblTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24
                )
        );

        lblTitle.setBounds(
                0,
                100,
                280,
                40
        );

        panel.add(lblTitle);

        JLabel lblDesc =
                new JLabel(
                        desc,
                        SwingConstants.CENTER
                );

        lblDesc.setForeground(
                Color.GRAY
        );

        lblDesc.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        lblDesc.setBounds(
                0,
                145,
                280,
                30
        );

        panel.add(lblDesc);

        return panel;
    }
}