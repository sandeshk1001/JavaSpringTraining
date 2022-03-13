package SpringBasic.Day12.Scoping;

public class LazySingleton {
    private static LazySingleton singleton=null;

     LazySingleton(){
    }

    public static LazySingleton getInstance(){
        if(singleton ==null)
            singleton=new LazySingleton();
        return singleton;
    }
}
/*
Scope
1) Singleton <-- All beans are singleton scope
There will only be once copy of that object available.
2) Prototype
Singleton Design Pattern
Design a class such that only one copy of that class can be created.
 */