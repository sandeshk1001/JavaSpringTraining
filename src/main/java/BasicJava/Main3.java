package BasicJava;

public class Main3 {
    public static void main(String[] args) {
//        System.out.println("Toss the coin 10 times");
//        for(int i=0;i<10;i++){
//            double random = Math.random();
//            if(random<10)
//                System.out.println("head Value("+random+")");
//            else
//                System.out.println("tail Value("+random+")");
//        }
//        System.out.println("GCD :"+findGDC(100,180));
//        characterFind("this is a sample text");
        int []arr={10,30,50,9,4,3};
        //Arrays.sort(arr);

        //System.out.println(keyPrint(arr,9));

        int [] arr2=reversearray(arr);
        for(int i:arr2){
            System.out.print(i+" ");
        }
    }

    /** it is a program for binary search
     *
     * @param arr this is a sorted array
     * @param number this is a array whose we want to find in that shorted array
     * @return this is return a index or that number
     */
    public static int keyPrint(int arr[], int number) {
        int low=0;
        int high=arr.length-1;
        int mid=(low+high)/2;
        while (low<=high){
            mid=(low+high)/2;
            if(arr[mid]==number){
                return mid;
            }else if(arr[mid] < number){
                low=mid;
            }else{
                high=mid;
            }
        }
        return -1;
    }

    /** this is a reverse of a array
     *
     * @param arr this is a array
     * @return return a reverse array
     */
    public static int[] reversearray(int arr[]){
        int k,l;
        for(int i=0;i<arr.length/2;i++){
            l=arr.length-i-1;
            k=arr[i];
            arr[i] =arr[l];
            arr[l]=k;
        }
        return arr;

    }

    //***********find no of character in string ****************
//    static void characterFind(String str){
//        int arr[] = new int[26];
//        for(int i=0;i<str.length();i++){
//            if(str.charAt(i) != ' ')
//                arr[str.charAt(i)-97]++;
//        }
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]>0){
//                //char a=(char)(arr[i]);
//                System.out.println((char)(i+97)+":"+arr[i]);
//            }
//        }
//    }

    //************find GDC**************
//    static int findGDC(int a,int b){
//        int num=1;
//        for(int i=1;i<=a && i<=b;i++){
//            if(a%i==0 && b%i==0){
//                num=i;
//            }
//        }
//        return num;
//    }
}
