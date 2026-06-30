package Main;

public class PaymentManager {
    // Quy định giá vé đồng giá cho mọi ghế là 80.000 VND
    private static final double TICKET_PRICE = 80000.0;

    /**
     * Hàm tính tổng tiền dựa trên số ghế đã đặt (có trạng thái true)
     */
    public static void calculateTotal(boolean[][] map) {
        int countBooked = 0;
        
        System.out.println("\n--- THÔNG TIN HÓA ĐƠN THANH TOÁN ---");
        
        // Quét toàn bộ sơ đồ phòng chiếu để đếm số ghế đã đặt [X]
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == true) {
                    countBooked++;
                    System.out.println("+ Ghế [" + i + "][" + j + "]: " + TICKET_PRICE + " VND");
                }
            }
        }

        // Tính toán tổng tiền thực tế
        double totalAmount = countBooked * TICKET_PRICE;
        
        System.out.println("-----------------------------------");
        System.out.println("Tổng số lượng ghế đã đặt: " + countBooked);
        System.out.println("TỔNG TIỀN PHẢI THANH TOÁN: " + totalAmount + " VND");
        }
}
