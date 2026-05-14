package hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HoaDon {

    private String maHoaDon;

    private DatPhong datPhong;

    private LocalDate ngayLap;

    private double tongTien;

    private double giaPhong;

    public HoaDon(
            String maHoaDon,
            DatPhong datPhong,
            double giaPhong
    ) {

        this.maHoaDon = maHoaDon;

        this.datPhong = datPhong;

        this.giaPhong = giaPhong;

        this.ngayLap = LocalDate.now();

        long soNgay =
                ChronoUnit.DAYS.between(

                        datPhong.getNgayNhan()
                                .toLocalDate(),

                        datPhong.getNgayTra()
                                .toLocalDate()
                );

        this.tongTien =
                soNgay * giaPhong;
    }

    // =========================
    // GETTER
    // =========================
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

    public double getGiaPhong() {

        return giaPhong;
    }

    // =========================
    // SETTER
    // =========================
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
    // TÍNH SỐ NGÀY THUÊ
    // =========================
    public long getSoNgayThue() {

        return ChronoUnit.DAYS.between(

                datPhong.getNgayNhan()
                        .toLocalDate(),

                datPhong.getNgayTra()
                        .toLocalDate()
        );
    }

    // =========================
    // HIỂN THỊ CONSOLE
    // =========================
    public void hienThiHoaDon() {

        System.out.println(toString());
    }

    // =========================
    // TO STRING
    // =========================
    @Override
    public String toString() {

        return

                "===== HÓA ĐƠN =====\n\n"

                + "Mã hóa đơn: "
                + maHoaDon

                + "\nTài khoản: "
                + datPhong.getTenDangNhap()

                + "\nMã phòng: "
                + datPhong.getMaPhong()

                + "\nNgày nhận: "
                + datPhong.getNgayNhan()

                + "\nNgày trả: "
                + datPhong.getNgayTra()

                + "\nSố ngày thuê: "
                + getSoNgayThue()

                + "\nGiá phòng: "
                + String.format(
                        "%,.0f",
                        giaPhong
                )
                + " VND"

                + "\n\nTỔNG TIỀN: "
                + String.format(
                        "%,.0f",
                        tongTien
                )
                + " VND"

                + "\n\nNgày lập: "
                + ngayLap;
    }
}