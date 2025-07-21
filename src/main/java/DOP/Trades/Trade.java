package DOP.Trades;

public sealed interface Trade permits Buy, Sell {

    String process();
}