package Stream.Teste;

import Stream.Exercitii.TransformStreamExercises;
import Stream.entity.*;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static Stream.entity.Order.PaymentMethod;

public class TransformStreamTest {

    private static TransformStreamExercises service = new TransformStreamExercises();

    private static LocalDate today = LocalDate.now();
    private static LocalDate yesterday = LocalDate.now().minusDays(1);

    public static void main(String[] args) {
        System.out.println(TestUtil.generateMessage(e1_toDtos(), 1));
        System.out.println(TestUtil.generateMessage(e2_getUsedPaymentMethods(), 2));
        System.out.println(TestUtil.generateMessage(e3_getOrderDatesAscending(), 3));
        System.out.println(TestUtil.generateMessage(e4_mapOrdersById(), 4));
        System.out.println(TestUtil.generateMessage(e5_getProductsByPaymentMethod(), 5));
        System.out.println(TestUtil.generateMessage(e6_getProductCount(), 6));
        System.out.println(TestUtil.generateMessage(e7_getAllOrderedProducts(), 7));
        System.out.println(TestUtil.generateMessage(e8_getProductsNamesJoined(), 8));
        System.out.println(TestUtil.generateMessage(e9_getApproximateTotalOrdersPrice(), 9));
        System.out.println(TestUtil.generateMessage(e10_readOrderFromFile(), 10));
    }

    private static boolean e1_toDtos() {
        Order order1 = new Order().setCreationDate(today).setTotalPrice(BigDecimal.TEN);
        Order order2 = new Order().setCreationDate(yesterday).setTotalPrice(BigDecimal.ONE);

        List<OrderDTO> dtos = service.e1_toDtos(Arrays.asList(order1, order2));

        return (dtos != null) && (!dtos.isEmpty())
                && (today.equals(dtos.get(0).creationDate)
                && (BigDecimal.TEN.equals(dtos.get(0).totalPrice))) && (yesterday.equals(dtos.get(1).creationDate));
    }

    private static boolean e2_getUsedPaymentMethods() {
        Order cardOrder = new Order().setPaymentMethod(PaymentMethod.CARD);
        Order cardOrder2 = new Order().setPaymentMethod(PaymentMethod.CARD);
        Order cashOnDeliveryOrder = new Order().setPaymentMethod(PaymentMethod.CASH_ON_DELIVERY);

        HashSet<PaymentMethod> expected = new HashSet<>(Arrays.asList(PaymentMethod.CARD, PaymentMethod.CASH_ON_DELIVERY));
        return expected.equals(service.e2_getUsedPaymentMethods(new Customer(cardOrder, cardOrder2, cashOnDeliveryOrder)));
    }

    private static boolean e3_getOrderDatesAscending() {
        Order order1 = new Order().setCreationDate(today);
        Order order1bis = new Order().setCreationDate(today);
        Order order2 = new Order().setCreationDate(yesterday);

        List<LocalDate> expected = Arrays.asList(yesterday, today);
        Collection<LocalDate> actual = service.e3_getOrderDatesAscending(new Customer(order1, order1bis, order2));

        return actual != null && expected.equals(new ArrayList<>(actual));
    }

    private static boolean e4_mapOrdersById() {
        Order order1 = new Order(1L);

        Map<Long, Order> actual = service.e4_mapOrdersById(new Customer(order1));
        Map<Long, Order> expected = Collections.singletonMap(1L, order1);
        return expected.equals(actual);
    }

    private static boolean e5_getProductsByPaymentMethod() {
        Order order1 = new Order().setPaymentMethod(PaymentMethod.CARD);
        Order order2 = new Order().setPaymentMethod(PaymentMethod.CASH_ON_DELIVERY);
        Order order3 = new Order().setPaymentMethod(PaymentMethod.CARD);
        Map<PaymentMethod, List<Order>> actual = service.e5_getProductsByPaymentMethod(new Customer(order1, order2, order3));
        return (actual != null)
                && (Arrays.asList(order2).equals(actual.get(PaymentMethod.CASH_ON_DELIVERY)))
                && (Arrays.asList(order1, order3).equals(actual.get(PaymentMethod.CARD)));
    }

    private static boolean e6_getProductCount() {
        Product chair = new Product("Chair");
        Product table = new Product("Table");

        Order order1 = new Order(new OrderLine(chair, 3));
        Order order2 = new Order(
                new OrderLine(table, 1),
                new OrderLine(chair, 1)
        );

        Map<Product, Long> actual = service.e6_getProductCount(new Customer(order1, order2));
        Map<Product, Long> expected = new HashMap<Product, Long>() {{
            put(chair, 4L);
            put(table, 1L);
        }};
        return actual != null && actual.equals(expected);
    }

    private static boolean e7_getAllOrderedProducts() {
        Product chair = new Product("Chair");
        Product table = new Product("Table");

        Order order1 = new Order(new OrderLine(chair, 3));
        Order order2 = new Order(
                new OrderLine(table, 1),
                new OrderLine(chair, 1)
        );

        List<Product> actual = service.e7_getAllOrderedProducts(new Customer(order1, order2));
        return (actual != null) && (!actual.isEmpty())
                && actual.equals(Arrays.asList(chair, table));
    }

    private static boolean e8_getProductsNamesJoined() {
        Product armchair = new Product("Armchair");
        Product chair = new Product("Chair");
        Product table = new Product("Table");

        Order order1 = new Order(new OrderLine(chair, 3));
        Order order2 = new Order(
                new OrderLine(armchair, 1),
                new OrderLine(table, 1),
                new OrderLine(chair, 1)
        );

        String actual = service.e8_getProductsJoined(new Customer(order1, order2));
        return actual != null && actual.equals("Armchair,Chair,Table");
    }

    private static boolean e9_getApproximateTotalOrdersPrice() {
        Order order1 = new Order().setTotalPrice(BigDecimal.TEN);
        Order order2 = new Order().setTotalPrice(BigDecimal.ONE);

        long actual = service.e9_getApproximateTotalOrdersPrice(new Customer(order1, order2));
        return 11L == actual;
    }

    private static boolean e10_readOrderFromFile() {
        List<OrderLine> orderLines;
        try {
            orderLines = service.e10_readOrderFromFile(new File("test.ok.txt"));
        } catch (IOException e) {
            return false;
        }
        return (orderLines != null) && (orderLines.size() > 1)
                && ("Chair".equals(orderLines.get(0).getProduct().getName()))
                && (2 == orderLines.get(0).getCount())
                && ("Table".equals(orderLines.get(1).getProduct().getName()))
                && (1 == orderLines.get(1).getCount());
    }
}
