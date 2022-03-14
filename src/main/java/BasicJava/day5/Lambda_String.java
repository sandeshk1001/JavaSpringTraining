package BasicJava.day5;

public class Lambda_String {
    public static void main(String[] args) {
        System.out.println(perform("Hello","Sandesh",new Concedinate()));
        System.out.println(perform("Hello", "Sandesh", new OperationString() {
            @Override
            public String operateString(String s1, String s2) {
                return s1+s2;
            }
        }));
        //OperationString operationString=;
        System.out.println(perform("Hello","Sandesh",(a,b)-> a+b));
    }
    static String perform(String a,String b,OperationString operationString){
        return operationString.operateString(a,b);
    }
}
interface OperationString{
    String operateString(String s1,String s2);
}
class Concedinate implements OperationString{

    @Override
    public String operateString(String s1, String s2) {
        return s1+s2;
    }
}