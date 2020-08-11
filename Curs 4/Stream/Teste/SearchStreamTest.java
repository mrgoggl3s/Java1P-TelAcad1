package Stream.Teste;

import Stream.Exercitii.SearchStreamExercises;
import Stream.entity.Customer;
import Stream.entity.Order;
import Stream.entity.OrderLine;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Stream.entity.Order.Status;
import static java.time.LocalDate.now;

public class SearchStreamTest {

    private static SearchStreamExercises service = new SearchStreamExercises();

    public static void main(String[] args) {
        System.out.println(TestUtil.generateMessage(e1_getOrderById() && e1_getOrderById_whenIdNotFound(), 1));
        System.out.println(TestUtil.generateMessage(e2_hasActiveOrders_false() && e2_hasActiveOrders_true(), 2));
        System.out.println(TestUtil.generateMessage(e3_canBeReturned_false() && e3_canBeReturned_true(), 3));
        System.out.println(TestUtil.generateMessage(e4_getMaxPriceOrder() && e4_getMaxPriceOrder_whenNoOrders_returnsNothing(), 4));
        System.out.println(TestUtil.generateMessage(e5_getLast3Orders() && e5_getLast3Orders_whenNoOrders() && e5_getLast3Orders_whenOnlyTwoOrders(), 5));
    }

    private static boolean e1_getOrderById() {
        List<Order> orders = Arrays.asList(new Order(1L), new Order(2L), new Order(3L));
        Order order = service.e1_getOrderById(orders, 2L);

        return (order != null) && (2L == order.getId());
    }

    private static boolean e1_getOrderById_whenIdNotFound() {
        List<Order> orders = Arrays.asList(new Order(1L));
        return service.e1_getOrderById(orders, 1000L).equals(new Order());
    }

    private static boolean e2_hasActiveOrders_true() {
        Customer customer = new Customer(new Order(Status.INACTIVE), new Order(Status.ACTIVE));
        return service.e2_hasActiveOrders(customer);
    }

    private static boolean e2_hasActiveOrders_false() {
        Customer customer = new Customer(new Order(Status.INACTIVE));
        return !service.e2_hasActiveOrders(customer);
    }

    private static boolean e3_canBeReturned_true() {
        Order order = new Order(new OrderLine());
        return service.e3_canBeReturned(order);
    }

    private static boolean e3_canBeReturned_false() {
        OrderLine specialOffer = new OrderLine().setSpecialOffer(true);
        Order order = new Order(specialOffer, new OrderLine());
        return !service.e3_canBeReturned(order);
    }

    private static boolean e4_getMaxPriceOrder() {
        LocalDate yesterday = now().minusDays(1);
        Order order1 = new Order().setTotalPrice(BigDecimal.ONE).setCreationDate(now());
        Order order2 = new Order().setTotalPrice(BigDecimal.TEN).setCreationDate(yesterday);
        return order2.equals(service.e4_getMaxPriceOrder(new Customer(order1, order2)));
        //return yesterday.equals(service.e4_getMaxPriceOrder(new Customer(order1, order2)).get());
    }

    private static boolean e4_getMaxPriceOrder_whenNoOrders_returnsNothing() {
        return service.e4_getMaxPriceOrder(new Customer()) == null;
        //return service.e4_getMaxPriceOrder(new Customer()).isPresent() == false;
    }

    private static boolean e5_getLast3Orders() {
        Order order1 = new Order().setCreationDate(LocalDate.parse("2016-01-01"));
        Order order2 = new Order().setCreationDate(LocalDate.parse("2016-01-02"));
        Order order3 = new Order().setCreationDate(LocalDate.parse("2016-01-03"));
        Order order4 = new Order().setCreationDate(LocalDate.parse("2016-01-04"));

        Customer customer = new Customer(order1, order2, order3, order4);

        return Arrays.asList(order4, order3, order2).equals(service.e5_getLast3Orders(customer));
    }

    private static boolean e5_getLast3Orders_whenOnlyTwoOrders() {
        Order order1 = new Order().setCreationDate(LocalDate.parse("2016-01-01"));
        Order order2 = new Order().setCreationDate(LocalDate.parse("2016-01-02"));

        Customer customer = new Customer(order1, order2);
        return Arrays.asList(order2, order1).equals(service.e5_getLast3Orders(customer));
    }

    private static boolean e5_getLast3Orders_whenNoOrders() {
        return Collections.emptyList().equals(service.e5_getLast3Orders(new Customer()));
    }
}
