package Stream.Exercitii;

import Stream.entity.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import static Stream.entity.Order.PaymentMethod;

public class TransformStreamExercises {

    // TODO: transform all entities to DTOs - at least 2 methods, try to make it clean!
    public List<OrderDTO> e1_toDtos(List<Order> orders) {
        return null;
    }

    // TODO: return a Set of all the payment methods
    public Set<PaymentMethod> e2_getUsedPaymentMethods(Customer customer) {
        return null;
    }

    // TODO: return a SortedSet of all the creationDates of the Orders - 2 methods for collection
    public SortedSet<LocalDate> e3_getOrderDatesAscending(Customer customer) {
        return null;
    }


    // TODO: return a map of (order.id -> order) - 2 methods
    public Map<Long, Order> e4_mapOrdersById(Customer customer) {
        return null;
    }

    // TODO: return a map of (PaymentMethod, List<Order> - orders, grouped by Order.paymentMethod
    public Map<PaymentMethod, List<Order>> e5_getProductsByPaymentMethod(Customer customer) {
        return null;
    }


    /*
        A hard one!
        TODO: Get total number of products bought by a customer, across all his orders.
        Customer -> Order -> OrderLine(.count .product)
        The sum of all counts for the same product.
        i.e. SELECT PROD_ID, SUM(COUNT) FROM PROD GROUPING BY PROD_ID
     */
    public Map<Product, Long> e6_getProductCount(Customer customer) {
        return null;
    }

    // TODO: return all the unique products bought by the customer, sorted by Product.name
    public List<Product> e7_getAllOrderedProducts(Customer customer) {
        return null;
    }

    /*
        TODO: return the names of all the products bought by Customer, sorted and then concatenated by ",".
        example: "Armchair,Chair,Table"
        Hint: Reuse the previous method!
     */
    public String e8_getProductsJoined(Customer customer) {
        return null;
    }

    // TODO: return the sum of all Order.getTotalPrice(), truncated to Long.
    public long e9_getApproximateTotalOrdersPrice(Customer customer) {
        return 0;
    }


    // ----------- IO ---------------

    /*
        TODO: Read lines from file as Strings.
        Where do you close the opened file?
        Parse those to OrderLine using the function below
        Validate the created OrderLine. Throw ? :S
        Hint: use parseOrderLine & validateOrderLine
     */
    public List<OrderLine> e10_readOrderFromFile(File file) throws IOException {
        return null;
    }

    // TODO: print cannonical paths of all files in current directory
    public void e11_printCannonicalPaths() {

    }



    private OrderLine parseOrderLine(String[] cells) {
        return new OrderLine(new Product(cells[1]), Integer.parseInt(cells[2]));
    }

    private void validateOrderLine(OrderLine orderLine) {
        if (orderLine.getCount() < 0) {
            throw new IllegalArgumentException("Negative items");
        }
    }
}
