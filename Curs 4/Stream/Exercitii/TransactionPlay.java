package Stream.Exercitii;

import Stream.entity.Trader;
import Stream.entity.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionPlay {

    // TODO: return all transactions form 2011, sorted by value
    public List<Transaction> e1_getAllTransactionsFrom2011SortedByValue(List<Transaction> transactions) {
        List<Transaction> collect = transactions.stream().filter(transaction -> transaction.getYear() > 2011).sorted((t1, t2) -> t1.getValue() - t2.getValue()).collect(Collectors.toList());
        return collect;
    }

    // TODO: return all the unique cities of the traders
    public List<String> e2_getUniqueCitiesOfTheTraders(List<Transaction> transactions) {
        List<String> collect = transactions.stream().map(transaction -> transaction.getTrader().getCity()).collect(Collectors.toList());
        return collect;
    }

    // TODO: return all the Traders from Cambridge, sorted by name
    public List<Trader> e3_getTradersFromCambridgeSortedByName(List<Transaction> transactions) {
        List<Trader> cambridge = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .collect(Collectors.toList());
        return cambridge;
    }

    // TODO: return the names of all the traders, sorted and joined
    public String e4_getNamesOfAllTradersSortedJoined(List<Transaction> transactions) {
        String collect = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .map(trader -> trader.getName())
                .sorted()
                //.collect(Collectors.joining());
                 .reduce("",(a,b)->a+b);
        return collect;
    }

    // TODO: returns true if there is at least one Trader from Milan
    public boolean e5_areTradersInMilan(List<Transaction> transactions) {
        boolean milan = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .anyMatch(trader -> trader.getCity().equals("Milan"));


        return milan;
    }

    // TODO: returns the sum of all the transactions from Traders that are from Cambridge
    public int e6_getSumOfValuesOfTransactionsFromCambridgeTraders(List<Transaction> transactions) {
        int cambridge = transactions.stream()
                .filter(tx -> tx.getTrader().getCity().equals("Cambridge"))
                .mapToInt(tx -> tx.getValue())
                .sum();
        return cambridge;
    }

    // TODO: returns the maximum value of all the transactions
    public int e7_getMaxTransactionValue(List<Transaction> transactions) { return 0; }

    // TODO: returns the smallest value of all the transactions
    public Transaction e8_getTransactionWithSmallestValue(List<Transaction> transactions) { return null; }

    // TODO: returns a transaction from 2012 - Optional??
    public Transaction e9_getATransactionFrom2012(List<Transaction> transactions) { return null;}
}
