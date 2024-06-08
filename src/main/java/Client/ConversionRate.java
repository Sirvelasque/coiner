package Client;


import java.util.Map;

public class ConversionRate {
    private final Map<String, Double> conversion_rates;

    public ConversionRate(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    // Getter and Setter
    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

}
