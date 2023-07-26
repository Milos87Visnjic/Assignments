import java.util.Arrays;

public class reverseArray {
    public static void main(String[] args) {


        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};


        int[] arrayReverse = new int[arr.length];

        int i=0;
        int j=arr.length-1;
        // 7,6,5,4,3,2,1,0

        do {
            arrayReverse[i]=arr[j];
            i++;
            j--;
        } while (j>=0);
        System.out.println(Arrays.toString(arrayReverse));
        System.out.println(Arrays.toString(arr));
    }
}
