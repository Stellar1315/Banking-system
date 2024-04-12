import java.util.ArrayList;

public class Account {
    private double money;
    private ArrayList<Transaction> transactions;
    public Account(){
        this.money = 0;
        transactions = new ArrayList<>();
    }
    public void deposit(double money){
        this.money = this.money + money;
        transactions.add(new Transaction(money, 1));
    }
    public void withdraw(double money){
        this.money = this.money - money;
        transactions.add(new Transaction(money, 0));
    }
    public double get_money_on_account() {
        return money;
    }
    public void print_transactions(){
        if(transactions.size() != 0) {
            for (int i = 0; i < transactions.size(); i++) {
                System.out.println(transactions.get(i));
            }
        }
        else{
            System.out.println("no transactions");
        }
    }
    public String toString(){
        if(get_money_on_account() != 0) {
            return "$" + get_money_on_account() + " on this account";
        }
        else{
            return "there is no money on account";
        }
    }
}
