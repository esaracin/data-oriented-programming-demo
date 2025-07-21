package Trades;

public record Sell(String ticker, int amount) implements Trade {

    public String process() {
        return "Processing Sell: " + ticker + ", Amount: " + amount;
    }
}