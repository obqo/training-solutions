package defaultconstructor;

public class SimpleDateFormatter {

    private CountryCode defaultContryCode;

    public SimpleDateFormatter() {
        this.defaultContryCode = CountryCode.HU;
    }

    public String formatDateString(SimpleDate simpleDate) {
        return formatDateStringByCountryCode(defaultContryCode, simpleDate);
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate){
        switch (countryCode) {
            case EN:
                return simpleDate.getDay() + "-" + simpleDate.getMonth() + "-" + simpleDate.getYear();
            case US:
                return simpleDate.getMonth() + "-" + simpleDate.getDay() + "-" + simpleDate.getYear();
            default:
                return simpleDate.getYear() + "-" + simpleDate.getMonth() + "-" + simpleDate.getDay();
        }
    }
}
