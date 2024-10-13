package service;

import model.DichVu;
import model.Phong;
import model.PhongDon;
import model.PhongDoi;
import model.PhongVIP;
import java.util.ArrayList;

public class ThanhToan {

    public double TienPhong(Phong phong, int soNgay) {
        if (phong != null && soNgay > 0) {
            return phong.getGia() * soNgay;
        } else {
            return 0.0;
        }
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
