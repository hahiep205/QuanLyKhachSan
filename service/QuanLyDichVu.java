package service;

import model.DichVu;
import java.util.ArrayList;
import model.KhachHang;

public class QuanLyDichVu {
    private ArrayList<DichVu> DanhSachDichVu;

    public QuanLyDichVu() {
        DanhSachDichVu = new ArrayList<>();
        DanhSachDichVu.add(new DichVu("Ăn sáng", 100000));
        DanhSachDichVu.add(new DichVu("Đưa đón", 200000));
        DanhSachDichVu.add(new DichVu("Giặt ủi", 50000));
        DanhSachDichVu.add(new DichVu("Spa", 300000));
    }

    public void ThemDichVu(DichVu DichVu) {
        DanhSachDichVu.add(DichVu);
    }

    public void HienThiDichVu() {
        for (int i = 0; i < DanhSachDichVu.size(); i++) {
            DichVu dv = DanhSachDichVu.get(i);
            System.out.println((i + 1) + ": " + dv.getTenDichVu() + " - Giá tiền: " + dv.getGia());
        }
    }

    public DichVu TimKiemDichVu(String TenDichVu) {
        for (int i = 0; i < DanhSachDichVu.size(); i++) {
            DichVu dv = DanhSachDichVu.get(i);
            if (dv.getTenDichVu().equalsIgnoreCase(TenDichVu)) {
                return dv;
            }
        }
        return null;
    }


}
