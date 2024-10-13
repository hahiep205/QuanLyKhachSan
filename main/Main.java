package main;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.DichVu;
import model.KhachHang;
import model.NhanVien;
import model.Phong;

import service.QuanLyDichVu;
import service.QuanLyKhachHang;
import service.QuanLyNhanVien;
import service.QuanLyPhong;
import service.ThanhToan;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
        QuanLyPhong quanLyPhong = new QuanLyPhong();
        QuanLyDichVu quanLyDichVu = new QuanLyDichVu();
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();

        ThanhToan thanhToan = new ThanhToan();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n|----------------------|");
            System.out.println("|  QUẢN LÝ KHÁCH SẠN   |");
            System.out.println("|----------------------|");
            System.out.println("| 1. Quản lý khách hàng|");
            System.out.println("| 2. Quản lý phòng     |");
            System.out.println("| 3. Đặt phòng         |");
            System.out.println("| 4. Quản lý dịch vụ   |");
            System.out.println("| 5. Thanh toán        |");
            System.out.println("| 6. Quản lý nhân viên |");
            System.out.println("| 7. Thoát             |");
            System.out.println("|----------------------|");

            int chucNang = NhapDuLieu.chonChucNang();

            System.out.println("\nBạn đã chọn: " + chucNang);

            switch (chucNang) {

                // QUẢN LÝ KHÁCH HÀNG
                case 1:
                    System.out.println("\n1. Thêm khách hàng");
                    System.out.println("2. Tìm kiếm khách hàng");
                    System.out.println("3. Sửa thông tin khách hàng");
                    System.out.println("4. Xoá khách hàng");
                    System.out.println("5. Hiển thị danh sách khách hàng");

                    int qlkh = NhapDuLieu.chonQLKH();
                    System.out.println("\nBạn đã chọn: " + qlkh);

                    // Thêm khách hàng
                    if (qlkh == 1) {
                        String ten = NhapDuLieu.nhapTenKhachHang();
                        String sdt = NhapDuLieu.nhapSDT();
                        String cccd = NhapDuLieu.nhapCCCD();
                        KhachHang khachMoi = new KhachHang(ten, sdt, cccd);
                        quanLyKhachHang.ThemKhachHang(khachMoi);
                        System.out.println("\nThêm khách hàng thành công!");

                        // Tìm kiếm khách hàng
                    } else if (qlkh == 2) {
                        String keyword = NhapDuLieu.nhapThongTinDeTimKiem();
                        KhachHang khachHang = quanLyKhachHang.TimKiemKhachHang(keyword);
                        if (khachHang != null) {
                            System.out.println("\nThông tin khách hàng:");
                            System.out.println("\tTên: " + khachHang.getTen());
                            System.out.println("\tSố điện thoại: " + khachHang.getSDT());
                            System.out.println("\tCCCD: " + khachHang.getCCCD());
                            System.out.println("\tPhòng đã thuê: " + khachHang.getLichSuDatPhong());
                        } else {
                            System.out.println("\nKhông tìm thấy khách hàng.");
                        }

                        // Sửa thông tin khách hàng
                    } else if (qlkh == 3) {
                        String key = NhapDuLieu.nhapThongTinDeSua();
                        KhachHang khachHang = quanLyKhachHang.TimKiemKhachHang(key);

                        if (khachHang != null) {

                            String tenMoi = NhapDuLieu.suaTen();
                            String sdtMoi = NhapDuLieu.suaSDT();
                            String cccdMoi = NhapDuLieu.suaCCCD();

                            quanLyKhachHang.SuaKhachHang(key, tenMoi, sdtMoi, cccdMoi);
                            System.out.println("\nSửa thông tin khách hàng thành công!");
                        } else {
                            System.out.println("\nKhông tìm thấy khách hàng");
                        }

                        // Xóa khách hàng
                    } else if (qlkh == 4) {
                        String key = NhapDuLieu.xoa();
                        KhachHang khachHang = quanLyKhachHang.TimKiemKhachHang(key);

                        System.out.println("Bạn có chắc chắn muốn xóa khách hàng này? (Y/N)");
                        String confirm = sc.nextLine();
                        if (confirm.equalsIgnoreCase("Y")) {
                            quanLyKhachHang.XoaKhachHang(key);
                            System.out.println("Khách hàng đã được xóa thành công!");
                        } else {
                            System.out.println("Xóa khách hàng đã bị hủy.");
                        }

                        // Hiển thị danh sách khách hàng
                    } else if (qlkh == 5) {
                        quanLyKhachHang.HienThiDanhSachKH();
                    }
                    break;

                // QUẢN LÝ PHÒNG
                case 2:
                    System.out.println("\n1. Hiển thị danh sách phòng trống");
                    System.out.println("2. Sửa loại phòng");

                    int room = NhapDuLieu.case2Chon();
                    if (room == 1) {
                        quanLyPhong.trangThaiPhong();
                    } else if (room == 2) {
                        // Sửa loại phòng
                        String soPhong = NhapDuLieu.nhapSoPhong();
                        String loaiPhongMoi = NhapDuLieu.nhapLoaiPhongMoi();
                        quanLyPhong.suaPhong(soPhong, loaiPhongMoi);
                    }
                    break;

                // ĐẶT PHÒNG
                case 3:
                    String tenKhach = NhapDuLieu.nhapTenKhach();
                    String sdtDat = NhapDuLieu.nhapSDTDat();
                    String cccdDat = NhapDuLieu.nhapCCCDDat();
                    // Hiển thị danh sách phòng trống
                    System.out.println("Danh sách phòng trống: ");
                    quanLyPhong.trangThaiPhong();

                    String soPhongDat = NhapDuLieu.nhapSoPhongDat(quanLyPhong);

                    try {
                        KhachHang khachDatPhong = new KhachHang(tenKhach, sdtDat, cccdDat);
                        quanLyKhachHang.ThemKhachHang(khachDatPhong);
                        khachDatPhong.ThemLichSuDatPhong(soPhongDat);
                        System.out.println("\nĐặt phòng thành công cho khách hàng: " + tenKhach);
                    } catch (Exception e) {
                        System.out.println("\nLỗi khi thêm khách hàng: " + e.getMessage());
                    }
                    break;

                // QUẢN LÝ DỊCH VỤ
                case 4:
                    System.out.println("\n1. Thêm dịch vụ");
                    System.out.println("2. Hiển thị danh sách dịch vụ");

                    int chonDV = NhapDuLieu.chonDV();
                    System.out.println("\nBạn đã chọn: " + chonDV);

                    // Thêm dịch vụ
                    if (chonDV == 1) {
                        String tenDV = NhapDuLieu.nhapTenDV(quanLyDichVu);
                        double giaDV = NhapDuLieu.nhapGiaDV();

                        DichVu dichVuMoi = new DichVu(tenDV, giaDV);
                        quanLyDichVu.ThemDichVu(dichVuMoi);
                        System.out.println("\nThêm dịch vụ thành công!");

                        // Hiển thị danh sách dịch vụ
                    } else if (chonDV == 2) {
                        quanLyDichVu.HienThiDichVu();
                    }
                    break;

                // THANH TOÁN
                case 5:
                    System.out.println("\n---------- Thanh toán ----------");
                    String tenKhachHang = NhapDuLieu.nhapTenKhachThanhToan();

                    KhachHang khachThanhToan = quanLyKhachHang.TimKiemKhachHang(tenKhachHang);

                    if (khachThanhToan != null) {
                        Phong phongThanhToan = null;
                        String soPhongThanhToan = NhapDuLieu.nhapSoPhongThanhToan(phongThanhToan, quanLyPhong);

                        int ngay = NhapDuLieu.nhapSoNgayO();

                        double tienPhong = thanhToan.TienPhong(phongThanhToan, ngay);
                        System.out.println("\nTổng tiền phòng: " + tienPhong);
                        System.out.println("---------------------------");

                        System.out.println("\nDanh sách dịch vụ: ");
                        quanLyDichVu.HienThiDichVu();

                        int soDichVu = NhapDuLieu.nhapSoLuongDVUsed();

                        ArrayList<DichVu> dvSD = new ArrayList<>();
                        double tongTienDichVu = 0;

                        for (int i = 0; i < soDichVu; i++) {

                            while (true) {
                                String tenDichVu = "";
                                try {
                                    System.out.print("\nNhập tên dịch vụ: ");
                                    tenDichVu = sc.nextLine();

                                    DichVu dichVu = quanLyDichVu.TimKiemDichVu(tenDichVu);
                                    if (dichVu == null) {
                                        System.out.println("\nDịch vụ không tồn tại.");
                                        continue;
                                    }

                                    int soLuong = NhapDuLieu.case5NhapSLDVUsed();

                                    double tienDichVu = dichVu.getGia() * soLuong;
                                    tongTienDichVu += tienDichVu;

                                    dvSD.add(dichVu);
                                    System.out.println(
                                            "\nKhách đã chọn dịch vụ: " + dichVu.getTenDichVu() + "\n"
                                            + " - Số lượng: " + soLuong + "\n"
                                            + " - Thành tiền: " + tienDichVu);
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Lỗi: " + e.getMessage());
                                }
                            }
                        }

                        System.out.println("\nTổng tiền dịch vụ: " + tongTienDichVu);

                        double tongTien = tienPhong + tongTienDichVu;
                        System.out.println("\nTổng tiền thanh toán: " + tongTien);

                        phongThanhToan.setTrangThai("Trong"); // Gọi phương thức để cập nhật trạng thái phòng

                        System.out.println("\nThanh toán thành công!");
                    } else {
                        System.out.println("\nKhông tìm thấy khách hàng.");
                    }
                    break;

                // QUẢN LÝ NHÂN VIÊN
                case 6:
                    System.out.println("\n1. Thêm nhân viên");
                    System.out.println("2. Tìm kiếm nhân viên");
                    System.out.println("3. Sửa thông tin nhân viên");
                    System.out.println("4. Xoá nhân viên");
                    System.out.println("5. Hiển thị danh sách nhân viên");

                    int qlnv = NhapDuLieu.chonQLNV();
                    System.out.println("\nBạn đã chọn: " + qlnv);

                    // Thêm nhân viên
                    if (qlnv == 1) {
                        String ten = NhapDuLieu.nhapTenNhanVien();
                        String queQuan = NhapDuLieu.nhapQueQuan();
                        String sdt = NhapDuLieu.nhapSDT();
                        String cccd = NhapDuLieu.nhapCCCD();
                        String soTaiKhoan = NhapDuLieu.nhapSoTaiKhoan();
                        NhanVien nhanVienMoi = new NhanVien(ten, queQuan, sdt, cccd, soTaiKhoan);
                        quanLyNhanVien.ThemNhanVien(nhanVienMoi);
                        System.out.println("\nThêm nhân viên thành công!");

                        // Tìm kiếm nhân viên
                    } else if (qlnv == 2) {
                        String keyword = NhapDuLieu.nhapThongTinDeTimKiem();
                        NhanVien nhanVien = quanLyNhanVien.TimKiemNhanVien(keyword);
                        if (nhanVien != null) {
                            System.out.println("\nThông tin nhân viên:");
                            System.out.println("\tTên: " + nhanVien.getTen());
                            System.out.println("\tQuê quán: " + nhanVien.getQueQuan());
                            System.out.println("\tSố điện thoại: " + nhanVien.getSdt());
                            System.out.println("\tCCCD: " + nhanVien.getCccd());
                            System.out.println("\tSố tài khoản: " + nhanVien.getSoTaiKhoan());
                        } else {
                            System.out.println("\nKhông tìm thấy nhân viên.");
                        }

                        // Sửa thông tin nhân viên
                    } else if (qlnv == 3) {
                        String key = NhapDuLieu.nhapThongTinDeSua();
                        NhanVien nhanVien = quanLyNhanVien.TimKiemNhanVien(key);

                        if (nhanVien != null) {
                            String tenMoi = NhapDuLieu.suaTen();
                            String queQuanMoi = NhapDuLieu.suaQueQuan();
                            String sdtMoi = NhapDuLieu.suaSDT();
                            String cccdMoi = NhapDuLieu.suaCCCD();
                            String soTaiKhoanMoi = NhapDuLieu.suaSoTaiKhoan();

                            quanLyNhanVien.SuaNhanVien(key, tenMoi, queQuanMoi, sdtMoi, cccdMoi, soTaiKhoanMoi);
                            System.out.println("\nSửa thông tin nhân viên thành công!");
                        } else {
                            System.out.println("\nKhông tìm thấy nhân viên.");
                        }

                        // Xóa nhân viên
                    } else if (qlnv == 4) {
                        String key = NhapDuLieu.xoa();
                        NhanVien nhanVien = quanLyNhanVien.TimKiemNhanVien(key);

                        System.out.println("Bạn có chắc chắn muốn xóa nhân viên này? (Y/N)");
                        String confirm = sc.nextLine();
                        if (confirm.equalsIgnoreCase("Y")) {
                            quanLyNhanVien.XoaNhanVien(key);
                            System.out.println("Khách hàng đã được xóa thành công!");
                        } else {
                            System.out.println("Xóa khách hàng đã bị hủy.");
                        }

                        // Hiển thị danh sách nhân viên
                    } else if (qlnv == 5) {
                        quanLyNhanVien.HienThiDanhSachNV();
                    } else if (qlnv == 6) {
                        quanLyNhanVien.HienThiDanhSachNV();
                    }
                    break;

                // THOÁT
                case 7:
                    System.err.println("\nThoát thành công!\n");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("\nChức năng không hợp lệ, vui lòng thử lại!");
            }
        }
    }
}
