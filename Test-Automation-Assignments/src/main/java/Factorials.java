public class Factorials {
    public static void main(String[] args) {
        printFactorial();
    }
    public static void printFactorial() {
        int n = 10;
        for( int j = 1; j <= n ; j++) {
            int result = 1;
            for (int i = 1; i <= j; i++) {
                System.out.print(i);
                if(i==1 && j==1) {
                    System.out.print(" x 1");
                }else if (i != j) {
                    System.out.print(" x ");
                }
                result = result * i;
            }
            System.out.println(" = " + result);
        }
    }
}









