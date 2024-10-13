package model;

public class PhongDoi extends Phong {
    // Giá cố định cho phòng đôi
    private static final double GIA = 500000;

    // Constructor gọi constructor của lớp cha Phong
    public PhongDoi(String SoPhong, String TrangThai) {
        super(SoPhong, "Double Room", TrangThai, GIA);
    }

    // Ghi đè phương thức getGia từ lớp cha để trả về giá của phòng đôi
    @Override
    public double getGia() {
        return GIA;
    }
}
