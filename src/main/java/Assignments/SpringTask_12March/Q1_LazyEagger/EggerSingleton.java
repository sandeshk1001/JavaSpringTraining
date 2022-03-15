package Assigments.SpringTask_12March.Q1_LazyEagger;
/*
Eager loading initializes or loads a resource as soon as the code is executed.
Eager loading also involves pre-loading
related entities referenced by a resource.
 */
public class EggerSingleton {
    private static EggerSingleton eggerSingleton=new EggerSingleton();

    private EggerSingleton(){
    }

    public static EggerSingleton getInstance(){
        return eggerSingleton;
    }
}
