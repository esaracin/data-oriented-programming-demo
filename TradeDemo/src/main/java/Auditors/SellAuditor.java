package Auditors;

import Trades.Sell;
import Trades.Trade;

public class SellAuditor implements TradeAuditor {
    public void audit(Trade trade) {
        Sell sell = (Sell) trade;
        if (sell.amount() > 20) {
            System.out.println("High volume Sell; Audit!");
        }
    }
}
