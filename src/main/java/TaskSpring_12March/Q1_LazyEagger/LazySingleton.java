package TaskSpring_12March.Q1_LazyEagger;

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