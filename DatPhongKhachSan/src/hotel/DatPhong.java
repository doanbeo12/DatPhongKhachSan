package hotel;

import java.sql.Date;

public class DatPhong {

    private int maDatPhong;

    private String tenDangNhap;

    private String maPhong;

    private Date ngayNhan;

    private Date ngayTra;

    public DatPhong(
            int maDatPhong,
            String tenDangNhap,
            String maPhong,
            Date ngayNhan,
            Date ngayTra
    ) {

        this.maDatPhong = maDatPhong;

        this.tenDangNhap = tenDangNhap;

        this.maPhong = maPhong;

        this.ngayNhan = ngayNhan;

        this.ngayTra = ngayTra;
    }

    public int getMaDatPhong() {
        return maDatPhong;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public Date getNgayTra() {
        return ngayTra;
    }
}