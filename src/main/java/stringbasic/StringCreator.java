package stringbasic;

public class StringCreator {

    public String createStringForHeap() {
        return new String("alma");
    }
    public String createStringForPool() {
        return "alma";
    }
}
