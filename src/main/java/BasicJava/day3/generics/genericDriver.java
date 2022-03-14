package BasicJava.day3.generics;

public class genericDriver {
    public static void main(String[] args) {
        GenericStack <String> stringGenericStack = new GenericStack<String>();
        System.out.println(stringGenericStack.isEmpty());
        stringGenericStack.push("Name-1");
        stringGenericStack.push("Name-2");
        stringGenericStack.push("Name-3");
        System.out.println(stringGenericStack);
        System.out.println(stringGenericStack.getSize());
        stringGenericStack.pop();
        stringGenericStack.pop();
        System.out.println(stringGenericStack.getSize());
        System.out.println(stringGenericStack.isEmpty());


    }
}
