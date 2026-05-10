package hotel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField txtUsername;

    private JPasswordField txtPassword;

    private JButton btnLogin;

    private JButton btnRegister;

    private TaiKhoanService tkService;

    public LoginFrame() {

        tkService =
                new TaiKhoanService();

        setTitle("Hotel Management");

        setSize(900, 500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setResizable(false);

        setLayout(new BorderLayout());

     // =========================
     // LEFT PANEL
     // =========================
     JPanel leftPanel = new JPanel();

     leftPanel.setBackground(
             new Color(33, 45, 62)
     );

     leftPanel.setPreferredSize(
             new Dimension(420, 500)
     );

     leftPanel.setLayout(
             new BorderLayout()
     );

     // =========================
     // CENTER CONTENT
     // =========================
     JPanel centerPanel = new JPanel();

     centerPanel.setOpaque(false);

     centerPanel.setLayout(
             new BoxLayout(
                     centerPanel,
                     BoxLayout.Y_AXIS
             )
     );

     JLabel lblHotel =
             new JLabel("NHÓM 9");

     lblHotel.setFont(
             new Font(
                     "Segoe UI",
                     Font.BOLD,
                     32
             )
     );

     lblHotel.setForeground(
             Color.WHITE
     );

     lblHotel.setAlignmentX(
             Component.CENTER_ALIGNMENT
     );

     JLabel lblWelcome =
             new JLabel(
                     "HỆ THỐNG ĐẶT PHÒNG KHÁCH SẠN"
             );

     lblWelcome.setFont(
             new Font(
                     "Segoe UI",
                     Font.PLAIN,
                     18
             )
     );

     lblWelcome.setForeground(
             new Color(220, 220, 220)
     );

     lblWelcome.setAlignmentX(
             Component.CENTER_ALIGNMENT
     );

     centerPanel.add(Box.createVerticalGlue());

     centerPanel.add(lblHotel);

     centerPanel.add(
             Box.createRigidArea(
                     new Dimension(0, 20)
             )
     );

     centerPanel.add(lblWelcome);

     centerPanel.add(Box.createVerticalGlue());

     // =========================
     // SUPPORT PANEL
     // =========================
     JPanel supportPanel = new JPanel();

     supportPanel.setOpaque(false);

     supportPanel.setBorder(
             new EmptyBorder(
                     20,
                     30,
                     20,
                     30
             )
     );

     supportPanel.setLayout(
             new BoxLayout(
                     supportPanel,
                     BoxLayout.Y_AXIS
             )
     );

     JLabel lblSupport =
             new JLabel(
                     "Chăm sóc khách hàng"
             );

     lblSupport.setFont(
             new Font(
                     "Segoe UI",
                     Font.BOLD,
                     16
             )
     );

     lblSupport.setForeground(
             Color.WHITE
     );

     JLabel lblPhone =
             new JLabel(
                     "SĐT: 0857653159 - Đoàn"
             );

     lblPhone.setForeground(
             new Color(220, 220, 220)
     );

     JLabel lblEmail =
             new JLabel(
                     "doanbeo30@gmail.com"
             );

     lblEmail.setForeground(
             new Color(220, 220, 220)
     );

     JLabel lblTime =
             new JLabel(
                     "Hỗ trợ 24/7"
             );

     lblTime.setForeground(
             new Color(220, 220, 220)
     );

     supportPanel.add(lblSupport);

     supportPanel.add(
             Box.createRigidArea(
                     new Dimension(0, 10)
             )
     );

     supportPanel.add(lblPhone);

     supportPanel.add(lblEmail);

     supportPanel.add(lblTime);

     // =========================
     // ADD TO LEFT PANEL
     // =========================
     leftPanel.add(
             centerPanel,
             BorderLayout.CENTER
     );

     leftPanel.add(
             supportPanel,
             BorderLayout.SOUTH
     );
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

        JLabel lblTitle =
                new JLabel("Đăng nhập");

        lblTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );

        lblTitle.setBounds(
                70,
                20,
                300,
                40
        );

        rightPanel.add(lblTitle);

        // username
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

        txtUsername =
                new JTextField();

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

        // password
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

        // login button
        btnLogin =
                new JButton("Đăng nhập");

        btnLogin.setBounds(
                70,
                300,
                300,
                45
        );

        btnLogin.setBackground(
                new Color(33, 45, 62)
        );

        btnLogin.setForeground(
                Color.WHITE
        );

        btnLogin.setFocusPainted(false);

        btnLogin.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        rightPanel.add(btnLogin);

        // register button
        btnRegister =
                new JButton(
                        "Đăng ký tài khoản"
                );

        btnRegister.setBounds(
                70,
                360,
                300,
                40
        );

        btnRegister.setBackground(
                Color.WHITE
        );

        btnRegister.setForeground(
                new Color(33, 45, 62)
        );

        btnRegister.setFocusPainted(false);

        btnRegister.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        rightPanel.add(btnRegister);

        // =========================
        // LOGIN EVENT
        // =========================
        btnLogin.addActionListener(e -> {

            String username =
                    txtUsername.getText();

            String password =
                    new String(
                            txtPassword.getPassword()
                    );

            TaiKhoan tk =
                    tkService.dangNhap(
                            username,
                            password
                    );

            if (tk != null) {

            	JOptionPane.showMessageDialog(
            	        this,
            	        "Đăng nhập thành công"
            	);

            	new HomeFrame(tk)
            	        .setVisible(true);

            	dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Sai tài khoản hoặc mật khẩu"
                );
            }
        });

        // =========================
        // REGISTER EVENT
        // =========================
        btnRegister.addActionListener(e -> {

            new RegisterFrame()
                    .setVisible(true);

            dispose();
        });

        add(leftPanel, BorderLayout.WEST);

        add(rightPanel, BorderLayout.CENTER);
    }
}