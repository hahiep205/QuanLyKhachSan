package model;

public class PhongDon extends Phong {
    // Giá cố định cho phòng đơn
    private static final double GIA = 300000;

    // Constructor gọi constructor của lớp cha Phong
    public PhongDon(String SoPhong, String TrangThai) {
        super(SoPhong, "Single Room", TrangThai, GIA);
    }

    // Ghi đè phương thức getGia từ lớp cha để trả về giá của phòng đơn
    @Override
    public double getGia() {
        return GIA;
    }
}
