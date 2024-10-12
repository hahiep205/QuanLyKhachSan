package model;

public class PhongVIP extends Phong {
    private static final double GIA = 1000000;

    public PhongVIP(String SoPhong, String TrangThai) {
        super(SoPhong, "Phòng VIP", TrangThai);
    }

    public double getGia() {
        return GIA;
    }
}
