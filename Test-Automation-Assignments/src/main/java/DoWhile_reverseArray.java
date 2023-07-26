import java.util.Arrays;

public class DoWhile_reverseArray {

    public static void main(String[] args) {

        int[]arr={0, 1, 2, 3, 4, 5, 6, 7};

        // create array that will have 7,6,5,4,3,2,1,0 using do while

        int[]revArray=new int[arr.length];

        int i=0;
        int j=arr.length-1;

        do{
            revArray[i]=arr[j];
            i++;
            j--;
        }
        while(j>=0);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(revArray));

    }
}
