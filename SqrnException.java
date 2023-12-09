package sqreq;
public class SqrnException extends ArithmeticException{
    public String detail;

    SqrnException(String message) {
        this.detail = message;
    }

    @Override
    public String toString() {
        return "D is negative, no real roots! " + detail;
    }
}