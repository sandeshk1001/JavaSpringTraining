package Assigments.SpringTask_12March.Q1_LazyEagger;
/*
The concept of delaying the loading of an object until one needs it is known as lazy loading.
In other words, it is the process of delaying the process of instantiating the class until required.
Lazy loading is important in a scenario where the cost of creating objects is high,
 or usage of the object is rare in the program.
 Lazy loading is a technique that enhances the efficiency of the program.
 */
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