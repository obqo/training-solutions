package week03;

public class Operation {

    private int left;
    private int right;

    public Operation(String operation) {
        this.left = Integer.parseInt(operation.substring(0, operation.indexOf("+")));
        this.right = Integer.parseInt(operation.substring(operation.indexOf("+") + 1));
    }

    public int getResult() {
        return left + right;
    }
}
