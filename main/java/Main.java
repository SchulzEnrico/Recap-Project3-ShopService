import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderMapRepo();
        IdService idService = new IdService();
        ShopService shopService = new ShopService(productRepo, orderRepo, idService);

        shopService.addOrder(List.of("1"));
        shopService.addOrder((List.of("3")));
        shopService.addOrder((List.of("2")));

        OrderStatus[] orderStatuses = OrderStatus.values();
        System.out.println(orderStatuses[0]);
    }
}
