package Main;
import java.util.Scanner;

public class BookingManager {

    public static void bookSeat(boolean[][] map, Scanner sc) {
        showMap(map);
        System.out.print("Nhập hàng muốn đặt (0-4): ");
        int row = sc.nextInt();
        System.out.print("Nhập cột muốn đặt (0-4): ");
        int col = sc.nextInt();
        
        if (row < 0 || row > 4 || col < 0 || col > 4) {
            System.out.println("Vị trí không hợp lệ! Vui lòng nhập từ 0 đến 4.");
            return;
        }
        if (!map[row][col]) {
            map[row][col] = true; 
            System.out.println("Đặt ghế [" + row + "][" + col + "] thành công!");
        } else {
            System.out.println("Ghế này đã có người đặt rồi!");
        }
    }

    public static void cancelSeat(boolean[][] map, Scanner sc) {
        System.out.print("Nhập hàng muốn hủy (0-4): ");
        int row = sc.nextInt();
        System.out.print("Nhập cột muốn hủy (0-4): ");
        int col = sc.nextInt();
        
        if (row < 0 || row > 4 || col < 0 || col > 4) {
            System.out.println("Vị trí không hợp lệ! Vui lòng nhập từ 0 đến 4.");
            return;
        }
        
        if (map[row][col]) {
            map[row][col] = false; 
            System.out.println("Đã hủy đặt ghế [" + row + "][" + col + "].");
        } else {
            System.out.println("Ghế này vốn đang trống, không thể hủy!");
        }
    }

    private static void showMap(boolean[][] map) {
        System.out.println("\n--- SƠ ĐỒ PHÒNG CHIẾU ( [O]: Trống | [X]: Đã đặt ) ---");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] ? "[X] " : "[O] ");
            }
            System.out.println();
        }
    }
}
