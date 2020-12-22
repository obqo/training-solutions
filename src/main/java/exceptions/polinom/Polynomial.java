package exceptions.polinom;

public class Polynomial {

    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] strCoefficients) {
        if (strCoefficients == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        try {
            double[] coefficients = new double[strCoefficients.length];
            for (int i = 0; i < strCoefficients.length; i++) {
                coefficients[i] = Double.parseDouble(strCoefficients[i]);
            }
            this.coefficients = coefficients;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", nfe);
        }
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public double evaluate(double x) {
        double result = 0;
        int n = coefficients.length;
        for (int i = 0; i < n; i++) {
            result += coefficients[i] * Math.pow(x, n - i - 1);
        }
        return result;
    }
}
