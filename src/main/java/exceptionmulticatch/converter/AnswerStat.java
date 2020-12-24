package exceptionmulticatch.converter;

public class AnswerStat {

    private BinaryStringConverter converter;

    public AnswerStat(BinaryStringConverter converter) {
        this.converter = converter;
    }

    public boolean[] convert(String str) {
        try {
            return converter.binaryStringToBooleanArray(str);
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new InvalidBinaryStringException(e);
        }
    }

    public int answerTruePercent(String answers) {
        int trues = 0;
        boolean[] booleans = convert(answers);
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i])
                trues++;
        }
        return trues * 100 / booleans.length;
    }
}
