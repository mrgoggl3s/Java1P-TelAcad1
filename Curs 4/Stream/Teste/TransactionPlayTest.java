package Stream.Teste;

import Stream.Exercitii.TransactionPlay;
import Stream.entity.Trader;
import Stream.entity.Transaction;

import java.util.Arrays;
import java.util.List;

public class TransactionPlayTest {

    private static TransactionPlay service = new TransactionPlay();

    static Trader raoul = new Trader("Raoul", "Cambridge");
    static Trader mario = new Trader("Mario", "Milan");
    static Trader alan = new Trader("Alan", "Cambridge");
    static Trader brian = new Trader("Brian", "Cambridge");

    static List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    static Transaction[] tx = transactions.toArray(new Transaction[0]);

    public static void main(String[] args) {
        System.out.println(TestUtil.generateMessage(e1_getAllTransactionsFrom2011SortedByValue(), 1));
        System.out.println(TestUtil.generateMessage(e2_getUniqueCitiesOfTheTraders(), 2));
        System.out.println(TestUtil.generateMessage(e3_getTradersFromCambridgeSortedByName(), 3));
        System.out.println(TestUtil.generateMessage(e4_getNamesOfAllTradersSortedJoined(), 4));
        System.out.println(TestUtil.generateMessage(e5_areTradersInMilan(), 5));
        System.out.println(TestUtil.generateMessage(e6_getSumOfValuesOfTransactionsFromCambridgeTraders(), 6));
        System.out.println(TestUtil.generateMessage(e7_getMaxTransactionValue(), 7));
        System.out.println(TestUtil.generateMessage(e8_getTransactionWithSmallestValue(), 8));
        System.out.println(TestUtil.generateMessage(e9_getATransactionFrom2012(), 9));
    }


    private static boolean e1_getAllTransactionsFrom2011SortedByValue() {
        List<Transaction> expected = Arrays.asList(tx[0], tx[2]);

        return expected.equals(service.e1_getAllTransactionsFrom2011SortedByValue(transactions));
    }

    private static boolean e2_getUniqueCitiesOfTheTraders() {
        return Arrays.asList("Cambridge", "Milan").equals(service.e2_getUniqueCitiesOfTheTraders(transactions));
    }

    private static boolean e3_getTradersFromCambridgeSortedByName() {
        return Arrays.asList(alan, brian, raoul).equals(service.e3_getTradersFromCambridgeSortedByName(transactions));
    }

    private static boolean e4_getNamesOfAllTradersSortedJoined() {
        return "Alan,Brian,Mario,Raoul".equals(service.e4_getNamesOfAllTradersSortedJoined(transactions));
    }

    private static boolean e5_areTradersInMilan() {
        return service.e5_areTradersInMilan(transactions);
    }

    private static boolean e6_getSumOfValuesOfTransactionsFromCambridgeTraders() {
        return 2650 == service.e6_getSumOfValuesOfTransactionsFromCambridgeTraders(transactions);
    }

    private static boolean e7_getMaxTransactionValue() {
        return 1000 == service.e7_getMaxTransactionValue(transactions);
    }

    private static boolean e8_getTransactionWithSmallestValue() {
        return tx[0].equals(service.e8_getTransactionWithSmallestValue(transactions));
    }

    private static boolean e9_getATransactionFrom2012() {
        return tx[1].equals(service.e9_getATransactionFrom2012(transactions));
    }
}
