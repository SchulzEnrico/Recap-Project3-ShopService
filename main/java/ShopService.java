import java.time.Instant;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ShopService {
    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();
    private IdService idService;

    //Coding: Exceptions
    public Order addOrder(List<String> productIds) throws NoSuchElementException {
        List<Product> products = new ArrayList<>();
        for (String productId : productIds) {
            Optional<Product> productToOrder = productRepo.getProductById(productId);
            if (productToOrder.isEmpty()) {
                throw new NoSuchElementException("Produkt mit der Id: " + productId + " konnte nicht bestellt werden");
            }
            Product orderProduct = productToOrder.get();
            products.add(orderProduct);
        }

        Order newOrder = new Order(UUID.randomUUID().toString(), products,OrderStatus.PROCESSING, Instant.now());

        return orderRepo.addOrder(newOrder);
    }

    //Coding: Bestellstatus
    public List<Order> findByOrderStatus(OrderStatus orderStatus){
        return orderRepo.getOrders().stream()
                .filter(s->s.orderStatus().equals(orderStatus)).toList();
    }

    //Coding: Lombok
    public Order updateOrder(String orderID, OrderStatus orderStatus){
        Order order = orderRepo.getOrderById(orderID).withOrderStatus(orderStatus);
        orderRepo.addOrder(order);
        return order;
    }

    // Bonus: Liegengebliebenes
    public Map<OrderStatus,Order> getOldestOrderPerStatus(){
        Map<OrderStatus, Order> oldestOrderPerStatus = new HashMap<>();
        OrderStatus[] orderStatuses = OrderStatus.values();
        for(int i = 0;i<orderStatuses.length;i++){
            List<Order> orderList = findByOrderStatus(orderStatuses[i])
                    .stream().sorted(Comparator.comparingInt(a -> a.timeOfOrder().getNano())).toList();
            if(!orderList.isEmpty()){
                oldestOrderPerStatus.put(orderStatuses[i],orderList.get(0));
            }
        }
        return oldestOrderPerStatus;
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orderRepo=" + orderRepo +
                '}';
    }
}


