
Classes in this package demonstrate the principles of Object-Oriented Programming (OOP) in Java.

The solution (in example.org.Main.java) is a simple Java application that demonstrates the use of classes, inheritance, 
polymorphism, and encapsulation as it relates to the simple processing of Trade objects by some client code. Here,
the client code is simply a main() method in the Main.java class, but you could imagine the concepts extending
to a client web-app that processes the Trade objects in more complex ways.

Benefits of the solution:
- Leveraging OOP best practices like encapsulation, inheritance, and polymorphism to avoid repeating code from the Trade
class in its subclasses
- Obeys the Open/Close principle, allowing for easy extension of the Trade class without modifying existing code.
- If new Trade types are added, the client code does not need to change, as it interacts with the Trade class
  and its subclasses through polymorphism. Only the Auditor class hierarchy needs to be changed.

Shortcomings of the solution:
- For each new Trade class implemented, we need to implement a new TradeAuditor class to audit that trade. These trade
auditors add complexity to our class hierarchy, and also copy a fair amount of logic from each other.
- The code is verbose and hard to read.
- Our processing code is now subject to many different potential exceptions.