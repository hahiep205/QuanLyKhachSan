package service;

import java.text.SimpleDateFormat;
import model.NhanVien;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class QuanLyNhanVien {

    private ArrayList<NhanVien> DanhSachNhanVien;
    private ArrayList<String> LichSuTraLuong;

    public QuanLyNhanVien() {
        DanhSachNhanVien = new ArrayList<>();
        LichSuTraLuong = new ArrayList<>();

        // Khởi tạo một vài nhân viên mẫu
        NhanVien nv1 = new NhanVien("Nguyen Van A", "Ha Noi", "0912551230", "0000000001", "123456789");
        DanhSachNhanVien.add(nv1);

        NhanVien nv2 = new NhanVien("Tran Thi B", "Hai Phong", "0821551230", "0000000002", "987654321");
        DanhSachNhanVien.add(nv2);

        NhanVien nv3 = new NhanVien("Le Van C", "Da Nang", "0812334455", "0000000003", "112233445");
        DanhSachNhanVien.add(nv3);
    }

    public void ThemNhanVien(NhanVien nhanVien) {
        DanhSachNhanVien.add(nhanVien);
    }

    public NhanVien TimKiemNhanVien(String Key) {
        for (NhanVien nv : DanhSachNhanVien) {
            if (nv.getTen().toLowerCase().contains(Key.toLowerCase())
                    || nv.getSdt().contains(Key)
                    || nv.getCccd().contains(Key)) {
                return nv;
            }
        }
        return null;
    }

    public void SuaNhanVien(String Key, String tenMoi, String queQuanMoi, String sdtMoi, String cccdMoi, String soTaiKhoanMoi) {
        NhanVien nhanVien = TimKiemNhanVien(Key);
        if (nhanVien != null) {
            nhanVien.setTen(tenMoi);
            nhanVien.setQueQuan(queQuanMoi);
            nhanVien.setSdt(sdtMoi);
            nhanVien.setCccd(cccdMoi);
            nhanVien.setSoTaiKhoan(soTaiKhoanMoi);
            System.out.println("\nCập nhật thông tin nhân viên thành công.");
        } else {
            System.out.println("\nKhông tìm thấy nhân viên.");
        }
    }

    public void XoaNhanVien(String Key) {
        NhanVien nhanVien = TimKiemNhanVien(Key);
        if (nhanVien != null) {
            DanhSachNhanVien.remove(nhanVien);
        }
    }

    public void HienThiDanhSachNV() {
        for (NhanVien nv : DanhSachNhanVien) {
            System.out.println("\n- Nhân viên: " + nv.getTen()
                    + " - Quê quán: " + nv.getQueQuan()
                    + " - Số điện thoại: " + nv.getSdt()
                    + " - CCCD: " + nv.getCccd()
                    + " - Số tài khoản: " + nv.getSoTaiKhoan());
        }
    }

}
