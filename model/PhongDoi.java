package model;

public class PhongDoi extends Phong {
    private static final double GIA = 500000;

    public PhongDoi(String SoPhong, String TrangThai) {
        super(SoPhong, "Phòng đôi", TrangThai);
    }

    public double getGia() {
        return GIA;
    }
}
