package hotel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RegisterFrame extends JFrame {

    private JTextField txtUsername;

    private JPasswordField txtPassword;

    private JButton btnRegister;

    private JButton btnBack;

    private TaiKhoanService tkService;

    public RegisterFrame() {

        tkService = new TaiKhoanService();

        setTitle("Đăng ký tài khoản");

        setSize(900, 500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        setLayout(new BorderLayout());

        // =========================
        // LEFT PANEL
        // =========================
        JPanel leftPanel = new JPanel();

        leftPanel.setBackground(
                new Color(52, 73, 94)
        );

        leftPanel.setPreferredSize(
                new Dimension(420, 500)
        );

        leftPanel.setLayout(
                new BoxLayout(
                        leftPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel lblTitle =
                new JLabel("TẠO TÀI KHOẢN");
        lblTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );

        lblTitle.setForeground(Color.WHITE);

        lblTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel lblDesc =
                new JLabel(
                        "Hệ thống đặt phòng khách sạn"
                );

        lblDesc.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        18
                )
        );

        lblDesc.setForeground(
                new Color(220, 220, 220)
        );

        lblDesc.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        leftPanel.add(Box.createVerticalGlue());

        leftPanel.add(lblTitle);

        leftPanel.add(
                Box.createRigidArea(
                        new Dimension(0, 20)
                )
        );

        leftPanel.add(lblDesc);

        leftPanel.add(Box.createVerticalGlue());

        // =========================
        // RIGHT PANEL
        // =========================
        JPanel rightPanel = new JPanel();

        rightPanel.setBackground(Color.WHITE);

        rightPanel.setBorder(
                new EmptyBorder(
                        60,
                        60,
                        60,
                        60
                )
        );

        rightPanel.setLayout(null);

        JLabel lblRegister =
                new JLabel("Đăng ký");

        lblRegister.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );

        lblRegister.setBounds(
                70,
                20,
                300,
                40
        );

        rightPanel.add(lblRegister);

        JLabel lblUser =
                new JLabel("Tên đăng nhập");

        lblUser.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        lblUser.setBounds(
                70,
                100,
                200,
                25
        );

        rightPanel.add(lblUser);

        txtUsername = new JTextField();

        txtUsername.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        txtUsername.setBounds(
                70,
                130,
                300,
                40
        );

        rightPanel.add(txtUsername);

        JLabel lblPass =
                new JLabel("Mật khẩu");

        lblPass.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        lblPass.setBounds(
                70,
                190,
                200,
                25
        );

        rightPanel.add(lblPass);

        txtPassword =
                new JPasswordField();

        txtPassword.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        txtPassword.setBounds(
                70,
                220,
                300,
                40
        );

        rightPanel.add(txtPassword);

        btnRegister =
                new JButton(
                        "Tạo tài khoản"
                );

        btnRegister.setBounds(
                70,
                300,
                300,
                45
        );

        btnRegister.setBackground(
                new Color(52, 73, 94)
        );

        btnRegister.setForeground(
                Color.WHITE
        );

        btnRegister.setFocusPainted(false);

        btnRegister.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        rightPanel.add(btnRegister);

        btnBack =
                new JButton(
                        "Quay lại đăng nhập"
                );

        btnBack.setBounds(
                70,
                360,
                300,
                40
        );

        btnBack.setBackground(
                Color.WHITE
        );

        btnBack.setForeground(
                new Color(52, 73, 94)
        );

        btnBack.setFocusPainted(false);

        btnBack.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        rightPanel.add(btnBack);

        // =========================
        // REGISTER EVENT
        // =========================
        btnRegister.addActionListener(e -> {

            String username =
                    txtUsername.getText();

            String password =
                    new String(
                            txtPassword.getPassword()
                    );

            boolean success =
                    tkService.dangKy(
                            username,
                            password
                    );

            if (success) {

                JOptionPane.showMessageDialog(
                        this,
                        "Đăng ký thành công"
                );

                new LoginFrame()
                        .setVisible(true);

                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Đăng ký thất bại"
                );
            }
        });

        // =========================
        // BACK TO LOGIN
        // =========================
        btnBack.addActionListener(e -> {

            new LoginFrame()
                    .setVisible(true);

            dispose();
        });

        add(leftPanel, BorderLayout.WEST);

        add(rightPanel, BorderLayout.CENTER);
    }
}