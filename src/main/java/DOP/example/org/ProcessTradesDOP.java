package DOP.example.org;

import DOP.Trades.Buy;
import DOP.Trades.Sell;
import DOP.Trades.Trade;


// For this demo, assume Trade package be external and managed by another team. They are responsible for extending
// it with new types of Trades, etc.
//
// Our job is to pull in their Trades, and process them, with additional auditing logic specific to each type of Trade.

public class ProcessTradesDOP {
    public static void main(String[] args) {
        Trade buy = new Buy("GOOGL", 10);
        Trade sell = new Sell("AAPL", 5);

        Trade bigBuy = new Buy("GOOGL", 20);
        Trade bigSell = new Sell("AAPL", 40);

        // My team's logic: if a buy amount is > 10, or a sell amount is > 20, we need to audit the trade!
        processTrade(buy);
        processTrade(sell);
        System.out.println();
        processTrade(bigBuy);
        processTrade(bigSell);
    }

    public static void processTrade(Trade trade) {
        String tradeString = switch(trade) {
            case Buy b when b.amount() > 10 -> "High volume Buy; Audit!" + "\n" + b.process();
            case Buy b -> b.process();
            case Sell s when s.amount() > 20 -> "High volume Sell; Audit!" + "\n" + s.process();
            case Sell s -> s.process();
        };
        System.out.println(tradeString);
    }

}