public class While_Loop {

    public static void main(String[] args) {
        printFibonacci();
    }
    public static void printFibonacci() {

        System.out.println("**************Fibonacci Numbers**************");

        int n = 15;
        int i=1;
        int firstTerm = 0;
        int secondTerm = 1;
        while (i<=n){

            System.out.print(firstTerm +" ");

            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
            i++;
        }}}

