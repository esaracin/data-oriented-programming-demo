package Auditors;

import Trades.Buy;
import Trades.Trade;

public class BuyAuditor implements TradeAuditor {
    public void audit(Trade trade) {
        Buy buy = (Buy) trade;
        if(buy.amount() > 10) {
           System.out.println("High volume Buy; Audit!");
        }
    }
}
