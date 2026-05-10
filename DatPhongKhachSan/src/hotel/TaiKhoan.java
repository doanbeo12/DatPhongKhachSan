package hotel;

public class TaiKhoan {

    private String tenDangNhap;
    private String matKhau;
    private String vaiTro;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenDangNhap,
                    String matKhau,
                    String vaiTro) {

        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }
}