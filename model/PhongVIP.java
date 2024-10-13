package model;

public class PhongVIP extends Phong {
    // Giá cố định cho phòng VIP
    private static final double GIA = 1000000;

    // Constructor gọi constructor của lớp cha Phong
    public PhongVIP(String SoPhong, String TrangThai) {
        super(SoPhong, "VIP Room", TrangThai, GIA);
    }

    // Ghi đè phương thức getGia từ lớp cha để trả về giá của phòng VIP
    @Override
    public double getGia() {
        return GIA;
    }
}
