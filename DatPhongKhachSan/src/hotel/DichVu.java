package hotel;
public class DichVu {

    private String maDichVu;
    private String tenDichVu;
    private double gia;

    public DichVu(String maDichVu,
                  String tenDichVu,
                  double gia) {

        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.gia = gia;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public double getGia() {
        return gia;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}