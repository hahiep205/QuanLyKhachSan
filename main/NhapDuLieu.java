package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.DichVu;
import model.Phong;
import service.QuanLyDichVu;
import service.QuanLyPhong;

public class NhapDuLieu {

    public static int chonChucNang() {
        Scanner sc = new Scanner(System.in);
        int key = 0;
        while (true) {
            try {
                System.out.print("\nChọn: ");
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
                System.out.print("\nChọn: ");
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
                System.out.print("\nNhập tên khách hàng: ");
                ten = sc.nextLine();
                if (ten.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nTên không được để trống.");
                }
                // Kiểm tra định dạng tên (ví dụ: chỉ chứa ký tự chữ cái và phải có ít nhất 2 ký tự)
                if (!ten.matches("[a-zA-Z]{2,}")) {
                    throw new IllegalArgumentException("Tên phải chứa ít nhất 2 ký tự chữ.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\nLỗi: " + e.getMessage() + "\n");
            }
        }
        return ten;
    }

    public static String nhapSDT() {
        Scanner sc = new Scanner(System.in);
        String sdt = "";
        while (true) {
            try {
                System.out.print("Nhập số điện thoại: ");
                sdt = sc.nextLine();
                if (sdt.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nSố điện thoại không được để trống.");
                }
                // Kiểm tra định dạng số điện thoại (ví dụ: 10 ký tự số)
                if (!sdt.matches("\\d{10}")) {
                    throw new IllegalArgumentException("Số điện thoại phải có 10 ký tự số.\n");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\nLỗi: " + e.getMessage() + "\n");
            }
        }
        return sdt;
    }

    public static String nhapCCCD() {
        Scanner sc = new Scanner(System.in);
        String cccd = "";
        while (true) {
            try {
                System.out.print("Nhập số CCCD: ");
                cccd = sc.nextLine();
                if (cccd.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nCCCD không được để trống.");
                }
                // Kiểm tra định dạng cccd (ví dụ: 12 ký tự số)
                if (!cccd.matches("\\d{12}")) {
                    throw new IllegalArgumentException("Căn cước công dân phải có 12 ký tự số.\n");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\nLỗi: " + e.getMessage() + "\n");
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
                    throw new IllegalArgumentException("\nKhông được để trống.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage());
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
                    throw new IllegalArgumentException("\nKhông được để trống.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage());
            }
        }
        return key;
    }

    public static String suaTen() {
        Scanner sc = new Scanner(System.in);
        String tenMoi = "";
        while (true) {
            try {
                System.out.print("\nNhập tên mới: ");
                tenMoi = sc.nextLine();
                if (tenMoi.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nKhông được để trống.");
                }
                // Kiểm tra định dạng tên (ví dụ: chỉ chứa ký tự chữ cái và phải có ít nhất 2 ký tự)
                if (!tenMoi.matches("[a-zA-Z]{2,}")) {
                    throw new IllegalArgumentException("Tên phải chứa ít nhất 2 ký tự chữ.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\nLỗi: " + e.getMessage() + "\n");
            }
        }
        return tenMoi;
    }

    public static String suaSDT() {
        Scanner sc = new Scanner(System.in);
        String sdtMoi = "";
        while (true) {
            try {
                System.out.print("Nhập số điện thoại mới: ");
                sdtMoi = sc.nextLine();
                if (sdtMoi.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nKhông được để trống.");
                }
                // Kiểm tra định dạng số điện thoại (ví dụ: 10 ký tự số)
                if (!sdtMoi.matches("\\d{10}")) {
                    throw new IllegalArgumentException("Số điện thoại phải có 10 ký tự số.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage() + "\n");
            }
        }
        return sdtMoi;
    }

    public static String suaCCCD() {
        Scanner sc = new Scanner(System.in);
        String cccdMoi = "";
        while (true) {
            try {
                System.out.print("Nhập số CCCD mới: ");
                cccdMoi = sc.nextLine();
                if (cccdMoi.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nKhông được để trống.");
                }
                // Kiểm tra định dạng cccd (ví dụ: 12 ký tự số)
                if (!cccdMoi.matches("\\d{10}")) {
                    throw new IllegalArgumentException("Căn cước công dân phải có 12 ký tự số.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage() + "\n");
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
                    throw new IllegalArgumentException("\nKhông được để trống.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage());
            }
        }
        return key;
    }

    public static int case2Chon() {
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        while (true) {
            try {
                System.out.print("\nChọn: ");
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

    public static String nhapSoPhong() {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("\nNhập số phòng: ");
                key = sc.nextLine();
                if (key.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nSố phòng không được để trống.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage());
            }
        }
        return key;
    }

    public static String nhapLoaiPhongMoi() {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("Nhập loại phòng mới (1-): ");
                key = sc.nextLine();
                if (key.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nLoại phòng không được để trống.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage());
            }
        }
        return key;
    }

    public static String nhapTenKhach() {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("\nNhập tên khách hàng: ");
                key = sc.nextLine();
                if (key.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nTên khách hàng không được để trống.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage());
            }
        }
        return key;
    }

    public static String nhapSDTDat() {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("Nhập số điện thoại: ");
                key = sc.nextLine();
                if (key.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nSố điện thoại không được để trống.");
                }
                // Kiểm tra định dạng số điện thoại (ví dụ: 10 ký tự số)
                if (!key.matches("\\d{10}")) {
                    throw new IllegalArgumentException("Số điện thoại phải có 10 ký tự số.\n");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\nLỗi: " + e.getMessage() + "\n");
            }
        }
        return key;
    }

    public static String nhapCCCDDat() {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("Nhập số CCCD: ");
                key = sc.nextLine();
                if (key.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nCCCD không được để trống.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage());
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
                key = sc.nextLine();
                Phong phongDat = quanLyPhong.timPhong(key);
                if (phongDat == null) {
                    throw new IllegalArgumentException("\nPhòng không tồn tại.");
                }
                if (!phongDat.getTrangThai().equals("Trong")) {
                    throw new IllegalArgumentException("\nPhòng không khả dụng!");
                }
                phongDat.setTrangThai("Full");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage());
            }
        }
        return key;
    }

    public static String nhapTenKhachThanhToan() {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("\nNhập tên khách hàng: ");
                key = sc.nextLine().trim();
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
                key = sc.nextLine();
                if (key.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nSố phòng không được để trống.");
                }
                phongThanhToan = quanLyPhong.timPhong(key);
                if (phongThanhToan == null) {
                    throw new IllegalArgumentException("\nPhòng không tồn tại.");
                }
                if (!phongThanhToan.getTrangThai().equals("Full")) {
                    throw new IllegalArgumentException("Phòng không khả dụng hoặc chưa được đặt.\n");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.print("\nLỗi: " + e.getMessage() + "\n");
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
                sc.nextLine();
                if (key <= 0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Vui lòng nhập một số nguyên hợp lệ.");
                sc.nextLine();
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
                sc.nextLine();
                if (key < 0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Vui lòng nhập một số nguyên không âm.");
                sc.nextLine();
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
                sc.nextLine();
                if (key < 0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Vui lòng nhập một số nguyên không âm.");
                sc.nextLine();
            }
        }
        return key;
    }

    public static String nhapTenDV(QuanLyDichVu quanLyDichVu) {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("\nNhập tên dịch vụ: ");
                key = sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage());
            }
            return key;
        }
    }

    public static int chonDV() {
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        while (true) {
            try {
                System.out.print("\nChọn: ");
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

    public static double nhapGiaDV() {
        Scanner sc = new Scanner(System.in);
        double key = 0;
        while (true) {
            try {
                System.out.print("Nhập giá dịch vụ: ");
                key = sc.nextDouble();
                if (key < 1) {
                    System.out.println("\nLỗi: Vui lòng nhập số nguyên dương.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Vui lòng nhập số nguyên dương.");
                sc.nextLine();
            }
        }
        return key;
    }

    public static int chonQLNV() {
        Scanner sc = new Scanner(System.in);
        int key = 0;
        while (true) {
            try {
                System.out.print("\nChọn: ");
                key = sc.nextInt();
                if (key < 1 || key > 5) {
                    System.out.println("\nLỗi: Vui lòng nhập một số nguyên hợp lệ từ 1 đến 5.");
                    continue;
                }
                sc.nextLine(); // Xóa bỏ dòng tiếp theo
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Vui lòng nhập một số nguyên hợp lệ.");
                sc.next(); // Xóa bỏ input không hợp lệ
            }
        }
        return key;
    }

    public static String nhapTenNhanVien() {
        Scanner sc = new Scanner(System.in);
        String ten = "";
        while (true) {
            try {
                System.out.print("\nNhập tên nhân viên: ");
                ten = sc.nextLine();
                if (ten.trim().isEmpty()) {
                    throw new IllegalArgumentException("\nTên không được để trống.");
                }
                // Kiểm tra định dạng tên (ví dụ: chỉ chứa ký tự chữ cái và phải có ít nhất 2 ký tự)
                if (!ten.matches("[a-zA-Z ]{2,}")) {
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
                    throw new IllegalArgumentException("\nQuê quán không được để trống.");
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
                    throw new IllegalArgumentException("\nSố tài khoản không được để trống.");
                }
                // Kiểm tra định dạng số tài khoản (ví dụ: 10 ký tự số)
                if (!soTaiKhoan.matches("\\d{10}")) {
                    throw new IllegalArgumentException("Số tài khoản phải có 10 ký tự số.");
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
                    throw new IllegalArgumentException("\nKhông được để trống.");
                }
                // Kiểm tra định dạng số tài khoản
                if (!soTaiKhoanMoi.matches("\\d{10}")) {
                    throw new IllegalArgumentException("Số tài khoản mới phải có 10 ký tự số.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\nLỗi: " + e.getMessage() + "\n");
            }
        }
        return soTaiKhoanMoi;
    }

    public static String suaQueQuan() {
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            try {
                System.out.print("\nNhập tên, số điện thoại, hoặc CCCD của nhân viên cần sửa thông tin: ");
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
