package model;

public class PhongDon extends Phong {
    private static final double GIA = 300000;

    public PhongDon(String SoPhong, String TrangThai) {
        super(SoPhong, "Phòng đơn", TrangThai);
    }

    public double getGia() {
        return GIA;
    }
}
