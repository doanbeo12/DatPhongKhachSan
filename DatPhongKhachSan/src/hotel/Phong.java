package hotel;

public class Phong {

    private String maPhong;

    private String tenPhong;

    private String loaiPhong;

    private double giaPhong;

    private boolean trangThai;

    private String moTa;

    public Phong(
            String maPhong,
            String tenPhong,
            String loaiPhong,
            double giaPhong,
            boolean trangThai,
            String moTa
    ) {

        this.maPhong = maPhong;

        this.tenPhong = tenPhong;

        this.loaiPhong = loaiPhong;

        this.giaPhong = giaPhong;

        this.trangThai = trangThai;

        this.moTa = moTa;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public double getGiaPhong() {
        return giaPhong;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public void setGiaPhong(double giaPhong) {
        this.giaPhong = giaPhong;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}