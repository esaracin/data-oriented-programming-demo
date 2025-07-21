package OOP.Trades;

public record Buy(String ticker, int amount) implements Trade {

    public String process() {
        return "Processing Buy: " + ticker + ", Amount: " + amount;
    }

}