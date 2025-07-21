package OOP.example.org;

import OOP.Auditors.TradeAuditor;
import OOP.Trades.Buy;
import OOP.Trades.Sell;
import OOP.Trades.Trade;

import java.lang.reflect.InvocationTargetException;

// For this demo, assume Trade package be external and managed by another team. They are responsible for extending
// it with new types of Trades, etc.
//
// Our job is to pull in their Trades, and process them, with additional auditing logic specific to each type of Trade.

public class ProcessTradesOOP {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
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

      // Fully OOP, not pattern based, but using polymorphism to handle different trade types.
      // Obeys Open/Closed Principle, as we can add new trade types without modifying existing code.
      // Disobeys the DRY principle, as we have duplicated logic in the auditor classes.
    public static void processTrade(Trade trade) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1. Get simple name of trade class: "Buy" / "Sell"
        String tradeName = trade.getClass().getSimpleName();

        // 2. Build full auditor class name.
        String auditorClassName = "OOP.Auditors." + tradeName + "Auditor";
        Class<?> raw = Class.forName(auditorClassName);

        // 3. Instantiate via no-arg constructor
        Class<TradeAuditor> auditorClass = (Class<TradeAuditor>) raw;
        var auditorObject = auditorClass.getDeclaredConstructor().newInstance();

        // Our crucial step of auditing the trade.
        auditorObject.audit(trade);

        // Leveraging polymorphism to get the correct process method called at runtime.
        System.out.println(trade.process());
    }
}