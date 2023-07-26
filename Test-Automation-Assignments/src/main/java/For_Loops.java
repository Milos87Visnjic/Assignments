public class For_Loops {
    public static void main(String[] args) {
        String[]array_String={"Milos", "Milan", "Ismail","Nafiseh","Filip" };

        //advance for loop
        for (String item : array_String){
            System.out.println(item);
        }
        System.out.println("**********************\n");
        //classic for loop
        int[]arr={3,5,7,4,6,9,7};
        for (int i=0;i<=arr.length;i++){
            System.out.println(i+ "--" + arr[i]);
        }

    }
}
