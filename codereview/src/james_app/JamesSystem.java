package james_app;

import entities.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JamesSystem {
    private static final List<Account> accounts = new ArrayList<>();
    private static final Set<Customer> customers = new HashSet<>();
    private static final Set<Transaction> transactions = new HashSet<>();
    //constructor
    public JamesSystem() {
    }

    public static boolean add(Transaction tr){
        return  transactions.add(tr);
    }
    public static boolean add(Customer c){
        return customers.add(c);
    }
    public static boolean add(Account acc){
        return accounts.add(acc);
    }
    public static Set<Transaction> filterTransaction(TransactionMatcher matcher){
        Set<Transaction> filtered = new HashSet<>();
        for (Transaction tr : transactions) {
            if (matcher.match(tr)) {
                filtered.add(tr);
            }
        }
        return filtered;
    }
    public static Set<Transaction> getTransactionsByAccount(Account account){
        Set<Transaction> filtered = new HashSet<>();
        for (Transaction tr : transactions) {
            //wenn der account welcher zur transaktion zugeordnet ist gleich zu diesem account ist füge sie hinzu
            if (tr.getAccount().equals(account)) {
                filtered.add(tr);
            }
        }
        return filtered;
    }

    public static List<Account> getAccounts(Customer c){
        List<Account> sorted = new ArrayList<>();
        for (Account acc : accounts) {
            if (acc.getOwner().equals(c)) {
                sorted.add(acc);
            }
        }
        sorted.sort(new AccountByIDComparator());
        return sorted;
    }
    public static List<Customer> customers(){
        List<Customer> all = new ArrayList<>(customers);

        return all;
    }
    public static Map<Account,List<Transaction>> getTransactionsByAccounts(){

        Map<Account, List<Transaction>> map = new HashMap<>();

        for (Transaction tr : transactions) {
            Account acc = tr.getAccount();

            if (!map.containsKey(acc)) {
                map.put(acc, new ArrayList<>());
            }
            map.get(acc).add(tr);
        }
        return map;
    }
    private static void init(){
        customers.add(new Customer(1, "John Doe", "john@doe.com"));
        customers.add(new Customer(2, "Jane Doe", "jane@doe.com"));
        customers.add(new Customer(3, "Jim Doe", "jim@doe.com"));
        customers.add(new Customer(4, "John Deer", "john@deer.com"));
        customers.add(new Customer(5, "Jane Deer", "jane@deer.com"));

        Random random = new Random(System.currentTimeMillis());


        int accountId = 0;

        for (Customer c : customers) {


            Account checking = new CheckingAccount(c, accountId++);
            checking.deposit(random.nextDouble() * 1000);
            accounts.add(checking);

            double balance = random.nextDouble() * 1000;

            Account savings = new SavingsAccount(c, accountId++, random.nextDouble() * 1000
            );
            accounts.add(savings);
        }
    }
    public static boolean writeAccountTransactions(Account a) {

        String filename = "TRANSACTIONS_" + a.getId() + ".txt";

        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter(filename))) {

            for (Transaction t : getTransactionsByAccount(a)) {

                bw.write(t.toString());
                bw.newLine();
            }

            return true;

        } catch (IOException ex) {

            System.out.println("Account could not be printed");

            return false;
        }
    }
}
