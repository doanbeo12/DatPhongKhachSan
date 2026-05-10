package hotel;

import javax.swing.*;

public class DatPhongFrame extends JFrame {

    public DatPhongFrame(
            TaiKhoan taiKhoan
    ) {

        setTitle("Đặt phòng");

        setSize(1000, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        add(
                new DanhSachPhongFrame(
                        taiKhoan
                ).getContentPane()
        );
    }
}