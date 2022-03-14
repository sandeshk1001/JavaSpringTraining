package BasicJava;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        int a=10;
//        int b=-10;
//        System.out.println(b>>2);
//	// write your code here
//        int n2 =100;
//        if(n2%2==1) // this condition evaluated to true. then the block is executed
//            System.out.println("odd");
//        else
//            System.out.println("even");
//    }
//    int y=5,f=1;
//    for(int i=1;i<=y;i++){
//        f=f*i;
//    }
//        System.out.println(f);
//    }
//        int daysofweek = 2;
//        if (daysofweek == 1) {
//            System.out.println("Monday");
//        } else if (daysofweek == 2) {
//            System.out.println("Tuesday");
//        } else if (daysofweek == 3) {
//            System.out.println("Wednesday");
//        } else if (daysofweek == 4) {
//            System.out.println("Trusday");
//        } else if (daysofweek == 5) {
//            System.out.println("Friday");
//        } else if (daysofweek == 7) {
//            System.out.println("Saterday");
//        } else if (daysofweek == 8) {
//            System.out.println("Sunday");
//        } else {
//            System.out.println("no found");
//        }
//
//        switch(daysofweek){
//            case 1:
//                System.out.println("Monday");
//                break
//
//        }
//        int i=1;
//        do {
//            System.out.print(i+",");
//            i++;
//
//        }while(i<=10);
//        for(int i=0;i<=5;i++){
//            for(int j=0;j<i;j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }

//        System.out.print("Enter the radius :");
//        double radius =input.nextDouble();
//        System.out.println("area :"+(radius*radius*Math.PI));
//
//        System.out.println(Math.pow(2,3.5));

//        int a,b,c;
//        System.out.print("Enter First Number :");
//        a= input.nextInt();
//        System.out.print("Enter Second Number :");
//        b= input.nextInt();
//        System.out.print("Enter Third Number :");
//        c= input.nextInt();
//        if(a <b && a<c){
//            System.out.println("Minimum is  First number");
//        }else if(b<a && b<c){
//            System.out.println("Minimum is  Second number");
//        }else{
//            System.out.println("Minimun is Third number");
//        }
        //System.out.println("min Number"+Math.);
//        double [] arr ={1.2,2.4,1,3};
//        System.out.println(findMinimun(arr));
//    }
//    public static double findMinimun(double a[]){
//        double min=a[0];
//        for(int i=1;i<a.length;i++){
//            if(min > a[i]){
//                min=a[i];
//            }
//        }
//        return min;

//        System.out.println(sumRecursive(10000));
//        System.out.println(sumIterative(10000));
//        printString("This is a sample Sentence");
        //System.out.println(isPalimdron("karrak"));
//        ascendingString("bangloro","ahemdabad");

        System.out.println(distance(10,10,40,40));

 }
    public static double distance(int x1, int y1, int x2, int y2){
        double x = Math.pow(x1 - x2,2);
        double y = Math.pow(y1-y2,2);
        return Math.sqrt(x+y);
    }
//
// public static void ascendingString(String str1,String str2){
//          if(str1.compareTo(str2)<0){
//              System.out.println(str1);
//              System.out.println(str2);
//          }else{
//              System.out.println(str2);
//              System.out.println(str1);
//          }
 }
//
// public static boolean isPalimdron(String str){
//     for(int i=0;i<str.length()/2;i++){
//         if(str.charAt(i) != str.charAt(str.length()-1-i)){
//             return false;
//         }
//     }
//        return true;
// }
// public static void printString(String str){
//        for(int i=0;i<str.length();i++){
//            System.out.println(str.charAt(i));
//     }
// }

//    public static long sumRecursive(long p){
//        if(p ==1){
//            return 1;
//        }
//        return sumRecursive(p-1)+p;
//    }
//
//    public static long sumIterative(long p){
//        long sum=0;
//        for(long i=0;i<=p;i++){
//            sum=sum+i;
//        }
//        return sum;
//    }
//}
