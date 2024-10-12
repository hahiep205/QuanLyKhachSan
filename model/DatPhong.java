package model;

import java.util.Date;

public class DatPhong {
    private Phong Phong;
    private KhachHang khachHang;
    private Date ngayDat;
    private Date ngayTra;

    public DatPhong(Phong Phong, KhachHang khachHang, Date ngayDat, Date ngayTra) {
        this.Phong = Phong;
        this.khachHang = khachHang;
        this.ngayDat = ngayDat;
        this.ngayTra = ngayTra;
    }

    public Phong getPhong() {
        return Phong;
    }

    public void setPhong(Phong phong) {
        this.Phong = Phong;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    // Phương thức để tính giá phòng
    public double tinhGiaPhong(int soNgay) {
        // Lấy giá từ đối tượng Phong
        double giaPhong = 0;
        if (Phong instanceof PhongDon) {
            giaPhong = ((PhongDon) Phong).getGia();
        } else if (Phong instanceof PhongDoi) {
            giaPhong = ((PhongDoi) Phong).getGia();
        } else if (Phong instanceof PhongVIP) {
            giaPhong = ((PhongVIP) Phong).getGia();
        }
        return giaPhong * soNgay;
    }
}
