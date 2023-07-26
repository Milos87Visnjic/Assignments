public class fibonacci_numbers {
    public static void main(String[] args) {
        {
            int n1 = 0, n2 = 1, sum, i, count = 15;
            System.out.println("******** Fibonacci Numbers *********");

            i = 1;
          while ( i < count)
            {
                sum = n1 + n2;
                System.out.print("  " + n1);
                n1 = n2;
                n2 = sum;
                i++;
            }
          /*
          0  1  1  2  3  5  8  13  21  34  55  89  144  233
          0+ 1= 1
          n1 n2 sum
             1+ 1=2
             n1 n2 sum
                1+2 = 3
                n1 n2 sum
           */
        }
    }
}
