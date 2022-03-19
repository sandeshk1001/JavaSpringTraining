package Assigments.BasicJavaTask.Task_2;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {

        System.out.print("Enter the number");
        int a =new Scanner(System.in).nextInt();
        for(int i=0;i<a ;i++){
            System.out.println(args[2]+" "+args[3]+" "+args[4]);
        }

        System.out.println("2D Array");
        char[][] grads = new char[3][5];
        int g=(int)'A';
        for (int i=0;i<3;i++){
            for (int j=0;j<5;j++){
                grads[i][j]=(char)g;
            }
            g++;
        }
        System.out.println("After Intialization :");
        for (int i=0;i<3;i++){
            System.out.print("Student "+i+" :");
            for(int j=0;j<5;j++){
                System.out.print("  "+grads[i][j]);
            }
            System.out.println();
        }

        grads[1][4]='C';
        grads[2][0]='A';

        System.out.println("After Updation :");
        for (int i=0;i<3;i++){
            System.out.print("Student "+i+" :");
            for(int j=0;j<5;j++){
                System.out.print("  "+grads[i][j]);
            }
            System.out.println();
        }
    }
}
