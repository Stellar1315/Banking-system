import java.util.Date;

public class Transaction {
    private double money;
    private int transaction_kind;
    private Date date;
    public Transaction(double money, int transaction_kind){
        this.transaction_kind = transaction_kind;
        this.money = money;
        this.date = new Date();
    }
    public String toString(){
        if (transaction_kind == 1){
            return "$" + money + " deposited on " + date;
        }
        else{
            return "$" + money + " withdrawn on " + date;
        }
    }
}
