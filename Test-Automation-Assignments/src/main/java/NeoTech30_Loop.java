public class NeoTech30_Loop {

    public static void main(String[] args) {

        int rows = 30;
        int i = 1;
        while (i <= rows) {
            for (i = 1; i <= rows; i++) {
                for (int j = 1; j <= i; j++) {

                    if (j % 3 == 0 && j % 5 == 0) {
                        System.out.print(" Neotech ");
                    } else if (j % 3 == 0) {
                        System.out.print(" Neo ");
                    } else if (j % 5 == 0) {
                        System.out.print(" Tech ");
                    } else System.out.print(" " + j + " ");
                }
                System.out.println();
            }
        }
    }}






