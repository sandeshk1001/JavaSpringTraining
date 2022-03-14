package BasicJava.day5;

public class LambdaExample {
    public static void main(String[] args) {
        /*------------------------------------
        *       normal using */
        //System.out.println(perform(2,4,new PowerOperation()));

    }

    public static int perform(int a, int b, Operation operation){
        return operation.operate(a,b);
    }

}
interface Operation{
     int operate(int num1, int num2);
}
class AddOperation implements Operation{

    @Override
    public int operate(int num1, int num2) {
        return num1 + num2;
    }
}
class MinusOperation implements  Operation{

    @Override
    public int operate(int num1, int num2) {
        return num1-num2;
    }
}

class PowerOperation implements  Operation {

    @Override
    public int operate(int num1, int num2) {
        return (int)Math.pow(num1,num2);
    }
}