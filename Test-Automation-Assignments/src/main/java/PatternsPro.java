public class PatternsPro {
    public static void main(String[] args) {

        int rows=7;
        //upper part
        for(int i=1;i<=rows;i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        //lower part
            for(int i=1;i<=rows;i++) {
                for (int j = rows; j > i; j--) {

                    System.out.print("* ");
                    //* i=1 j=1
                    //** i=2 =2
                }
                System.out.println();

            }
    }
}
