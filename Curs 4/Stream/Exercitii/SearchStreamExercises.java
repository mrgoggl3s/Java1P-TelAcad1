package Stream.Exercitii;

import Stream.entity.Customer;
import Stream.entity.Order;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class SearchStreamExercises {

    // TODO: return the Order in the list with the given id
    public Order e1_getOrderById(List<Order> orders, long orderId) {
        Order order1 = orders.stream()
                .filter(order -> order.getId().equals(orderId))
                .findFirst()
                .orElse(null);
        return order1;
    }


    // TODO: return true if customer has at least one order with status ACTIVE
    public boolean e2_hasActiveOrders(Customer customer) {
        List<Order> orders = customer.getOrders();
       return orders.stream().filter(order -> order.getStatus().equals(Order.Status.ACTIVE)).anyMatch(order -> order.getStatus().equals(Order.Status.ACTIVE));
    }


    // TODO: an Order can be returned if it doesn't contain any OrderLine with isSpecialOffer()==true
    public boolean e3_canBeReturned(Order order) {
        boolean b = order.getOrderLines().stream()
                .filter(orderLine -> orderLine.isSpecialOffer() == true).anyMatch(orderLine -> orderLine.isSpecialOffer() == true);
        return b;
    }


    // TODO: return the Order with maximum getTotalPrice (the most expensive Order, or null if no Orders)
    // TODO Challenge: return an Optional<creationDate>
    public Order e4_getMaxPriceOrder(Customer customer) {
        Order order = customer.getOrders().stream()
                .max((comparing(Order::getTotalPrice)))
                .orElse(null);
        return order;
    }



    // TODO: return last 3 Orders sorted descending by creationDate
    public List<Order> e5_getLast3Orders(Customer customer) {
        List<Order> collect = customer.getOrders().stream()
                .sorted((order1, order2) -> order2.getCreationDate().compareTo(order1.getCreationDate()))
                .limit(3)
                .collect(Collectors.toList());
        return collect;
    }

}
