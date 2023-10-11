import lombok.With;

import java.time.Instant;
import java.util.List;
@With
public record Order(
        String id,
        List<Product> products,
        OrderStatus orderStatus,
        Instant timeOfOrder
) {
    public Order(String id, List<Product> products, OrderStatus orderStatus) {
        this(id, products, orderStatus, null);
    }

    public Order(String id, List<Product> products) {
        this(id, products, OrderStatus.PROCESSING, null);
    }

    public Order(String id, List<Product> products, Instant timeOfOrder) {
        this(id, products, null, timeOfOrder);
    }
}