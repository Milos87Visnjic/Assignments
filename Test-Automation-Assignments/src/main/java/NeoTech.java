public class NeoTech {
    public static void main(String[] args) {

        String result = "";

        for (int i = 1; i <= 30; i++) {
            if ((i % 5 == 0) && (i % 3 == 0)) {
                result += "NEOTECH ";
            } else if (i % 5 == 0) {
                result += "TECH ";
            } else if (i % 3 == 0) {
                result += "NEO ";
            } else {
                result += i + " ";
            }
            System.out.println(result);
        }
    }
}
