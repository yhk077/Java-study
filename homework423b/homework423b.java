class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message){
        super(message);
    }
}
class Account{
    protected int accountId;
    protected String accountHolder;
    protected double balance;
    public Account(int accountId, String accountHolder, double balance){
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public void displayInfo(){
        System.out.println("账号: " + accountId);
        System.out.println("账户名: " + accountHolder);
        System.out.println("余额: " + balance);
    }
}
interface Transaction{
    void deposit(double amount);
    void withdraw(double amount)throws InsufficientBalanceException;
}

class SavingsAccount extends Account implements Transaction{ 
        public SavingsAccount(int accountId,String accountHolder,double balance){
            super(accountId,accountHolder,balance);
        }
        public void deposit(double amount){
            if(amount > 0){
                balance += amount;
                System.out.println("成功存入" + amount + "，余额" + balance);
            } else {
                System.out.println("存入金额必须大于0");
            }
        }
        public void withdraw(double amount) throws InsufficientBalanceException{
            if(amount > balance){
                throw new InsufficientBalanceException("余额不足");
            }
            if(amount > 0){
                balance -= amount;
                System.out.println("取款成功，余额为:" + balance);
            } else {
                System.out.println("取款金额必须大于0");
            }
        }
}   
public class homework423b {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount(12345, "LiHua", 1000.0);
        account.displayInfo();
        try {
            account.withdraw(1500.0);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}