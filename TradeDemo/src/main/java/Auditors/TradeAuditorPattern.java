package Auditors;

import Trades.Trade;

// Set the stage as Buy and Sell audits have very different flows.
// For our demo, they'll just print based on different conditions, but
// image there are more complex flows after the prints in a real application.
public class TradeAuditorPattern {

    public void audit(Trade trade){
        if (trade instanceof Trades.Buy buy) {
            if (buy.amount() > 10) {
                System.out.println("High volume Buy; Audit!");
            }
        } else if (trade instanceof Trades.Sell sell) {
            if (sell.amount() > 20) {
                System.out.println("High volume Sell; Audit!");
            }
        } else {
            System.out.println("Unknown trade type; no audit performed.");
        }
    }
}
