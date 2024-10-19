// custom checked exception for inactive account
class  InactiveAccountException extends Exception {
    public InactiveAccountException(String message) {
        super(message);
    }
}

// custom checked exception for insufficient amount
class InsufficientAmount extends Exception {
    public InsufficientAmount(String message) {
        super(message);
    }
}

// custom checked exception for invalid amount
class InvalidAmount extends Exception {
    public InvalidAmount(String message) {
        super(message);
    }
}


class BankAccount {
    private  double balance;
    private  boolean isActive;

    public BankAccount(double balance, boolean isActive) {
        this.balance = balance;
        this.isActive = isActive;
    }

    public double withdraw(double amount) throws InsufficientAmount, InvalidAmount, InactiveAccountException {
        if(!isActive)
        {
            throw new InactiveAccountException("Account is inactive. Please contact support");
        }

        if(amount <= 0 )
        {
            throw new InvalidAmount("please enter a valid amount.");
        }

        if(amount > balance)
        {
            throw new InsufficientAmount("Insufficient amount");
        }

        balance -= amount;
        return amount;
    }

    public double getBalance(){
        return balance;
    }

    public void setActive(boolean isActive){
        this.isActive = isActive;
    }

}


public class Example {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000, false);

//        try{
//            account.withdraw(500);
//
//        }catch (InsufficientAmount|InvalidAmount|InactiveAccountException e) {
//            System.out.println(e.getMessage());
//        }

//        try{
//            account.withdraw(6600);
//
//        }catch (InsufficientAmount|InvalidAmount|InactiveAccountException e) {
//            System.out.println(e.getMessage());
//        }

//        try{
//            account.withdraw(-700);
//
//        }catch (InsufficientAmount|InvalidAmount|InactiveAccountException e) {
//            System.out.println(e.getMessage());
//        }

        try{
            account.withdraw(700);

        }catch (InsufficientAmount|InvalidAmount|InactiveAccountException e) {
            System.out.println(e.getMessage());
        }
    }

}
