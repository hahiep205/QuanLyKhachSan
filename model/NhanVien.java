package model;

public class NhanVien {
    private String ten;
    private String queQuan;
    private String sdt;
    private String cccd;
    private String soTaiKhoan;

    public NhanVien(String ten, String queQuan, String sdt, String cccd, String soTaiKhoan) {
        this.ten = ten;
        this.queQuan = queQuan;
        this.sdt = sdt;
        this.cccd = cccd;
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    // Phương thức kiểm tra tính hợp lệ của thông tin tài khoản (so sánh tên và số tài khoản)
    public boolean kiemTraTaiKhoan(String ten, String soTaiKhoan) {
        return this.ten.equalsIgnoreCase(ten) && this.soTaiKhoan.equals(soTaiKhoan);
    }

    // Phương thức hiển thị thông tin nhân viên
    @Override
    public String toString() {
        return "Tên: " + ten +
               " - Quê quán: " + queQuan +
               " - Số điện thoại: " + sdt +
               " - CCCD: " + cccd +
               " - Số tài khoản: " + soTaiKhoan;
    }
}
