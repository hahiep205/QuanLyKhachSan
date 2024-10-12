package service;

import model.KhachHang;
import java.util.ArrayList;

public class QuanLyKhachHang {
    private ArrayList<KhachHang> DanhSachKhachHang;

    public QuanLyKhachHang() {
        DanhSachKhachHang = new ArrayList<>();
        DanhSachKhachHang.add(new KhachHang("Nguyen Duc A", "0812551230", "0000000001"));
        DanhSachKhachHang.add(new KhachHang("Mai Van B", "0912551230", "0000000002"));
        DanhSachKhachHang.add(new KhachHang("Nguyen Hong C", "0889999403", "0000000003"));
        DanhSachKhachHang.add(new KhachHang("Le Thi D", "0812442111", "0000000004"));
        DanhSachKhachHang.add(new KhachHang("Dang Duc E", "0912551230", "0000000005"));
    }

    public void ThemKhachHang(KhachHang KhachHang) {
        DanhSachKhachHang.add(KhachHang);
    }

    public KhachHang TimKiemKhachHang(String Key) {
        for (KhachHang kh : DanhSachKhachHang) {
            if (kh.getTen().toLowerCase().contains(Key.toLowerCase())
                    || kh.getSDT().contains(Key)
                    || kh.getCCCD().contains(Key)) {
                return kh;
            }
        }
        return null;
    }

    // Sửa thông tin khách hàng
    public void SuaKhachHang(String Key, String TenMoi, String sdtMoi, String cccdMoi) {
        KhachHang KhachHang = TimKiemKhachHang(Key);
        if (KhachHang != null) {
            KhachHang.setTen(TenMoi);
            KhachHang.setSDT(sdtMoi);
            KhachHang.setCCCD(cccdMoi);
            System.out.println("\nCâp nhật thông tin khách hàng thành công.");
        } else {
            System.out.println("\nKhông tìm thấy khách hàng.");
        }
    }


    public void XoaKhachHang(String Key) {
        KhachHang KhachHang = TimKiemKhachHang(Key);
        if (KhachHang != null) {
            DanhSachKhachHang.remove(KhachHang);
            System.out.println("\nXóa khách hàng thành công.");
        } else {
            System.out.println("\nKhông tìm thấy khách hàng.");
        }
    }

    public void HienThiDanhSachKH() {
        for (int i = 0; i < DanhSachKhachHang.size(); i++) {
            KhachHang kh = DanhSachKhachHang.get(i);
            System.out.println("\n- Khách hàng: " + kh.getTen()
                    + " - Số điện thọai: " + kh.getSDT()
                    + " - CCCD: " + kh.getCCCD());

            System.out.print("- Phòng đã thuê: ");
            ArrayList<String> LichSuPhong = kh.getLichSuDatPhong();
            for (int j = 0; j < LichSuPhong.size(); j++) {
                System.out.println(LichSuPhong.get(j));
            }
        }
    }

}
