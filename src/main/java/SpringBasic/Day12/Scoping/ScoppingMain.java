package SpringBasic.Day12.Scoping;


/*
Dependency Injection
HTTP GET, POST, PUT methods
Postman <-- This is used to make HTTP GET, POST, PUT method calls
Ex:
Make a class called ShareTrading
which has a property called strategy
strategy is an interface.
Make a concrete implementation of Stragegy interface
and a Constructor Injection to Inject it to the object of ShareTrading.
Dependency Injection is also sometimes known as Inversion of Control (IOC)
 */
public class ScoppingMain {
    public static void main(String[] args) {

        /*----------------------------------------------------
          --------------Lazy Singleton------------------------
        ----------------------------------------------------*/

        /* using of this we can create main object of a single class
                but when we create private construtor on singleton class we cannt access direct */
          /* using of getInstance we can get the object we havto create this method on sinbgle ton
          using of that if the object is already create than it is return the created object of a hashcode
           */
            LazySingleton singleton = new LazySingleton();
            LazySingleton singleton1 =new LazySingleton();
            System.out.println("Lazy Singleton   :"+singleton.hashCode()+" ||   "+singleton1.hashCode());


        /*----------------------------------------------------
          --------------Egger Singleton------------------------
        ----------------------------------------------------*/
        EggerSingleton eggerSingleton = EggerSingleton.getInstance();
        EggerSingleton eggerSingleton1 = EggerSingleton.getInstance();
        System.out.println("Egger Singleton  :"+eggerSingleton.hashCode() + " , "+ eggerSingleton1.hashCode());

        /*----------------------------------------------------
          --------------Egger Singleton------------------------
        ----------------------------------------------------*/
    }
}

/*
Question: generally which design pattern is used to develop a software?
Ans:
There are 100's of Design patterns. It depends what kind of Problem you are dealing with. There is no
single design pattern. All of them have a use depending upon the problem you are trying to solve.
But there are General Design Principles or Coding Guidelines. Design Principles are different from Design Patterns

The most common Design Principles are :
1) DRY - Don't Repeat Yourself
Basically means you should not duplicate code
2) Single Responsibility Principle
Each class you write should have only one responsibility.
It should not do that job of two classes. If that is the case then split
it into two classes
3) Open/Closed Principle
Each Class should be open to extension but closed to modification.
This is something that is achieved with Dependency Injection as we saw in the examples

Some principle are famous and have an acronym called SOLID Design principles

 */
