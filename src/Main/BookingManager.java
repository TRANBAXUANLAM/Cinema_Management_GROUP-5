package Main;
import java.util.Scanner;

public class BookingManager {

    // 1. Hàm hiển thị sơ đồ và đặt vé
    public static void bookSeat(boolean[][] map, Scanner sc) {
        showMap(map);
        System.out.print("Nhập hàng muốn đặt (0-4): ");
        int row = sc.nextInt();
        System.out.print("Nhập cột muốn đặt (0-4): ");
        int col = sc.nextInt();
        
        // Kiểm tra vị trí nhập vào có hợp lệ không (tránh lỗi tràn mảng)
        if (row < 0 || row > 4 || col < 0 || col > 4) {
            System.out.println(" Vị trí không hợp lệ! Vui lòng nhập từ 0 đến 4.");
            return;
        }
        if (map[row][col] == false) {
            map[row][col] = true; // Đổi trạng thái sang "Đã đặt"
            System.out.println("Đặt ghế [" + row + "][" + col + "] thành công!");
        } else {
            System.out.println("Ghế này đã có người đặt rồi!");
        }
    }

    // 2. Hàm hủy đặt vé
    public static void cancelSeat(boolean[][] map, Scanner sc) {
        System.out.print("Nhập hàng muốn hủy (0-4): ");
        int row = sc.nextInt();
        System.out.print("Nhập cột muốn hủy (0-4): ");
        int col = sc.nextInt();
        
        if (row < 0 || row > 4 || col < 0 || col > 4) {
            System.out.println(" Vị trí không hợp lệ! Vui lòng nhập từ 0 đến 4.");
            return;
        }
        
        if (map[row][col] == true) {
            map[row][col] = false; // Trả về ghế trống
            System.out.println("️ Đã hủy đặt ghế [" + row + "][" + col + "].");
        } else {
            System.out.println(" Ghế này vốn đang trống, không thể hủy!");
        }
    }

    // 3. Hàm phụ để in sơ đồ ghế: [O] là trống, [X] là đã đặt
    private static void showMap(boolean[][] map) {
        System.out.println("\n--- SƠ ĐỒ PHÒNG CHIẾU ( [O]: Trống | [X]: Đã đặt ) ---");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == false) {
                    System.out.print("[O] ");
                } else {
                    System.out.print("[X] ");
                }
            }
            System.out.println();
        }
    }

}
