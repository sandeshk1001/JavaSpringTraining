package Assigments.BasicJavaTask.javaassignment;

public class Q3_febonici {
    public static void main(String[] args) {
        System.out.println("i"+printfabonici(100));
        System.out.println("r"+printfabonici_recursive(5));

    }
    static int printfabonici(int n){
        int a=0,b=1,c;
        for(int i=1;i<n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return b;
    }

    static int printfabonici_recursive(int n){
        if(n<=1){
            return n;
        }
        return printfabonici_recursive(n-1)+printfabonici_recursive(n-2);
    }
}
// etrative function is faster than recursive