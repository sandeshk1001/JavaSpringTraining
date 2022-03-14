package TaskSpring_12March.Q1_LazyEagger;

public class EggerSingleton {
    private static EggerSingleton eggerSingleton=new EggerSingleton();

    private EggerSingleton(){
    }

    public static EggerSingleton getInstance(){
        return eggerSingleton;
    }
}
