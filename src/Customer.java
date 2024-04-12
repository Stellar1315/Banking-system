import java.util.ArrayList;

public class Customer {
    private String firstname;
    private String lastname;
    private int pincode;
    private ArrayList<Account> accounts;
    private int errors;

    public Customer(String firstname, String lastname, int pincode){
        this.firstname = ((firstname.trim()).toLowerCase());
        this.lastname = ((lastname.trim()).toLowerCase());
        this.errors = 0;
        this.pincode = pincode;
        this.accounts = new ArrayList<>();
        System.out.println("customer has been made");
    }
    public Customer(String firstname, String lastname){
        this(firstname, lastname, 0000);
    }
    public void set_pincode(int new_pincode, int pincode){
        if(!lockdown()) {
            if (pincode == this.pincode) {
                if ((String.valueOf(new_pincode)).length() == 4) {
                    this.pincode = new_pincode;
                    System.out.println("pincode has been changed");
                } else {
                    System.out.println("invalid pincode, must be 4 numbers long");
                }
            } else {
                System.out.println(get_error_message());
                errors++;
            }
        }
        else{
            System.out.println("account is blocked");
        }
    }
    public void set_firstname(String new_firstname, int pincode){
        if(!lockdown()) {
            if (pincode == this.pincode) {
                this.firstname = firstname;
                System.out.println("firstname has been changed");
            } else {
                System.out.println(get_error_message());
                errors++;

            }
        }
        else{
            System.out.println("account is blocked");
        }
    }
    public void set_lastname(String new_lastname, int pincode){
        if(!lockdown()) {
            if (pincode == this.pincode) {
                this.lastname = new_lastname;
                System.out.println("lastname has been changed");
            } else {
                System.out.println(get_error_message());
                errors++;

            }
        }
        else{
            System.out.println("account is blocked");
        }
    }
    public void open_account(int pincode){
        if(!lockdown()){
            if(pincode == this.pincode){
                accounts.add(new Account());
                System.out.println("account has been made");
            }
            else{
                System.out.println(get_error_message());
                errors++;
            }
        }
        else{
            System.out.println("account is blocked");
        }
    }
    public void get_accounts(int pincode){
        if(!lockdown()){
            if(pincode == this.pincode){
                for(int count = 0; count < accounts.size(); count++){
                    System.out.println("[" + (count + 1) + "] "+ accounts.get(count));
                }
            }
            else{
                System.out.println(get_error_message());
                errors++;
            }
        }
        else{
            System.out.println("account is blocked");
        }
    }
    public void deposit_money(int pincode, double money, int account){
        if(!lockdown()) {
            if(pincode == this.pincode) {
                if(accounts.size() == 0){
                    System.out.println("u dont have any accounts");
                }
                else {
                    if(account > 0 && account <= accounts.size()) {
                        accounts.get(account - 1).deposit(money);
                        System.out.println("$" + money + " deposited on account: " + account + " (money on account: $" +accounts.get(account - 1).get_money_on_account() + ")");
                    }
                    else{
                        System.out.println("this account doesnt exist");
                    }
                }
            }
            else{
                System.out.println(get_error_message());
                errors++;
            }
        }
        else{
            System.out.println("account is blocked");
        }
    }
    public void withdraw_money(int pincode, double money, int account){
        if(!lockdown()) {
            if (pincode == this.pincode) {
                if (accounts.size() == 0) {
                    System.out.println("u dont have any accounts");
                } else {
                    if(account > 0 && account <= accounts.size()){
                        if(accounts.get(account - 1).get_money_on_account() >= money){
                            accounts.get(account - 1).withdraw(money);
                            System.out.println("$" + money + " withdrawn from account: " + account + " (money on account: $" +accounts.get(account - 1).get_money_on_account() + ")" );
                        }
                        else{
                            System.out.println("u have $" + accounts.get(account - 1).get_money_on_account() + ", so u cant withdraw more");
                        }
                    }
                    else{
                        System.out.println("this account doesnt exist");
                    }
                }
            }
            else{
                System.out.println(get_error_message());
                errors++;
            }
        }

        else{
            System.out.println("account is blocked");
        }
    }
    public void get_transactions(int pincode, int account){
        if(!lockdown()) {
            if (pincode == this.pincode) {
                if (account > 0 && account <= accounts.size()) {
                    accounts.get(account - 1).print_transactions();
                } else {
                    System.out.println("this account doesnt exist");
                }
            } else {
                System.out.println(get_error_message());
                errors++;
            }
        }
        else{
            System.out.println("account is blocked");
        }
    }
    public boolean lockdown(){
        if( errors >= 2){
            return true;
        }
        else{
            return false;
        }
    }
    public String get_error_message(){
        if(errors == 0){
            return "invalid pincode, 1 more try";
        }
        else{
            return "invalid pincode, account has been blocked";
        }
    }
    public String toString() {
        if(accounts.size() == 0) {
            return firstname + " " + lastname + ", no accounts";
        }
        else if(accounts.size() == 1){
            return firstname + " " + lastname + ", 1 account open";
        }
        else{
            return firstname + " " + lastname + ", " + String.valueOf(accounts.size()) + " accounts open";
        }
    }
}
