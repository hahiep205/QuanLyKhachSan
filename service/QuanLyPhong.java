package service;

import model.Phong;
import model.PhongDon;
import model.PhongDoi;
import model.PhongVIP;

import java.util.ArrayList;

public class QuanLyPhong {

    private ArrayList<Phong> danhSachPhong;

    public QuanLyPhong() {
        danhSachPhong = new ArrayList<>();
        danhSachPhong.add(new PhongDon("101", "Trong"));
        danhSachPhong.add(new PhongDoi("102", "Trong"));
        danhSachPhong.add(new PhongVIP("103", "Trong"));
        danhSachPhong.add(new PhongDon("104", "Trong"));
        danhSachPhong.add(new PhongVIP("105", "Trong"));
    }

    public void trangThaiPhong() {
        for (Phong phong : danhSachPhong) {
            System.out.println("\n- Phòng: " + phong.getSoPhong()
                    + " - Lọai phòng: " + phong.getLoaiPhong()
                    + " - Trạng thái: " + phong.getTrangThai());
        }
    }

    public Phong timPhong(String soPhong) {
        for (Phong phong : danhSachPhong) {
            if (phong.getSoPhong().equals(soPhong)) {
                return phong;
            }
        }
        return null;
    }

    public void suaPhong(String soPhong, String loaiPhongMoi) {
        Phong phong = timPhong(soPhong);
        if (phong != null) {
            switch (loaiPhongMoi.toLowerCase()) {
                case "single":
                    phong.setLoaiPhong("Single Room");
                    break;
                case "double":
                    phong.setLoaiPhong("Double Room");
                    break;
                case "vip":
                    phong.setLoaiPhong("VIP Room");
                    break;
                default:
                    System.out.println("\nLoại phòng không hợp lệ: " + loaiPhongMoi);
                    return;
            }

            System.out.println("\nCập nhật thành công! \nPhòng số: " + soPhong + " - Loại phòng mới: " + phong.getLoaiPhong());
        } else {
            System.out.println("\nKhông tìm thấy phòng có số: " + soPhong);
        }
    }
}
