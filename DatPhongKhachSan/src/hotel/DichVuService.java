package hotel;

import java.util.ArrayList;
import java.util.List;

public class DichVuService {

    private List<DichVu> danhSachDV;

    public DichVuService() {
        danhSachDV = new ArrayList<>();
    }

    // Thêm dịch vụ
    public void themDV(DichVu dv) {

        if (dv.getMaDichVu() == null
                || dv.getMaDichVu().trim().isEmpty()) {

            System.out.println("Mã dịch vụ không được để trống.");
            return;
        }

        for (DichVu existDV : danhSachDV) {

            if (existDV.getMaDichVu()
                    .equals(dv.getMaDichVu())) {

                System.out.println("Mã dịch vụ đã tồn tại.");
                return;
            }
        }

        if (dv.getGia() <= 0) {

            System.out.println("Giá dịch vụ phải lớn hơn 0.");
            return;
        }

        if (dv.getTenDichVu() == null
                || dv.getTenDichVu().trim().isEmpty()) {

            System.out.println("Tên dịch vụ không được để trống.");
            return;
        }

        danhSachDV.add(dv);

        System.out.println("Thêm dịch vụ thành công.");
    }

    // Sửa dịch vụ
    public void suaDV(String maDV, DichVu dvMoi) {

        for (DichVu dv : danhSachDV) {

            if (dv.getMaDichVu().equals(maDV)) {

                dv.setTenDichVu(dvMoi.getTenDichVu());
                dv.setGia(dvMoi.getGia());

                System.out.println("Sửa dịch vụ thành công.");
                return;
            }
        }

        System.out.println("Không tìm thấy dịch vụ.");
    }

    // Xóa dịch vụ
    public void xoaDV(String maDV) {

        DichVu dvCanXoa = null;

        for (DichVu dv : danhSachDV) {

            if (dv.getMaDichVu().equals(maDV)) {
                dvCanXoa = dv;
                break;
            }
        }

        if (dvCanXoa != null) {

            danhSachDV.remove(dvCanXoa);

            System.out.println("Đã xóa dịch vụ " + maDV);

        } else {

            System.out.println("Không tìm thấy dịch vụ cần xóa.");
        }
    }

    // Tìm theo tên
    public List<DichVu> timDV(String tenDV) {

        List<DichVu> ketQua = new ArrayList<>();

        if (tenDV == null || tenDV.trim().isEmpty()) {
            return ketQua;
        }

        String keyword = tenDV.toLowerCase();

        for (DichVu dv : danhSachDV) {

            if (dv.getTenDichVu() != null
                    && dv.getTenDichVu()
                    .toLowerCase()
                    .contains(keyword)) {

                ketQua.add(dv);
            }
        }

        return ketQua;
    }

    // Tìm theo mã
    public DichVu timDVTheoMa(String maDV) {

        for (DichVu dv : danhSachDV) {

            if (dv.getMaDichVu().equals(maDV)) {
                return dv;
            }
        }

        return null;
    }

    // Hiển thị danh sách
    public void hienThiDanhSach() {

        if (danhSachDV.isEmpty()) {

            System.out.println("Danh sách dịch vụ trống.");

        } else {

            System.out.println("=== DANH SÁCH DỊCH VỤ ===");

            for (DichVu dv : danhSachDV) {

                System.out.println(
                        "Mã: " + dv.getMaDichVu()
                        + " - Tên: " + dv.getTenDichVu()
                        + " - Giá: " + dv.getGia()
                );
            }
        }
    }

    // Getter danh sách
    public List<DichVu> getDanhSachDV() {
        return danhSachDV;
    }
}