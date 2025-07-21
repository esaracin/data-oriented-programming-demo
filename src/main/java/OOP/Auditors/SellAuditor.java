package OOP.Auditors;

import OOP.Trades.Sell;
import OOP.Trades.Trade;

public class SellAuditor implements TradeAuditor {
    public void audit(Trade trade) {
        Sell sell = (Sell) trade;
        if (sell.amount() > 20) {
            System.out.println("High volume Sell; Audit!");
        }
    }
}
