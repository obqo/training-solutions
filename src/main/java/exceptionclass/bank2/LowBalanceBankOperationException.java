package exceptionclass.bank2;

public class LowBalanceBankOperationException extends InvalidBankOperationException {

    public LowBalanceBankOperationException() {
        super();
    }

    public LowBalanceBankOperationException(String message) {
        super(message);
    }
}
