package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.DichVu;
import model.KhachHang;
import model.Phong;
import service.QuanLyDichVu;
import service.QuanLyKhachHang;
import service.QuanLyPhong;

public class NhapDuLieu {

    public static int chonChucNang() {
        Scanner sc = new Scanner(System.in);
        int key = 0;
        while (true) {
            try {
                System.out.print("\nChọn chức năng [1-7]: ");
                key = sc.nextInt();
                
                if (key < 1 || key > 7) {
                    System.out.println("\nLỗi: Vui lòng nhập một số nguyên hợp lệ từ 1 đến 7.");
                    continue;
                }
                
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Vui lòng nhập một số nguyên hợp lệ.");
                sc.next();
            }
        }
        return key;
    }

    public static int chonQLKH() {
        Scanner sc = new Scanner(System.in);
        int key = 0;
        while (true) {
            try {
                System.out.print("\nChọn chức năng quản lý khách hàng [1-5]: ");
                key = sc.nextInt();
                
                if (key < 1 || key > 5) {
                    System.out.println("\nLỗi: Vui lòng nhập một số nguyên hợp lệ từ 1 đến 5.");
                    continue;
                }
                
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Vui lòng nhập một số nguyên hợp lệ.");
                sc.next();
            }
        }
        return key;
    }

    public static String nhapTenKhachHang() {
        Scanner sc = new Scanner(System.in);
        String ten = "";
        while (true) {
            try {
                System.out.print("\nNhập tên khách hàng (ít nhất 2 ký tự, không dùng dấu): ");
                ten = sc.nextLine();
                
                if (ten.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLỗi: Tên không được để trống.");
                }
                
                // Kiểm tra định dạng tên (ít nhất 2 ký tự chữ cái)
                if (!ten.matches("[a-zA-Z ]{2,}")) {
                    throw new IllegalArgumentException("Lỗi: Tên phải chứa ít nhất 2 ký tự chữ và không chứa ký tự đặc biệt.");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\n" + e.getMessage() + "\nVui lòng nhập lại:/n");
            }
        }
        return ten;
    }

    public static String nhapSDT() {
        Scanner sc = new Scanner(System.in);
        String sdt = "";
        while (true) {
            try {
                System.out.print("Nhập số điện thoại (10 ký tự số): ");
                sdt = sc.nextLine();
                
                if (sdt.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLỗi: Số điện thoại không được để trống.");
                }
                
                // Kiểm tra định dạng số điện thoại (ví dụ: 10 ký tự số và bắt đầu bằng số 0)
                if (!sdt.matches("0\\d{9}")) {
                    throw new IllegalArgumentException("Lỗi: Số điện thoại phải có 10 ký tự số và bắt đầu bằng số 0.\n");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\n" +e.getMessage() + "\n");
            }
        }
        return sdt;
    }

    public static String nhapCCCD() {
        Scanner sc = new Scanner(System.in);
        String cccd = "";
        while (true) {
            try {
                System.out.print("Nhập số CCCD (12 ký tự số): ");
                cccd = sc.nextLine();
                
                if (cccd.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLỗi: CCCD không được để trống.");
                }
                
                // Kiểm tra định dạng CCCD (12 ký tự số)
                if (!cccd.matches("\\d{12}")) {
                    throw new IllegalArgumentException("Lỗi: Căn cước công dân phải có 12 ký tự số.\n");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\n" + e.getMessage() + "\n");
            }
        }
        return cccd;
    }

    public static String nhapThongTinDeTimKiem() {
        Scanner sc = new Scanner(System.in);
        String keyword = "";
        while (true) {
            try {
                System.out.print("\nNhập tên, số điện thoại, hoặc CCCD để tìm kiếm: ");
                keyword = sc.nextLine();
                
                if (keyword.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLỗi: Không được để trống.");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return keyword;
    }

    public static String nhapThongTinDeSua() {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("\nNhập tên, số điện thoại, hoặc CCCD của khách hàng cần sửa thông tin: ");
                key = sc.nextLine();
                
                if (key.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLỗi: Không được để trống.");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return key;
    }

    public static String suaTen() {
        Scanner sc = new Scanner(System.in);
        String tenMoi = "";
        while (true) {
            try {
                System.out.print("\nNhập tên mới (ít nhất 2 ký tự, không dùng dấu): ");
                tenMoi = sc.nextLine();
                
                if (tenMoi.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLỗi: Không được để trống.");
                }
                
                // Kiểm tra định dạng tên
                if (!tenMoi.matches("[\\p{L} ]{2,}")) { // \\p{L} cho phép ký tự chữ từ mọi ngôn ngữ
                    throw new IllegalArgumentException("Lỗi: Tên phải chứa ít nhất 2 ký tự chữ.");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\n" + e.getMessage() + "\n");
            }
        }
        return tenMoi;
    }

    public static String suaSDT() {
        Scanner sc = new Scanner(System.in);
        String sdtMoi = "";
        while (true) {
            try {
                System.out.print("Nhập số điện thoại mới (10 ký tự số): ");
                sdtMoi = sc.nextLine();
                
                if (sdtMoi.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLỗi: Không được để trống.");
                }
                
                // Kiểm tra định dạng số điện thoại (10 ký tự số)
                if (!sdtMoi.matches("\\d{10}")) {
                    throw new IllegalArgumentException("Lỗi: Số điện thoại phải có 10 ký tự số.");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
        }
        return sdtMoi;
    }

    public static String suaCCCD() {
        Scanner sc = new Scanner(System.in);
        String cccdMoi = "";
        while (true) {
            try {
                System.out.print("Nhập số CCCD mới (12 ký tự số): ");
                cccdMoi = sc.nextLine();
                
                if (cccdMoi.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLỗi: Không được để trống.");
                }
                
                // Kiểm tra định dạng CCCD (12 ký tự số)
                if (!cccdMoi.matches("\\d{12}")) {
                    throw new IllegalArgumentException("Lỗi: Căn cước công dân phải có 12 ký tự số.");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
        }
        return cccdMoi;
    }

    public static String xoa() {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("\nNhập tên, số điện thoại, hoặc CCCD của khách hàng muốn xóa: ");
                key = sc.nextLine();
                
                if (key.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLỗi: Không được để trống.");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage());
            }
        }
        return key;
    }

    public static int case2Chon() {
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        while (true) {
            try {
                System.out.print("\nChọn [1-2]: ");
                chon = sc.nextInt();
                
                if (chon < 1 || chon > 2) {
                    System.out.println("\nLỗi: Vui lòng nhập 1 hoặc 2.");
                    continue;
                }
                
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Vui lòng nhập một số nguyên hợp lệ là 1 hoặc 2.");
                sc.nextLine();
            }
        }
        return chon;
    }

    public static String nhapSoPhong(QuanLyPhong quanLyPhong) {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("\nNhập số phòng: ");
                key = sc.nextLine();
                Phong phong = quanLyPhong.timPhong(key);
                
                if (phong == null) {
                    System.out.println("\nKhông tìm thấy phòng có số: " + key);
                    continue;
                }
                
                if (key.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLỗi: Số phòng không được để trống.");
                }
                
                // Kiểm tra định dạng số phòng (chỉ chứa số)
                if (!key.matches("\\d+")) {
                    throw new IllegalArgumentException("Lỗi: Số phòng chỉ được chứa ký tự số.");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage());
            }
        }
        return key;
    }

    public static String nhapLoaiPhongMoi() {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("Nhập loại phòng mới (simple, double, vip): ");
                key = sc.nextLine();
                
                if (!key.equalsIgnoreCase("simple")
                        && !key.equalsIgnoreCase("double")
                        && !key.equalsIgnoreCase("vip")) {
                    System.out.println("\nLoại phòng không hợp lệ. Vui lòng nhập lại.\n");
                    continue;
                }
                
                if (key.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLỗi: Loại phòng không được để trống.");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage());
            }
        }
        return key;
    }

    public static String nhapTenKhach() {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("\nNhập tên khách hàng (ít nhất 2 ký tự, không dùng dấu): ");
                key = sc.nextLine();
                
                if (key.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLỗi: Tên khách hàng không được để trống.");
                }
                
                // Kiểm tra định dạng tên
                if (!key.matches("[\\p{L} ]{2,}")) { // \\p{L} cho phép ký tự chữ từ mọi ngôn ngữ
                    throw new IllegalArgumentException("Lỗi: Tên phải chứa ít nhất 2 ký tự chữ.");
                }
                
                // Kiểm tra định dạng tên
                if (!key.matches("[a-zA-Z\\s]+")) {
                    throw new IllegalArgumentException("Tên khách hàng chỉ được chứa ký tự chữ cái và khoảng trắng.");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage());
            }
        }
        return key;
    }

    public static String nhapSDTDat() {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("Nhập số điện thoại (10 chữ số): ");
                key = sc.nextLine();
                
                if (key.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLỗi: Số điện thoại không được để trống.");
                }
                
                // Kiểm tra định dạng số điện thoại (10 ký tự số)
                if (!key.matches("\\d{10}")) {
                    throw new IllegalArgumentException("Lỗi: Số điện thoại phải có 10 ký tự số.\n");
                }
                
                // Kiểm tra nếu số điện thoại bắt đầu bằng số "0"
                if (!key.startsWith("0")) {
                    throw new IllegalArgumentException("Lỗi: Số điện thoại phải bắt đầu bằng số 0.\n");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\n" + e.getMessage() + "\n");
            }
        }
        return key;
    }

    public static String nhapCCCDDat() {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("Nhập số CCCD (12 chữ số): ");
                key = sc.nextLine();
                
                if (key.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLỗi: CCCD không được để trống.");
                }
                
                // Kiểm tra định dạng CCCD (12 ký tự số)
                if (!key.matches("\\d{12}")) {
                    throw new IllegalArgumentException("Lỗi: Căn cước công dân phải có 12 ký tự số.\n");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage());
            }
        }
        return key;
    }

    public static String nhapSoPhongDat(QuanLyPhong quanLyPhong) {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("\nNhập số phòng muốn đặt: ");
                key = sc.nextLine().trim();
                
                if (!key.matches("\\d+")) { // Nếu số phòng chỉ chứa số
                    throw new IllegalArgumentException("Lỗi: Số phòng không hợp lệ.");
                }

                Phong phongDat = quanLyPhong.timPhong(key);
                if (phongDat == null) {
                    throw new IllegalArgumentException("Lỗi: Phòng không tồn tại.");
                }
                
                if (!phongDat.getTrangThai().equals("Trong")) {
                    throw new IllegalArgumentException("\nLỗi: Phòng không khả dụng!");
                }

                phongDat.setTrangThai("Full");
                System.out.println("Đặt phòng thành công: " + key);
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage());
            }
        }
        return key;
    }

    public static String nhapTenKhachThanhToan(QuanLyKhachHang quanLyKhachHang) {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("\nNhập tên khách hàng: ");
                key = sc.nextLine().trim();
                
                KhachHang khachThanhToan = quanLyKhachHang.TimKiemKhachHang(key);
                if (khachThanhToan == null) {
                    System.out.println("\nLỗi : không tìm thấy khách hàng. Mời nhập lại.");
                    continue;
                }
                
                if (key.isEmpty()) {
                    throw new IllegalArgumentException("Tên khách hàng không được để trống.");
                }
                
                // Kiểm tra định dạng tên
                if (!key.matches("[a-zA-Z ]{2,}")) {
                    throw new IllegalArgumentException("Tên khách hàng phải chứa ít nhất 2 ký tự chữ.");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage());
            }
        }
        return key;
    }

    public static String nhapSoPhongThanhToan(Phong phongThanhToan, QuanLyPhong quanLyPhong) {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("Nhập số phòng: ");
                key = sc.nextLine().trim();

                if (key.isEmpty()) {
                    throw new IllegalArgumentException("Số phòng không được để trống.");
                }

                phongThanhToan = quanLyPhong.timPhong(key);

                if (phongThanhToan == null) {
                    throw new IllegalArgumentException("Phòng không tồn tại.\n");
                }

                if (!phongThanhToan.getTrangThai().equals("Full")) {
                    throw new IllegalArgumentException("Phòng không khả dụng hoặc chưa được đặt.\n");
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage());
            }
        }
        return key;
    }

    public static int nhapSoNgayO() {
        Scanner sc = new Scanner(System.in);
        int key = 0;
        while (true) {
            try {
                System.out.print("Nhập số ngày khách ở: ");
                key = sc.nextInt();
                
                if (key <= 0) {
                    System.out.println("\nLỗi: Số ngày phải lớn hơn 0.\n");
                    continue;
                }
                
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Vui lòng nhập một số nguyên hợp lệ.\n");
                sc.next();
            }
        }
        return key;
    }

    public static int nhapSoLuongDVUsed() {
        Scanner sc = new Scanner(System.in);
        int key = 0;
        while (true) {
            try {
                System.out.print("\nNhập số lượng dịch vụ khách sử dụng: ");
                key = sc.nextInt();
                
                if (key < 0) {
                    System.out.println("\nLỗi: Số lượng dịch vụ phải không âm.\n");
                    continue;
                }
                
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Vui lòng nhập một số nguyên dương.\n");
                sc.next();
            }
        }
        return key;
    }

    public static int case5NhapSLDVUsed() {
        Scanner sc = new Scanner(System.in);
        int key = 0;
        while (true) {
            try {
                System.out.print("Nhập số lượng dịch vụ đã sử dụng: ");
                key = sc.nextInt();
                
                if (key < 0) {
                    System.out.println("Lỗi: Số lượng dịch vụ phải không âm.");
                    continue;
                }
                
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Vui lòng nhập một số nguyên dương.");
                sc.next();
            }
        }
        return key;
    }

    public static String nhapTenDV(QuanLyDichVu quanLyDichVu) {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("\nNhập tên dịch vụ (không dùng dấu): ");
                key = sc.nextLine().trim();
                
                if (key.isEmpty()) {
                    throw new IllegalArgumentException("Tên dịch vụ không được để trống.");
                }
                
                // Kiểm tra định dạng số phòng
                if (key.matches("\\d+")) {
                    throw new IllegalArgumentException("Tên dịch vụ chỉ được chứa ký tự chữ.");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage());
            }
        }
        return key;
    }

    public static int chonDV() {
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        while (true) {
            try {
                System.out.print("\nChọn [1-2]: ");
                chon = sc.nextInt();
                
                if (chon < 1 || chon > 2) {
                    System.out.println("\nLỗi: Vui lòng nhập 1 hoặc 2.");
                    continue;
                }
                
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Vui lòng nhập một số nguyên hợp lệ là 1 hoặc 2.");
                sc.next();
            }
        }
        return chon;
    }

    public static double nhapGiaDV() {
        Scanner sc = new Scanner(System.in);
        double key = 0;
        while (true) {
            try {
                System.out.print("Nhập giá dịch vụ: ");
                key = sc.nextDouble();
                
                if (key <= 0) {
                    System.out.println("\nLỗi: Vui lòng nhập số nguyên dương lớn hơn 0.\n");
                    continue;
                }
                
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Vui lòng nhập một số nguyên dương hợp lệ.\n");
                sc.next();
            }
        }
        return key;
    }

    public static int chonQLNV() {
        Scanner sc = new Scanner(System.in);
        int key = 0;
        while (true) {
            try {
                System.out.print("\nChọn [1-5]: ");
                key = sc.nextInt();
                
                if (key < 1 || key > 5) {
                    System.out.println("\nLỗi: Vui lòng nhập một số nguyên hợp lệ từ 1 đến 5.");
                    continue;
                }
                
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Vui lòng nhập một số nguyên hợp lệ.");
                sc.next();
            }
        }
        return key;
    }

    public static String nhapTenNhanVien() {
        Scanner sc = new Scanner(System.in);
        String ten = "";
        while (true) {
            try {
                System.out.print("\nNhập tên nhân viên (ít nhất 2 ký tự, không dùng dấu): ");
                ten = sc.nextLine();
                
                if (ten.trim().isEmpty()) {
                    throw new IllegalArgumentException("Tên không được để trống.");
                }
                
                // Kiểm tra định dạng tên
                if (!ten.matches("[\\p{L} ]{2,}")) {
                    throw new IllegalArgumentException("Tên phải chứa ít nhất 2 ký tự chữ và không được chứa ký tự đặc biệt.");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\nLỗi: " + e.getMessage() + "\n");
            }
        }
        return ten;
    }

    public static String nhapQueQuan() {
        Scanner sc = new Scanner(System.in);
        String queQuan = "";
        while (true) {
            try {
                System.out.print("Nhập quê quán: ");
                queQuan = sc.nextLine();
                
                if (queQuan.trim().isEmpty()) {
                    throw new IllegalArgumentException("Quê quán không được để trống.\n");
                }
                
                // Kiểm tra định dạng quê quán
                if (!queQuan.matches("[\\p{L} ]+")) {
                    throw new IllegalArgumentException("Quê quán chỉ được chứa chữ cái và khoảng trắng.\n");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\nLỗi: " + e.getMessage() + "\n");
            }
        }
        return queQuan;
    }

    public static String nhapSoTaiKhoan() {
        Scanner sc = new Scanner(System.in);
        String soTaiKhoan = "";
        while (true) {
            try {
                System.out.print("Nhập số tài khoản: ");
                soTaiKhoan = sc.nextLine();
                
                if (soTaiKhoan.trim().isEmpty()) {
                    throw new IllegalArgumentException("Số tài khoản không được để trống.");
                }
                
                // Kiểm tra định dạng số tài khoản (10 ký tự số)
                if (!soTaiKhoan.matches("\\d{10}")) {
                    throw new IllegalArgumentException("Số tài khoản phải có 10 ký tự số.\n");
                }
                
                // Kiểm tra định dạng số tài khoản
                if (!soTaiKhoan.matches("\\d+")) {
                    throw new IllegalArgumentException("Số tài khoản chỉ được chứa ký tự số.\n");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\nLỗi: " + e.getMessage() + "\n");
            }
        }
        return soTaiKhoan;
    }

    public static String suaSoTaiKhoan() {
        Scanner sc = new Scanner(System.in);
        String soTaiKhoanMoi = "";
        while (true) {
            try {
                System.out.print("Nhập số tài khoản mới: ");
                soTaiKhoanMoi = sc.nextLine();
                
                if (soTaiKhoanMoi.trim().isEmpty()) {
                    throw new IllegalArgumentException("Không được để trống.");
                }
                
                // Kiểm tra định dạng số tài khoản (10 ký tự số)
                if (!soTaiKhoanMoi.matches("\\d{10}")) {
                    throw new IllegalArgumentException("Số tài khoản mới phải có 10 ký tự số.\n");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage());
            }
        }
        return soTaiKhoanMoi;
    }

    public static String suaQueQuan() {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("\nNhập quê quán mới: ");
                key = sc.nextLine();
                
                if (key.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nKhông được để trống.");
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage());
            }
        }
        return key;
    }

}
