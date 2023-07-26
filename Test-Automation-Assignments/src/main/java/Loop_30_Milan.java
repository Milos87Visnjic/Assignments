public class Loop_30_Milan {

    public static void main(String[] args) {

       int rows = 30;

       for(int i=1; i<=rows; i++){
            for(int j=1; j<=i; j++){

                if(j%3==0&&j%5==0){
                  System.out.print(" NEOTECH ");
                } else if (j%3==0){
                   System.out.print(" NEO ");
              }else if (j%5==0){
                   System.out.print(" TECH ");
              }else System.out.print( " " + j + " " );
            }
           System.out.println();
       }

   }
}

//        int rows = 30;
//        int i = 1;
//
//        while (i <= rows) {
//            for (i = 1; i <= rows; i++) {
//                for (int j = 1; j <= i; j++) {
//
//                    if (j % 3 == 0 && j % 5 == 0) {
//                        System.out.print(" NEOTECH ");
//                    } else if (j % 3 == 0) {
//                        System.out.print(" NEO ");
//                    } else if (j % 5 == 0) {
//                        System.out.print(" TECH ");
//                    } else System.out.print(" " + j + " ");
//                }
//                System.out.println();
//            }
//
//        }
//    }
//}

