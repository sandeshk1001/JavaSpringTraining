package TaskSpring_12March.Q4;
/*
In Java, Singleton is a design pattern that ensures that a class can only have one object.
To create a singleton class, a class must implement the following properties:
1) Create a private constructor of the class to restrict object creation outside of the class.
2) Create a private attribute of the class type that refers to the single object.
3) Create a public static method that allows us to create and access the object we created.
    Inside the method, we will create a condition that restricts us from creating more than
    one object.

    prons and cons

1) in lazy loading runtime required more
    but in egger loading runtime required less time
2) in lazy loading create object on constructor and any time required condition to create object
    but in Egger loading we create a static object not any condtion thats way it load fater
 */

public class SingletonImplementation {
    public static void main(String[] args) {
        LazyLoading lazySingleton = LazyLoading.getInstance();
        LazyLoading lazySingleton1 = LazyLoading.getInstance();
        System.out.println("1 object:"+lazySingleton.hashCode() + " ,2 object: " + lazySingleton1.hashCode());

        EagerLoading eagerSingleton = EagerLoading.getInstance();
        EagerLoading eagerSingleton1 = EagerLoading.getInstance();
        System.out.println("1 object :"+eagerSingleton.hashCode() + " ,2 object: " + eagerSingleton1.hashCode());
    }
}
class LazyLoading {
    private static LazyLoading singleton = null;
    private LazyLoading() {
    }
    public static LazyLoading getInstance() {
        if (singleton == null)
            singleton = new LazyLoading();
        return singleton;
    }
}

class EagerLoading {
    private static final EagerLoading singleton = new EagerLoading();

    private EagerLoading() {
    }

    public static EagerLoading getInstance() {
        return singleton;
    }
}