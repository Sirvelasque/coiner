package Client;

import java.io.IOException;

public class CoinConverter {
    public double convert (String base, String goal, double value){
        return convertRate(base, goal) * value;
    }

    public double convertRate (String base, String goal){
        HttpExchange httpExchange = new HttpExchange();
        try{
            ConversionRate conversionRate = httpExchange.ExChangeConvert(base);
            return conversionRate.getConversionRates().get(goal);
        }catch (IOException | InterruptedException e) {
            System.out.println("error detected");
        }
        return 0.0;
    }
}
