package model;

import java.util.Date;

public class DatPhong {
    private Phong phong;
    private KhachHang khachHang;
    private Date ngayDat;
    private Date ngayTra;

    public DatPhong(Phong phong, KhachHang khachHang, Date ngayDat, Date ngayTra) {
        this.phong = phong;
        this.khachHang = khachHang;
        this.ngayDat = ngayDat;
        this.ngayTra = ngayTra;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
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
        double giaPhong = phong.getGia(); // Gọi phương thức getGia từ lớp cha Phong
        return giaPhong * soNgay;
    }
}
