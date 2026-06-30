package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[][] seatingMap = new boolean[5][5]; // Sơ đồ ghế 5x5
        
        while (true) {
            System.out.println("\n--- HỆ THỐNG ĐẶT VÉ XEM PHIM MINI ---");
            System.out.println("1. Xem danh sách phim và suất chiếu");
            System.out.println("2. Xem sơ đồ ghế và Đặt vé");
            System.out.println("3. Hủy đặt vé");
            System.out.println("4. Tính tổng tiền thanh toán");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng (1-5): ");
            
            int choice = scanner.nextInt();
            if (choice == 5) {
                System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
                break;
            }
            
            switch (choice) {
                case 1:
                    MovieManager.displayMovies();
                    break;
                case 2:
                    BookingManager.bookSeat(seatingMap, scanner);
                    break;
                case 3:
                    BookingManager.cancelSeat(seatingMap, scanner);
                    break;
                case 4:
                    // Gọi hàm xử lý của bạn
                    PaymentManager.calculateTotal(seatingMap);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
        scanner.close();
    }
}
