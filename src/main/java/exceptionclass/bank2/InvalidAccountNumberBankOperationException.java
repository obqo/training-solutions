package exceptionclass.bank2;

public class InvalidAccountNumberBankOperationException extends InvalidBankOperationException{

    public InvalidAccountNumberBankOperationException() {
        super();
    }

    public InvalidAccountNumberBankOperationException(String message) {
        super(message);
    }
}
