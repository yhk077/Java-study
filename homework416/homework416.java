abstract class Transaction{
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
}
class Account extends Transaction{
    protected String accountId;
    protected String accountHolder;
    protected double balance;
    public Account (String accountId,String accountHolder,double balance){
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = balance; 
    }
    public void displayInfo(){
        System.out.println("账户:" + accountId);
        System.out.println("账户名:" + accountHolder);
        System.out.println("余额:" + balance);
    }
    public void result(String message){
        System.out.println("交易日志:"+message);
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){ 
        this.balance = balance;
    }
    public void deposit(double amount){}
    public void withdraw(double amount){}
}
class SavingAccount extends Account{
    public double amount;
    public SavingAccount(String accountId,String accountHolder,double balance){
        super(accountId,accountHolder,balance); 
    }
    public void deposit(double amount){ 
        if(amount > 0){
            balance += amount;
            result("存入成功"+",余额:"+balance);
        }
        else{ 
            result("请输入正确金额");
        }
    }
    public void withdraw(double amount){ 
        if(amount < 0){
            result("请输入正确金额");  
        }
        else if(amount <= balance){
            balance -= amount;
            result("取款成功"+",余额:"+balance);
        }
        else{ 
            result("账户余额不足");
        }
    }
}    
public class homework416{
    public static void main(String[] args){
        SavingAccount A = new SavingAccount("A1","A",1000.0);
        SavingAccount B = new SavingAccount("B1","B",0.0);
        SavingAccount C = new SavingAccount("C1","C",1000.0);
        A.displayInfo();
        System.out.println();
        B.displayInfo();
        System.out.println();
        C.displayInfo();
        System.out.println();
        A.deposit(500.0);
        System.out.println();
        B.withdraw(1000.0);
        System.out.println();
        C.withdraw(100.0);
        System.out.println();
    }
}
