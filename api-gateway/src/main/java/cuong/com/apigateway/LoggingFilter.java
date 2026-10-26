package cuong.com.apigateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // Lấy thông tin Path của Request
        String path = exchange.getRequest().getURI().getPath();

        // In ra Console
        System.out.println("Incoming request to: " + path);

        // Cho phép Request đi tiếp đến Service đích
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // Mức độ ưu tiên của filter (số nhỏ chạy trước)
        return -1;
    }
}