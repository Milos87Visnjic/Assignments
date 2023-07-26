public class PrintNEOTECH {
    public static void main(String[] args) {
        int n = 30;
        for (int i = 1; i <= n; i++) {
            System.out.println();
            for (int j = 1; j <= i; j++) {
                if (j % 3 == 0 && j%5!=0) {
                    System.out.print("\tNEO");
                }
                else if (j% 5==0 && j%3!=0){
                        System.out.print ("\tTECH");
                    }
                else if (j% 15==0){
                       System.out.print ("\tNEOTECH");
                }
                else {
                    System.out.print("\t"+j);
                }
                }
        }
    }
}








