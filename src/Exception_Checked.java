/*
- Built-in exceptions :
1 : Checked Exception :
    These are the exception that are checked at compile time. if it throws a checked exception. it must be either caught or declared in the method signature using throws.
    Example :
    1: IOEXCEPTION
    2: SQLEXCEPTION
    3: FILENOTFOUNDEXCEPTION

2 : Unchecked Exception
    These are the exception which are not checked at compile time and usually occurs at run time, it might be caught or declared in the method signature using throws.
    Example :
    1: NullPointerException
    2: ArrayIndexOutOfBoundedException
    3: ArithmeticException
    4: IllegalArgumentException

- try, catch(), finally, throw & throws
    :: try - catch
        The try block contains the code that might cause an exception. and the catch block handles the exception which are caused in try block.

        Syntax of try catch
        try{
           // code that may throw an exception
            int result = 10 / 0;
        }catch(ArithmeticException e){
             System.out.println(e.getMessage());
         }
    :: finally
        The finally block will run regardless of whether exception occurred or not
        Syntax :
        try{
           // code that may throw an exception
            int result = 10 / 0;
        }catch(ArithmeticException e){
             System.out.println(e.getMessage());
         }finally{
             System.out.println("hello");
         }
     :: throw
        this keyword is used to explicitly throw an exception, either a built-in or custom exception

        throw new ArithmeticException("Division by zero is not allowed")
     :: throws
         the throws keyword is used in the method signature to declare that method might throw an exception.

- Custom Exception
    You can create your own exception by extending the Exception class(for checked exception) or the RuntimeException class(unchecked exception)

*/

class  CustomException extends Exception{
    CustomException(String msg)
    {
        super(msg);
    }
     public void checkAge(int age) throws CustomException{
        if(age < 18)
        {
            throw new CustomException("Age is too low for voting");
        }
     }

}


class CustomUnCheckedException extends RuntimeException{
    public CustomUnCheckedException(String msg){
        super(msg);
    }

    public void validDate(int num) throws CustomUnCheckedException{
        if(num <0 )
        {
            throw new CustomUnCheckedException("Invalid date format");
        }
    }

}

public class Exception_Checked {
    public static void main(String[] args) throws CustomException {

        CustomException ce = new CustomException("Exception");
        ce.checkAge(16);
        CustomUnCheckedException cue = new CustomUnCheckedException("Custom Exception");
        cue.validDate(-16);

    }
}
