package model;

public class Phong {
    private String SoPhong;
    private String LoaiPhong;
    private String TrangThai;
    private double gia;

    public Phong(String SoPhong, String LoaiPhong, String TrangThai, double gia) {
        this.SoPhong = SoPhong;
        this.LoaiPhong = LoaiPhong;
        this.TrangThai = TrangThai;
        this.gia = gia;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(String SoPhong) {
        this.SoPhong = SoPhong;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(String LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    // Phương thức tính tiền dựa trên số ngày
    public double tinhTien(int soNgay) {
        return gia * soNgay;
    }
}
