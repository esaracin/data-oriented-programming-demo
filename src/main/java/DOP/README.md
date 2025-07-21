
Classes in this package demonstrate the principles of Data-Oriented Programming (DOP) in Java.

The solution (in example.org.Main.java) is a simple Java application that demonstrates the use records, enhanced 
switch statement pattern matching, and functional programming as it relates to the simple processing of Trade objects 
by some client code. We also make the Trade interface sealed, which allows us to define a fixed set of Trade types that can be used in the application (avoiding
a default clause on our switch statements)

Benefits of the solution:
- Code is much more readable and concise than the OOP solution.
- No longer need extended parallel class hierarchy of TradeAuditors for each type of Trade

Shortcomings of the solution:
- No longer following Open/Closed principal: every new Trade type added requires a change to the client code.