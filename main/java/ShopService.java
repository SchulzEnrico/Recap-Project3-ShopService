import java.util.*;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor

public class ShopService {
    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();

    //Coding: Exceptions
    public Order addOrder(List<String> productIds) throws NoSuchElementException {
        List<Optional<Product>> products = new ArrayList<>();
        for (String productId : productIds) {
            Optional<Optional<Product>> productToOrder = Optional.ofNullable(productRepo.getProductById(productId));
            if (productToOrder.isEmpty()) {
                throw new NoSuchElementException("Product mit der Id: " + productId + " konnte nicht bestellt werden");
            }
            Optional<Product> orderProduct = productToOrder.get();
            products.add(orderProduct);
        }

        Order newOrder = new Order(UUID.randomUUID().toString(), products);

        return orderRepo.addOrder(newOrder);
    }

    //Coding: Bestellstatus
    public List<Order> findByOrderStatus(OrderStatus orderStatus){
        return orderRepo.getOrders().stream()
                .filter(s->s.OrderStatus().equals(orderStatus)).toList();
    }

    //Coding: Lombok
    public Order updateOrder(String orderID, OrderStatus orderStatus){
        Order order = orderRepo.getOrderById(orderID).withOrderStatus(orderStatus);
        orderRepo.addOrder(order);
        return order;
    }
}


