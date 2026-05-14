package hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HoaDon {

    private String maHoaDon;

    private DatPhong datPhong;

    private LocalDate ngayLap;

    private double tongTien;

    public HoaDon(
            String maHoaDon,
            DatPhong datPhong,
            double giaPhong
    ) {

        this.maHoaDon = maHoaDon;

        this.datPhong = datPhong;

        this.ngayLap = LocalDate.now();

        long soNgay = ChronoUnit.DAYS.between(

                datPhong.getNgayNhan()
                        .toLocalDate(),

                datPhong.getNgayTra()
                        .toLocalDate()
        );

        this.tongTien =
                soNgay * giaPhong;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public DatPhong getDatPhong() {
        return datPhong;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setDatPhong(
            DatPhong datPhong
    ) {

        this.datPhong = datPhong;
    }

    public void setTongTien(
            double tongTien
    ) {

        this.tongTien = tongTien;
    }

    // =========================
    // HIỂN THỊ HÓA ĐƠN
    // =========================
    public void hienThiHoaDon() {

        System.out.println(
                "===== HÓA ĐƠN ====="
        );

        System.out.println(
                "Mã hóa đơn: "
                + maHoaDon
        );

        System.out.println(
                "Tài khoản: "
                + datPhong.getTenDangNhap()
        );

        System.out.println(
                "Phòng: "
                + datPhong.getMaPhong()
        );

        System.out.println(
                "Ngày nhận: "
                + datPhong.getNgayNhan()
        );

        System.out.println(
                "Ngày trả: "
                + datPhong.getNgayTra()
        );

        System.out.println(
                "Ngày lập: "
                + ngayLap
        );

        System.out.println(
                "Tổng tiền: "
                + tongTien
        );
    }
}