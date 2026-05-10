package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatPhongService {

    private List<DatPhong> danhSachDatPhong;

    private List<HoaDon> danhSachHoaDon;

    public DatPhongService() {

        danhSachDatPhong =
                new ArrayList<>();

        danhSachHoaDon =
                new ArrayList<>();
    }

    // =========================
    // THÊM ĐẶT PHÒNG
    // =========================
    public void themDatPhong(
            DatPhong dp
    ) {

        // kiểm tra ngày hợp lệ
        if (
                dp.getNgayTra()
                        .toLocalDate()
                        .isBefore(
                                dp.getNgayNhan()
                                        .toLocalDate()
                        )

                ||

                dp.getNgayTra()
                        .toLocalDate()
                        .isEqual(
                                dp.getNgayNhan()
                                        .toLocalDate()
                        )
        ) {

            System.out.println(
                    "Ngày trả phải sau ngày nhận."
            );

            return;
        }

        // kiểm tra trùng lịch
        for (DatPhong datPhong
                : danhSachDatPhong) {

            if (
                    datPhong.getMaPhong()
                            .equals(
                                    dp.getMaPhong()
                            )
            ) {

                LocalDate ngayNhanMoi =
                        dp.getNgayNhan()
                                .toLocalDate();

                LocalDate ngayTraMoi =
                        dp.getNgayTra()
                                .toLocalDate();

                LocalDate ngayNhanCu =
                        datPhong.getNgayNhan()
                                .toLocalDate();

                LocalDate ngayTraCu =
                        datPhong.getNgayTra()
                                .toLocalDate();

                boolean trungLich =

                        !(ngayTraMoi.isBefore(
                                ngayNhanCu
                        )

                        ||

                        ngayNhanMoi.isAfter(
                                ngayTraCu
                        ));

                if (trungLich) {

                    System.out.println(
                            "Phòng đã được đặt trong khoảng thời gian này."
                    );

                    return;
                }
            }
        }

        danhSachDatPhong.add(dp);

        System.out.println(
                "Đặt phòng thành công."
        );
    }

    // =========================
    // XÓA ĐẶT PHÒNG
    // =========================
    public void xoaDatPhong(
            int maDatPhong
    ) {

        DatPhong canXoa = null;

        for (DatPhong dp
                : danhSachDatPhong) {

            if (
                    dp.getMaDatPhong()
                            == maDatPhong
            ) {

                canXoa = dp;

                break;
            }
        }

        if (canXoa != null) {

            danhSachDatPhong.remove(
                    canXoa
            );

            System.out.println(
                    "Xóa đặt phòng thành công."
            );

        } else {

            System.out.println(
                    "Không tìm thấy đặt phòng."
            );
        }
    }

    // =========================
    // TÌM ĐẶT PHÒNG
    // =========================
    public DatPhong timDatPhong(
            int maDatPhong
    ) {

        for (DatPhong dp
                : danhSachDatPhong) {

            if (
                    dp.getMaDatPhong()
                            == maDatPhong
            ) {

                return dp;
            }
        }

        return null;
    }

    // =========================
    // HIỂN THỊ DS ĐẶT PHÒNG
    // =========================
    public void hienThiDanhSachDatPhong() {

        if (
                danhSachDatPhong.isEmpty()
        ) {

            System.out.println(
                    "Danh sách đặt phòng trống."
            );

            return;
        }

        System.out.println(
                "=== DANH SÁCH ĐẶT PHÒNG ==="
        );

        for (DatPhong dp
                : danhSachDatPhong) {

            System.out.println(

                    "Mã: "
                    + dp.getMaDatPhong()

                    + " | Tài khoản: "

                    + dp.getTenDangNhap()

                    + " | Phòng: "

                    + dp.getMaPhong()

                    + " | Nhận: "

                    + dp.getNgayNhan()

                    + " | Trả: "

                    + dp.getNgayTra()
            );
        }
    }

    // =========================
    // GETTER
    // =========================
    public List<DatPhong>
    getDanhSachDatPhong() {

        return danhSachDatPhong;
    }

    public List<HoaDon>
    getDanhSachHoaDon() {

        return danhSachHoaDon;
    }
}