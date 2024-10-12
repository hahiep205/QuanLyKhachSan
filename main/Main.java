package main;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.DichVu;
import model.KhachHang;
import model.Phong;

import service.QuanLyDichVu;
import service.QuanLyKhachHang;
import service.QuanLyPhong;
import service.ThanhToan;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
        QuanLyPhong quanLyPhong = new QuanLyPhong();
        QuanLyDichVu quanLyDichVu = new QuanLyDichVu();
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
            System.out.println("| 6. Thoát             |");
            System.out.println("|----------------------|");
            System.out.print("\nChọn: ");

            int chucNang = 0;
            while (true) {
                try {
                    chucNang = sc.nextInt();
                    sc.nextLine();
                    if (chucNang < 1 || chucNang > 6) {
                        throw new InputMismatchException();
                    }
                    break; // Thoát vòng lặp nếu nhập đúng
                } catch (InputMismatchException e) {
                    System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ từ 1 đến 6.");
                    sc.nextLine(); // Xóa bỏ dữ liệu không hợp lệ
                }
            }

            switch (chucNang) {
                case 1:
                    // Quản lý khách hàng
                    System.out.println("\n1. Thêm khách hàng");
                    System.out.println("2. Tìm kiếm khách hàng");
                    System.out.println("3. Sửa thông tin khách hàng");
                    System.out.println("4. Xoá khách hàng");
                    System.out.println("5. Hiển thị danh sách khách hàng");
                    System.out.print("\nChọn: ");

                    int qlkh = 0;
                    while (true) {
                        try {
                            qlkh = sc.nextInt();
                            sc.nextLine();
                            if (qlkh < 1 || qlkh > 5) {
                                throw new InputMismatchException();
                            }
                            break; // Thoát vòng lặp nếu nhập đúng
                        } catch (InputMismatchException e) {
                            System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ từ 1 đến 5.");
                            sc.nextLine(); // Xóa bỏ dữ liệu không hợp lệ
                        }
                    }

                    // Thêm khách hàng
                    if (qlkh == 1) {
                        String ten = "";
                        String sdt = "";
                        String cccd = "";

                        // Nhập tên khách hàng
                        while (true) {
                            try {
                                System.out.print("\nNhập tên khách hàng: ");
                                ten = sc.nextLine();
                                if (ten.trim().isEmpty()) {
                                    throw new IllegalArgumentException("\nTên không được để trống.");
                                }
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("\nLỗi: " + e.getMessage());
                            }
                        }

                        // Nhập số điện thoại
                        while (true) {
                            try {
                                System.out.print("Nhập số điện thoại: ");
                                sdt = sc.nextLine();
                                if (sdt.trim().isEmpty()) {
                                    throw new IllegalArgumentException("\nSố điện thoại không được để trống.");
                                }
                                // Kiểm tra định dạng số điện thoại (ví dụ: 10 ký tự số)
                                if (!sdt.matches("\\d{10}")) {
                                    throw new IllegalArgumentException("\nSố điện thoại phải có 10 ký tự số.");
                                }
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("\nLỗi: " + e.getMessage());
                            }
                        }

                        // Nhập CCCD
                        while (true) {
                            try {
                                System.out.print("Nhập số CCCD: ");
                                cccd = sc.nextLine();
                                if (cccd.trim().isEmpty()) {
                                    throw new IllegalArgumentException("\nCCCD không được để trống.");
                                }
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("\nLỗi: " + e.getMessage());
                            }
                        }

                        KhachHang khachMoi = new KhachHang(ten, sdt, cccd);
                        quanLyKhachHang.ThemKhachHang(khachMoi);
                        System.out.println("\nThêm khách hàng thành công!");

                    } else if (qlkh == 2) {
                        // Tìm kiếm khách hàng
                        String keyword;
                        while (true) {
                            try {
                                System.out.println("\nNhập tên, số điện thoại, hoặc CCCD để tìm kiếm: ");
                                keyword = sc.nextLine();
                                if (keyword.trim().isEmpty()) {
                                    throw new IllegalArgumentException("\nKhông được để trống.");
                                }
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("\nLỗi: " + e.getMessage());
                            }
                        }

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
                    } else if (qlkh == 3) {
                        // Sửa thông tin khách hàng

                        String key;

                        while (true) {
                            try {
                                System.out.println("\nNhập tên, số điện thoại, hoặc CCCD của khách hàng cần sửa thông tin: ");
                                key = sc.nextLine();
                                if (key.trim().isEmpty()) {
                                    throw new IllegalArgumentException("\nKhông được để trống.");
                                }
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("\nLỗi: " + e.getMessage());
                            }
                        }

                        KhachHang khachHang = quanLyKhachHang.TimKiemKhachHang(key);

                        if (khachHang != null) {

                            String tenMoi;

                            while (true) {
                                try {
                                    System.out.print("\nNhập tên mới: ");
                                    tenMoi = sc.nextLine();
                                    if (tenMoi.trim().isEmpty()) {
                                        throw new IllegalArgumentException("\nKhông được để trống.");
                                    }
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("\nLỗi: " + e.getMessage());
                                }
                            }

                            String sdtMoi;

                            while (true) {
                                try {
                                    System.out.print("Nhập số điện thoại mới: ");
                                    sdtMoi = sc.nextLine();
                                    if (sdtMoi.trim().isEmpty()) {
                                        throw new IllegalArgumentException("\nKhông được để trống.");
                                    }
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("\nLỗi: " + e.getMessage());
                                }
                            }

                            String cccdMoi;

                            while (true) {
                                try {
                                    System.out.print("Nhập số CCCD mới: ");
                                    cccdMoi = sc.nextLine();
                                    if (cccdMoi.trim().isEmpty()) {
                                        throw new IllegalArgumentException("\nKhông được để trống.");
                                    }
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("\nLỗi: " + e.getMessage());
                                }
                            }

                            quanLyKhachHang.SuaKhachHang(key, tenMoi, sdtMoi, cccdMoi);
                            System.out.println("\nSửa thông tin khách hàng thành công!");
                        } else {
                            System.out.println("\nKhông tìm thấy khách hàng");
                        }
                    } else if (qlkh == 4) {
                        // Xóa khách hàng

                        String key;

                        while (true) {
                            try {
                                System.out.println("\nNhập tên, số điện thoại, hoặc CCCD của khách hàng muốn xóa: ");
                                key = sc.nextLine();
                                if (key.trim().isEmpty()) {
                                    throw new IllegalArgumentException("\nKhông được để trống.");
                                }
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("\nLỗi: " + e.getMessage());
                            }
                        }

                        KhachHang khachHang = quanLyKhachHang.TimKiemKhachHang(key);

                        if (khachHang != null) {
                            quanLyKhachHang.XoaKhachHang(key);
                            System.out.println("\nXóa khách hàng thành công!");
                        } else {
                            System.out.println("\nKhông tìm thấy khách hàng.");
                        }
                    } else if (qlkh == 5) {
                        // Hiển thị danh sách khách hàng
                        quanLyKhachHang.HienThiDanhSachKH();
                    }
                    break;

                case 2:
                    // Quản lý phòng
                    System.out.println("\n1. Hiển thị danh sách phòng trống");
                    System.out.println("2. Sửa loại phòng");
                    System.out.print("\nChọn: ");

                    int room = 0;
                    while (true) {
                        try {
                            room = sc.nextInt();
                            sc.nextLine();
                            if (room < 1 || room > 2) {
                                throw new InputMismatchException();
                            }
                            break; // Thoát vòng lặp nếu nhập đúng
                        } catch (InputMismatchException e) {
                            System.out.println("\nLỗi: Vui lòng nhập một số nguyên hợp lệ từ 1 đến 2.");
                            sc.nextLine(); // Xóa bỏ dữ liệu không hợp lệ
                        }
                    }

                    if (room == 1) {
                        quanLyPhong.trangThaiPhong();
                    } else if (room == 2) {
                        // Sửa loại phòng
                        String soPhong = "";
                        String loaiPhongMoi = "";

                        // Nhập số phòng
                        while (true) {
                            try {
                                System.out.print("\nNhập số phòng: ");
                                soPhong = sc.nextLine();
                                // Kiểm tra số phòng hợp lệ (thêm kiểm tra nếu cần)
                                if (soPhong.trim().isEmpty()) {
                                    throw new IllegalArgumentException("Số phòng không được để trống.");
                                }
                                break; // Thoát vòng lặp nếu nhập đúng
                            } catch (IllegalArgumentException e) {
                                System.out.println("Lỗi: " + e.getMessage());
                            }
                        }

                        // Nhập loại phòng mới
                        while (true) {
                            try {
                                System.out.print("Nhập loại phòng mới: ");
                                loaiPhongMoi = sc.nextLine();
                                if (loaiPhongMoi.trim().isEmpty()) {
                                    throw new IllegalArgumentException("Loại phòng không được để trống.");
                                }
                                break; // Thoát vòng lặp nếu nhập đúng
                            } catch (IllegalArgumentException e) {
                                System.out.println("Lỗi: " + e.getMessage());
                            }
                        }

                        quanLyPhong.suaPhong(soPhong, loaiPhongMoi);
                    }
                    break;

                case 3:
                    // Đặt phòng
                    String tenKhach = "";
                    String sdtDat = "";
                    String cccdDat = "";
                    String soPhongDat = "";

                    // Nhập tên khách hàng
                    while (true) {
                        try {
                            System.out.print("\nNhập tên khách hàng: ");
                            tenKhach = sc.nextLine();
                            if (tenKhach.trim().isEmpty()) {
                                throw new IllegalArgumentException("Tên khách hàng không được để trống.");
                            }
                            break; // Thoát vòng lặp nếu nhập đúng
                        } catch (IllegalArgumentException e) {
                            System.out.println("Lỗi: " + e.getMessage());
                        }
                    }

                    // Nhập số điện thoại
                    while (true) {
                        try {
                            System.out.print("Nhập số điện thoại: ");
                            sdtDat = sc.nextLine();
                            if (sdtDat.trim().isEmpty()) {
                                throw new IllegalArgumentException("Số điện thoại không được để trống.");
                            }
                            // Kiểm tra định dạng số điện thoại (ví dụ: 10 ký tự số)
                            if (!sdtDat.matches("\\d{10}")) {
                                throw new IllegalArgumentException("Số điện thoại phải có 10 ký tự số.");
                            }
                            break; // Thoát vòng lặp nếu nhập đúng
                        } catch (IllegalArgumentException e) {
                            System.out.println("Lỗi: " + e.getMessage());
                        }
                    }

                    // Nhập số CCCD
                    while (true) {
                        try {
                            System.out.print("Nhập số CCCD: ");
                            cccdDat = sc.nextLine();
                            if (cccdDat.trim().isEmpty()) {
                                throw new IllegalArgumentException("CCCD không được để trống.");
                            }
                            break; // Thoát vòng lặp nếu nhập đúng
                        } catch (IllegalArgumentException e) {
                            System.out.println("Lỗi: " + e.getMessage());
                        }
                    }

                    // Hiển thị danh sách phòng trống
                    System.out.println("Danh sách phòng trống: ");
                    quanLyPhong.trangThaiPhong();

                    // Nhập số phòng muốn đặt
                    while (true) {
                        try {
                            System.out.print("\nNhập số phòng muốn đặt: ");
                            soPhongDat = sc.nextLine();
                            Phong phongDat = quanLyPhong.timPhong(soPhongDat);
                            if (phongDat == null) {
                                throw new IllegalArgumentException("Phòng không tồn tại.");
                            }
                            if (!phongDat.getTrangThai().equals("Trong")) {
                                throw new IllegalArgumentException("Phòng không khả dụng!");
                            }
                            phongDat.setTrangThai("Full"); // Đặt phòng thành công
                            break; // Thoát vòng lặp nếu nhập đúng
                        } catch (IllegalArgumentException e) {
                            System.out.println("Lỗi: " + e.getMessage());
                        }
                    }

                    // Tạo đối tượng KhachHang và thêm vào danh sách
                    try {
                        KhachHang khachDatPhong = new KhachHang(tenKhach, sdtDat, cccdDat);
                        quanLyKhachHang.ThemKhachHang(khachDatPhong);
                        khachDatPhong.ThemLichSuDatPhong(soPhongDat);
                        System.out.println("\nĐặt phòng thành công cho khách hàng: " + tenKhach);
                    } catch (Exception e) {
                        System.out.println("Lỗi khi thêm khách hàng: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Quản lý dịch vụ
                    System.out.println("\n---------- Danh sách dịch vụ ----------\n");
                    quanLyDichVu.HienThiDichVu();
                    break;

                case 5:
                    // Thanh toán
                    System.out.println("\n---------- Thanh toán ----------");
                    String tenKhachHang = "";
                    while (true) {
                        try {
                            System.out.print("\nNhập tên khách hàng: ");
                            tenKhachHang = sc.nextLine();
                            if (tenKhachHang.trim().isEmpty()) {
                                throw new IllegalArgumentException("Tên khách hàng không được để trống.");
                            }
                            break; // Thoát vòng lặp nếu nhập đúng
                        } catch (IllegalArgumentException e) {
                            System.out.println("Lỗi: " + e.getMessage());
                        }
                    }

                    KhachHang khachThanhToan = quanLyKhachHang.TimKiemKhachHang(tenKhachHang);

                    if (khachThanhToan != null) {
                        String soPhongThanhToan = "";
                        Phong phongThanhToan = null; // Khai báo biến ngoài vòng lặp
                        while (true) {
                            try {
                                System.out.print("Nhập số phòng: ");
                                soPhongThanhToan = sc.nextLine();
                                if (soPhongThanhToan.trim().isEmpty()) {
                                    throw new IllegalArgumentException("Số phòng không được để trống.");
                                }
                                phongThanhToan = quanLyPhong.timPhong(soPhongThanhToan); // Gán giá trị cho phongThanhToan
                                if (phongThanhToan == null) {
                                    throw new IllegalArgumentException("Phòng không tồn tại.");
                                }
                                if (!phongThanhToan.getTrangThai().equals("Full")) {
                                    throw new IllegalArgumentException("Phòng không khả dụng hoặc chưa được đặt.");
                                }
                                break; // Thoát vòng lặp nếu nhập đúng
                            } catch (IllegalArgumentException e) {
                                System.out.println("Lỗi: " + e.getMessage());
                            }
                        }

                        int ngay = 0;
                        while (true) {
                            try {
                                System.out.print("Nhập số ngày khách ở: ");
                                ngay = sc.nextInt();
                                sc.nextLine();
                                if (ngay <= 0) {
                                    throw new InputMismatchException();
                                }
                                break; // Thoát vòng lặp nếu nhập đúng
                            } catch (InputMismatchException e) {
                                System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ cho số ngày khách ở.");
                                sc.nextLine(); // Xóa bỏ dữ liệu không hợp lệ
                            }
                        }

                        double tienPhong = thanhToan.TienPhong(phongThanhToan, ngay); // Sử dụng phongThanhToan đã được khởi tạo
                        System.out.println("Tổng tiền phòng: " + tienPhong);
                        System.out.println("---------------------------");

                        System.out.println("\nDanh sách dịch vụ: ");
                        quanLyDichVu.HienThiDichVu();

                        int soDichVu = 0;
                        while (true) {
                            try {
                                System.out.print("\nNhập số lượng dịch vụ khách sử dụng: ");
                                soDichVu = sc.nextInt();
                                sc.nextLine();
                                if (soDichVu < 0) {
                                    throw new InputMismatchException();
                                }
                                break; // Thoát vòng lặp nếu nhập đúng
                            } catch (InputMismatchException e) {
                                System.out.println("Lỗi: Vui lòng nhập một số nguyên không âm cho số lượng dịch vụ.");
                                sc.nextLine(); // Xóa bỏ dữ liệu không hợp lệ
                            }
                        }

                        ArrayList<DichVu> dvSD = new ArrayList<>();
                        double tongTienDichVu = 0;

                        for (int i = 0; i < soDichVu; i++) {
                            String tenDichVu = "";
                            while (true) {
                                try {
                                    System.out.print("\nNhập tên dịch vụ: ");
                                    tenDichVu = sc.nextLine();
                                    if (tenDichVu.trim().isEmpty()) {
                                        throw new IllegalArgumentException("Tên dịch vụ không được để trống.");
                                    }

                                    DichVu dichVu = quanLyDichVu.TimKiemDichVu(tenDichVu);
                                    if (dichVu == null) {
                                        throw new IllegalArgumentException("Dịch vụ không tồn tại.");
                                    }

                                    int soLuong = 0;
                                    while (true) {
                                        try {
                                            System.out.print("Nhập số lượng dịch vụ '" + tenDichVu + "' đã sử dụng: ");
                                            soLuong = sc.nextInt();
                                            sc.nextLine();
                                            if (soLuong < 0) {
                                                throw new InputMismatchException();
                                            }
                                            break; // Thoát vòng lặp nếu nhập đúng
                                        } catch (InputMismatchException e) {
                                            System.out.println("Lỗi: Vui lòng nhập một số nguyên không âm cho số lượng dịch vụ.");
                                            sc.nextLine(); // Xóa bỏ dữ liệu không hợp lệ
                                        }
                                    }

                                    double tienDichVu = dichVu.getGia() * soLuong;
                                    tongTienDichVu += tienDichVu;

                                    dvSD.add(dichVu);
                                    System.out.println(
                                            "\nKhách đã chọn dịch vụ: " + dichVu.getTenDichVu() + "\n"
                                            + " - Số lượng: " + soLuong + "\n"
                                            + " - Thành tiền: " + tienDichVu);
                                    break; // Thoát vòng lặp nếu nhập đúng
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

                case 6:
                    System.out.println("\nThoát thành công!");
                    System.exit(0);
                default:
                    System.out.println("\nChức năng không hợp lệ, vui lòng thử lại!");
            }
        }
    }
}
