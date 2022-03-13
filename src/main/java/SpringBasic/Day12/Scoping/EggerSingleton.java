package SpringBasic.Day12.Scoping;

public class EggerSingleton {
    private static EggerSingleton eggerSingleton=new EggerSingleton();

    private EggerSingleton(){

    }

    public static EggerSingleton getInstance(){
        return eggerSingleton;
    }
}
