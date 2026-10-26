package cuong.com.customerservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class CustomerController {

    @GetMapping("/{id}")
    public String getCustomerDetail(@PathVariable String id) {
        // Dữ liệu giả lập để kiểm tra xem Gateway có điều hướng đúng sang port 8081 không
        return "Routing thành công! Đây là thông tin customer ID: " + id + " (Phản hồi từ customer-service chạy port 8081)";
    }
    @GetMapping("/login")
    public String login() {
        return "Login endpoint hit!";
    }
}