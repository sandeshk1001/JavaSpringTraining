package Assigments.BasicJavaTask.javaassignment;

public class Q4_2DMatrix {
    public static int f=10,l=10;
    public static void main(String[] args) {

        int a[][] = { { 1, 3, 5 },
                { 3, 2, 4 },
                { 5, 4, 1 } };
        System.out.println(a.length-1);
        System.out.println(checkmatrinx(a,a.length-1));
    }
    public static boolean checkmatrinx(int[][] a,int N){
        int transpose[][] = new int[f][l];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                transpose[i][j] = a[j][i];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (a[i][j] != transpose[i][j])
                    return false;
        return true;
    }
}
