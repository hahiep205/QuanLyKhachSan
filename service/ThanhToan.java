package service;

import model.DichVu;
import model.Phong;
import model.PhongDon;
import model.PhongDoi;
import model.PhongVIP;
import java.util.ArrayList;

public class ThanhToan {

    public double TienPhong(Phong phong, int soNgay) {
        double GiaPhong;

        if (phong instanceof PhongDon) {
            GiaPhong = 300000;
        } else if (phong instanceof PhongDoi) {
            GiaPhong = 500000;
        } else if (phong instanceof PhongVIP) {
            GiaPhong = 1000000;
        } else {
            System.out.println("Loại phòng không hợp lệ.");
            return 0;
        }

        return GiaPhong * soNgay;
    }

    public double TienDichVu(ArrayList<DichVu> dichVu) {
        double tongTien = 0;
        if (dichVu != null && !dichVu.isEmpty()) {
            for (DichVu dv : dichVu) {
                tongTien += dv.getGia();
            }
        }
        return tongTien;
    }
}
