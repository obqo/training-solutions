package exceptionclass.bank2;

public class InvalidAmountBankOperationException extends InvalidBankOperationException {

    public InvalidAmountBankOperationException() {
        super();
    }

    public InvalidAmountBankOperationException(String message) {
        super(message);
    }
}
