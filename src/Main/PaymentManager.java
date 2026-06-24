import java.util.HashMap;
import java.util.Map;

public class PaymentManager {
    // Lưu trữ lịch sử giao dịch: Key = Mã đặt vé (BookingID), Value = Số tiền
    private Map<String, Double> paymentHistory;

    public PaymentManager() {
        this.paymentHistory = new HashMap<>();
    }

    /**
     * Xử lý thanh toán khi người dùng đặt ghế thành công
     * @param bookingId Mã đặt vé từ BookingManager
     * @param amount Số tiền cần thanh toán
     * @return true nếu thanh toán thành công
     */
    public boolean processPayment(String bookingId, double amount) {
        if (amount <= 0) {
            System.out.println("Lỗi: Số tiền thanh toán không hợp lệ!");
            return false;
        }
        
        // Giả lập kết nối cổng thanh toán thành công
        paymentHistory.put(bookingId, amount);
        System.out.println("Thanh toán thành công cho đơn hàng " + bookingId + ". Số tiền: " + amount + " VND");
        return true;
    }

    /**
     * Xử lý hoàn tiền khi người dùng hủy ghế từ BookingManager
     * @param bookingId Mã đặt vé cần hủy
     * @return true nếu hoàn tiền thành công
     */
    public boolean refundPayment(String bookingId) {
        if (!paymentHistory.containsKey(bookingId)) {
            System.out.println("Lỗi: Không tìm thấy lịch sử thanh toán cho mã " + bookingId);
            return false;
        }

        double refundedAmount = paymentHistory.remove(bookingId);
        System.out.println("Đã hoàn trả số tiền: " + refundedAmount + " VND cho đơn hàng " + bookingId);
        return true;
    }

    /**
     * Kiểm tra trạng thái thanh toán của một đơn đặt vé
     */
    public void checkPaymentStatus(String bookingId) {
        if (paymentHistory.containsKey(bookingId)) {
            System.out.println("Đơn hàng " + bookingId + " ĐÃ thanh toán: " + paymentHistory.get(bookingId) + " VND");
        } else {
            System.out.println("Đơn hàng " + bookingId + " CHƯA được thanh toán hoặc đã bị hủy.");
        }
    }
}
